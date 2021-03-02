package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException {
        Server myGrpcServer = ServerBuilder
                                .forPort(5454)
                                .addService(new GreetingServiceImpl())
                                //может быть много сервисов на одном сервере
                                //.addService(new GreetingServiceImpl2())
                                .build();
        //запускаем grpc сервер
        myGrpcServer.start();
        System.out.println("Server started!");

        //сервер будет работать, пока не завершим из консоли
        myGrpcServer.awaitTermination();
    }
}

package com.tencent.biz.richframework.download;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;

public class RFWOkHttpClientFactory
{
  public static int DEFAULT_CONNECT_POOL = 5;
  public static int DEFAULT_MAX_REQUEST = 64;
  public static int DEFAULT_MAX_REQUEST_PEER_HOST = 5;
  
  public static OkHttpClient createDeFaultOKHttpClient()
  {
    return createOkHttpClient(DEFAULT_CONNECT_POOL, DEFAULT_MAX_REQUEST, DEFAULT_MAX_REQUEST_PEER_HOST);
  }
  
  public static OkHttpClient createOkHttpClient(int paramInt1, int paramInt2, int paramInt3)
  {
    ConnectionPool localConnectionPool = new ConnectionPool(paramInt1, 600L, TimeUnit.SECONDS);
    Dispatcher localDispatcher = new Dispatcher();
    localDispatcher.setMaxRequests(paramInt2);
    localDispatcher.setMaxRequestsPerHost(paramInt3);
    return new OkHttpClient().newBuilder().dispatcher(localDispatcher).callTimeout(120L, TimeUnit.SECONDS).readTimeout(120L, TimeUnit.SECONDS).connectionPool(localConnectionPool).writeTimeout(120L, TimeUnit.SECONDS).protocols(Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 })).build();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWOkHttpClientFactory
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.dc;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;

public class g
{
  public static final MediaType a = MediaType.parse("application/json;");
  public static final MediaType b = MediaType.parse("image/png");
  private static OkHttpClient c;
  private static OkHttpClient d;
  private static volatile OkHttpClient e;
  private static final Interceptor f = new g.1();
  private static final HostnameVerifier g = new g.2();
  
  private static boolean b()
  {
    return s.a.a();
  }
  
  public static OkHttpClient cgiClient()
  {
    try
    {
      if (d != null)
      {
        localOkHttpClient = d;
        return localOkHttpClient;
      }
      d = rawClient().newBuilder().addInterceptor(f).build();
      OkHttpClient localOkHttpClient = d;
      return localOkHttpClient;
    }
    finally {}
  }
  
  public static OkHttpClient get()
  {
    try
    {
      if (c == null) {
        c = new OkHttpClient.Builder().hostnameVerifier(g).protocols(Arrays.asList(new Protocol[] { Protocol.HTTP_1_1, Protocol.HTTP_2 })).build();
      }
      OkHttpClient localOkHttpClient = c;
      return localOkHttpClient;
    }
    finally {}
  }
  
  public static OkHttpClient longConnectClient()
  {
    try
    {
      if (e == null) {
        e = new OkHttpClient.Builder().connectTimeout(35L, TimeUnit.SECONDS).readTimeout(35L, TimeUnit.SECONDS).hostnameVerifier(g).build();
      }
      OkHttpClient localOkHttpClient = e;
      return localOkHttpClient;
    }
    finally {}
  }
  
  public static OkHttpClient rawClient()
  {
    try
    {
      OkHttpClient localOkHttpClient = get();
      return localOkHttpClient;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.g
 * JD-Core Version:    0.7.0.1
 */
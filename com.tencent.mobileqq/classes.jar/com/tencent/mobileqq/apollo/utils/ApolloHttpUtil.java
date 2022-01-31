package com.tencent.mobileqq.apollo.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class ApolloHttpUtil
{
  public static SSLContext a()
  {
    Object localObject = null;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("TLS");
      localObject = localSSLContext;
      localSSLContext.init(null, new TrustManager[] { new ApolloHttpUtil.CustomX509TrustManager() }, null);
      return localSSLContext;
    }
    catch (Exception localException) {}
    return localObject;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    int i = 0;
    for (;;)
    {
      HttpURLConnection localHttpURLConnection;
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
        localHttpURLConnection.setRequestMethod("POST");
        if ((localHttpURLConnection instanceof HttpsURLConnection))
        {
          paramString1 = a();
          if (paramString1 != null)
          {
            paramString1 = paramString1.getSocketFactory();
            ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramString1);
          }
        }
        localHttpURLConnection.setConnectTimeout(8000);
        localHttpURLConnection.setReadTimeout(8000);
        localHttpURLConnection.setUseCaches(false);
        localHttpURLConnection.setRequestProperty("Postbody", paramString2);
        localHttpURLConnection.setRequestProperty("Referer", paramString3);
        localHttpURLConnection.setRequestProperty("Cookie", paramString4);
        paramString1 = null;
        if (i < paramArrayOfString.length) {
          if (i % 2 == 0) {
            paramString1 = paramArrayOfString[i];
          } else {
            localHttpURLConnection.setRequestProperty(paramString1, paramArrayOfString[i]);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramApolloHttpCallBack.a(-1, null);
        return;
      }
      paramString1 = localHttpURLConnection.getOutputStream();
      paramString1.write(paramString2.getBytes());
      paramString1.flush();
      i = localHttpURLConnection.getResponseCode();
      if (i == 200)
      {
        paramString1 = localHttpURLConnection.getInputStream();
        paramString2 = new ByteArrayOutputStream();
        paramString3 = new byte[1024];
        for (;;)
        {
          int j = paramString1.read(paramString3);
          if (j == -1) {
            break;
          }
          paramString2.write(paramString3, 0, j);
        }
        paramString1.close();
        paramString2.close();
        paramString1.close();
        localHttpURLConnection.disconnect();
        paramApolloHttpCallBack.a(i, paramString2.toByteArray());
        return;
      }
      paramApolloHttpCallBack.a(i, null);
      return;
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2, byte[] paramArrayOfByte, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramString2 = (HttpURLConnection)new URL(paramString2).openConnection();
        paramString2.setRequestMethod(paramString1);
        if ((paramString2 instanceof HttpsURLConnection))
        {
          paramString1 = a();
          if (paramString1 != null)
          {
            paramString1 = paramString1.getSocketFactory();
            ((HttpsURLConnection)paramString2).setSSLSocketFactory(paramString1);
          }
        }
        paramString2.setConnectTimeout(8000);
        paramString2.setReadTimeout(8000);
        paramString2.setUseCaches(false);
        paramString1 = null;
        if (i < paramArrayOfString.length) {
          if (i % 2 == 0) {
            paramString1 = paramArrayOfString[i];
          } else {
            paramString2.setRequestProperty(paramString1, paramArrayOfString[i]);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramApolloHttpCallBack.a(-1, null);
        return;
      }
      paramString1 = paramString2.getOutputStream();
      paramString1.write(paramArrayOfByte);
      paramString1.flush();
      i = paramString2.getResponseCode();
      if (i == 200)
      {
        paramString1 = paramString2.getInputStream();
        paramArrayOfByte = new ByteArrayOutputStream();
        paramArrayOfString = new byte[1024];
        for (;;)
        {
          int j = paramString1.read(paramArrayOfString);
          if (j == -1) {
            break;
          }
          paramArrayOfByte.write(paramArrayOfString, 0, j);
        }
        paramString1.close();
        paramArrayOfByte.close();
        paramString1.close();
        paramString2.disconnect();
        paramApolloHttpCallBack.a(i, paramArrayOfByte.toByteArray());
        return;
      }
      paramApolloHttpCallBack.a(i, null);
      return;
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    int i = 0;
    for (;;)
    {
      HttpURLConnection localHttpURLConnection;
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString1).openConnection();
        localHttpURLConnection.setRequestMethod("POST");
        if ((localHttpURLConnection instanceof HttpsURLConnection))
        {
          paramString1 = a();
          if (paramString1 != null)
          {
            paramString1 = paramString1.getSocketFactory();
            ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramString1);
          }
        }
        localHttpURLConnection.setConnectTimeout(8000);
        localHttpURLConnection.setReadTimeout(8000);
        localHttpURLConnection.setUseCaches(false);
        paramString1 = null;
        if (i < paramArrayOfString.length) {
          if (i % 2 == 0) {
            paramString1 = paramArrayOfString[i];
          } else {
            localHttpURLConnection.setRequestProperty(paramString1, paramArrayOfString[i]);
          }
        }
      }
      catch (Exception paramString1)
      {
        paramApolloHttpCallBack.a(-1, null);
        return;
      }
      paramString1 = localHttpURLConnection.getOutputStream();
      paramString1.write(paramString2.getBytes());
      paramString1.flush();
      i = localHttpURLConnection.getResponseCode();
      if (i == 200)
      {
        paramString1 = localHttpURLConnection.getInputStream();
        paramString2 = new ByteArrayOutputStream();
        paramArrayOfString = new byte[1024];
        for (;;)
        {
          int j = paramString1.read(paramArrayOfString);
          if (j == -1) {
            break;
          }
          paramString2.write(paramArrayOfString, 0, j);
        }
        paramString1.close();
        paramString2.close();
        paramString1.close();
        localHttpURLConnection.disconnect();
        paramApolloHttpCallBack.a(i, paramString2.toByteArray());
        return;
      }
      paramApolloHttpCallBack.a(i, null);
      return;
      i += 1;
    }
  }
  
  public static void a(String paramString, String[] paramArrayOfString, ApolloHttpCallBack paramApolloHttpCallBack)
  {
    int i = 0;
    for (;;)
    {
      HttpURLConnection localHttpURLConnection;
      try
      {
        localHttpURLConnection = (HttpURLConnection)new URL(paramString).openConnection();
        localHttpURLConnection.setRequestMethod("GET");
        if ((localHttpURLConnection instanceof HttpsURLConnection))
        {
          paramString = a();
          if (paramString != null)
          {
            paramString = paramString.getSocketFactory();
            ((HttpsURLConnection)localHttpURLConnection).setSSLSocketFactory(paramString);
          }
        }
        localHttpURLConnection.setConnectTimeout(8000);
        localHttpURLConnection.setReadTimeout(8000);
        paramString = null;
        if (i < paramArrayOfString.length) {
          if (i % 2 == 0) {
            paramString = paramArrayOfString[i];
          } else {
            localHttpURLConnection.setRequestProperty(paramString, paramArrayOfString[i]);
          }
        }
      }
      catch (Exception paramString)
      {
        paramApolloHttpCallBack.a(-1, null);
        return;
      }
      i = localHttpURLConnection.getResponseCode();
      if (i == 200)
      {
        paramString = localHttpURLConnection.getInputStream();
        paramArrayOfString = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int j = paramString.read(arrayOfByte);
          if (j == -1) {
            break;
          }
          paramArrayOfString.write(arrayOfByte, 0, j);
        }
        paramString.close();
        paramArrayOfString.close();
        paramString.close();
        localHttpURLConnection.disconnect();
        paramApolloHttpCallBack.a(i, paramArrayOfString.toByteArray());
        return;
      }
      paramApolloHttpCallBack.a(i, null);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloHttpUtil
 * JD-Core Version:    0.7.0.1
 */
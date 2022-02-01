package com.tencent.av.utils;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class HttpUtil
{
  /* Error */
  public static java.lang.String a(java.lang.String paramString1, java.lang.String paramString2, java.lang.String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 14	com/tencent/av/utils/HttpUtil:a	(Z)Lorg/apache/http/client/HttpClient;
    //   4: astore_3
    //   5: new 16	org/apache/http/client/methods/HttpPost
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 19	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: new 21	org/apache/http/entity/StringEntity
    //   18: dup
    //   19: aload_1
    //   20: ldc 23
    //   22: invokespecial 26	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: invokevirtual 30	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   28: aload_0
    //   29: ldc 32
    //   31: ldc 34
    //   33: invokevirtual 37	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_2
    //   37: ifnull +10 -> 47
    //   40: aload_0
    //   41: ldc 39
    //   43: aload_2
    //   44: invokevirtual 37	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_3
    //   48: aload_0
    //   49: invokeinterface 45 2 0
    //   54: invokeinterface 51 1 0
    //   59: invokestatic 57	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   62: astore_0
    //   63: aload_3
    //   64: ifnull +14 -> 78
    //   67: aload_3
    //   68: invokeinterface 61 1 0
    //   73: invokeinterface 66 1 0
    //   78: aload_0
    //   79: areturn
    //   80: astore_1
    //   81: aload_3
    //   82: astore_0
    //   83: goto +6 -> 89
    //   86: astore_1
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: ifnull +14 -> 104
    //   93: aload_0
    //   94: invokeinterface 61 1 0
    //   99: invokeinterface 66 1 0
    //   104: aload_1
    //   105: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramString1	java.lang.String
    //   0	106	1	paramString2	java.lang.String
    //   0	106	2	paramString3	java.lang.String
    //   4	78	3	localHttpClient	HttpClient
    // Exception table:
    //   from	to	target	type
    //   5	36	80	finally
    //   40	47	80	finally
    //   47	63	80	finally
    //   0	5	86	finally
  }
  
  public static HttpClient a(boolean paramBoolean)
  {
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setStaleCheckingEnabled((HttpParams)localObject2, false);
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 5000);
    HttpConnectionParams.setTcpNoDelay((HttpParams)localObject2, true);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 10000);
    HttpConnectionParams.setSocketBufferSize((HttpParams)localObject2, 8192);
    HttpProtocolParams.setVersion((HttpParams)localObject2, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, "randchat");
    Object localObject1 = new SchemeRegistry();
    ((SchemeRegistry)localObject1).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    try
    {
      ((SchemeRegistry)localObject1).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      label99:
      if (paramBoolean) {
        localObject1 = new ThreadSafeClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
      } else {
        localObject1 = new SingleClientConnManager((HttpParams)localObject2, (SchemeRegistry)localObject1);
      }
      localObject2 = new DefaultHttpClient((ClientConnectionManager)localObject1, (HttpParams)localObject2);
      ((DefaultHttpClient)localObject2).setRoutePlanner(new DefaultHttpRoutePlanner(((ClientConnectionManager)localObject1).getSchemeRegistry()));
      return localObject2;
    }
    catch (Exception localException)
    {
      break label99;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.HttpUtil
 * JD-Core Version:    0.7.0.1
 */
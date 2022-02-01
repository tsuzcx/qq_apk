package com.rookery.asyncHttpClient;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class CustomSSLSocketFactory$MyX509TrustManager
  implements X509TrustManager
{
  X509TrustManager a;
  
  CustomSSLSocketFactory$MyX509TrustManager()
  {
    Object localObject4 = null;
    try
    {
      localObject1 = KeyStore.getInstance("JKS");
    }
    catch (Exception localException2)
    {
      Object localObject1;
      label16:
      int j;
      Object localObject3;
      Object localObject2;
      int i;
      break label16;
    }
    localObject1 = null;
    j = 0;
    if (localObject1 != null)
    {
      try
      {
        localObject3 = new FileInputStream("trustedCerts");
        ((KeyStore)localObject1).load((InputStream)localObject3, "passphrase".toCharArray());
        localObject4 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
        ((TrustManagerFactory)localObject4).init((KeyStore)localObject1);
        localObject4 = ((TrustManagerFactory)localObject4).getTrustManagers();
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      catch (Exception localException1)
      {
        throw localException1;
      }
    }
    else
    {
      localObject2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject2).init((KeyStore)null);
      localObject3 = ((TrustManagerFactory)localObject2).getTrustManagers();
      localObject2 = localObject4;
    }
    i = j;
    if (localObject2 != null)
    {
      ((FileInputStream)localObject2).close();
      i = j;
    }
    while (i < localObject3.length)
    {
      if ((localObject3[i] instanceof X509TrustManager))
      {
        this.a = ((X509TrustManager)localObject3[i]);
        return;
      }
      i += 1;
    }
    localObject2 = new Exception("Couldn't initialize");
    for (;;)
    {
      throw ((Throwable)localObject2);
    }
  }
  
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.CustomSSLSocketFactory.MyX509TrustManager
 * JD-Core Version:    0.7.0.1
 */
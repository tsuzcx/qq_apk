package com.huawei.updatesdk.a.b.b;

import com.huawei.updatesdk.a.a.a.d;
import com.huawei.updatesdk.a.a.c.b.b;
import com.huawei.updatesdk.a.b.a.a;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class c
{
  private static volatile c a = null;
  
  public static c a()
  {
    try
    {
      if (a == null) {
        a = new c();
      }
      c localc = a;
      return localc;
    }
    finally {}
  }
  
  private Proxy b()
  {
    if (b.b(a.a().b())) {
      return b.a();
    }
    return null;
  }
  
  public HttpURLConnection a(String paramString)
  {
    paramString = new URL(paramString);
    Proxy localProxy = b();
    if (localProxy == null) {}
    for (paramString = (HttpURLConnection)paramString.openConnection();; paramString = (HttpURLConnection)paramString.openConnection(localProxy))
    {
      paramString.setConnectTimeout(7000);
      paramString.setReadTimeout(10000);
      paramString.setUseCaches(false);
      paramString.setDoInput(true);
      paramString.setRequestProperty("Accept-Encoding", "identity");
      paramString.setInstanceFollowRedirects(true);
      if ((paramString instanceof HttpsURLConnection))
      {
        ((HttpsURLConnection)paramString).setSSLSocketFactory(d.a(a.a().b()));
        ((HttpsURLConnection)paramString).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      }
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */
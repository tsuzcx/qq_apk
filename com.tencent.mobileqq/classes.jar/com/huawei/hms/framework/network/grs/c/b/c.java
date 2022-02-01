package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class c
  extends SSLSocketFactory
{
  public static final X509HostnameVerifier a = new BrowserCompatHostnameVerifier();
  public static final X509HostnameVerifier b = new StrictHostnameVerifier();
  private static volatile c c = null;
  private static String[] d = null;
  private SSLContext e = null;
  private Context f;
  
  private c(Context paramContext, String paramString)
  {
    this.f = paramContext;
    this.e = b.a();
    paramContext = new d(this.f, paramString);
    this.e.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  public static c a(Context paramContext, String paramString)
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new c(paramContext, paramString);
      }
      return c;
    }
    finally {}
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    paramString = this.e.getSocketFactory().createSocket(paramString, paramInt);
    if ((paramString instanceof SSLSocket)) {
      b.e((SSLSocket)paramString);
    }
    return paramString;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return createSocket(paramString, paramInt1);
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return createSocket(paramInetAddress.getHostAddress(), paramInt);
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return createSocket(paramInetAddress1.getHostAddress(), paramInt1);
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    paramSocket = this.e.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if ((paramSocket instanceof SSLSocket)) {
      b.e((SSLSocket)paramSocket);
    }
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    if (d != null) {
      return (String[])d.clone();
    }
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b.c
 * JD-Core Version:    0.7.0.1
 */
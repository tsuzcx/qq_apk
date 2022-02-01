package com.huawei.updatesdk.a.a.a;

import android.content.Context;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class d
  extends SSLSocketFactory
{
  private static volatile d a = null;
  private SSLContext b = null;
  
  private d(Context paramContext)
  {
    paramContext = new e(paramContext);
    this.b.init(null, new X509TrustManager[] { paramContext }, null);
  }
  
  public static d a(Context paramContext)
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new d(paramContext);
      }
      return a;
    }
    finally {}
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    paramString = this.b.getSocketFactory().createSocket(paramString, paramInt);
    if ((paramString instanceof SSLSocket)) {
      c.a((SSLSocket)paramString);
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
    paramSocket = this.b.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
    if ((paramSocket instanceof SSLSocket)) {
      c.a((SSLSocket)paramSocket);
    }
    return paramSocket;
  }
  
  public String[] getDefaultCipherSuites()
  {
    return new String[0];
  }
  
  public String[] getSupportedCipherSuites()
  {
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.a.d
 * JD-Core Version:    0.7.0.1
 */
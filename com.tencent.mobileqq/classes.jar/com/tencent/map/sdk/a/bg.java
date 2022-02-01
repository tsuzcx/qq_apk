package com.tencent.map.sdk.a;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class bg
  extends SSLSocketFactory
{
  public boolean a;
  private String b;
  
  public bg(String paramString)
  {
    bg.class.getSimpleName();
    this.a = false;
    this.b = paramString;
  }
  
  public Socket createSocket()
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
  {
    return null;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(this.b)) {
      try
      {
        if (Build.VERSION.SDK_INT < 17)
        {
          paramSocket = (SSLSocket)((SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(ac.a()))).createSocket(paramSocket, this.b, paramInt, paramBoolean);
          paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
          paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { this.b });
          paramSocket.startHandshake();
          return paramSocket;
        }
        paramString = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(ac.a()));
        paramSocket = (SSLSocket)paramString.createSocket(paramSocket, this.b, paramInt, paramBoolean);
        paramString.setUseSessionTickets(paramSocket, true);
        paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
        paramString.setHostname(paramSocket, this.b);
        paramSocket.startHandshake();
        return paramSocket;
      }
      catch (Throwable paramSocket)
      {
        this.a = true;
        if ((paramSocket instanceof IOException)) {
          throw ((IOException)paramSocket);
        }
        throw new IOException("HalleySNI exception: ".concat(String.valueOf(paramSocket)));
      }
    }
    throw new IOException("Halley set empty bizHost");
  }
  
  public boolean equals(Object paramObject)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      if (!(paramObject instanceof bg)) {
        return false;
      }
      paramObject = ((bg)paramObject).b;
      if (TextUtils.isEmpty(paramObject)) {
        return false;
      }
      return this.b.equals(paramObject);
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.bg
 * JD-Core Version:    0.7.0.1
 */
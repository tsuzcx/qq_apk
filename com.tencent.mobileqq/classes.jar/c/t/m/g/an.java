package c.t.m.g;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class an
  extends SSLSocketFactory
{
  public boolean a = false;
  private final String b = an.class.getSimpleName();
  private String c;
  
  public an(String paramString)
  {
    this.c = paramString;
  }
  
  public Socket createSocket()
    throws IOException
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt)
    throws IOException, UnknownHostException
  {
    return null;
  }
  
  public Socket createSocket(String paramString, int paramInt1, InetAddress paramInetAddress, int paramInt2)
    throws IOException, UnknownHostException
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress, int paramInt)
    throws IOException
  {
    return null;
  }
  
  public Socket createSocket(InetAddress paramInetAddress1, int paramInt1, InetAddress paramInetAddress2, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException
  {
    if (TextUtils.isEmpty(this.c)) {
      throw new IOException("Halley set empty bizHost");
    }
    Log.i(this.b, "customized createSocket. host: " + this.c);
    try
    {
      if (Build.VERSION.SDK_INT < 17)
      {
        paramSocket = (SSLSocket)((SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(m.a()))).createSocket(paramSocket, this.c, paramInt, paramBoolean);
        paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
        paramSocket.getClass().getMethod("setHostname", new Class[] { String.class }).invoke(paramSocket, new Object[] { this.c });
        paramSocket.startHandshake();
        return paramSocket;
      }
      paramString = (SSLCertificateSocketFactory)SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(m.a()));
      paramSocket = (SSLSocket)paramString.createSocket(paramSocket, this.c, paramInt, paramBoolean);
      paramString.setUseSessionTickets(paramSocket, true);
      paramSocket.setEnabledProtocols(paramSocket.getSupportedProtocols());
      paramString.setHostname(paramSocket, this.c);
      paramSocket.startHandshake();
      return paramSocket;
    }
    catch (Throwable paramSocket)
    {
      this.a = true;
      throw new IOException("HalleySNI exception: ".concat(String.valueOf(paramSocket)));
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((TextUtils.isEmpty(this.c)) || (!(paramObject instanceof an))) {}
    do
    {
      return false;
      paramObject = ((an)paramObject).c;
    } while (TextUtils.isEmpty(paramObject));
    return this.c.equals(paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.an
 * JD-Core Version:    0.7.0.1
 */
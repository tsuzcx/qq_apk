package com.rookery.asyncHttpClient;

import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class CustomSSLSocketFactory
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a = SSLContext.getInstance("TLS");
  
  public CustomSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    try
    {
      paramKeyStore = new CustomSSLSocketFactory.MyX509TrustManager();
    }
    catch (Exception paramKeyStore)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cancel] cancel task");
        localStringBuilder.append(paramKeyStore);
        QLog.e("Translator", 2, localStringBuilder.toString());
      }
      paramKeyStore = null;
    }
    this.a.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.CustomSSLSocketFactory
 * JD-Core Version:    0.7.0.1
 */
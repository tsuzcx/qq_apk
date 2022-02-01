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
      this.a.init(null, new TrustManager[] { paramKeyStore }, null);
      return;
    }
    catch (Exception paramKeyStore)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Translator", 2, "[cancel] cancel task" + paramKeyStore);
        }
        paramKeyStore = null;
      }
    }
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
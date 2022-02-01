package com.rookery.asyncHttpClient;

import com.tencent.qphone.base.util.QLog;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

class AsyncHttpClient$1
  implements X509HostnameVerifier
{
  private X509HostnameVerifier jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
  
  AsyncHttpClient$1(AsyncHttpClient paramAsyncHttpClient) {}
  
  public void verify(String paramString, X509Certificate paramX509Certificate)
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify(str, paramX509Certificate);
  }
  
  public void verify(String paramString, SSLSocket paramSSLSocket)
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify(str, paramSSLSocket);
  }
  
  public void verify(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    String str = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      str = "accesscontrol.windows.net";
    }
    this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify(str, paramArrayOfString1, paramArrayOfString2);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[AsyncHttpClient] host:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Translator", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramString;
    if (paramString.equalsIgnoreCase("datamarket.accesscontrol.windows.net")) {
      localObject = "accesscontrol.windows.net";
    }
    return this.jdField_a_of_type_OrgApacheHttpConnSslX509HostnameVerifier.verify((String)localObject, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.rookery.asyncHttpClient.AsyncHttpClient.1
 * JD-Core Version:    0.7.0.1
 */
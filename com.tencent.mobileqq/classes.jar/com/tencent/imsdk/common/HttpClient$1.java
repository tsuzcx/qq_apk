package com.tencent.imsdk.common;

import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class HttpClient$1
  implements X509TrustManager
{
  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      paramArrayOfX509Certificate[0].checkValidity();
      return;
    }
    catch (CertificateNotYetValidException paramArrayOfX509Certificate)
    {
      paramArrayOfX509Certificate.printStackTrace();
      return;
    }
    catch (CertificateExpiredException paramArrayOfX509Certificate)
    {
      paramArrayOfX509Certificate.printStackTrace();
    }
  }
  
  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      paramArrayOfX509Certificate[0].checkValidity();
      return;
    }
    catch (CertificateNotYetValidException paramArrayOfX509Certificate)
    {
      paramArrayOfX509Certificate.printStackTrace();
      return;
    }
    catch (CertificateExpiredException paramArrayOfX509Certificate)
    {
      paramArrayOfX509Certificate.printStackTrace();
    }
  }
  
  public X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.HttpClient.1
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.g;
import java.security.Principal;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public class StrictHostnameVerifier
  implements HostnameVerifier
{
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      paramSSLSession = (X509Certificate)paramSSLSession.getPeerCertificates()[0];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("verify: certificate is : ");
      localStringBuilder.append(paramSSLSession.getSubjectDN().getName());
      g.a("", localStringBuilder.toString());
      b.a(paramString, paramSSLSession, true);
      return true;
    }
    catch (SSLException paramString)
    {
      paramSSLSession = new StringBuilder();
      paramSSLSession.append("SSLException : ");
      paramSSLSession.append(paramString.getMessage());
      g.b("", paramSSLSession.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier
 * JD-Core Version:    0.7.0.1
 */
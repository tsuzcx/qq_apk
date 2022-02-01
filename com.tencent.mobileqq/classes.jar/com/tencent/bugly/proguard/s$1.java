package com.tencent.bugly.proguard;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class s$1
  implements X509TrustManager
{
  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    x.c("checkClientTrusted", new Object[0]);
  }
  
  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    x.c("checkServerTrusted", new Object[0]);
  }
  
  public final X509Certificate[] getAcceptedIssuers()
  {
    return new X509Certificate[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.s.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mars.cdn;

import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.X509TrustManager;

final class b$b
  implements b.c
{
  private final X509TrustManager a;
  
  public b$b(X509TrustManager paramX509TrustManager)
  {
    this.a = paramX509TrustManager;
  }
  
  public List<X509Certificate> a(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
  {
    this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString1);
    return Collections.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.b.b
 * JD-Core Version:    0.7.0.1
 */
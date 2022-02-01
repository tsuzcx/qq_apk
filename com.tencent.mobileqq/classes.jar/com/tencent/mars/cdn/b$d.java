package com.tencent.mars.cdn;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;

final class b$d
  implements b.c
{
  private final X509TrustManagerExtensions a;
  
  @SuppressLint({"NewApi"})
  public b$d(X509TrustManager paramX509TrustManager)
  {
    this.a = new X509TrustManagerExtensions(paramX509TrustManager);
  }
  
  @SuppressLint({"NewApi"})
  public List<X509Certificate> a(X509Certificate[] paramArrayOfX509Certificate, String paramString1, String paramString2)
  {
    return this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.cdn.b.d
 * JD-Core Version:    0.7.0.1
 */
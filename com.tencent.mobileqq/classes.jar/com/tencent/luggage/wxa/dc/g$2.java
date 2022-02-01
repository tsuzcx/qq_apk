package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qz.c;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.internal.tls.OkHostnameVerifier;

final class g$2
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    if (c.a) {
      return true;
    }
    return OkHostnameVerifier.INSTANCE.verify(paramString, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.g.2
 * JD-Core Version:    0.7.0.1
 */
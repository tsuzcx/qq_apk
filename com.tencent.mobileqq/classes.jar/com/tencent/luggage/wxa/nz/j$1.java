package com.tencent.luggage.wxa.nz;

import java.util.ArrayList;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class j$1
  implements HostnameVerifier
{
  j$1(HostnameVerifier paramHostnameVerifier, ArrayList paramArrayList) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (this.a.verify(paramString, paramSSLSession)) || (j.b(this.b, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.j.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.imsdk.common;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class HttpClient$2
  implements HostnameVerifier
{
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (paramString.contains("cloud")) || (paramString.contains("tim"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.HttpClient.2
 * JD-Core Version:    0.7.0.1
 */
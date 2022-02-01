package com.tencent.mobileqq.app.face;

import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class FaceDownloader$2
  implements HostnameVerifier
{
  FaceDownloader$2(boolean paramBoolean, URL paramURL) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return (this.val$isIp) || (HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$urlObj.getHost(), paramSSLSession));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDownloader.2
 * JD-Core Version:    0.7.0.1
 */
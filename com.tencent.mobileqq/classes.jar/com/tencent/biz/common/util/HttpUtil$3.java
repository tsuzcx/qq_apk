package com.tencent.biz.common.util;

import com.tencent.qphone.base.util.QLog;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

final class HttpUtil$3
  implements HostnameVerifier
{
  HttpUtil$3(String paramString) {}
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    boolean bool = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.val$host, paramSSLSession);
    QLog.d("Q.share.sdk", 1, new Object[] { "uploadImageWithHttps|verify hostname=", paramString, ", host=", this.val$host, ", verify=", Boolean.valueOf(bool) });
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.common.util.HttpUtil.3
 * JD-Core Version:    0.7.0.1
 */
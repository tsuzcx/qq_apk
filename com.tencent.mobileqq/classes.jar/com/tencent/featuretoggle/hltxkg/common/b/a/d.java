package com.tencent.featuretoggle.hltxkg.common.b.a;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class d
  implements HostnameVerifier
{
  private String a;
  
  public d(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!TextUtils.isEmpty(this.a))
    {
      if (!(paramObject instanceof d)) {
        return false;
      }
      paramObject = ((d)paramObject).a;
      if (TextUtils.isEmpty(paramObject)) {
        return false;
      }
      return this.a.equals(paramObject);
    }
    return false;
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.b.a.d
 * JD-Core Version:    0.7.0.1
 */
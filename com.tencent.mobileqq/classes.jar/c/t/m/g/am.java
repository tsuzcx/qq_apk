package c.t.m.g;

import android.text.TextUtils;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class am
  implements HostnameVerifier
{
  private String a;
  
  public am(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((TextUtils.isEmpty(this.a)) || (!(paramObject instanceof am))) {}
    do
    {
      return false;
      paramObject = ((am)paramObject).a;
    } while (TextUtils.isEmpty(paramObject));
    return this.a.equals(paramObject);
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.am
 * JD-Core Version:    0.7.0.1
 */
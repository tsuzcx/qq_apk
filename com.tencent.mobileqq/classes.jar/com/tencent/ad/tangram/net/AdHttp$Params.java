package com.tencent.ad.tangram.net;

import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import java.net.URL;

@Keep
public class AdHttp$Params
{
  public static final String METHOD_GET = "GET";
  public static final String METHOD_POST = "POST";
  public int connectTimeoutMillis = 10000;
  public String contentType;
  public long durationMillis = -2147483648L;
  public boolean isInstanceFollowRedirects = false;
  public String method;
  public int readTimeoutMillis = 10000;
  public String referer;
  public byte[] requestData;
  public int responseCode = -2147483648;
  public byte[] responseData;
  private URL url;
  
  public boolean canSend()
  {
    boolean bool;
    if ((this.url != null) && (!TextUtils.isEmpty(this.method))) {
      bool = true;
    }
    while (TextUtils.equals(this.method, "POST")) {
      if ((bool) && (this.requestData != null))
      {
        return true;
        bool = false;
      }
      else
      {
        return false;
      }
    }
    return bool;
  }
  
  public String getUrl()
  {
    if (this.url != null) {
      return this.url.toString();
    }
    return null;
  }
  
  public boolean isSuccess()
  {
    return (canSend()) && (this.responseCode == 200);
  }
  
  public void setUrl(String paramString)
  {
    try
    {
      this.url = new URL(paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdHttp", "setUrl " + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdHttp.Params
 * JD-Core Version:    0.7.0.1
 */
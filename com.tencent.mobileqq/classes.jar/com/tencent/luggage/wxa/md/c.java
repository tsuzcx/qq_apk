package com.tencent.luggage.wxa.md;

import android.webkit.URLUtil;
import com.tencent.luggage.wxa.qz.q;
import java.net.MalformedURLException;
import java.net.URL;

public class c
  implements b
{
  public String a(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {
      return paramString;
    }
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("http://mpvideo.qpic.cn")) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    }
    try
    {
      paramString = new URL(str);
    }
    catch (MalformedURLException paramString)
    {
      com.tencent.luggage.wxa.mf.b.a(6, "DefaultCacheKeyGenerator", com.tencent.luggage.wxa.mf.b.a(paramString));
      paramString = null;
    }
    if (paramString != null) {
      return q.a(str).substring(0, 20);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.md.c
 * JD-Core Version:    0.7.0.1
 */
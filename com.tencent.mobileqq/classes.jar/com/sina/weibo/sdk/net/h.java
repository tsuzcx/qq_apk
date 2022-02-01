package com.sina.weibo.sdk.net;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class h
{
  private HashMap<String, String> s = new HashMap();
  
  public final String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.s.keySet().iterator();
    int i = 1;
    label118:
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        for (;;)
        {
          String str2 = (String)this.s.get(str1);
          if (TextUtils.isEmpty(str2)) {
            break label118;
          }
          try
          {
            localStringBuilder.append(URLEncoder.encode(str1, "UTF-8")).append("=").append(URLEncoder.encode(str2, "UTF-8"));
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  public final void put(String paramString1, String paramString2)
  {
    this.s.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.net.h
 * JD-Core Version:    0.7.0.1
 */
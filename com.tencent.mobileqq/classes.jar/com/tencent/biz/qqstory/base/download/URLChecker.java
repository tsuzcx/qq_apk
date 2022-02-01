package com.tencent.biz.qqstory.base.download;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.net.URL;

@TargetApi(14)
public class URLChecker
{
  public static URL a(URL paramURL)
  {
    String str1 = paramURL.getHost();
    int k = str1.indexOf(':');
    if (k != -1)
    {
      String str2 = str1.substring(0, k);
      int j = paramURL.getPort();
      int i = j;
      if (j == -1) {
        i = Integer.valueOf(str1.substring(k + 1)).intValue();
      }
      SLog.b("URLChecker", "url is not initilized correctly, so re-create it");
      return new URL(paramURL.getProtocol(), str2, i, paramURL.getFile());
    }
    return paramURL;
  }
  
  public static boolean a(URL paramURL)
  {
    return paramURL.getHost().indexOf(':') == -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.URLChecker
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.component.network.downloader;

import android.text.TextUtils;
import com.tencent.component.network.utils.NetworkUtils;
import pod;
import poe;

public abstract class UrlKeyGenerator
{
  public static final UrlKeyGenerator a = new pod(null);
  public static final UrlKeyGenerator b = new poe(null);
  
  private static boolean b(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 == null) || (paramString2 == null)) {
      return false;
    }
    return paramString1.regionMatches(true, 0, paramString2, 0, paramString2.length());
  }
  
  public final String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!NetworkUtils.isNetworkUrl(paramString)) {
      return paramString;
    }
    return b(paramString);
  }
  
  public abstract String b(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.UrlKeyGenerator
 * JD-Core Version:    0.7.0.1
 */
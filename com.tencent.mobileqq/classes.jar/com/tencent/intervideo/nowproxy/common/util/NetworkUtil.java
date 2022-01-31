package com.tencent.intervideo.nowproxy.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

public class NetworkUtil
{
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext == null) {
      return 30;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext != null)
    {
      if (!paramContext.isAvailable()) {
        return 31;
      }
      return paramContext.getType();
    }
    return 30;
  }
  
  public static boolean hasProxy()
  {
    String str1 = System.getProperty("http.proxyHost");
    String str2 = System.getProperty("http.proxyPort");
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2));
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isAvailable());
  }
  
  public static String replaceDomainWithIp(String paramString1, String paramString2)
  {
    String str = paramString1;
    try
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        str = paramString1;
        if (!TextUtils.isEmpty(paramString1)) {
          str = replaceIp(paramString1, "http://" + paramString2 + "/");
        }
      }
      return str;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public static String replaceIp(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 != null)
    {
      str = paramString1;
      if (paramString2 != null)
      {
        str = paramString1;
        if (paramString2.length() > 0) {
          str = paramString1.replaceFirst("http://[^/\\s]*/", paramString2);
        }
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.util.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */
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
    if (paramContext != null) {
      return paramContext.isAvailable();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.intervideo.nowproxy.common.util.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */
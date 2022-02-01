package com.tencent.beacon.core.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class e
{
  public static NetworkInfo a(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      d.a(paramContext);
    }
    return null;
  }
  
  public static String b(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return "unknown";
    }
    if (paramContext.getType() == 1) {
      return "wifi";
    }
    String str = paramContext.getExtraInfo();
    paramContext = str;
    if (str != null)
    {
      paramContext = str;
      if (str.length() > 64) {
        paramContext = str.substring(0, 64);
      }
    }
    return "" + paramContext;
  }
  
  public static boolean c(Context paramContext)
  {
    paramContext = a(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static boolean d(Context paramContext)
  {
    paramContext = a(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.e.e
 * JD-Core Version:    0.7.0.1
 */
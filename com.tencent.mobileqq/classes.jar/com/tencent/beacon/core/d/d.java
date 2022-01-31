package com.tencent.beacon.core.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class d
{
  public static boolean a(Context paramContext)
  {
    paramContext = d(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = d(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String c(Context paramContext)
  {
    paramContext = d(paramContext);
    if (paramContext == null) {
      paramContext = "unknown";
    }
    String str;
    do
    {
      do
      {
        return paramContext;
        if (paramContext.getType() == 1) {
          return "wifi";
        }
        str = paramContext.getExtraInfo();
        paramContext = str;
      } while (str == null);
      paramContext = str;
    } while (str.length() <= 64);
    return str.substring(0, 64);
  }
  
  private static NetworkInfo d(Context paramContext)
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
      b.a(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.d
 * JD-Core Version:    0.7.0.1
 */
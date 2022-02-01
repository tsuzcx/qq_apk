package com.tencent.map.tools.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

@SuppressLint({"MissingPermission"})
public class NetUtil
{
  public static final String MAP_USER_AGENT = "QQ Map Mobile";
  public static final String STR_UserAgent = "androidsdk";
  public static final int TYPE_3GWAP = 3;
  public static final int TYPE_CMWAP = 1;
  public static final int TYPE_CTWAP = 4;
  public static final int TYPE_NET_WORK_DISABLED = 0;
  public static final int TYPE_OTHER_NET = 6;
  public static final int TYPE_UNIWAP = 2;
  public static final int TYPE_WIFI = 5;
  
  public static int getNetType(Context paramContext)
  {
    paramContext = getNetworkInfo(paramContext);
    if ((paramContext != null) && (paramContext.isAvailable()))
    {
      int i = paramContext.getType();
      if (i == 1) {
        return 5;
      }
      if (i != 0) {
        return 6;
      }
      paramContext = paramContext.getExtraInfo();
      if (TextUtils.isEmpty(paramContext)) {
        return 6;
      }
      if (paramContext.equalsIgnoreCase("cmwap")) {
        return 1;
      }
      if (!paramContext.equalsIgnoreCase("3gwap"))
      {
        if (paramContext.equalsIgnoreCase("uniwap")) {
          return 2;
        }
        if (paramContext.equalsIgnoreCase("ctwap")) {
          return 4;
        }
      }
      return 3;
    }
    return 0;
  }
  
  public static String getNetTypeStr(Context paramContext)
  {
    int i = getNetType(paramContext);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5) {
              return "";
            }
            return "wifi";
          }
          return "ctwap";
        }
        return "3gwap";
      }
      return "uniwap";
    }
    return "cmwap";
  }
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      label15:
      break label15;
    }
    return null;
  }
  
  public static String getNetworkType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        if (i == 1) {
          return "wifi";
        }
        if (i == 0)
        {
          i = paramContext.getSubtype();
          switch (i)
          {
          case 7: 
          default: 
            return "other";
          case 5: 
          case 6: 
          case 8: 
            return "3g";
          case 4: 
            return "2g";
          case 3: 
            return "3g";
          }
          return "2g";
        }
        return "other";
      }
      return "unknown";
    }
    catch (Exception paramContext) {}
    return "unknown";
  }
  
  public static boolean isMobile(Context paramContext)
  {
    int i = getNetType(paramContext);
    return (i != 0) && (i != 5);
  }
  
  public static boolean isNetAvailable(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      paramContext = getNetworkInfo(paramContext);
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
      paramContext = localConnectivityManager.getAllNetworkInfo();
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        localConnectivityManager = paramContext[i];
        if (localConnectivityManager.isAvailable())
        {
          boolean bool = localConnectivityManager.isConnectedOrConnecting();
          if (bool) {
            return true;
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    return getNetType(paramContext) == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.tools.net.NetUtil
 * JD-Core Version:    0.7.0.1
 */
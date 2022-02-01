package com.tencent.falco.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;

public final class NetworkUtil
{
  public static final int NETWORK_2G = 2;
  public static final int NETWORK_3G = 3;
  public static final int NETWORK_4G = 4;
  public static final int NETWORK_MOBILE = 5;
  public static final int NETWORK_NONE = 0;
  public static final int NETWORK_WIFI = 1;
  
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return null;
    }
    NetworkInfo localNetworkInfo = paramContext.getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {
      return localNetworkInfo;
    }
    paramContext = paramContext.getAllNetworkInfo();
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        if (paramContext[i].getState() == NetworkInfo.State.CONNECTED) {
          return paramContext[i];
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return 0;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable())) {
      return 0;
    }
    localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
    if (localObject != null)
    {
      localObject = ((NetworkInfo)localObject).getState();
      if ((localObject != null) && ((localObject == NetworkInfo.State.CONNECTED) || (localObject == NetworkInfo.State.CONNECTING))) {
        return 1;
      }
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getNetworkType())
    {
    default: 
      return 5;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return 2;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
      return 3;
    }
    return 4;
  }
  
  public static boolean is2GNetwork(Context paramContext)
  {
    return getNetworkType(paramContext) == 2;
  }
  
  public static boolean is3GNetwork(Context paramContext)
  {
    return getNetworkType(paramContext) == 3;
  }
  
  public static boolean is4GNetwork(Context paramContext)
  {
    return getNetworkType(paramContext) == 4;
  }
  
  public static boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null) {
        return paramContext.isAvailable();
      }
    }
    return false;
  }
  
  public static boolean isWiFi(Context paramContext)
  {
    return getNetworkType(paramContext) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */
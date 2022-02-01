package com.huawei.hms.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public abstract class NetWorkUtil
{
  public static int a(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()))
    {
      if (paramNetworkInfo.getType() == 1) {
        return 1;
      }
      if (paramNetworkInfo.getType() == 0)
      {
        switch (paramNetworkInfo.getSubtype())
        {
        default: 
          return 6;
        case 13: 
        case 14: 
          return 4;
        case 3: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 15: 
          return 3;
        }
        return 2;
      }
    }
    return 0;
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext != null) {
      return paramContext.getActiveNetworkInfo();
    }
    return null;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    return a(a(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.NetWorkUtil
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class h
{
  public static String a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      if ((!paramString.equalsIgnoreCase("TD-SCDMA")) && (!paramString.equalsIgnoreCase("WCDMA")))
      {
        str = paramString;
        if (!paramString.equalsIgnoreCase("CDMA2000")) {
          return str;
        }
      }
      break;
    case 13: 
      return "4G";
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
      return "2G";
    }
    String str = "3G";
    return str;
  }
  
  public static String a(Context paramContext)
  {
    Object localObject1 = "";
    if ((paramContext != null) && (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) == 0))
    {
      Object localObject2 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      paramContext = (Context)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
        paramContext = (Context)localObject1;
        if (localObject2 != null)
        {
          paramContext = (Context)localObject1;
          if (((NetworkInfo)localObject2).isConnected())
          {
            if (((NetworkInfo)localObject2).getType() == 1) {
              return "WIFI";
            }
            if (((NetworkInfo)localObject2).getType() == 0)
            {
              paramContext = ((NetworkInfo)localObject2).getSubtypeName();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Network getSubtypeName : ");
              ((StringBuilder)localObject1).append(paramContext);
              y.c("hmsSdk", ((StringBuilder)localObject1).toString());
              return a(((NetworkInfo)localObject2).getSubtype(), paramContext);
            }
            if (((NetworkInfo)localObject2).getType() == 16)
            {
              paramContext = new StringBuilder();
              paramContext.append("type name = ");
              paramContext.append("COMPANION_PROXY");
              y.f("hmsSdk", paramContext.toString());
              return "COMPANION_PROXY";
            }
            if (((NetworkInfo)localObject2).getType() == 9)
            {
              paramContext = new StringBuilder();
              paramContext.append("type name = ");
              paramContext.append("ETHERNET");
              y.c("hmsSdk", paramContext.toString());
              return "ETHERNET";
            }
            paramContext = new StringBuilder();
            paramContext.append("type name = ");
            paramContext.append(((NetworkInfo)localObject2).getType());
            y.c("hmsSdk", paramContext.toString());
            paramContext = "OTHER_NETWORK_TYPE";
          }
        }
      }
      return paramContext;
    }
    y.f("hmsSdk", "not have network state phone permission!");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.h
 * JD-Core Version:    0.7.0.1
 */
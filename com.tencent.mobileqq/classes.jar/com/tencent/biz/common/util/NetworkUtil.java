package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtil
{
  public static NetworkInfo getNetworInfo(Context paramContext)
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
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        break label269;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected())) {
        break label195;
      }
      i = paramContext.getType();
      if (!QLog.isColorLevel()) {
        break label305;
      }
      QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType type = ", Integer.valueOf(i) });
    }
    catch (IllegalStateException paramContext)
    {
      if (!QLog.isColorLevel()) {
        break label343;
      }
      QLog.d("NetworkUtil", 2, "getNetworkType IllegalStateException", paramContext);
      break label343;
      if (!QLog.isColorLevel()) {
        break label343;
      }
      QLog.d("NetworkUtil", 2, "getNetworkType could not get ConnectivityManager");
      break label343;
    }
    catch (Exception paramContext)
    {
      int i;
      label195:
      while (QLog.isColorLevel())
      {
        QLog.d("NetworkUtil", 2, "getNetworkType exception", paramContext);
        break;
        switch (i)
        {
        case 0: 
        default: 
          return -1;
        }
        return 1;
      }
      label269:
      label305:
      return -1;
      return 2;
      return 3;
      return 4;
    }
    i = paramContext.getSubtype();
    switch (i)
    {
    default: 
      if (QLog.isColorLevel())
      {
        QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType subType = ", Integer.valueOf(i) });
        break;
        if (paramContext == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NetworkUtil", 2, "getNetworkType networkInfo = null");
          }
        }
        else if (QLog.isColorLevel()) {
          QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType networkInfo isConnected =", Boolean.valueOf(paramContext.isConnected()) });
        }
      }
      break;
    }
    label343:
    return 0;
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
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      paramContext = paramContext.getAllNetworkInfo();
      if (paramContext != null)
      {
        int i = 0;
        while (i < paramContext.length)
        {
          if (paramContext[i].getState() == NetworkInfo.State.CONNECTED) {
            return true;
          }
          i += 1;
        }
      }
    }
  }
  
  public static String toDirectIpUrl(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        String str = new URL(paramString).getHost();
        Object localObject2 = InnerDns.getInstance().reqDns(str, paramInt);
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          Object localObject1 = localObject2;
          if (!((String)localObject2).contains(":"))
          {
            localObject2 = new StringBuilder().append((String)localObject2);
            if (!paramString.startsWith("https")) {
              break label89;
            }
          }
          label89:
          for (localObject1 = ":443";; localObject1 = ":80")
          {
            localObject1 = (String)localObject1;
            return paramString.replaceFirst(str, (String)localObject1);
          }
        }
        return paramString;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("NetworkUtil", 1, "MalformedURLException", localMalformedURLException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.common.util.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */
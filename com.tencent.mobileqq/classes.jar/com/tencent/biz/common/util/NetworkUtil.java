package com.tencent.biz.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtil
{
  public static String a(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        String str4 = new URL(paramString).getHost();
        String str3 = InnerDns.getInstance().reqDns(str4, paramInt);
        if (!TextUtils.isEmpty(str3))
        {
          String str1 = str3;
          if (!str3.contains(":"))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(str3);
            if (!paramString.startsWith("https")) {
              break label114;
            }
            str1 = ":443";
            localStringBuilder.append(str1);
            str1 = localStringBuilder.toString();
          }
          str1 = paramString.replaceFirst(str4, str1);
          return str1;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        QLog.e("NetworkUtil", 1, "MalformedURLException", localMalformedURLException);
      }
      return paramString;
      label114:
      String str2 = ":80";
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
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
    return false;
  }
  
  public static int b(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if (paramContext != null)
        {
          paramContext = paramContext.getActiveNetworkInfo();
          if ((paramContext != null) && (paramContext.isConnected()))
          {
            i = paramContext.getType();
            if (!QLog.isColorLevel()) {
              break label304;
            }
            QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType type = ", Integer.valueOf(i) });
            break label304;
            i = paramContext.getSubtype();
          }
        }
        switch (i)
        {
        default: 
          boolean bool = QLog.isColorLevel();
          if (!bool) {
            break label326;
          }
          QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType subType = ", Integer.valueOf(i) });
          return -1;
          if (paramContext == null)
          {
            if (QLog.isColorLevel())
            {
              QLog.d("NetworkUtil", 2, "getNetworkType networkInfo = null");
              return 0;
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("NetworkUtil", 2, new Object[] { "getNetworkType networkInfo isConnected =", Boolean.valueOf(paramContext.isConnected()) });
            return 0;
            if (QLog.isColorLevel())
            {
              QLog.d("NetworkUtil", 2, "getNetworkType could not get ConnectivityManager");
              return 0;
            }
          }
          break;
        }
      }
      catch (Exception paramContext)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("NetworkUtil", 2, "getNetworkType exception", paramContext);
          return 0;
        }
      }
      catch (IllegalStateException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NetworkUtil", 2, "getNetworkType IllegalStateException", paramContext);
        }
      }
      return 0;
      label304:
      if (i != 0)
      {
        if (i != 1) {
          return -1;
        }
        return 1;
      }
    }
    return 4;
    return 3;
    return 2;
    label326:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */
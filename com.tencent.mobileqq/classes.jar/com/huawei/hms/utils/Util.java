package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util
{
  private static boolean a = false;
  private static boolean b = false;
  private static final Object c = new Object();
  
  private static boolean a(String paramString)
  {
    return Pattern.compile("(^([0-9]{1,2}\\.){2}[0-9]{1,2}$)|(^([0-9]{1,2}\\.){3}[0-9]{1,3}$)").matcher(paramString).find();
  }
  
  private static int b(String paramString)
  {
    int j = 0;
    int i = j;
    if (a(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length >= 3) {
        break label28;
      }
      i = j;
    }
    label28:
    do
    {
      return i;
      j = Integer.parseInt(paramString[0]) * 10000000 + Integer.parseInt(paramString[1]) * 100000 + Integer.parseInt(paramString[2]) * 1000;
      i = j;
    } while (paramString.length != 4);
    return j + Integer.parseInt(paramString[3]);
  }
  
  public static int compareHmsVersion(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        do
        {
          return -1;
          if (TextUtils.isEmpty(paramString2)) {
            return 1;
          }
          if ((!a(paramString1)) || (!a(paramString2))) {
            break;
          }
          paramString1 = paramString1.split("\\.");
          paramString2 = paramString2.split("\\.");
          if (Integer.parseInt(paramString1[0]) > Integer.parseInt(paramString2[0])) {
            return 1;
          }
        } while (Integer.parseInt(paramString1[0]) < Integer.parseInt(paramString2[0]));
        if (Integer.parseInt(paramString1[1]) > Integer.parseInt(paramString2[1])) {
          return 1;
        }
      } while (Integer.parseInt(paramString1[1]) < Integer.parseInt(paramString2[1]));
      if (Integer.parseInt(paramString1[2]) > Integer.parseInt(paramString2[2])) {
        return 1;
      }
    } while (Integer.parseInt(paramString1[2]) < Integer.parseInt(paramString2[2]));
    return 0;
  }
  
  public static Activity getActiveActivity(Activity paramActivity, Context paramContext)
  {
    return UIUtil.getActiveActivity(paramActivity, paramContext);
  }
  
  public static String getAppId(Context paramContext)
  {
    return AGCUtils.getAppId(paramContext);
  }
  
  public static String getAppName(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      HMSLog.e("Util", "In getAppName, context is null.");
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
      return "";
    }
    String str = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str = paramContext.getPackageName();
      }
      paramContext = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(str, 0));
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("Util", "In getAppName, Failed to get app name.");
      return "";
    }
    catch (Resources.NotFoundException paramContext)
    {
      label75:
      break label75;
    }
  }
  
  public static String getCpId(Context paramContext)
  {
    return AGCUtils.getCpId(paramContext);
  }
  
  public static int getHmsVersion(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
      return 0;
    }
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.huawei.hms.version");
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          if (!TextUtils.isEmpty(paramContext)) {
            return b(paramContext);
          }
        }
      }
      HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
    }
    return 0;
  }
  
  public static String getNetType(Context paramContext)
  {
    return SystemUtils.getNetType(paramContext);
  }
  
  public static String getProcessName(Context paramContext, int paramInt)
  {
    return UIUtil.getProcessName(paramContext, paramInt);
  }
  
  public static String getProductCountry()
  {
    Object localObject = getSystemProperties("ro.product.locale.region", "");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    String str;
    do
    {
      return localObject;
      localObject = getSystemProperties("ro.product.locale", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        int i = ((String)localObject).lastIndexOf("_");
        if (i != -1) {
          return ((String)localObject).substring(i + 1);
        }
      }
      str = SystemUtils.getLocalCountry();
      localObject = str;
    } while (!TextUtils.isEmpty(str));
    return "";
  }
  
  public static String getSystemProperties(String paramString1, String paramString2)
  {
    return SystemUtils.getSystemProperties(paramString1, paramString2);
  }
  
  public static Activity getValidActivity(Activity paramActivity1, Activity paramActivity2)
  {
    Activity localActivity;
    if (paramActivity1 != null)
    {
      localActivity = paramActivity1;
      if (!paramActivity1.isFinishing()) {}
    }
    else
    {
      if ((paramActivity2 != null) && (!paramActivity2.isFinishing())) {
        return paramActivity2;
      }
      localActivity = null;
    }
    return localActivity;
    return paramActivity2;
  }
  
  public static boolean isAvailableLibExist(Context paramContext)
  {
    for (;;)
    {
      boolean bool3;
      boolean bool4;
      boolean bool1;
      PackageManager localPackageManager;
      synchronized (c)
      {
        if (!a)
        {
          bool3 = false;
          bool4 = false;
          bool1 = false;
          localPackageManager = paramContext.getPackageManager();
          if (localPackageManager == null) {
            HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
          }
        }
        else
        {
          try
          {
            Class.forName("com.huawei.hms.adapter.AvailableAdapter");
            bool1 = true;
          }
          catch (ClassNotFoundException paramContext)
          {
            HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");
            continue;
          }
          b = bool1;
          a = true;
          HMSLog.i("Util", "available exist: " + b);
          return b;
        }
      }
      boolean bool2 = bool4;
      try
      {
        paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
        bool1 = bool3;
        if (paramContext != null)
        {
          bool1 = bool3;
          bool2 = bool4;
          if (paramContext.metaData != null)
          {
            bool2 = bool4;
            paramContext = paramContext.metaData.get("availableLoaded");
            bool1 = bool3;
            if (paramContext != null)
            {
              bool1 = bool3;
              bool2 = bool4;
              if (String.valueOf(paramContext).equalsIgnoreCase("yes"))
              {
                bool2 = bool4;
                HMSLog.i("Util", "available exist: true");
                bool1 = true;
              }
            }
          }
        }
        bool2 = bool1;
        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
        bool1 = bool2;
      }
    }
  }
  
  public static boolean isBackground(Context paramContext)
  {
    boolean bool2 = false;
    if (paramContext == null) {}
    KeyguardManager localKeyguardManager;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    do
    {
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            return true;
            localObject = (ActivityManager)paramContext.getSystemService("activity");
            localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
          } while ((localObject == null) || (localKeyguardManager == null));
          localObject = ((ActivityManager)localObject).getRunningAppProcesses();
        } while (localObject == null);
        paramContext = getProcessName(paramContext, Process.myPid());
        localObject = ((List)localObject).iterator();
      }
      localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
    } while (!TextUtils.equals(localRunningAppProcessInfo.processName, paramContext));
    HMSLog.i("Util", "appProcess.importance is " + localRunningAppProcessInfo.importance);
    if (localRunningAppProcessInfo.importance == 100) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool3 = localKeyguardManager.inKeyguardRestrictedInputMode();
      HMSLog.i("Util", "isForground is " + bool1 + "***  isLockedState is " + bool3);
      if (bool1)
      {
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public static boolean isChinaROM()
  {
    return SystemUtils.isChinaROM();
  }
  
  public static boolean isEMUI()
  {
    return SystemUtils.isEMUI();
  }
  
  public static void unBindServiceCatchException(Context paramContext, ServiceConnection paramServiceConnection)
  {
    try
    {
      HMSLog.i("Util", "Trying to unbind service from " + paramServiceConnection);
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("Util", "On unBindServiceException:" + paramContext.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.Util
 * JD-Core Version:    0.7.0.1
 */
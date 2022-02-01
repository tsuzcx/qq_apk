package com.huawei.hms.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;

public class Util
{
  private static final String AVAILABLE_LOADED = "availableLoaded";
  private static final Object LOCK_OBJECT = new Object();
  private static final String META_HMSVERSION_NAME = "com.huawei.hms.version";
  private static final String SERVICE_ACTION = "com.huawei.hms.core.aidl.action";
  private static final String TAG = "Util";
  private static boolean availableInit = false;
  private static boolean isAvailableAvailable = false;
  private static String serviceAction;
  
  public static int compareHmsVersion(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return -1;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return 1;
    }
    if ((StringUtil.checkVersion(paramString1)) && (StringUtil.checkVersion(paramString2)))
    {
      paramString1 = paramString1.split("\\.");
      paramString2 = paramString2.split("\\.");
      if ((2 < paramString1.length) && (2 < paramString2.length))
      {
        if (Integer.parseInt(paramString1[0]) > Integer.parseInt(paramString2[0])) {
          return 1;
        }
        if (Integer.parseInt(paramString1[0]) < Integer.parseInt(paramString2[0])) {
          return -1;
        }
        if (Integer.parseInt(paramString1[1]) > Integer.parseInt(paramString2[1])) {
          return 1;
        }
        if (Integer.parseInt(paramString1[1]) < Integer.parseInt(paramString2[1])) {
          return -1;
        }
        if (Integer.parseInt(paramString1[2]) > Integer.parseInt(paramString2[2])) {
          return 1;
        }
        if (Integer.parseInt(paramString1[2]) < Integer.parseInt(paramString2[2])) {
          return -1;
        }
      }
    }
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
    catch (PackageManager.NameNotFoundException|Resources.NotFoundException paramContext)
    {
      label74:
      break label74;
    }
    HMSLog.e("Util", "In getAppName, Failed to get app name.");
    return "";
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
            return StringUtil.convertVersion2Integer(paramContext);
          }
        }
      }
      HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label84:
      break label84;
    }
    HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
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
  
  @Deprecated
  public static String getProductCountry()
  {
    Object localObject = "";
    String str = getSystemProperties("ro.product.locale.region", "");
    if (!TextUtils.isEmpty(str)) {
      return str;
    }
    str = getSystemProperties("ro.product.locale", "");
    if (!TextUtils.isEmpty(str))
    {
      int i = str.lastIndexOf("-");
      if (i != -1) {
        return str.substring(i + 1);
      }
    }
    str = SystemUtils.getLocalCountry();
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    return localObject;
  }
  
  public static String getServiceActionMetadata(Context paramContext)
  {
    Object localObject = serviceAction;
    if (localObject != null) {
      return localObject;
    }
    localObject = paramContext.getPackageManager();
    if (localObject == null)
    {
      HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
      return null;
    }
    try
    {
      paramContext = ((PackageManager)localObject).getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.huawei.hms.core.aidl.action");
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          if (!TextUtils.isEmpty(paramContext))
          {
            serviceAction = paramContext;
            return serviceAction;
          }
        }
      }
      HMSLog.i("Util", "In getServiceActionMetadata, Failed to read meta data for the SERVICE ACTION.");
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label98:
      break label98;
    }
    HMSLog.w("Util", "In getServiceActionMetadata, Failed to read meta data for the SERVICE ACTION.");
    serviceAction = "";
    return serviceAction;
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
  }
  
  public static boolean isAvailableLibExist(Context paramContext)
  {
    synchronized (LOCK_OBJECT)
    {
      boolean bool2;
      PackageManager localPackageManager;
      if (!availableInit)
      {
        bool2 = false;
        localPackageManager = paramContext.getPackageManager();
        if (localPackageManager == null) {
          HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
        }
      }
      try
      {
        Class.forName("com.huawei.hms.adapter.AvailableAdapter");
      }
      catch (ClassNotFoundException paramContext)
      {
        label41:
        boolean bool1;
        label126:
        break label41;
      }
      HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");
      bool1 = bool2;
      try
      {
        paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
        bool1 = bool2;
        if (paramContext == null) {
          break label135;
        }
        bool1 = bool2;
        if (paramContext.metaData == null) {
          break label135;
        }
        paramContext = paramContext.metaData.get("availableLoaded");
        bool1 = bool2;
        if (paramContext == null) {
          break label135;
        }
        bool1 = bool2;
        if (!String.valueOf(paramContext).equalsIgnoreCase("yes")) {
          break label135;
        }
        HMSLog.i("Util", "available exist: true");
        bool1 = true;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        break label126;
      }
      HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
      bool1 = bool2;
      label135:
      isAvailableAvailable = bool1;
      availableInit = true;
      paramContext = new StringBuilder();
      paramContext.append("available exist: ");
      paramContext.append(isAvailableAvailable);
      HMSLog.i("Util", paramContext.toString());
      return isAvailableAvailable;
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Trying to unbind service from ");
      localStringBuilder.append(paramServiceConnection);
      HMSLog.i("Util", localStringBuilder.toString());
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    catch (Exception paramContext)
    {
      paramServiceConnection = new StringBuilder();
      paramServiceConnection.append("On unBindServiceException:");
      paramServiceConnection.append(paramContext.getMessage());
      HMSLog.e("Util", paramServiceConnection.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.Util
 * JD-Core Version:    0.7.0.1
 */
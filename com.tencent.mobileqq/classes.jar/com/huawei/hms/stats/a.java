package com.huawei.hms.stats;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.support.log.HMSLog;

public class a
{
  public static int a;
  public static final Object b = new Object();
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null)
    {
      HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {}
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext == null) || (paramContext.metaData == null)) {
        break label67;
      }
      boolean bool = paramContext.metaData.getBoolean("com.huawei.hms.client.bireport.setting");
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label60:
      label67:
      break label60;
    }
    HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
    HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null)
    {
      HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager != null) {}
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 128).applicationInfo;
      if ((paramContext == null) || (paramContext.metaData == null)) {
        break label67;
      }
      boolean bool = paramContext.metaData.getBoolean("com.huawei.hms.client.bi.setting");
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label60:
      label67:
      break label60;
    }
    HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
    HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    synchronized (b)
    {
      int i = a;
      bool = true;
      if (i == 0)
      {
        if (paramContext == null) {
          return true;
        }
        if (a(paramContext))
        {
          HMSLog.i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");
          a = 1;
        }
        else if (b(paramContext))
        {
          HMSLog.i("AnalyticsSwitchHolder", "Builder->biSetting :true");
          a = 2;
        }
        else if ("CN".equalsIgnoreCase(GrsApp.getInstance().getIssueCountryCode(paramContext)))
        {
          a = 1;
        }
        else
        {
          HMSLog.i("AnalyticsSwitchHolder", "not ChinaROM");
        }
      }
      try
      {
        i = Settings.Secure.getInt(paramContext.getContentResolver(), "hw_app_analytics_state");
        paramContext = new StringBuilder();
        paramContext.append("hw_app_analytics_state value is ");
        paramContext.append(i);
        HMSLog.i("AnalyticsSwitchHolder", paramContext.toString());
        if (i == 1) {
          a = 1;
        } else {
          a = 2;
        }
      }
      catch (Settings.SettingNotFoundException paramContext)
      {
        for (;;)
        {
          continue;
          bool = false;
        }
      }
      HMSLog.i("AnalyticsSwitchHolder", "Get OOBE failed");
      a = 2;
      if (a != 1) {
        return bool;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.a
 * JD-Core Version:    0.7.0.1
 */
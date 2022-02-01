package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper
{
  public static void doAutoInit(Context paramContext)
  {
    try
    {
      boolean bool = isAutoInitEnabled(paramContext);
      if (bool)
      {
        HMSLog.i("AutoInit", "Push init start");
        new Thread(new f(paramContext)).start();
        return;
      }
    }
    catch (Exception paramContext)
    {
      HMSLog.e("AutoInit", "Push init failed", paramContext);
    }
  }
  
  public static boolean isAutoInitEnabled(Context paramContext)
  {
    i locali = i.a(paramContext);
    if (locali.containsKey("push_kit_auto_init_enabled")) {
      return locali.getBoolean("push_kit_auto_init_enabled");
    }
    try
    {
      boolean bool = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label46:
      break label46;
    }
    return false;
  }
  
  public static void setAutoInitEnabled(Context paramContext, boolean paramBoolean)
  {
    i locali = i.a(paramContext);
    boolean bool = locali.getBoolean("push_kit_auto_init_enabled");
    locali.saveBoolean("push_kit_auto_init_enabled", paramBoolean);
    if ((paramBoolean) && (!bool)) {
      doAutoInit(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.aaid.init.AutoInitHelper
 * JD-Core Version:    0.7.0.1
 */
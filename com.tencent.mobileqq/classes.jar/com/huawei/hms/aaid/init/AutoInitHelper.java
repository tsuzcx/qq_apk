package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.huawei.hms.opendevice.g;
import com.huawei.hms.opendevice.q;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper
{
  public static void doAutoInit(Context paramContext)
  {
    try
    {
      if (isAutoInitEnabled(paramContext))
      {
        HMSLog.i("AutoInit", "Push init start");
        new Thread(new g(paramContext)).start();
      }
      return;
    }
    catch (Exception paramContext)
    {
      HMSLog.e("AutoInit", "Push init failed", paramContext);
    }
  }
  
  public static boolean isAutoInitEnabled(Context paramContext)
  {
    q localq = new q(paramContext, "push_client_self_info");
    if (localq.d("push_kit_auto_init_enabled")) {
      return localq.a("push_kit_auto_init_enabled");
    }
    try
    {
      boolean bool = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static void setAutoInitEnabled(Context paramContext, boolean paramBoolean)
  {
    q localq = new q(paramContext, "push_client_self_info");
    boolean bool = localq.a("push_kit_auto_init_enabled");
    localq.a("push_kit_auto_init_enabled", paramBoolean);
    if ((paramBoolean) && (!bool)) {
      doAutoInit(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.aaid.init.AutoInitHelper
 * JD-Core Version:    0.7.0.1
 */
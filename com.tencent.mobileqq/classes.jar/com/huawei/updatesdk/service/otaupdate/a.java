package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build.VERSION;

public abstract class a
{
  public static void a(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    if ((paramBroadcastReceiver == null) || (paramContext == null)) {
      return;
    }
    try
    {
      paramContext.unregisterReceiver(paramBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("ActivityUtil", "unregisterReceiver error:" + paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, IntentFilter paramIntentFilter, BroadcastReceiver paramBroadcastReceiver)
  {
    if ((paramIntentFilter == null) || (paramBroadcastReceiver == null)) {}
    while (a(paramContext)) {
      return;
    }
    try
    {
      paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      return;
    }
    catch (IllegalArgumentException paramContext)
    {
      com.huawei.updatesdk.a.a.b.a.a.a.d("ActivityUtil", "registerReceiver error:" + paramContext.toString());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return true;
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      if ((paramContext.isFinishing()) || ((Build.VERSION.SDK_INT >= 17) && (paramContext.isDestroyed())))
      {
        com.huawei.updatesdk.a.a.b.a.a.a.d("ActivityUtil", "activity has bean finished, cannot instance:" + paramContext);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.a
 * JD-Core Version:    0.7.0.1
 */
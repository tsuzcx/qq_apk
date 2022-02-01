package com.huawei.hms.framework.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Process;

public class ContextCompat
{
  private static final String TAG = "ContextCompat";
  
  public static boolean checkSelfPermission(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null))
    {
      try
      {
        int i = paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
        if (i == 0) {
          return true;
        }
      }
      catch (RuntimeException paramContext)
      {
        Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", paramContext);
      }
      return false;
    }
    Logger.w("ContextCompat", "param is null");
    return false;
  }
  
  public static Context getProtectedStorageContext(Context paramContext)
  {
    if (paramContext == null)
    {
      Logger.w("ContextCompat", "context is null");
      return null;
    }
    if (Build.VERSION.SDK_INT < 24) {
      return paramContext;
    }
    return paramContext.createDeviceProtectedStorageContext();
  }
  
  public static Object getSystemService(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      Logger.w("ContextCompat", "context is null");
      return null;
    }
    try
    {
      paramContext = paramContext.getSystemService(paramString);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("ContextCompat", "SystemServer error:", paramContext);
    }
    return null;
  }
  
  public static Intent registerReceiver(Context paramContext, BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    if (paramContext == null)
    {
      Logger.w("ContextCompat", "context is null");
      return null;
    }
    try
    {
      paramContext = paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", paramContext);
    }
    return null;
  }
  
  public static Intent registerReceiver(Context paramContext, BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    if (paramContext == null)
    {
      Logger.w("ContextCompat", "context is null");
      return null;
    }
    try
    {
      paramContext = paramContext.registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("ContextCompat", "dealType rethrowFromSystemServer:", paramContext);
    }
    return null;
  }
  
  public static ComponentName startService(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      Logger.w("ContextCompat", "context is null");
      return null;
    }
    try
    {
      paramContext = paramContext.startService(paramIntent);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("ContextCompat", "SystemServer error:", paramContext);
    }
    return null;
  }
  
  public static void unregisterReceiver(Context paramContext, BroadcastReceiver paramBroadcastReceiver)
  {
    if (paramContext == null)
    {
      Logger.w("ContextCompat", "context is null");
      return;
    }
    try
    {
      paramContext.unregisterReceiver(paramBroadcastReceiver);
      return;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("ContextCompat", "SystemServer error:", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ContextCompat
 * JD-Core Version:    0.7.0.1
 */
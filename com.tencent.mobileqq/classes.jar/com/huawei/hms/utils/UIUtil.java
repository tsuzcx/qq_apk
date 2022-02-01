package com.huawei.hms.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import java.util.Iterator;
import java.util.List;

public class UIUtil
{
  public static Activity getActiveActivity(Activity paramActivity, Context paramContext)
  {
    if (isBackground(paramContext))
    {
      paramActivity = new StringBuilder();
      paramActivity.append("isBackground");
      paramActivity.append(isBackground(paramContext));
      HMSLog.i("UIUtil", paramActivity.toString());
      return null;
    }
    if (paramActivity == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("activity is ");
      paramContext.append(paramActivity);
      HMSLog.i("UIUtil", paramContext.toString());
      return ActivityMgr.INST.getCurrentActivity();
    }
    paramContext = paramActivity;
    if (paramActivity.isFinishing())
    {
      paramContext = new StringBuilder();
      paramContext.append("activity isFinishing is ");
      paramContext.append(paramActivity.isFinishing());
      HMSLog.i("UIUtil", paramContext.toString());
      paramContext = ActivityMgr.INST.getCurrentActivity();
    }
    return paramContext;
  }
  
  public static String getProcessName(Context paramContext, int paramInt)
  {
    if (paramContext == null) {
      return "";
    }
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    if (paramContext != null)
    {
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (localRunningAppProcessInfo.pid == paramInt) {
            return localRunningAppProcessInfo.processName;
          }
        }
      }
    }
    return "";
  }
  
  public static boolean isActivityFullscreen(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) == 1024;
  }
  
  public static boolean isBackground(Context paramContext)
  {
    boolean bool4 = true;
    if (paramContext == null) {
      return true;
    }
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    KeyguardManager localKeyguardManager = (KeyguardManager)paramContext.getSystemService("keyguard");
    boolean bool3 = bool4;
    if (localObject != null)
    {
      if (localKeyguardManager == null) {
        return true;
      }
      localObject = ((ActivityManager)localObject).getRunningAppProcesses();
      if (localObject == null) {
        return true;
      }
      paramContext = getProcessName(paramContext, Process.myPid());
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        bool3 = bool4;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
      } while (!TextUtils.equals(((ActivityManager.RunningAppProcessInfo)localObject).processName, paramContext));
      paramContext = new StringBuilder();
      paramContext.append("appProcess.importance is ");
      paramContext.append(((ActivityManager.RunningAppProcessInfo)localObject).importance);
      HMSLog.i("UIUtil", paramContext.toString());
      boolean bool1;
      if (((ActivityManager.RunningAppProcessInfo)localObject).importance == 100) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2;
      if (Build.VERSION.SDK_INT > 22) {
        bool2 = localKeyguardManager.isDeviceLocked();
      } else {
        bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
      }
      paramContext = new StringBuilder();
      paramContext.append("isForground is ");
      paramContext.append(bool1);
      paramContext.append("***  isLockedState is ");
      paramContext.append(bool2);
      HMSLog.i("UIUtil", paramContext.toString());
      bool3 = bool4;
      if (bool1)
      {
        if (bool2) {
          return true;
        }
        bool3 = false;
      }
    }
    return bool3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.utils.UIUtil
 * JD-Core Version:    0.7.0.1
 */
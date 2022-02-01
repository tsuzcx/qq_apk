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
      HMSLog.i("UIUtil", "isBackground" + isBackground(paramContext));
      paramContext = null;
    }
    do
    {
      return paramContext;
      if (paramActivity == null) {
        break;
      }
      paramContext = paramActivity;
    } while (!paramActivity.isFinishing());
    HMSLog.i("UIUtil", "activity is " + paramActivity + "activity isFinishing is " + paramActivity.isFinishing());
    return ActivityMgr.INST.getCurrentActivity();
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
    boolean bool3 = false;
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
    HMSLog.i("UIUtil", "appProcess.importance is " + localRunningAppProcessInfo.importance);
    boolean bool1;
    if (localRunningAppProcessInfo.importance == 100)
    {
      bool1 = true;
      if (Build.VERSION.SDK_INT < 22) {
        break label209;
      }
    }
    label209:
    for (boolean bool2 = localKeyguardManager.isDeviceLocked();; bool2 = localKeyguardManager.inKeyguardRestrictedInputMode())
    {
      HMSLog.i("UIUtil", "isForground is " + bool1 + "***  isLockedState is " + bool2);
      if (bool1)
      {
        bool1 = bool3;
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.utils.UIUtil
 * JD-Core Version:    0.7.0.1
 */
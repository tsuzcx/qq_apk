package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.List;

public class ActivityUtil
{
  private static final String TAG = "ActivityUtil";
  
  public static PendingIntent getActivities(Context paramContext, int paramInt1, Intent[] paramArrayOfIntent, int paramInt2)
  {
    if (paramContext == null)
    {
      Logger.w("ActivityUtil", "context is null");
      return null;
    }
    try
    {
      paramContext = PendingIntent.getActivities(paramContext, paramInt1, paramArrayOfIntent, paramInt2);
      return paramContext;
    }
    catch (RuntimeException paramContext)
    {
      Logger.e("ActivityUtil", "dealType rethrowFromSystemServer:", paramContext);
    }
    return null;
  }
  
  public static boolean isForeground(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject2 = (ActivityManager)ContextCompat.getSystemService(paramContext, "activity");
      if (localObject2 != null)
      {
        Object localObject1 = null;
        try
        {
          localObject2 = ((ActivityManager)localObject2).getRunningAppProcesses();
          localObject1 = localObject2;
        }
        catch (RuntimeException localRuntimeException)
        {
          Logger.w("ActivityUtil", "activityManager getRunningAppProcesses occur exception: ", localRuntimeException);
        }
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            if ((localRunningAppProcessInfo.processName != null) && (localRunningAppProcessInfo.processName.equals(paramContext.getPackageName())) && (localRunningAppProcessInfo.importance == 100))
            {
              Logger.v("ActivityUtil", "isForeground true");
              return true;
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.common.ActivityUtil
 * JD-Core Version:    0.7.0.1
 */
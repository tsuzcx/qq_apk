package com.huawei.hms.framework.common;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.PowerManager;

public class PowerUtils
{
  private static final String TAG = "PowerUtils";
  
  public static boolean isDozeIdleMode(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ContextCompat.getSystemService(paramContext, "power");
      if ((paramContext instanceof PowerManager)) {
        paramContext = (PowerManager)paramContext;
      } else {
        paramContext = null;
      }
      if (paramContext != null)
      {
        if (Build.VERSION.SDK_INT >= 23) {
          try
          {
            boolean bool = paramContext.isDeviceIdleMode();
            return bool;
          }
          catch (RuntimeException paramContext)
          {
            Logger.e("PowerUtils", "dealType rethrowFromSystemServer:", paramContext);
            return false;
          }
        }
        Logger.i("PowerUtils", "isDozeIdleMode is version control state!");
        return false;
      }
      Logger.i("PowerUtils", "isDozeIdleMode powerManager is null!");
      return false;
    }
    Logger.i("PowerUtils", "isDozeIdleMode Context is null!");
    return false;
  }
  
  public static boolean isInteractive(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ContextCompat.getSystemService(paramContext, "power");
      if ((paramContext instanceof PowerManager))
      {
        paramContext = (PowerManager)paramContext;
        if (Build.VERSION.SDK_INT >= 20) {
          try
          {
            boolean bool = paramContext.isInteractive();
            return bool;
          }
          catch (RuntimeException paramContext)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getActiveNetworkInfo failed, exception:");
            localStringBuilder.append(paramContext.getClass().getSimpleName());
            localStringBuilder.append(paramContext.getMessage());
            Logger.i("PowerUtils", localStringBuilder.toString());
          }
        }
      }
    }
    return false;
  }
  
  public static boolean isWhilteList(Context paramContext)
  {
    if (paramContext != null)
    {
      Object localObject = ContextCompat.getSystemService(paramContext, "power");
      if ((localObject instanceof PowerManager)) {
        localObject = (PowerManager)localObject;
      } else {
        localObject = null;
      }
      paramContext = paramContext.getPackageName();
      if ((localObject != null) && (Build.VERSION.SDK_INT >= 23)) {
        try
        {
          boolean bool = ((PowerManager)localObject).isIgnoringBatteryOptimizations(paramContext);
          return bool;
        }
        catch (RuntimeException paramContext)
        {
          Logger.e("PowerUtils", "dealType rethrowFromSystemServer:", paramContext);
        }
      }
    }
    return false;
  }
  
  public static int readPowerSaverMode(Context paramContext)
  {
    int i;
    if (paramContext != null)
    {
      int j = SettingUtil.getSystemInt(paramContext.getContentResolver(), PowerUtils.PowerMode.SMART_MODE_STATUS, PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE);
      i = j;
      if (j == PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE)
      {
        Object localObject1 = null;
        Object localObject2 = ContextCompat.getSystemService(paramContext, "power");
        paramContext = localObject1;
        if ((localObject2 instanceof PowerManager)) {
          paramContext = (PowerManager)localObject2;
        }
        i = j;
        if (paramContext != null)
        {
          if (Build.VERSION.SDK_INT >= 21) {
            try
            {
              if (paramContext.isPowerSaveMode()) {
                i = PowerUtils.PowerMode.POWER_SAVER_MODE;
              } else {
                i = PowerUtils.PowerMode.POWER_MODE_DEFAULT_RETURN_VALUE;
              }
              return i;
            }
            catch (RuntimeException paramContext)
            {
              Logger.e("PowerUtils", "dealType rethrowFromSystemServer:", paramContext);
              return j;
            }
          }
          Logger.i("PowerUtils", "readPowerSaverMode is control by version!");
          return j;
        }
      }
    }
    else
    {
      Logger.i("PowerUtils", "readPowerSaverMode Context is null!");
      i = 0;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.PowerUtils
 * JD-Core Version:    0.7.0.1
 */
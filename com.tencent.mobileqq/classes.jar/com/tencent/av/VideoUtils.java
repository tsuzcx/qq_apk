package com.tencent.av;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import com.tencent.av.app.DeprecatedClass.VideoUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.List;

public class VideoUtils
  extends DeprecatedClass.VideoUtils
{
  public static final String a = ;
  
  public static Bitmap a(Resources paramResources, String paramString)
  {
    return a(paramString, 320, paramResources.getDisplayMetrics().densityDpi);
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inDensity = paramInt1;
    if (paramInt2 >= 0) {
      ((BitmapFactory.Options)localObject).inTargetDensity = paramInt2;
    }
    ((BitmapFactory.Options)localObject).inScaled = true;
    Bitmap localBitmap = BitmapManager.a(paramString, (BitmapFactory.Options)localObject);
    if (localBitmap == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeFileWithXhdpi, 加载失败, path[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.w("VideoUtils", 1, ((StringBuilder)localObject).toString());
      return localBitmap;
    }
    if (AudioHelper.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeFileWithXhdpi, bitmap[");
      localStringBuilder.append(localBitmap.getWidth());
      localStringBuilder.append(", ");
      localStringBuilder.append(localBitmap.getHeight());
      localStringBuilder.append("], Density[");
      localStringBuilder.append(localBitmap.getDensity());
      localStringBuilder.append("], path[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], density[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], inTargetDensity[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], outWidth[");
      localStringBuilder.append(((BitmapFactory.Options)localObject).outWidth);
      localStringBuilder.append("], outHeight[");
      localStringBuilder.append(((BitmapFactory.Options)localObject).outHeight);
      localStringBuilder.append("], inDensity[");
      localStringBuilder.append(((BitmapFactory.Options)localObject).inDensity);
      localStringBuilder.append("], inSampleSize[");
      localStringBuilder.append(((BitmapFactory.Options)localObject).inSampleSize);
      localStringBuilder.append("], inScreenDensity[");
      localStringBuilder.append(((BitmapFactory.Options)localObject).inScreenDensity);
      localStringBuilder.append("], inTargetDensity[");
      localStringBuilder.append(((BitmapFactory.Options)localObject).inTargetDensity);
      localStringBuilder.append("], bitmapSize[");
      localStringBuilder.append(localBitmap.getWidth());
      localStringBuilder.append(", ");
      localStringBuilder.append(localBitmap.getHeight());
      localStringBuilder.append("]");
      QLog.w("VideoUtils", 1, localStringBuilder.toString());
    }
    return localBitmap;
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      QLog.d("VideoUtils", 1, String.format("requestPartialWakeLock tag=%s timeout=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      PowerManager localPowerManager = (PowerManager)BaseApplication.getContext().getSystemService("power");
      if (localPowerManager != null)
      {
        localPowerManager.newWakeLock(1, paramString).acquire(paramLong);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d(paramString, 1, "requestPartialWakeLock fail.", localThrowable);
    }
  }
  
  public static final boolean a()
  {
    for (;;)
    {
      int i;
      int j;
      try
      {
        boolean bool = LocalMultiProcConfig.getBool("is_qzone_live_launch", false);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isQzoneLiveExist, isRunning=");
        ((StringBuilder)localObject).append(bool);
        QLog.d("VideoUtils", 1, ((StringBuilder)localObject).toString());
        if (!bool) {
          return false;
        }
        localObject = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localObject != null) {
          break label187;
        }
        return false;
      }
      catch (Exception localException)
      {
        Object localObject;
        QLog.e("VideoUtils", 1, localException, new Object[0]);
        return false;
      }
      if (i < ((List)localObject).size())
      {
        if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).processName)) {
          j = ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i)).pid;
        }
      }
      else
      {
        i = LocalMultiProcConfig.getInt("qzone_live_process_id", -1);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isQzoneLiveExist, processId=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", id=");
        ((StringBuilder)localObject).append(i);
        QLog.d("VideoUtils", 1, ((StringBuilder)localObject).toString());
        return j == i;
        label187:
        i = 0;
        j = -2;
        continue;
      }
      i += 1;
    }
  }
  
  public static void b(String paramString, long paramLong)
  {
    try
    {
      QLog.d("VideoUtils", 1, String.format("requestScreenBrightWakeLock tag=%s timeout=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      PowerManager localPowerManager = (PowerManager)BaseApplication.getContext().getSystemService("power");
      if (localPowerManager != null)
      {
        localPowerManager.newWakeLock(805306378, paramString).acquire(paramLong);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.d(paramString, 1, "requestScreenBrightWakeLock fail.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoUtils
 * JD-Core Version:    0.7.0.1
 */
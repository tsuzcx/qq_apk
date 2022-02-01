package com.tencent.av.camera;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class QavCameraUsage
{
  public static String a;
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(System.currentTimeMillis());
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setCameraUsageState, last[");
    localStringBuilder.append(str);
    localStringBuilder.append("], cur[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w("QavCameraUsage", 1, localStringBuilder.toString());
    a = paramString;
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).edit();
    paramContext.putString("camera_used_desc", paramString);
    paramContext.putBoolean("camera_used", true);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).getString("camera_used_desc", null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCameraUsageState, cameraIsUsing[");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("]");
    QLog.w("QavCameraUsage", 1, localStringBuilder.toString());
    if (paramContext != null) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      for (;;)
      {
        j = i;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        if (((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video")) {
          i = 1;
        }
      }
    }
    int j = 0;
    if (j != 0) {
      bool = a(paramContext);
    }
    if ((bool) && (paramBoolean)) {
      new Handler(Looper.getMainLooper()).post(new QavCameraUsage.1(paramContext));
    }
    return bool;
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("clearCameraUsageState, cameraIsUsing[");
    localStringBuilder.append(a);
    localStringBuilder.append("], type[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    QLog.w("QavCameraUsage", 1, localStringBuilder.toString());
    a = null;
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).edit();
    paramContext.remove("camera_used_desc");
    paramContext.putBoolean("camera_used", false);
    paramContext.commit();
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.QavCameraUsage
 * JD-Core Version:    0.7.0.1
 */
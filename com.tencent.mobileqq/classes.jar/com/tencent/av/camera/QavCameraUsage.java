package com.tencent.av.camera;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;
import jhq;

public class QavCameraUsage
{
  public static boolean a;
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (paramContext == null) {
      return;
    }
    a = paramBoolean;
    paramContext = paramContext.getSharedPreferences("qav_camera_usage_sp", 4).edit();
    paramContext.putBoolean("camera_used", paramBoolean);
    paramContext.commit();
  }
  
  public static boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    return paramContext.getSharedPreferences("qav_camera_usage_sp", 4).getBoolean("camera_used", false);
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramContext == null) {
      return bool2;
    }
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    label43:
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject).hasNext()) {
        break label83;
      }
      if (!((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName.equals("com.tencent.mobileqq:video")) {
        break label135;
      }
      i = 1;
    }
    label135:
    for (;;)
    {
      break label43;
      j = 0;
      label83:
      if (j != 0) {
        bool1 = a(paramContext);
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!paramBoolean) {
        break;
      }
      new Handler(Looper.getMainLooper()).post(new jhq(paramContext));
      return bool1;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return a(paramContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.camera.QavCameraUsage
 * JD-Core Version:    0.7.0.1
 */
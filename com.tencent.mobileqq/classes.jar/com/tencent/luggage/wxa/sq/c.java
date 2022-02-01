package com.tencent.luggage.wxa.sq;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.tencent.luggage.wxa.f.f;

public class c
{
  private static Boolean a;
  private static Boolean b;
  
  public static boolean a(Context paramContext)
  {
    if (a != null)
    {
      paramContext = new StringBuilder();
      paramContext.append("isUseXwebCamera:");
      paramContext.append(a);
      f.b("WMPF.XwebCameraUtil", paramContext.toString());
      return a.booleanValue();
    }
    paramContext = paramContext.getApplicationContext();
    try
    {
      a = Boolean.valueOf(paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getBoolean("use_xweb_camera"));
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    paramContext = new StringBuilder();
    paramContext.append("isUseXwebCamera:");
    paramContext.append(a);
    f.b("WMPF.XwebCameraUtil", paramContext.toString());
    return a.booleanValue();
  }
  
  public static boolean b(Context paramContext)
  {
    if (b != null)
    {
      paramContext = new StringBuilder();
      paramContext.append("isUseCpuCrop:");
      paramContext.append(a);
      f.b("WMPF.XwebCameraUtil", paramContext.toString());
      return b.booleanValue();
    }
    paramContext = paramContext.getApplicationContext();
    try
    {
      b = Boolean.valueOf(paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData.getBoolean("use_cpu_crop"));
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    paramContext = new StringBuilder();
    paramContext.append("isUseCpuCrop:");
    paramContext.append(b);
    f.b("WMPF.XwebCameraUtil", paramContext.toString());
    return b.booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sq.c
 * JD-Core Version:    0.7.0.1
 */
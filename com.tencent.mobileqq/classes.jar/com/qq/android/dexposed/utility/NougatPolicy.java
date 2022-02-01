package com.qq.android.dexposed.utility;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;

public class NougatPolicy
{
  private static final String TAG = "NougatPolicy";
  
  public static boolean clearCompileData(Context paramContext)
  {
    try
    {
      Object localObject = getPackageManagerBinderProxy();
      boolean bool = ((Boolean)localObject.getClass().getDeclaredMethod("performDexOpt", new Class[] { String.class, Boolean.TYPE, Integer.TYPE, Boolean.TYPE }).invoke(localObject, new Object[] { paramContext.getPackageName(), Boolean.valueOf(false), Integer.valueOf(2), Boolean.valueOf(true) })).booleanValue();
      return bool;
    }
    catch (Throwable paramContext)
    {
      NougatPolicy.TraceLogger.e("NougatPolicy", "clear compile data failed", paramContext);
    }
    return false;
  }
  
  public static boolean fullCompile(Context paramContext)
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      Object localObject = getPackageManagerBinderProxy();
      if (localObject == null)
      {
        NougatPolicy.TraceLogger.e("NougatPolicy", "can not found package service");
        return false;
      }
      boolean bool = ((Boolean)localObject.getClass().getDeclaredMethod("performDexOptMode", new Class[] { String.class, Boolean.TYPE, String.class, Boolean.TYPE }).invoke(localObject, new Object[] { paramContext.getPackageName(), Boolean.valueOf(false), "speed", Boolean.valueOf(true) })).booleanValue();
      long l2 = SystemClock.elapsedRealtime();
      paramContext = new StringBuilder("full Compile cost: ");
      paramContext.append(l2 - l1);
      paramContext.append(" result:");
      paramContext.append(bool);
      Log.i("NougatPolicy", paramContext.toString());
      return bool;
    }
    catch (Throwable paramContext)
    {
      NougatPolicy.TraceLogger.e("NougatPolicy", "fullCompile failed:", paramContext);
    }
    return false;
  }
  
  private static Object getPackageManagerBinderProxy()
  {
    return Class.forName("android.app.ActivityThread").getDeclaredMethod("getPackageManager", new Class[0]).invoke(null, new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.NougatPolicy
 * JD-Core Version:    0.7.0.1
 */
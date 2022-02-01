package com.qq.android.dexposed;

import android.annotation.SuppressLint;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DeviceCheck
{
  private static boolean a = false;
  private static boolean b = false;
  
  @SuppressLint({"DefaultLocale"})
  public static boolean a()
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class });
      str = (String)((Method)localObject2).invoke(null, new Object[] { "ro.yunos.version" });
    }
    catch (NoSuchMethodException|ClassNotFoundException|IllegalAccessException|InvocationTargetException localNoSuchMethodException1)
    {
      Object localObject2;
      String str;
      label63:
      label66:
      label68:
      break label66;
    }
    try
    {
      localObject2 = (String)((Method)localObject2).invoke(null, new Object[] { "java.vm.name" });
      localObject1 = localObject2;
    }
    catch (NoSuchMethodException|ClassNotFoundException|IllegalAccessException|InvocationTargetException localNoSuchMethodException2)
    {
      break label63;
    }
    break label68;
    str = null;
    return ((localObject1 != null) && (localObject1.toLowerCase().contains("lemur"))) || ((str != null) && (str.trim().length() > 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.DeviceCheck
 * JD-Core Version:    0.7.0.1
 */
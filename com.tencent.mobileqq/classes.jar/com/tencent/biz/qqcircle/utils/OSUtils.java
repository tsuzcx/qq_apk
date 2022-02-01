package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class OSUtils
{
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      paramString1 = (String)localClass.getMethod("get", new Class[] { String.class, String.class }).invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean a()
  {
    return TextUtils.isEmpty(a("ro.miui.ui.version.name", "")) ^ true;
  }
  
  public static boolean b()
  {
    return c().toLowerCase().contains("flyme");
  }
  
  private static String c()
  {
    return a("ro.build.display.id", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.OSUtils
 * JD-Core Version:    0.7.0.1
 */
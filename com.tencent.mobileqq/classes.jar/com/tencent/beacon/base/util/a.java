package com.tencent.beacon.base.util;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public class a
{
  private static String a;
  
  public static String a()
  {
    String str = a;
    if (str != null) {
      return str;
    }
    try
    {
      Class localClass = Class.forName("android.app.ActivityThread");
      int i = Build.VERSION.SDK_INT;
      if (i >= 18) {
        str = "currentProcessName";
      } else {
        str = "currentPackageName";
      }
      a = (String)localClass.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }
    catch (Throwable localThrowable)
    {
      c.a(localThrowable);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.util.a
 * JD-Core Version:    0.7.0.1
 */
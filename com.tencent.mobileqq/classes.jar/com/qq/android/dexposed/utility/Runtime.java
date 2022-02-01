package com.qq.android.dexposed.utility;

import android.util.Log;
import java.lang.reflect.Method;
import me.weishu.epic.art.method.ArtMethod;

public class Runtime
{
  private static volatile Boolean a;
  private static volatile boolean b = false;
  private static volatile boolean c = true;
  
  static
  {
    try
    {
      b = ((Boolean)Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
    }
    catch (Exception localException)
    {
      Log.e("Runtime", "get is64Bit failed, default not 64bit!", localException);
      b = false;
    }
    c = System.getProperty("java.vm.version").startsWith("2");
    StringBuilder localStringBuilder = new StringBuilder("is64Bit: ");
    localStringBuilder.append(b);
    localStringBuilder.append(", isArt: ");
    localStringBuilder.append(c);
    Log.i("Runtime", localStringBuilder.toString());
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static boolean b()
  {
    if (a != null) {
      return a.booleanValue();
    }
    boolean bool = false;
    try
    {
      long l = ArtMethod.a(String.class.getDeclaredMethod("hashCode", new Class[0])).b();
      StringBuilder localStringBuilder1 = new StringBuilder("isThumb2, entry: ");
      localStringBuilder1.append(Long.toHexString(l));
      Logger.c("Runtime", localStringBuilder1.toString());
      if ((l & 1L) == 1L) {
        bool = true;
      }
      a = Boolean.valueOf(bool);
      bool = a.booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder("isThumb2, error: ");
      localStringBuilder2.append(localThrowable);
      Logger.c("Runtime", localStringBuilder2.toString());
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Runtime
 * JD-Core Version:    0.7.0.1
 */
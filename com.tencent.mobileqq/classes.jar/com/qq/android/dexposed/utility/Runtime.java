package com.qq.android.dexposed.utility;

import android.util.Log;
import java.lang.reflect.Method;
import me.weishu.epic.art.method.ArtMethod;

public class Runtime
{
  private static final String TAG = "Runtime";
  private static volatile boolean g64 = false;
  private static volatile boolean isArt = true;
  private static volatile Boolean isThumb = null;
  
  static
  {
    try
    {
      g64 = ((Boolean)Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
      isArt = System.getProperty("java.vm.version").startsWith("2");
      Log.i("Runtime", "is64Bit: " + g64 + ", isArt: " + isArt);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("Runtime", "get is64Bit failed, default not 64bit!", localException);
        g64 = false;
      }
    }
  }
  
  public static boolean is64Bit()
  {
    return g64;
  }
  
  public static boolean isArt()
  {
    return isArt;
  }
  
  public static boolean isThumb2()
  {
    boolean bool = false;
    if (isThumb != null) {
      return isThumb.booleanValue();
    }
    try
    {
      long l = ArtMethod.of(String.class.getDeclaredMethod("hashCode", new Class[0])).getEntryPointFromQuickCompiledCode();
      Logger.w("Runtime", "isThumb2, entry: " + Long.toHexString(l));
      if ((l & 1L) == 1L) {
        bool = true;
      }
      isThumb = Boolean.valueOf(bool);
      bool = isThumb.booleanValue();
      return bool;
    }
    catch (Throwable localThrowable)
    {
      Logger.w("Runtime", "isThumb2, error: " + localThrowable);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Runtime
 * JD-Core Version:    0.7.0.1
 */
package com.qq.android.dexposed;

import android.os.Build.VERSION;
import android.util.Log;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DexposedBridge
{
  public static final ClassLoader a;
  private static final Object[] b;
  private static final Map<Member, DexposedBridge.CopyOnWriteSortedSet<XC_MethodHook>> c;
  private static final ArrayList<XC_MethodHook.Unhook> d;
  
  static
  {
    try
    {
      if ((Build.VERSION.SDK_INT > 19) && (Build.VERSION.SDK_INT <= 27))
      {
        System.loadLibrary("qqjhook");
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder("unsupported api level: ");
        localStringBuilder.append(Build.VERSION.SDK_INT);
        throw new RuntimeException(localStringBuilder.toString());
      }
    }
    catch (Throwable localThrowable)
    {
      a(localThrowable);
      b = new Object[0];
      a = ClassLoader.getSystemClassLoader();
      c = new HashMap();
      d = new ArrayList();
    }
  }
  
  public static void a(String paramString)
  {
    try
    {
      Log.i("DexposedBridge", paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    try
    {
      a(Log.getStackTraceString(paramThrowable));
      return;
    }
    finally
    {
      paramThrowable = finally;
      throw paramThrowable;
    }
  }
  
  private static synchronized native void hookMethodNative(Member paramMember, Class<?> paramClass, int paramInt, Object paramObject);
  
  private static native Object invokeOriginalMethodNative(Member paramMember, int paramInt, Class<?>[] paramArrayOfClass, Class<?> paramClass, Object paramObject, Object[] paramArrayOfObject);
  
  private static native Object invokeSuperNative(Object paramObject, Object[] paramArrayOfObject, Member paramMember, Class<?> paramClass1, Class<?>[] paramArrayOfClass, Class<?> paramClass2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.DexposedBridge
 * JD-Core Version:    0.7.0.1
 */
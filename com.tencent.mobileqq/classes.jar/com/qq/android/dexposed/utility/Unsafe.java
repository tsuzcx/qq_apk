package com.qq.android.dexposed.utility;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class Unsafe
{
  private static Object a;
  private static Class b;
  
  static
  {
    try
    {
      b = Class.forName("sun.misc.Unsafe");
      localField = b.getDeclaredField("theUnsafe");
      localField.setAccessible(true);
      a = localField.get(null);
      return;
    }
    catch (Exception localException1)
    {
      Field localField;
      label31:
      label54:
      break label31;
    }
    try
    {
      localField = b.getDeclaredField("THE_ONE");
      localField.setAccessible(true);
      a = localField.get(null);
      return;
    }
    catch (Exception localException2)
    {
      break label54;
    }
    Log.w("Unsafe", "Unsafe not found o.O");
  }
  
  public static int a(Class paramClass)
  {
    try
    {
      int i = ((Integer)b.getDeclaredMethod("arrayBaseOffset", new Class[] { Class.class }).invoke(a, new Object[] { paramClass })).intValue();
      return i;
    }
    catch (Exception paramClass)
    {
      Log.w("Unsafe", paramClass);
    }
    return 0;
  }
  
  public static int a(Object paramObject, long paramLong)
  {
    try
    {
      int i = ((Integer)b.getDeclaredMethod("getInt", new Class[] { Object.class, Long.TYPE }).invoke(a, new Object[] { paramObject, Long.valueOf(paramLong) })).intValue();
      return i;
    }
    catch (Exception paramObject)
    {
      Log.w("Unsafe", paramObject);
    }
    return 0;
  }
  
  public static long a(Object paramObject)
  {
    try
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramObject;
      if (b([Ljava.lang.Object.class) == 8) {
        return b(arrayOfObject, a([Ljava.lang.Object.class));
      }
      int i = a(arrayOfObject, a([Ljava.lang.Object.class));
      return 0xFFFFFFFF & i;
    }
    catch (Exception paramObject)
    {
      Log.w("Unsafe", paramObject);
    }
    return -1L;
  }
  
  public static int b(Class paramClass)
  {
    try
    {
      int i = ((Integer)b.getDeclaredMethod("arrayIndexScale", new Class[] { Class.class }).invoke(a, new Object[] { paramClass })).intValue();
      return i;
    }
    catch (Exception paramClass)
    {
      Log.w("Unsafe", paramClass);
    }
    return 0;
  }
  
  public static long b(Object paramObject, long paramLong)
  {
    try
    {
      paramLong = ((Long)b.getDeclaredMethod("getLong", new Class[] { Object.class, Long.TYPE }).invoke(a, new Object[] { paramObject, Long.valueOf(paramLong) })).longValue();
      return paramLong;
    }
    catch (Exception paramObject)
    {
      Log.w("Unsafe", paramObject);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.android.dexposed.utility.Unsafe
 * JD-Core Version:    0.7.0.1
 */
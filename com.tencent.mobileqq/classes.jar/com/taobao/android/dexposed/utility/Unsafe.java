package com.taobao.android.dexposed.utility;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class Unsafe
{
  private static final String TAG = "Unsafe";
  private static Object unsafe;
  private static Class unsafeClass;
  
  static
  {
    try
    {
      unsafeClass = Class.forName("sun.misc.Unsafe");
      Field localField1 = unsafeClass.getDeclaredField("theUnsafe");
      localField1.setAccessible(true);
      unsafe = localField1.get(null);
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        Field localField2 = unsafeClass.getDeclaredField("THE_ONE");
        localField2.setAccessible(true);
        unsafe = localField2.get(null);
        return;
      }
      catch (Exception localException2)
      {
        Log.w("Unsafe", "Unsafe not found o.O");
      }
    }
  }
  
  public static int arrayBaseOffset(Class paramClass)
  {
    try
    {
      int i = ((Integer)unsafeClass.getDeclaredMethod("arrayBaseOffset", new Class[] { Class.class }).invoke(unsafe, new Object[] { paramClass })).intValue();
      return i;
    }
    catch (Exception paramClass)
    {
      Log.w("Unsafe", paramClass);
    }
    return 0;
  }
  
  public static int arrayIndexScale(Class paramClass)
  {
    try
    {
      int i = ((Integer)unsafeClass.getDeclaredMethod("arrayIndexScale", new Class[] { Class.class }).invoke(unsafe, new Object[] { paramClass })).intValue();
      return i;
    }
    catch (Exception paramClass)
    {
      Log.w("Unsafe", paramClass);
    }
    return 0;
  }
  
  public static int getInt(Object paramObject, long paramLong)
  {
    try
    {
      int i = ((Integer)unsafeClass.getDeclaredMethod("getInt", new Class[] { Object.class, Long.TYPE }).invoke(unsafe, new Object[] { paramObject, Long.valueOf(paramLong) })).intValue();
      return i;
    }
    catch (Exception paramObject)
    {
      Log.w("Unsafe", paramObject);
    }
    return 0;
  }
  
  public static long getLong(Object paramObject, long paramLong)
  {
    try
    {
      paramLong = ((Long)unsafeClass.getDeclaredMethod("getLong", new Class[] { Object.class, Long.TYPE }).invoke(unsafe, new Object[] { paramObject, Long.valueOf(paramLong) })).longValue();
      return paramLong;
    }
    catch (Exception paramObject)
    {
      Log.w("Unsafe", paramObject);
    }
    return 0L;
  }
  
  public static Object getObject(long paramLong)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = null;
    long l = arrayBaseOffset([Ljava.lang.Object.class);
    if (Runtime.is64Bit()) {
      putLong(arrayOfObject, l, paramLong);
    }
    for (;;)
    {
      return arrayOfObject[0];
      putInt(arrayOfObject, l, (int)paramLong);
    }
  }
  
  public static long getObjectAddress(Object paramObject)
  {
    try
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramObject;
      if (arrayIndexScale([Ljava.lang.Object.class) == 8) {
        return getLong(arrayOfObject, arrayBaseOffset([Ljava.lang.Object.class));
      }
      int i = getInt(arrayOfObject, arrayBaseOffset([Ljava.lang.Object.class));
      return i & 0xFFFFFFFF;
    }
    catch (Exception paramObject)
    {
      Log.w("Unsafe", paramObject);
    }
    return -1L;
  }
  
  public static long objectFieldOffset(Field paramField)
  {
    try
    {
      long l = ((Long)unsafeClass.getDeclaredMethod("objectFieldOffset", new Class[] { Field.class }).invoke(unsafe, new Object[] { paramField })).longValue();
      return l;
    }
    catch (Exception paramField)
    {
      Log.w("Unsafe", paramField);
    }
    return 0L;
  }
  
  public static void putInt(Object paramObject, long paramLong, int paramInt)
  {
    try
    {
      unsafeClass.getDeclaredMethod("putIntVolatile", new Class[] { Object.class, Long.TYPE, Integer.TYPE }).invoke(unsafe, new Object[] { paramObject, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      try
      {
        unsafeClass.getDeclaredMethod("putIntVolatile", new Class[] { Object.class, Long.TYPE, Integer.TYPE }).invoke(unsafe, new Object[] { paramObject, Long.valueOf(paramLong), Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramObject)
      {
        Log.w("Unsafe", localException);
      }
    }
  }
  
  public static void putLong(Object paramObject, long paramLong1, long paramLong2)
  {
    try
    {
      unsafeClass.getDeclaredMethod("putLongVolatile", new Class[] { Object.class, Long.TYPE, Long.TYPE }).invoke(unsafe, new Object[] { paramObject, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      return;
    }
    catch (Exception localException)
    {
      try
      {
        unsafeClass.getDeclaredMethod("putLong", new Class[] { Object.class, Long.TYPE, Long.TYPE }).invoke(unsafe, new Object[] { paramObject, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
        return;
      }
      catch (Exception paramObject)
      {
        Log.w("Unsafe", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.utility.Unsafe
 * JD-Core Version:    0.7.0.1
 */
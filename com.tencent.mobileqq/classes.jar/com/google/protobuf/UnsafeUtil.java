package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil
{
  static final long a;
  static final boolean b;
  private static final Logger c = Logger.getLogger(UnsafeUtil.class.getName());
  private static final Unsafe d = c();
  private static final UnsafeUtil.MemoryAccessor e = d();
  private static final boolean f = f();
  private static final boolean g = e();
  private static final long h;
  private static final long i;
  private static final long j;
  private static final long k;
  private static final long l;
  private static final long m;
  private static final long n;
  private static final long o;
  private static final long p;
  private static final long q;
  private static final long r;
  private static final long s;
  private static final long t;
  private static final int u;
  
  static
  {
    a = b([B.class);
    h = b([Z.class);
    i = c([Z.class);
    j = b([I.class);
    k = c([I.class);
    l = b([J.class);
    m = c([J.class);
    n = b([F.class);
    o = c([F.class);
    p = b([D.class);
    q = c([D.class);
    r = b([Ljava.lang.Object.class);
    s = c([Ljava.lang.Object.class);
    t = c(g());
    u = (int)(a & 0x7);
    boolean bool;
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      bool = true;
    } else {
      bool = false;
    }
    b = bool;
  }
  
  static byte a(long paramLong)
  {
    return e.a(paramLong);
  }
  
  static byte a(byte[] paramArrayOfByte, long paramLong)
  {
    return e.a(paramArrayOfByte, a + paramLong);
  }
  
  static int a(Object paramObject, long paramLong)
  {
    return e.e(paramObject, paramLong);
  }
  
  static long a(Field paramField)
  {
    return e.b(paramField);
  }
  
  static long a(ByteBuffer paramByteBuffer)
  {
    return e.f(paramByteBuffer, t);
  }
  
  static <T> T a(Class<T> paramClass)
  {
    try
    {
      paramClass = d.allocateInstance(paramClass);
      return paramClass;
    }
    catch (InstantiationException paramClass)
    {
      throw new IllegalStateException(paramClass);
    }
  }
  
  private static Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  static void a(long paramLong, byte paramByte)
  {
    e.a(paramLong, paramByte);
  }
  
  static void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, long paramLong3)
  {
    e.a(paramLong1, paramArrayOfByte, paramLong2, paramLong3);
  }
  
  static void a(Object paramObject, long paramLong, double paramDouble)
  {
    e.a(paramObject, paramLong, paramDouble);
  }
  
  static void a(Object paramObject, long paramLong, float paramFloat)
  {
    e.a(paramObject, paramLong, paramFloat);
  }
  
  static void a(Object paramObject, long paramLong, int paramInt)
  {
    e.a(paramObject, paramLong, paramInt);
  }
  
  static void a(Object paramObject, long paramLong1, long paramLong2)
  {
    e.a(paramObject, paramLong1, paramLong2);
  }
  
  static void a(Object paramObject1, long paramLong, Object paramObject2)
  {
    e.a(paramObject1, paramLong, paramObject2);
  }
  
  static void a(Object paramObject, long paramLong, boolean paramBoolean)
  {
    e.a(paramObject, paramLong, paramBoolean);
  }
  
  static void a(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    e.a(paramArrayOfByte, a + paramLong, paramByte);
  }
  
  static void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
  {
    e.a(paramArrayOfByte, paramLong1, paramLong2, paramLong3);
  }
  
  static boolean a()
  {
    return g;
  }
  
  private static int b(Class<?> paramClass)
  {
    if (g) {
      return e.a(paramClass);
    }
    return -1;
  }
  
  static long b(long paramLong)
  {
    return e.b(paramLong);
  }
  
  static long b(Object paramObject, long paramLong)
  {
    return e.f(paramObject, paramLong);
  }
  
  static Object b(Field paramField)
  {
    return e.a(paramField);
  }
  
  static boolean b()
  {
    return f;
  }
  
  private static int c(Class<?> paramClass)
  {
    if (g) {
      return e.b(paramClass);
    }
    return -1;
  }
  
  private static long c(Field paramField)
  {
    if (paramField != null)
    {
      UnsafeUtil.MemoryAccessor localMemoryAccessor = e;
      if (localMemoryAccessor != null) {
        return localMemoryAccessor.b(paramField);
      }
    }
    return -1L;
  }
  
  static Unsafe c()
  {
    try
    {
      Unsafe localUnsafe = (Unsafe)AccessController.doPrivileged(new UnsafeUtil.1());
      return localUnsafe;
    }
    catch (Throwable localThrowable)
    {
      label16:
      break label16;
    }
    return null;
  }
  
  static boolean c(Object paramObject, long paramLong)
  {
    return e.b(paramObject, paramLong);
  }
  
  static float d(Object paramObject, long paramLong)
  {
    return e.c(paramObject, paramLong);
  }
  
  private static UnsafeUtil.MemoryAccessor d()
  {
    Unsafe localUnsafe = d;
    if (localUnsafe == null) {
      return null;
    }
    return new UnsafeUtil.JvmMemoryAccessor(localUnsafe);
  }
  
  static double e(Object paramObject, long paramLong)
  {
    return e.d(paramObject, paramLong);
  }
  
  private static boolean e()
  {
    Object localObject = d;
    if (localObject == null) {
      return false;
    }
    try
    {
      localObject = localObject.getClass();
      ((Class)localObject).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject).getMethod("arrayBaseOffset", new Class[] { Class.class });
      ((Class)localObject).getMethod("arrayIndexScale", new Class[] { Class.class });
      ((Class)localObject).getMethod("getInt", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putInt", new Class[] { Object.class, Long.TYPE, Integer.TYPE });
      ((Class)localObject).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putLong", new Class[] { Object.class, Long.TYPE, Long.TYPE });
      ((Class)localObject).getMethod("getObject", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putObject", new Class[] { Object.class, Long.TYPE, Object.class });
      ((Class)localObject).getMethod("getByte", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putByte", new Class[] { Object.class, Long.TYPE, Byte.TYPE });
      ((Class)localObject).getMethod("getBoolean", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE });
      ((Class)localObject).getMethod("getFloat", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putFloat", new Class[] { Object.class, Long.TYPE, Float.TYPE });
      ((Class)localObject).getMethod("getDouble", new Class[] { Object.class, Long.TYPE });
      ((Class)localObject).getMethod("putDouble", new Class[] { Object.class, Long.TYPE, Double.TYPE });
      return true;
    }
    catch (Throwable localThrowable)
    {
      Logger localLogger = c;
      Level localLevel = Level.WARNING;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(localThrowable);
      localLogger.log(localLevel, localStringBuilder.toString());
    }
    return false;
  }
  
  static Object f(Object paramObject, long paramLong)
  {
    return e.g(paramObject, paramLong);
  }
  
  private static boolean f()
  {
    Object localObject = d;
    if (localObject == null) {
      return false;
    }
    try
    {
      localObject = localObject.getClass();
      ((Class)localObject).getMethod("objectFieldOffset", new Class[] { Field.class });
      ((Class)localObject).getMethod("getLong", new Class[] { Object.class, Long.TYPE });
      if (g() == null) {
        return false;
      }
      ((Class)localObject).getMethod("getByte", new Class[] { Long.TYPE });
      ((Class)localObject).getMethod("putByte", new Class[] { Long.TYPE, Byte.TYPE });
      ((Class)localObject).getMethod("getInt", new Class[] { Long.TYPE });
      ((Class)localObject).getMethod("putInt", new Class[] { Long.TYPE, Integer.TYPE });
      ((Class)localObject).getMethod("getLong", new Class[] { Long.TYPE });
      ((Class)localObject).getMethod("putLong", new Class[] { Long.TYPE, Long.TYPE });
      ((Class)localObject).getMethod("copyMemory", new Class[] { Long.TYPE, Long.TYPE, Long.TYPE });
      ((Class)localObject).getMethod("copyMemory", new Class[] { Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE });
      return true;
    }
    catch (Throwable localThrowable)
    {
      Logger localLogger = c;
      Level localLevel = Level.WARNING;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      localStringBuilder.append(localThrowable);
      localLogger.log(localLevel, localStringBuilder.toString());
    }
    return false;
  }
  
  private static Field g()
  {
    Field localField = a(Buffer.class, "address");
    if ((localField != null) && (localField.getType() == Long.TYPE)) {
      return localField;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnsafeUtil
 * JD-Core Version:    0.7.0.1
 */
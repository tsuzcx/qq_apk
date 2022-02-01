package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class UnsafeUtil$MemoryAccessor
{
  Unsafe a;
  
  UnsafeUtil$MemoryAccessor(Unsafe paramUnsafe)
  {
    this.a = paramUnsafe;
  }
  
  public abstract byte a(long paramLong);
  
  public abstract byte a(Object paramObject, long paramLong);
  
  public final int a(Class<?> paramClass)
  {
    return this.a.arrayBaseOffset(paramClass);
  }
  
  public abstract Object a(Field paramField);
  
  public abstract void a(long paramLong, byte paramByte);
  
  public abstract void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, long paramLong3);
  
  public abstract void a(Object paramObject, long paramLong, byte paramByte);
  
  public abstract void a(Object paramObject, long paramLong, double paramDouble);
  
  public abstract void a(Object paramObject, long paramLong, float paramFloat);
  
  public final void a(Object paramObject, long paramLong, int paramInt)
  {
    this.a.putInt(paramObject, paramLong, paramInt);
  }
  
  public final void a(Object paramObject, long paramLong1, long paramLong2)
  {
    this.a.putLong(paramObject, paramLong1, paramLong2);
  }
  
  public final void a(Object paramObject1, long paramLong, Object paramObject2)
  {
    this.a.putObject(paramObject1, paramLong, paramObject2);
  }
  
  public abstract void a(Object paramObject, long paramLong, boolean paramBoolean);
  
  public abstract void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3);
  
  public final int b(Class<?> paramClass)
  {
    return this.a.arrayIndexScale(paramClass);
  }
  
  public abstract long b(long paramLong);
  
  public final long b(Field paramField)
  {
    return this.a.objectFieldOffset(paramField);
  }
  
  public abstract boolean b(Object paramObject, long paramLong);
  
  public abstract float c(Object paramObject, long paramLong);
  
  public abstract double d(Object paramObject, long paramLong);
  
  public final int e(Object paramObject, long paramLong)
  {
    return this.a.getInt(paramObject, paramLong);
  }
  
  public final long f(Object paramObject, long paramLong)
  {
    return this.a.getLong(paramObject, paramLong);
  }
  
  public final Object g(Object paramObject, long paramLong)
  {
    return this.a.getObject(paramObject, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnsafeUtil.MemoryAccessor
 * JD-Core Version:    0.7.0.1
 */
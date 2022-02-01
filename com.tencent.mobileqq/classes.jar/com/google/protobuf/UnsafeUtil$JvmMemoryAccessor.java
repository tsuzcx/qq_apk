package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

final class UnsafeUtil$JvmMemoryAccessor
  extends UnsafeUtil.MemoryAccessor
{
  UnsafeUtil$JvmMemoryAccessor(Unsafe paramUnsafe)
  {
    super(paramUnsafe);
  }
  
  public byte a(long paramLong)
  {
    return this.a.getByte(paramLong);
  }
  
  public byte a(Object paramObject, long paramLong)
  {
    return this.a.getByte(paramObject, paramLong);
  }
  
  public Object a(Field paramField)
  {
    return g(this.a.staticFieldBase(paramField), this.a.staticFieldOffset(paramField));
  }
  
  public void a(long paramLong, byte paramByte)
  {
    this.a.putByte(paramLong, paramByte);
  }
  
  public void a(long paramLong1, byte[] paramArrayOfByte, long paramLong2, long paramLong3)
  {
    this.a.copyMemory(null, paramLong1, paramArrayOfByte, UnsafeUtil.a + paramLong2, paramLong3);
  }
  
  public void a(Object paramObject, long paramLong, byte paramByte)
  {
    this.a.putByte(paramObject, paramLong, paramByte);
  }
  
  public void a(Object paramObject, long paramLong, double paramDouble)
  {
    this.a.putDouble(paramObject, paramLong, paramDouble);
  }
  
  public void a(Object paramObject, long paramLong, float paramFloat)
  {
    this.a.putFloat(paramObject, paramLong, paramFloat);
  }
  
  public void a(Object paramObject, long paramLong, boolean paramBoolean)
  {
    this.a.putBoolean(paramObject, paramLong, paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3)
  {
    this.a.copyMemory(paramArrayOfByte, UnsafeUtil.a + paramLong1, null, paramLong2, paramLong3);
  }
  
  public long b(long paramLong)
  {
    return this.a.getLong(paramLong);
  }
  
  public boolean b(Object paramObject, long paramLong)
  {
    return this.a.getBoolean(paramObject, paramLong);
  }
  
  public float c(Object paramObject, long paramLong)
  {
    return this.a.getFloat(paramObject, paramLong);
  }
  
  public double d(Object paramObject, long paramLong)
  {
    return this.a.getDouble(paramObject, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.UnsafeUtil.JvmMemoryAccessor
 * JD-Core Version:    0.7.0.1
 */
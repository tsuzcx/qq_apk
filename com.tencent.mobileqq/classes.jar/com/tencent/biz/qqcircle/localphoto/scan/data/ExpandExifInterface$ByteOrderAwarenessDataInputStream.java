package com.tencent.biz.qqcircle.localphoto.scan.data;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteOrder;

class ExpandExifInterface$ByteOrderAwarenessDataInputStream
  extends ByteArrayInputStream
{
  private static final ByteOrder a = ByteOrder.LITTLE_ENDIAN;
  private static final ByteOrder b = ByteOrder.BIG_ENDIAN;
  private ByteOrder c = ByteOrder.BIG_ENDIAN;
  private final long d;
  private long e;
  
  public ExpandExifInterface$ByteOrderAwarenessDataInputStream(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
    this.d = paramArrayOfByte.length;
    this.e = 0L;
  }
  
  public long a()
  {
    return this.e;
  }
  
  public void a(long paramLong)
  {
    this.e = 0L;
    reset();
    if (skip(paramLong) == paramLong) {
      return;
    }
    throw new IOException("Couldn't seek up to the byteCount");
  }
  
  public void a(ByteOrder paramByteOrder)
  {
    this.c = paramByteOrder;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.e += paramArrayOfByte.length;
    if (this.e <= this.d)
    {
      if (super.read(paramArrayOfByte, 0, paramArrayOfByte.length) == paramArrayOfByte.length) {
        return;
      }
      throw new IOException("Couldn't read up to the length of buffer");
    }
    throw new EOFException();
  }
  
  public short b()
  {
    this.e += 2L;
    if (this.e <= this.d)
    {
      int i = super.read();
      int j = super.read();
      if ((i | j) >= 0)
      {
        Object localObject = this.c;
        if (localObject == a) {
          return (short)((j << 8) + i);
        }
        if (localObject == b) {
          return (short)((i << 8) + j);
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid byte order: ");
        ((StringBuilder)localObject).append(this.c);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      throw new EOFException();
    }
    throw new EOFException();
  }
  
  public int c()
  {
    this.e += 4L;
    if (this.e <= this.d)
    {
      int i = super.read();
      int j = super.read();
      int k = super.read();
      int m = super.read();
      if ((i | j | k | m) >= 0)
      {
        Object localObject = this.c;
        if (localObject == a) {
          return (m << 24) + (k << 16) + (j << 8) + i;
        }
        if (localObject == b) {
          return (i << 24) + (j << 16) + (k << 8) + m;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid byte order: ");
        ((StringBuilder)localObject).append(this.c);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      throw new EOFException();
    }
    throw new EOFException();
  }
  
  public int d()
  {
    this.e += 2L;
    if (this.e <= this.d)
    {
      int i = super.read();
      int j = super.read();
      if ((i | j) >= 0)
      {
        Object localObject = this.c;
        if (localObject == a) {
          return (j << 8) + i;
        }
        if (localObject == b) {
          return (i << 8) + j;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid byte order: ");
        ((StringBuilder)localObject).append(this.c);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      throw new EOFException();
    }
    throw new EOFException();
  }
  
  public long e()
  {
    return c() & 0xFFFFFFFF;
  }
  
  public long f()
  {
    this.e += 8L;
    if (this.e <= this.d)
    {
      int i = super.read();
      int j = super.read();
      int k = super.read();
      int m = super.read();
      int n = super.read();
      int i1 = super.read();
      int i2 = super.read();
      int i3 = super.read();
      if ((i | j | k | m | n | i1 | i2 | i3) >= 0)
      {
        Object localObject = this.c;
        if (localObject == a) {
          return (i3 << 56) + (i2 << 48) + (i1 << 40) + (n << 32) + (m << 24) + (k << 16) + (j << 8) + i;
        }
        if (localObject == b) {
          return (i << 56) + (j << 48) + (k << 40) + (m << 32) + (n << 24) + (i1 << 16) + (i2 << 8) + i3;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid byte order: ");
        ((StringBuilder)localObject).append(this.c);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      throw new EOFException();
    }
    throw new EOFException();
  }
  
  public float g()
  {
    return Float.intBitsToFloat(c());
  }
  
  public double h()
  {
    return Double.longBitsToDouble(f());
  }
  
  public long skip(long paramLong)
  {
    paramLong = super.skip(Math.min(paramLong, this.d - this.e));
    this.e += paramLong;
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.localphoto.scan.data.ExpandExifInterface.ByteOrderAwarenessDataInputStream
 * JD-Core Version:    0.7.0.1
 */
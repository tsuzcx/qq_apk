package com.tencent.beacon.core.network.volley;

import java.io.ByteArrayOutputStream;

public class PoolingByteArrayOutputStream
  extends ByteArrayOutputStream
{
  private static final int DEFAULT_SIZE = 256;
  private final ByteArrayPool mPool;
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool)
  {
    this(paramByteArrayPool, 256);
  }
  
  public PoolingByteArrayOutputStream(ByteArrayPool paramByteArrayPool, int paramInt)
  {
    this.mPool = paramByteArrayPool;
    this.buf = this.mPool.getBuf(Math.max(paramInt, 256));
  }
  
  private void expand(int paramInt)
  {
    int i = this.count;
    if (i + paramInt <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.mPool.getBuf((i + paramInt) * 2);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.mPool.returnBuf(this.buf);
    this.buf = arrayOfByte;
  }
  
  public void close()
  {
    this.mPool.returnBuf(this.buf);
    this.buf = null;
    super.close();
  }
  
  protected void finalize()
  {
    this.mPool.returnBuf(this.buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      expand(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      expand(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.network.volley.PoolingByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */
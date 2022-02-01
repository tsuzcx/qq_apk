package com.b.a.a;

import java.io.ByteArrayOutputStream;

public final class i
  extends ByteArrayOutputStream
{
  private final c a;
  
  public i(c paramc, int paramInt)
  {
    this.a = paramc;
    this.buf = this.a.a(Math.max(paramInt, 256));
  }
  
  private void a(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.a.a(this.count + paramInt << 1);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.a.a(this.buf);
    this.buf = arrayOfByte;
  }
  
  public final void close()
  {
    this.a.a(this.buf);
    this.buf = null;
    super.close();
  }
  
  public final void finalize()
  {
    this.a.a(this.buf);
  }
  
  public final void write(int paramInt)
  {
    try
    {
      a(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt2);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.b.a.a.i
 * JD-Core Version:    0.7.0.1
 */
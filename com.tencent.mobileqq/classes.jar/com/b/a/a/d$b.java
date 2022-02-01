package com.b.a.a;

import java.io.FilterInputStream;
import java.io.InputStream;

final class d$b
  extends FilterInputStream
{
  private final long a;
  private long b;
  
  d$b(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    this.a = paramLong;
  }
  
  final long a()
  {
    return this.a - this.b;
  }
  
  public final int read()
  {
    int i = super.read();
    if (i != -1) {
      this.b += 1L;
    }
    return i;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 != -1) {
      this.b += paramInt1;
    }
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.a.d.b
 * JD-Core Version:    0.7.0.1
 */
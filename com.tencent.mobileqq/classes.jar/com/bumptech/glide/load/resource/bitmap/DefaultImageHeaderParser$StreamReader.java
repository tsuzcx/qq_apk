package com.bumptech.glide.load.resource.bitmap;

import java.io.InputStream;

final class DefaultImageHeaderParser$StreamReader
  implements DefaultImageHeaderParser.Reader
{
  private final InputStream a;
  
  DefaultImageHeaderParser$StreamReader(InputStream paramInputStream)
  {
    this.a = paramInputStream;
  }
  
  public int a()
  {
    return this.a.read() << 8 & 0xFF00 | this.a.read() & 0xFF;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramInt;
    while (i > 0)
    {
      int j = this.a.read(paramArrayOfByte, paramInt - i, i);
      if (j == -1) {
        break;
      }
      i -= j;
    }
    return paramInt - i;
  }
  
  public long a(long paramLong)
  {
    if (paramLong < 0L) {
      return 0L;
    }
    long l1 = paramLong;
    if (l1 > 0L)
    {
      long l2 = this.a.skip(l1);
      if (l2 > 0L) {}
      for (;;)
      {
        l1 -= l2;
        break;
        if (this.a.read() == -1) {
          break label61;
        }
        l2 = 1L;
      }
    }
    label61:
    return paramLong - l1;
  }
  
  public short b()
  {
    return (short)(this.a.read() & 0xFF);
  }
  
  public int c()
  {
    return this.a.read();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.StreamReader
 * JD-Core Version:    0.7.0.1
 */
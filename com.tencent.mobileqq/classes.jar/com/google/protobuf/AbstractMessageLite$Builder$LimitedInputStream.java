package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

final class AbstractMessageLite$Builder$LimitedInputStream
  extends FilterInputStream
{
  private int a;
  
  AbstractMessageLite$Builder$LimitedInputStream(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    this.a = paramInt;
  }
  
  public int available()
  {
    return Math.min(super.available(), this.a);
  }
  
  public int read()
  {
    if (this.a <= 0) {
      return -1;
    }
    int i = super.read();
    if (i >= 0) {
      this.a -= 1;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.a;
    if (i <= 0) {
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, i));
    if (paramInt1 >= 0) {
      this.a -= paramInt1;
    }
    return paramInt1;
  }
  
  public long skip(long paramLong)
  {
    paramLong = super.skip(Math.min(paramLong, this.a));
    if (paramLong >= 0L) {
      this.a = ((int)(this.a - paramLong));
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.google.protobuf.AbstractMessageLite.Builder.LimitedInputStream
 * JD-Core Version:    0.7.0.1
 */
package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class DefaultImageHeaderParser$ByteBufferReader
  implements DefaultImageHeaderParser.Reader
{
  private final ByteBuffer a;
  
  DefaultImageHeaderParser$ByteBufferReader(ByteBuffer paramByteBuffer)
  {
    this.a = paramByteBuffer;
    paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
  }
  
  public int a()
  {
    return c() << 8 & 0xFF00 | c() & 0xFF;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    paramInt = Math.min(paramInt, this.a.remaining());
    if (paramInt == 0) {
      return -1;
    }
    this.a.get(paramArrayOfByte, 0, paramInt);
    return paramInt;
  }
  
  public long a(long paramLong)
  {
    int i = (int)Math.min(this.a.remaining(), paramLong);
    ByteBuffer localByteBuffer = this.a;
    localByteBuffer.position(localByteBuffer.position() + i);
    return i;
  }
  
  public short b()
  {
    return (short)(c() & 0xFF);
  }
  
  public int c()
  {
    if (this.a.remaining() < 1) {
      return -1;
    }
    return this.a.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.ByteBufferReader
 * JD-Core Version:    0.7.0.1
 */
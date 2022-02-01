package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

final class DefaultImageHeaderParser$RandomAccessReader
{
  private final ByteBuffer a;
  
  DefaultImageHeaderParser$RandomAccessReader(byte[] paramArrayOfByte, int paramInt)
  {
    this.a = ((ByteBuffer)ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).limit(paramInt));
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    return this.a.remaining() - paramInt1 >= paramInt2;
  }
  
  int a()
  {
    return this.a.remaining();
  }
  
  int a(int paramInt)
  {
    if (a(paramInt, 4)) {
      return this.a.getInt(paramInt);
    }
    return -1;
  }
  
  void a(ByteOrder paramByteOrder)
  {
    this.a.order(paramByteOrder);
  }
  
  short b(int paramInt)
  {
    if (a(paramInt, 2)) {
      return this.a.getShort(paramInt);
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.RandomAccessReader
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.dlsdk.yybutil.apkchannel.v2;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class c
{
  private static int a(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getShort(paramInt) & 0xFFFF;
  }
  
  static long a(ByteBuffer paramByteBuffer)
  {
    d(paramByteBuffer);
    return b(paramByteBuffer, paramByteBuffer.position() + 16);
  }
  
  static b<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile.length() < 22L) {
      return null;
    }
    b localb = a(paramRandomAccessFile, 0);
    if (localb != null) {
      return localb;
    }
    return a(paramRandomAccessFile, 65535);
  }
  
  private static b<ByteBuffer, Long> a(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 65535))
    {
      long l = paramRandomAccessFile.length();
      if (l < 22L) {
        return null;
      }
      ByteBuffer localByteBuffer = ByteBuffer.allocate((int)Math.min(paramInt, l - 22L) + 22);
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      l -= localByteBuffer.capacity();
      paramRandomAccessFile.seek(l);
      paramRandomAccessFile.readFully(localByteBuffer.array(), localByteBuffer.arrayOffset(), localByteBuffer.capacity());
      paramInt = c(localByteBuffer);
      if (paramInt == -1) {
        return null;
      }
      localByteBuffer.position(paramInt);
      paramRandomAccessFile = localByteBuffer.slice();
      paramRandomAccessFile.order(ByteOrder.LITTLE_ENDIAN);
      return b.a(paramRandomAccessFile, Long.valueOf(l + paramInt));
    }
    paramRandomAccessFile = new StringBuilder("maxCommentSize: ");
    paramRandomAccessFile.append(paramInt);
    throw new IllegalArgumentException(paramRandomAccessFile.toString());
  }
  
  static final boolean a(RandomAccessFile paramRandomAccessFile, long paramLong)
  {
    paramLong -= 20L;
    if (paramLong < 0L) {
      return false;
    }
    paramRandomAccessFile.seek(paramLong);
    return paramRandomAccessFile.readInt() == 1347094023;
  }
  
  static long b(ByteBuffer paramByteBuffer)
  {
    d(paramByteBuffer);
    return b(paramByteBuffer, paramByteBuffer.position() + 12);
  }
  
  private static long b(ByteBuffer paramByteBuffer, int paramInt)
  {
    return paramByteBuffer.getInt(paramInt) & 0xFFFFFFFF;
  }
  
  private static int c(ByteBuffer paramByteBuffer)
  {
    d(paramByteBuffer);
    int i = paramByteBuffer.capacity();
    if (i < 22) {
      return -1;
    }
    int j = i - 22;
    int k = Math.min(j, 65535);
    i = 0;
    for (;;)
    {
      if (i >= k) {
        return -1;
      }
      int m = j - i;
      if ((paramByteBuffer.getInt(m) == 101010256) && (a(paramByteBuffer, m + 20) == i)) {
        return m;
      }
      i += 1;
    }
  }
  
  private static void d(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.order() == ByteOrder.LITTLE_ENDIAN) {
      return;
    }
    throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.dlsdk.yybutil.apkchannel.v2.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.armap.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;

public final class BufferedByteStream
{
  public static long a(BufferedInputStream paramBufferedInputStream, BufferedOutputStream paramBufferedOutputStream)
  {
    byte[] arrayOfByte = new byte[1024000];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramBufferedInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramBufferedOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static byte[] a(BufferedInputStream paramBufferedInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    BufferedOutputStream localBufferedOutputStream = new BufferedOutputStream(localByteArrayOutputStream);
    a(paramBufferedInputStream, localBufferedOutputStream);
    localBufferedOutputStream.flush();
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.utils.BufferedByteStream
 * JD-Core Version:    0.7.0.1
 */
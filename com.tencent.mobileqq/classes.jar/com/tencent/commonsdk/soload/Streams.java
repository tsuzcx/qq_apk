package com.tencent.commonsdk.soload;

import java.io.EOFException;
import java.io.InputStream;

public class Streams
{
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {}
    for (;;)
    {
      return;
      if (paramInputStream == null) {
        throw new NullPointerException("in == null");
      }
      if (paramArrayOfByte == null) {
        throw new NullPointerException("dst == null");
      }
      if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= paramArrayOfByte.length) && (paramArrayOfByte.length - paramInt1 >= paramInt2)) {
        while (paramInt2 > 0)
        {
          int i = paramInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
          if (i < 0) {
            throw new EOFException();
          }
          paramInt1 += i;
          paramInt2 -= i;
        }
      }
    }
  }
  
  public static int readSingleByte(InputStream paramInputStream)
  {
    int i = -1;
    byte[] arrayOfByte = new byte[1];
    if (paramInputStream.read(arrayOfByte, 0, 1) != -1) {
      i = arrayOfByte[0] & 0xFF;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.commonsdk.soload.Streams
 * JD-Core Version:    0.7.0.1
 */
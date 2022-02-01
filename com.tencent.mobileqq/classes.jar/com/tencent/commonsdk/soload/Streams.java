package com.tencent.commonsdk.soload;

import java.io.EOFException;
import java.io.InputStream;

public class Streams
{
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    if (paramInputStream != null)
    {
      if (paramArrayOfByte != null)
      {
        if (((paramInt1 | paramInt2) >= 0) && (paramInt1 <= paramArrayOfByte.length))
        {
          int i = paramInt1;
          int j = paramInt2;
          if (paramArrayOfByte.length - paramInt1 < paramInt2) {
            return;
          }
          while (j > 0)
          {
            paramInt1 = paramInputStream.read(paramArrayOfByte, i, j);
            if (paramInt1 >= 0)
            {
              i += paramInt1;
              j -= paramInt1;
            }
            else
            {
              throw new EOFException();
            }
          }
        }
        return;
      }
      throw new NullPointerException("dst == null");
    }
    paramInputStream = new NullPointerException("in == null");
    for (;;)
    {
      throw paramInputStream;
    }
  }
  
  public static int readSingleByte(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[1];
    int j = paramInputStream.read(arrayOfByte, 0, 1);
    int i = -1;
    if (j != -1) {
      i = arrayOfByte[0] & 0xFF;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.commonsdk.soload.Streams
 * JD-Core Version:    0.7.0.1
 */
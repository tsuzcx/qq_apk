package com.peterlmeng.animate_image;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public final class ByteStreams
{
  private static final int BUF_SIZE = 4096;
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return l;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      int i = 0;
      for (;;)
      {
        int j;
        if (i < paramInt2)
        {
          j = paramInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
          if (j != -1) {}
        }
        else
        {
          return i;
        }
        i += j;
      }
    }
    throw new IndexOutOfBoundsException("len is negative");
  }
  
  public static void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 = read(paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 == paramInt2) {
      return;
    }
    paramInputStream = new StringBuilder();
    paramInputStream.append("reached end of stream after reading ");
    paramInputStream.append(paramInt1);
    paramInputStream.append(" bytes; ");
    paramInputStream.append(paramInt2);
    paramInputStream.append(" bytes expected");
    throw new EOFException(paramInputStream.toString());
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] toByteArray(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    int i = paramInt;
    int k;
    if (i > 0)
    {
      int j = paramInt - i;
      k = paramInputStream.read(arrayOfByte, j, i);
      if (k == -1) {
        localObject = Arrays.copyOf(arrayOfByte, j);
      }
    }
    do
    {
      return localObject;
      i -= k;
      break;
      paramInt = paramInputStream.read();
      localObject = arrayOfByte;
    } while (paramInt == -1);
    Object localObject = new ByteStreams.FastByteArrayOutputStream(null);
    ((ByteStreams.FastByteArrayOutputStream)localObject).write(paramInt);
    copy(paramInputStream, (OutputStream)localObject);
    paramInputStream = new byte[arrayOfByte.length + ((ByteStreams.FastByteArrayOutputStream)localObject).size()];
    System.arraycopy(arrayOfByte, 0, paramInputStream, 0, arrayOfByte.length);
    ((ByteStreams.FastByteArrayOutputStream)localObject).writeTo(paramInputStream, arrayOfByte.length);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.ByteStreams
 * JD-Core Version:    0.7.0.1
 */
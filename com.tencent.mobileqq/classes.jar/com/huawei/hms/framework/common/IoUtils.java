package com.huawei.hms.framework.common;

import android.database.Cursor;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IoUtils
{
  private static final int BUFF_SIZE = 4096;
  private static final int MAX_SIZE = 16777216;
  
  public static void close(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public static void closeSecure(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        Logger.w("IOUtil", "closeSecure IOException", paramCloseable);
        return;
      }
    }
    Logger.w("IOUtil", "closeable is null");
  }
  
  public static void closeSecure(InputStream paramInputStream)
  {
    closeSecure(paramInputStream);
  }
  
  public static void closeSecure(OutputStream paramOutputStream)
  {
    closeSecure(paramOutputStream);
  }
  
  public static void closeSecure(Reader paramReader)
  {
    closeSecure(paramReader);
  }
  
  public static void closeSecure(Writer paramWriter)
  {
    closeSecure(paramWriter);
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        return l;
      }
      if (l > 16777216L) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    throw new IOException("input data too large for byte.");
    return l;
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.IoUtils
 * JD-Core Version:    0.7.0.1
 */
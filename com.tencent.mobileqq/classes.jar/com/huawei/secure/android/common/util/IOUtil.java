package com.huawei.secure.android.common.util;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class IOUtil
{
  private static final String TAG = "IOUtil";
  private static final int j = 4096;
  
  public static void close(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public static void closeSecure(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      label11:
      break label11;
    }
    Log.e("IOUtil", "closeSecure IOException");
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
    return copy(paramInputStream, paramOutputStream, new byte[4096]);
  }
  
  public static long copy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(paramArrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(paramArrayOfByte, 0, i);
    }
    return l;
  }
  
  public static void deleteSecure(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()) && (!paramFile.delete())) {
      Log.e("IOUtil", "deleteSecure exception");
    }
  }
  
  public static void deleteSecure(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      deleteSecure(new File(paramString));
    }
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static InputStream toInputStream(byte[] paramArrayOfByte)
  {
    return new ByteArrayInputStream(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.IOUtil
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.secure.android.common.ssl.util;

import android.database.Cursor;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public abstract class f
{
  private static final String a = "IOUtil";
  private static final int b = 4096;
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    return a(paramInputStream, paramOutputStream, new byte[4096]);
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte)
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
  
  public static InputStream a(byte[] paramArrayOfByte)
  {
    return new ByteArrayInputStream(paramArrayOfByte);
  }
  
  public static void a(Cursor paramCursor)
  {
    if (paramCursor != null) {
      paramCursor.close();
    }
  }
  
  public static void a(Closeable paramCloseable)
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
    g.b("IOUtil", "closeSecure IOException");
  }
  
  public static void a(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()) && (!paramFile.delete())) {
      g.b("IOUtil", "deleteSecure exception");
    }
  }
  
  public static void a(InputStream paramInputStream)
  {
    a(paramInputStream);
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    a(paramOutputStream);
  }
  
  public static void a(Reader paramReader)
  {
    a(paramReader);
  }
  
  public static void a(Writer paramWriter)
  {
    a(paramWriter);
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a(new File(paramString));
    }
  }
  
  public static byte[] b(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.f
 * JD-Core Version:    0.7.0.1
 */
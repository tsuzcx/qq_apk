package com.tencent.featuretoggle.utils;

import android.os.Build.VERSION;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Utils
{
  public static String a()
  {
    try
    {
      String str = UUID.randomUUID().toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
    return null;
  }
  
  public static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
      paramThrowable = localStringWriter.getBuffer().toString();
      return paramThrowable;
    }
    catch (Throwable paramThrowable)
    {
      if (!LogUtils.a(paramThrowable)) {
        paramThrowable.printStackTrace();
      }
    }
    return "fail";
  }
  
  public static void a(long paramLong)
  {
    try
    {
      Thread.sleep(paramLong);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      if (!LogUtils.a(localInterruptedException)) {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT < paramInt;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.finish();
      localGZIPOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (!LogUtils.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      Object localObject = new ByteArrayInputStream(paramArrayOfByte);
      GZIPInputStream localGZIPInputStream = new GZIPInputStream((InputStream)localObject);
      byte[] arrayOfByte = new byte[1024];
      paramArrayOfByte = new ByteArrayOutputStream();
      for (;;)
      {
        int i = localGZIPInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        paramArrayOfByte.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte.flush();
      localGZIPInputStream.close();
      ((ByteArrayInputStream)localObject).close();
      localObject = paramArrayOfByte.toByteArray();
      paramArrayOfByte.close();
      return localObject;
    }
    catch (IOException paramArrayOfByte)
    {
      if (!LogUtils.a(paramArrayOfByte)) {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.Utils
 * JD-Core Version:    0.7.0.1
 */
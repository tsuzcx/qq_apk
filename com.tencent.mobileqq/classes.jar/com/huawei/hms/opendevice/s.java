package com.huawei.hms.opendevice;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.secure.android.common.util.IOUtil;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public abstract class s
{
  public static String a(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (int i = paramInputStream.read(); -1 != i; i = paramInputStream.read()) {
      localByteArrayOutputStream.write(i);
    }
    String str = localByteArrayOutputStream.toString("UTF-8");
    a(paramInputStream);
    IOUtil.closeSecure(localByteArrayOutputStream);
    return str;
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      HMSLog.w("StreamUtil", "close IOException");
    }
  }
  
  public static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {}
    try
    {
      paramHttpURLConnection.disconnect();
      return;
    }
    catch (Throwable paramHttpURLConnection)
    {
      HMSLog.w("StreamUtil", "close HttpURLConnection Exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.opendevice.s
 * JD-Core Version:    0.7.0.1
 */
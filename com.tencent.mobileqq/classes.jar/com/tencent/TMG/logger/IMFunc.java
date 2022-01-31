package com.tencent.TMG.logger;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class IMFunc
{
  private static final char[] digits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static String appSignature(int paramInt, String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramString4 == null)) {
      return "-1";
    }
    long l = System.currentTimeMillis() / 1000L;
    int i = Math.abs(new Random().nextInt());
    paramString1 = "a=" + paramInt + "&k=" + paramString1 + "&e=" + (l + paramLong) + "&t=" + l + "&r=" + i + "&f=" + paramString3 + "&b=" + paramString4;
    paramString2 = getHmacSHA1(paramString1.getBytes(), paramString2);
    paramString3 = new byte[paramString2.length + paramString1.getBytes().length];
    System.arraycopy(paramString2, 0, paramString3, 0, paramString2.length);
    System.arraycopy(paramString1.getBytes(), 0, paramString3, paramString2.length, paramString1.getBytes().length);
    return base64Encode(paramString3);
  }
  
  public static String base64Encode(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 2);
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      paramThrowable = "";
    }
    String str;
    StackTraceElement[] arrayOfStackTraceElement;
    do
    {
      return paramThrowable;
      str = paramThrowable.toString();
      arrayOfStackTraceElement = paramThrowable.getStackTrace();
      paramThrowable = str;
    } while (arrayOfStackTraceElement == null);
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    for (;;)
    {
      paramThrowable = str;
      if (i >= j) {
        break;
      }
      paramThrowable = arrayOfStackTraceElement[i];
      str = str + "\n\tat " + paramThrowable.toString();
      i += 1;
    }
  }
  
  public static byte[] getHmacSHA1(byte[] paramArrayOfByte, String paramString)
  {
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec(paramString.getBytes(), "HmacSHA1"));
    try
    {
      paramArrayOfByte = localMac.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (IllegalStateException paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] getParamBytes(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return ("--" + paramString1 + "\r\nContent-Disposition: form-data; name=\"" + paramString2 + "\"; filename=\"" + paramString3 + "\"\r\n\r\n" + paramString4 + "\r\n").getBytes();
  }
  
  public static byte[] getParamBytes(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    paramString1 = ("--" + paramString1 + "\r\nContent-Disposition: form-data; name=\"" + paramString2 + "\"; filename=\"" + paramString3 + "\"\r\n\r\n").getBytes();
    paramString2 = new byte[paramString1.length + paramArrayOfByte.length + 2];
    System.arraycopy(paramString1, 0, paramString2, 0, paramString1.length);
    System.arraycopy(paramArrayOfByte, 0, paramString2, paramString1.length, paramArrayOfByte.length);
    System.arraycopy("\r\n".getBytes(), 0, paramString2, paramString1.length + paramArrayOfByte.length, 2);
    return paramString2;
  }
  
  public static byte[] gzCompress(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
    localGZIPOutputStream.write(paramString.getBytes());
    localGZIPOutputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static boolean httpPostReq(String paramString, byte[] paramArrayOfByte, Map<String, String> paramMap, IMFunc.RequestListener paramRequestListener)
  {
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      new Thread(new IMFunc.1(paramString, paramArrayOfByte, paramMap, paramRequestListener)).start();
      return true;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      if (paramRequestListener != null) {
        paramRequestListener.onFail(getExceptionInfo(paramString));
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.logger.IMFunc
 * JD-Core Version:    0.7.0.1
 */
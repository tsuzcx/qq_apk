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
    if ((paramString1 != null) && (paramString2 != null) && (paramString3 != null) && (paramString4 != null))
    {
      long l = System.currentTimeMillis() / 1000L;
      int i = Math.abs(new Random().nextInt());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("a=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("&k=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&e=");
      localStringBuilder.append(paramLong + l);
      localStringBuilder.append("&t=");
      localStringBuilder.append(l);
      localStringBuilder.append("&r=");
      localStringBuilder.append(i);
      localStringBuilder.append("&f=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append("&b=");
      localStringBuilder.append(paramString4);
      paramString1 = localStringBuilder.toString();
      paramString2 = getHmacSHA1(paramString1.getBytes(), paramString2);
      paramString3 = new byte[paramString2.length + paramString1.getBytes().length];
      System.arraycopy(paramString2, 0, paramString3, 0, paramString2.length);
      System.arraycopy(paramString1.getBytes(), 0, paramString3, paramString2.length, paramString1.getBytes().length);
      return base64Encode(paramString3);
    }
    return "-1";
  }
  
  public static String base64Encode(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 2);
  }
  
  public static String getExceptionInfo(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    String str = paramThrowable.toString();
    StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
    Object localObject = str;
    if (arrayOfStackTraceElement != null)
    {
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      paramThrowable = str;
      for (;;)
      {
        localObject = paramThrowable;
        if (i >= j) {
          break;
        }
        str = arrayOfStackTraceElement[i];
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramThrowable);
        ((StringBuilder)localObject).append("\n\tat ");
        ((StringBuilder)localObject).append(str.toString());
        paramThrowable = ((StringBuilder)localObject).toString();
        i += 1;
      }
    }
    return localObject;
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
    catch (IllegalStateException paramArrayOfByte)
    {
      label31:
      break label31;
    }
    return null;
  }
  
  public static byte[] getParamBytes(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\r\nContent-Disposition: form-data; name=\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\"; filename=\"");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\"\r\n\r\n");
    localStringBuilder.append(paramString4);
    localStringBuilder.append("\r\n");
    return localStringBuilder.toString().getBytes();
  }
  
  public static byte[] getParamBytes(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("--");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\r\nContent-Disposition: form-data; name=\"");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("\"; filename=\"");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("\"\r\n\r\n");
    paramString1 = localStringBuilder.toString().getBytes();
    paramString2 = new byte[paramString1.length + paramArrayOfByte.length + 2];
    System.arraycopy(paramString1, 0, paramString2, 0, paramString1.length);
    System.arraycopy(paramArrayOfByte, 0, paramString2, paramString1.length, paramArrayOfByte.length);
    System.arraycopy("\r\n".getBytes(), 0, paramString2, paramString1.length + paramArrayOfByte.length, 2);
    return paramString2;
  }
  
  public static byte[] gzCompress(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes());
      localGZIPOutputStream.close();
      return localByteArrayOutputStream.toByteArray();
    }
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.logger.IMFunc
 * JD-Core Version:    0.7.0.1
 */
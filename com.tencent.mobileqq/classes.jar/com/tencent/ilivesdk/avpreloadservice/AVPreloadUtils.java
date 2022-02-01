package com.tencent.ilivesdk.avpreloadservice;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AVPreloadUtils
{
  public static String a(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      localObject = a(((MessageDigest)localObject).digest());
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      label24:
      break label24;
    }
    return String.valueOf(paramString.hashCode());
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(str);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString)
  {
    try
    {
      Object localObject = paramString.split("\\?")[0].split("/");
      localObject = localObject[(localObject.length - 1)].split("\\.")[0];
      return localObject;
    }
    catch (Exception localException)
    {
      AVPreloadLog.a(localException);
    }
    return paramString;
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject = paramString.split("\\?")[0].split("/");
      localObject = localObject[(localObject.length - 1)].split("\\.")[0];
      return localObject;
    }
    catch (Exception localException)
    {
      AVPreloadLog.a(localException);
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadUtils
 * JD-Core Version:    0.7.0.1
 */
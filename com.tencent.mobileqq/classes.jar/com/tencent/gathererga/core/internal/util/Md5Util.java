package com.tencent.gathererga.core.internal.util;

import java.security.MessageDigest;

public class Md5Util
{
  private static final String[] a = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  
  private static String a(byte paramByte)
  {
    int i = paramByte;
    if (paramByte < 0) {
      i = paramByte + 256;
    }
    paramByte = i / 16;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a[paramByte]);
    localStringBuilder.append(a[(i % 16)]);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new String(paramString);
    }
    catch (Exception paramString)
    {
      String str;
      label29:
      label31:
      break label31;
    }
    try
    {
      str = a(MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8")));
      return str;
    }
    catch (Exception localException)
    {
      break label29;
    }
    return paramString;
    return null;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuffer.append(a(paramArrayOfByte[i]));
      i += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.Md5Util
 * JD-Core Version:    0.7.0.1
 */
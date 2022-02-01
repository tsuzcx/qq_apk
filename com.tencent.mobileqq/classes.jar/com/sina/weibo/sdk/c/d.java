package com.sina.weibo.sdk.c;

import java.security.MessageDigest;

public final class d
{
  private static final char[] ap = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    int i = 0;
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((MessageDigest)localObject).digest();
      localObject = new char[32];
      int j = 0;
      while (i < 16)
      {
        int k = paramArrayOfByte[i];
        int m = j + 1;
        localObject[j] = ap[(k >>> 4 & 0xF)];
        j = m + 1;
        localObject[m] = ap[(k & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String((char[])localObject);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static String e(String paramString)
  {
    try
    {
      paramString = a(paramString.getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.c.d
 * JD-Core Version:    0.7.0.1
 */
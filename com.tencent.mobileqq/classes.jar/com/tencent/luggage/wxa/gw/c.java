package com.tencent.luggage.wxa.gw;

import java.security.MessageDigest;

public class c
{
  protected static char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  protected static ThreadLocal<MessageDigest> b = new c.1();
  
  @Deprecated
  public static String a(String paramString)
  {
    return a(paramString.getBytes());
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return b(((MessageDigest)b.get()).digest(paramArrayOfByte));
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramInt2 * 2);
    int i = paramInt1;
    while (i < paramInt2 + paramInt1)
    {
      a(paramArrayOfByte[i], localStringBuffer);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static void a(byte paramByte, StringBuffer paramStringBuffer)
  {
    char[] arrayOfChar = a;
    char c1 = arrayOfChar[((paramByte & 0xF0) >> 4)];
    char c2 = arrayOfChar[(paramByte & 0xF)];
    paramStringBuffer.append(c1);
    paramStringBuffer.append(c2);
  }
  
  private static String b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gw.c
 * JD-Core Version:    0.7.0.1
 */
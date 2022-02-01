package com.qq.a.a.a;

import java.nio.charset.Charset;
import java.util.Arrays;

final class c
{
  private static Charset a = Charset.forName("utf-8");
  private static int b = 32;
  
  static byte[] a(int paramInt)
  {
    int i = b;
    int j = i - paramInt % i;
    paramInt = j;
    if (j == 0) {
      paramInt = i;
    }
    char c = (char)(byte)paramInt;
    String str = new String();
    i = 0;
    while (i < paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(c);
      str = localStringBuilder.toString();
      i += 1;
    }
    return str.getBytes(a);
  }
  
  static byte[] a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte[(paramArrayOfByte.length - 1)];
    int i;
    if (j > 0)
    {
      i = j;
      if (j <= 32) {}
    }
    else
    {
      i = 0;
    }
    return Arrays.copyOfRange(paramArrayOfByte, 0, paramArrayOfByte.length - i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.hms.stats;

import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.Locale;

public abstract class g
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  private static byte a(char paramChar)
  {
    return (byte)"0123456789ABCDEF".indexOf(paramChar);
  }
  
  static String a(int paramInt)
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[paramInt];
    localSecureRandom.nextBytes(arrayOfByte);
    return a(arrayOfByte);
  }
  
  static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      af.c("HexUtil", "byteArray is empty");
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(a[((k & 0xF0) >> 4)]).append(a[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  static byte[] a()
  {
    SecureRandom localSecureRandom = new SecureRandom();
    byte[] arrayOfByte = new byte[16];
    localSecureRandom.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  static byte[] a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new byte[0];
      return paramString;
    }
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    int j = paramString.length() / 2;
    char[] arrayOfChar = paramString.toCharArray();
    byte[] arrayOfByte = new byte[j];
    for (;;)
    {
      paramString = arrayOfByte;
      if (i >= j) {
        break;
      }
      int k = i * 2;
      int m = a(arrayOfChar[k]);
      arrayOfByte[i] = ((byte)(a(arrayOfChar[(k + 1)]) | m << 4));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.g
 * JD-Core Version:    0.7.0.1
 */
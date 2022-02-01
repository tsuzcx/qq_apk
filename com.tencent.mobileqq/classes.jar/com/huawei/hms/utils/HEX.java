package com.huawei.hms.utils;

public final class HEX
{
  public static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  public static final char[] b = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static char[] a(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = paramArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = paramArrayOfChar[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte)
  {
    return encodeHex(paramArrayOfByte, false);
  }
  
  public static char[] encodeHex(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    char[] arrayOfChar;
    if (paramBoolean) {
      arrayOfChar = b;
    } else {
      arrayOfChar = a;
    }
    return a(paramArrayOfByte, arrayOfChar);
  }
  
  public static String encodeHexString(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new String(encodeHex(paramArrayOfByte, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.HEX
 * JD-Core Version:    0.7.0.1
 */
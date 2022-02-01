package com.huawei.hms.support.log.common;

public final class Base64
{
  public static final char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47, 61 };
  public static final byte[] b = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
  
  public static int a(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    while (i < paramString.length())
    {
      int m = paramString.charAt(i);
      int k;
      if (m <= 255)
      {
        k = j;
        if (b[m] >= 0) {}
      }
      else
      {
        k = j - 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  public static byte[] decode(String paramString)
  {
    int i = a(paramString);
    int j = i / 4 * 3;
    int k = i % 4;
    i = j;
    if (k == 3) {
      i = j + 2;
    }
    j = i;
    if (k == 2) {
      j = i + 1;
    }
    byte[] arrayOfByte = new byte[j];
    j = 0;
    k = 0;
    int m = 0;
    for (int n = 0; j < paramString.length(); n = i)
    {
      i = paramString.charAt(j);
      int i3;
      if (i > 255) {
        i3 = -1;
      } else {
        i3 = b[i];
      }
      int i2 = k;
      int i1 = m;
      i = n;
      if (i3 >= 0)
      {
        n += 6;
        m = m << 6 | i3;
        i2 = k;
        i1 = m;
        i = n;
        if (n >= 8)
        {
          i = n - 8;
          arrayOfByte[k] = ((byte)(0xFF & m >> i));
          i2 = k + 1;
          i1 = m;
        }
      }
      j += 1;
      k = i2;
      m = i1;
    }
    if (k != arrayOfByte.length) {
      return new byte[0];
    }
    return arrayOfByte;
  }
  
  public static String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static String encode(byte[] paramArrayOfByte, int paramInt)
  {
    char[] arrayOfChar1 = new char[(paramInt + 2) / 3 * 4];
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      int m = (paramArrayOfByte[j] & 0xFF) << 8;
      int k = j + 1;
      int n = 1;
      if (k < paramInt)
      {
        m |= paramArrayOfByte[k] & 0xFF;
        k = 1;
      }
      else
      {
        k = 0;
      }
      m <<= 8;
      int i1 = j + 2;
      if (i1 < paramInt) {
        m |= paramArrayOfByte[i1] & 0xFF;
      } else {
        n = 0;
      }
      char[] arrayOfChar2 = a;
      i1 = 64;
      if (n != 0) {
        n = m & 0x3F;
      } else {
        n = 64;
      }
      arrayOfChar1[(i + 3)] = arrayOfChar2[n];
      n = m >> 6;
      arrayOfChar2 = a;
      m = i1;
      if (k != 0) {
        m = n & 0x3F;
      }
      arrayOfChar1[(i + 2)] = arrayOfChar2[m];
      k = n >> 6;
      arrayOfChar2 = a;
      arrayOfChar1[(i + 1)] = arrayOfChar2[(k & 0x3F)];
      arrayOfChar1[(i + 0)] = arrayOfChar2[(k >> 6 & 0x3F)];
      j += 3;
      i += 4;
    }
    return new String(arrayOfChar1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.support.log.common.Base64
 * JD-Core Version:    0.7.0.1
 */
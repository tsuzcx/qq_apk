package com.tencent.acstat.common;

public class d
{
  static final byte[] a = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }
  
  static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = 0;
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    int j = paramArrayOfByte2.length;
    if ((j <= 0) || (j > 256)) {
      throw new IllegalArgumentException("key must be between 1 and 256 bytes");
    }
    int i = 0;
    while (i < 256)
    {
      arrayOfInt1[i] = i;
      arrayOfInt2[i] = paramArrayOfByte2[(i % j)];
      i += 1;
    }
    j = 0;
    i = 0;
    while (i < 256)
    {
      j = j + arrayOfInt1[i] + arrayOfInt2[i] & 0xFF;
      k = arrayOfInt1[i];
      arrayOfInt1[i] = arrayOfInt1[j];
      arrayOfInt1[j] = k;
      i += 1;
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
    int k = 0;
    j = 0;
    i = m;
    while (i < paramArrayOfByte1.length)
    {
      k = k + 1 & 0xFF;
      j = j + arrayOfInt1[k] & 0xFF;
      m = arrayOfInt1[k];
      arrayOfInt1[k] = arrayOfInt1[j];
      arrayOfInt1[j] = m;
      paramArrayOfByte2[i] = ((byte)(arrayOfInt1[(arrayOfInt1[k] + arrayOfInt1[j] & 0xFF)] ^ paramArrayOfByte1[i]));
      i += 1;
    }
    return paramArrayOfByte2;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    return b(paramArrayOfByte, a);
  }
  
  static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.common.d
 * JD-Core Version:    0.7.0.1
 */
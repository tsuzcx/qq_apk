package com.tencent.luggage.wxa.ao;

import android.util.Pair;

public final class d
{
  private static final byte[] a = { 0, 0, 0, 1 };
  private static final int[] b = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  private static final int[] c = { 0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1 };
  
  private static int a(l paraml)
  {
    int j = paraml.c(5);
    int i = j;
    if (j == 31) {
      i = paraml.c(6) + 32;
    }
    return i;
  }
  
  public static Pair<Integer, Integer> a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new l(paramArrayOfByte);
    int m = a(paramArrayOfByte);
    int i = b(paramArrayOfByte);
    int k = paramArrayOfByte.c(4);
    if (m != 5)
    {
      j = k;
      if (m != 29) {}
    }
    else
    {
      m = b(paramArrayOfByte);
      i = m;
      j = k;
      if (a(paramArrayOfByte) == 22)
      {
        j = paramArrayOfByte.c(4);
        i = m;
      }
    }
    int j = c[j];
    boolean bool;
    if (j != -1) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    return Pair.create(Integer.valueOf(i), Integer.valueOf(j));
  }
  
  public static byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = a;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramInt2];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte2, a.length, paramInt2);
    return arrayOfByte2;
  }
  
  private static int b(l paraml)
  {
    int i = paraml.c(4);
    if (i == 15) {
      return paraml.c(24);
    }
    boolean bool;
    if (i < 13) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    return b[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gathererga.ad.internal;

import com.tencent.gathererga.core.internal.util.GLog;

final class AdHexUtil
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int k = paramArrayOfByte.length;
    if (k <= 0) {
      return null;
    }
    try
    {
      char[] arrayOfChar = new char[k << 1];
      int i = 0;
      int j = 0;
      while (i < k)
      {
        int m = j + 1;
        arrayOfChar[j] = a[(paramArrayOfByte[i] >>> 4 & 0xF)];
        j = m + 1;
        arrayOfChar[m] = a[(paramArrayOfByte[i] & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      GLog.b("bytes2HexString", paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdHexUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ad.tangram.util;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public final class AdHexUtil
{
  private static final String TAG = "AdHexUtil";
  private static final char[] hexDigits = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String bytes2HexString(byte[] paramArrayOfByte)
  {
    int j = 0;
    if (paramArrayOfByte == null) {}
    int k;
    do
    {
      return null;
      k = paramArrayOfByte.length;
    } while (k <= 0);
    try
    {
      char[] arrayOfChar = new char[k << 1];
      int i = 0;
      while (i < k)
      {
        int m = j + 1;
        arrayOfChar[j] = hexDigits[(paramArrayOfByte[i] >>> 4 & 0xF)];
        j = m + 1;
        arrayOfChar[m] = hexDigits[(paramArrayOfByte[i] & 0xF)];
        i += 1;
      }
      paramArrayOfByte = new String(arrayOfChar);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      AdLog.e("AdHexUtil", "bytes2HexString", paramArrayOfByte);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdHexUtil
 * JD-Core Version:    0.7.0.1
 */
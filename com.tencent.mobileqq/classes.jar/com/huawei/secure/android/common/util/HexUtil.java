package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class HexUtil
{
  private static final String TAG = "HexUtil";
  private static final String i = "";
  
  public static String byteArray2HexStr(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = byteArray2HexStr(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("byte array 2 hex string exception : ");
      localStringBuilder.append(paramString.getMessage());
      Log.e("HexUtil", localStringBuilder.toString());
      return "";
    }
    catch (UnsupportedEncodingException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("byte array 2 hex string UnsupportedEncodingException : ");
      localStringBuilder.append(paramString.getMessage());
      Log.e("HexUtil", localStringBuilder.toString());
    }
    return "";
  }
  
  public static String byteArray2HexStr(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = 0;
      while (j < paramArrayOfByte.length)
      {
        String str = Integer.toHexString(paramArrayOfByte[j] & 0xFF);
        if (str.length() == 1) {
          localStringBuilder.append('0');
        }
        localStringBuilder.append(str);
        j += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static byte[] hexStr2ByteArray(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new byte[0];
    }
    paramString = paramString.toUpperCase(Locale.ENGLISH);
    byte[] arrayOfByte = new byte[paramString.length() / 2];
    try
    {
      paramString = paramString.getBytes("UTF-8");
      int j = 0;
      while (j < arrayOfByte.length)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0x");
        int k = j * 2;
        localStringBuilder.append(new String(new byte[] { paramString[k] }, "UTF-8"));
        int m = (byte)(Byte.decode(localStringBuilder.toString()).byteValue() << 4);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("0x");
        localStringBuilder.append(new String(new byte[] { paramString[(k + 1)] }, "UTF-8"));
        arrayOfByte[j] = ((byte)(m ^ Byte.decode(localStringBuilder.toString()).byteValue()));
        j += 1;
      }
      localStringBuilder = new StringBuilder();
    }
    catch (Exception paramString) {}catch (NumberFormatException paramString)
    {
      break label226;
    }
    catch (UnsupportedEncodingException paramString)
    {
      break label226;
    }
    localStringBuilder.append("byte array 2 hex string exception : ");
    localStringBuilder.append(paramString.getMessage());
    Log.e("HexUtil", localStringBuilder.toString());
    return arrayOfByte;
    label226:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hex string 2 byte UnsupportedEncodingException or NumberFormatException : ");
    localStringBuilder.append(paramString.getMessage());
    Log.e("HexUtil", localStringBuilder.toString());
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.util.HexUtil
 * JD-Core Version:    0.7.0.1
 */
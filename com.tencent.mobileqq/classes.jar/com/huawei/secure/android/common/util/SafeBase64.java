package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

public class SafeBase64
{
  private static final String TAG = SafeBase64.class.getSimpleName();
  
  public static byte[] decode(String paramString, int paramInt)
  {
    try
    {
      paramString = Base64.decode(paramString, paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e(TAG, paramString.getClass().getSimpleName() + " , message2 : " + paramString.getMessage());
    }
    return new byte[0];
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = Base64.decode(paramArrayOfByte, paramInt);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e(TAG, paramArrayOfByte.getClass().getSimpleName() + " , message0 : " + paramArrayOfByte.getMessage());
    }
    return new byte[0];
  }
  
  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = Base64.decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e(TAG, paramArrayOfByte.getClass().getSimpleName() + " , message1 : " + paramArrayOfByte.getMessage());
    }
    return new byte[0];
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = Base64.encode(paramArrayOfByte, paramInt);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e(TAG, paramArrayOfByte.getClass().getSimpleName() + " , message3 : " + paramArrayOfByte.getMessage());
    }
    return new byte[0];
  }
  
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = Base64.encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e(TAG, paramArrayOfByte.getClass().getSimpleName() + " , message4 : " + paramArrayOfByte.getMessage());
    }
    return new byte[0];
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, paramInt);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e(TAG, paramArrayOfByte.getClass().getSimpleName() + " , message5 : " + paramArrayOfByte.getMessage());
    }
    return "";
  }
  
  public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.e(TAG, paramArrayOfByte.getClass().getSimpleName() + " , message6 : " + paramArrayOfByte.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafeBase64
 * JD-Core Version:    0.7.0.1
 */
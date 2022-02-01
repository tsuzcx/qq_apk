package com.huawei.secure.android.common.util;

import android.util.Base64;
import android.util.Log;

public class SafeBase64
{
  private static final String TAG = "SafeBase64";
  
  public static byte[] decode(String paramString, int paramInt)
  {
    try
    {
      paramString = Base64.decode(paramString, paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getClass().getSimpleName());
      localStringBuilder.append(" , message2 : ");
      localStringBuilder.append(paramString.getMessage());
      Log.e(str, localStringBuilder.toString());
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfByte.getClass().getSimpleName());
      localStringBuilder.append(" , message0 : ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      Log.e(str, localStringBuilder.toString());
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfByte.getClass().getSimpleName());
      localStringBuilder.append(" , message1 : ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      Log.e(str, localStringBuilder.toString());
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfByte.getClass().getSimpleName());
      localStringBuilder.append(" , message3 : ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      Log.e(str, localStringBuilder.toString());
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfByte.getClass().getSimpleName());
      localStringBuilder.append(" , message4 : ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      Log.e(str, localStringBuilder.toString());
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfByte.getClass().getSimpleName());
      localStringBuilder.append(" , message5 : ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      Log.e(str, localStringBuilder.toString());
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
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfByte.getClass().getSimpleName());
      localStringBuilder.append(" , message6 : ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      Log.e(str, localStringBuilder.toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafeBase64
 * JD-Core Version:    0.7.0.1
 */
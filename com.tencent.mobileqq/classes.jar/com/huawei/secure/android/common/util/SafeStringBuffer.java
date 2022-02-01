package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeStringBuffer
{
  private static final String TAG = SafeStringBuffer.class.getSimpleName();
  private static final String i = "";
  
  public static String substring(StringBuffer paramStringBuffer, int paramInt)
  {
    if ((paramStringBuffer == null) || (paramStringBuffer.length() < paramInt) || (paramInt < 0)) {
      return "";
    }
    try
    {
      paramStringBuffer = paramStringBuffer.substring(paramInt);
      return paramStringBuffer;
    }
    catch (Exception paramStringBuffer)
    {
      Log.e(TAG, "substring exception: " + paramStringBuffer.getMessage());
    }
    return "";
  }
  
  public static String substring(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if ((paramStringBuffer == null) || (paramInt1 < 0) || (paramInt2 > paramStringBuffer.length()) || (paramInt2 < paramInt1)) {
      return "";
    }
    try
    {
      paramStringBuffer = paramStringBuffer.substring(paramInt1, paramInt2);
      return paramStringBuffer;
    }
    catch (Exception paramStringBuffer)
    {
      Log.e(TAG, "substring: " + paramStringBuffer.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafeStringBuffer
 * JD-Core Version:    0.7.0.1
 */
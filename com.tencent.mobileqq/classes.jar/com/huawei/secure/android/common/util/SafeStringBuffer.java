package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeStringBuffer
{
  private static final String TAG = "SafeStringBuffer";
  private static final String i = "";
  
  public static String substring(StringBuffer paramStringBuffer, int paramInt)
  {
    if ((paramStringBuffer != null) && (paramStringBuffer.length() >= paramInt))
    {
      if (paramInt < 0) {
        return "";
      }
      try
      {
        paramStringBuffer = paramStringBuffer.substring(paramInt);
        return paramStringBuffer;
      }
      catch (Exception paramStringBuffer)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("substring exception: ");
        localStringBuilder.append(paramStringBuffer.getMessage());
        Log.e(str, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static String substring(StringBuffer paramStringBuffer, int paramInt1, int paramInt2)
  {
    if ((paramStringBuffer != null) && (paramInt1 >= 0) && (paramInt2 <= paramStringBuffer.length()))
    {
      if (paramInt2 < paramInt1) {
        return "";
      }
      try
      {
        paramStringBuffer = paramStringBuffer.substring(paramInt1, paramInt2);
        return paramStringBuffer;
      }
      catch (Exception paramStringBuffer)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("substring: ");
        localStringBuilder.append(paramStringBuffer.getMessage());
        Log.e(str, localStringBuilder.toString());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafeStringBuffer
 * JD-Core Version:    0.7.0.1
 */
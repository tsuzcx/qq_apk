package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeString
{
  private static final String TAG = SafeString.class.getSimpleName();
  private static final String i = "";
  
  public static String replace(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramString == null) || (paramCharSequence1 == null) || (paramCharSequence2 == null)) {
      return paramString;
    }
    try
    {
      paramCharSequence1 = paramString.replace(paramCharSequence1, paramCharSequence2);
      return paramCharSequence1;
    }
    catch (Exception paramCharSequence1)
    {
      Log.e(TAG, "replace: " + paramCharSequence1.getMessage());
    }
    return paramString;
  }
  
  public static String substring(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() < paramInt) || (paramInt < 0)) {
      return "";
    }
    try
    {
      paramString = paramString.substring(paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e(TAG, "substring exception: " + paramString.getMessage());
    }
    return "";
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString == null) || (paramInt1 < 0) || (paramInt2 > paramString.length()) || (paramInt2 < paramInt1)) {
      return "";
    }
    try
    {
      paramString = paramString.substring(paramInt1, paramInt2);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e(TAG, "substring: " + paramString.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafeString
 * JD-Core Version:    0.7.0.1
 */
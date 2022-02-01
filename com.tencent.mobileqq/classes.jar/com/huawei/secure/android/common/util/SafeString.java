package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeString
{
  private static final String TAG = "SafeString";
  private static final String i = "";
  
  public static String replace(String paramString, CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((paramString != null) && (paramCharSequence1 != null))
    {
      if (paramCharSequence2 == null) {
        return paramString;
      }
      try
      {
        paramCharSequence1 = paramString.replace(paramCharSequence1, paramCharSequence2);
        return paramCharSequence1;
      }
      catch (Exception paramCharSequence1)
      {
        paramCharSequence2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("replace: ");
        localStringBuilder.append(paramCharSequence1.getMessage());
        Log.e(paramCharSequence2, localStringBuilder.toString());
      }
    }
    return paramString;
  }
  
  public static String substring(String paramString, int paramInt)
  {
    if ((paramString != null) && (paramString.length() >= paramInt))
    {
      if (paramInt < 0) {
        return "";
      }
      try
      {
        paramString = paramString.substring(paramInt);
        return paramString;
      }
      catch (Exception paramString)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("substring exception: ");
        localStringBuilder.append(paramString.getMessage());
        Log.e(str, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static String substring(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramString != null) && (paramInt1 >= 0) && (paramInt2 <= paramString.length()))
    {
      if (paramInt2 < paramInt1) {
        return "";
      }
      try
      {
        paramString = paramString.substring(paramInt1, paramInt2);
        return paramString;
      }
      catch (Exception paramString)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("substring: ");
        localStringBuilder.append(paramString.getMessage());
        Log.e(str, localStringBuilder.toString());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafeString
 * JD-Core Version:    0.7.0.1
 */
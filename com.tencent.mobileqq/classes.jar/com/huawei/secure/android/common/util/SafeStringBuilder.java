package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

public class SafeStringBuilder
{
  private static final String TAG = "SafeStringBuilder";
  private static final String i = "";
  
  public static String substring(StringBuilder paramStringBuilder, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramStringBuilder)) && (paramStringBuilder.length() >= paramInt))
    {
      if (paramInt < 0) {
        return "";
      }
      try
      {
        paramStringBuilder = paramStringBuilder.substring(paramInt);
        return paramStringBuilder;
      }
      catch (Exception paramStringBuilder)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("substring exception: ");
        localStringBuilder.append(paramStringBuilder.getMessage());
        Log.e(str, localStringBuilder.toString());
      }
    }
    return "";
  }
  
  public static String substring(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramStringBuilder)) && (paramInt1 >= 0) && (paramInt2 <= paramStringBuilder.length()))
    {
      if (paramInt2 < paramInt1) {
        return "";
      }
      try
      {
        paramStringBuilder = paramStringBuilder.substring(paramInt1, paramInt2);
        return paramStringBuilder;
      }
      catch (Exception paramStringBuilder)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("substring: ");
        localStringBuilder.append(paramStringBuilder.getMessage());
        Log.e(str, localStringBuilder.toString());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafeStringBuilder
 * JD-Core Version:    0.7.0.1
 */
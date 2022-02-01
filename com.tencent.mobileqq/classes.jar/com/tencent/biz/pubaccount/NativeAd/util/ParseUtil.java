package com.tencent.biz.pubaccount.NativeAd.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ParseUtil
{
  public static double a(String paramString, double paramDouble)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        double d = Double.valueOf(paramString.trim()).doubleValue();
        return d;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" parseDouble error message=");
        localStringBuilder.append(paramString.getMessage());
        QLog.d("ParseUtil", 2, localStringBuilder.toString());
      }
    }
    return paramDouble;
  }
  
  public static float a(String paramString, float paramFloat)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        float f = Float.valueOf(paramString.trim()).floatValue();
        return f;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" parseFloat error message=");
        localStringBuilder.append(paramString.getMessage());
        QLog.d("ParseUtil", 2, localStringBuilder.toString());
      }
    }
    return paramFloat;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int i = Integer.valueOf(paramString.trim()).intValue();
        return i;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" parseInteger error message=");
        localStringBuilder.append(paramString.getMessage());
        QLog.d("ParseUtil", 2, localStringBuilder.toString());
      }
    }
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        int i = Color.parseColor(paramString1.trim());
        return i;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" parseColor error message=");
        localStringBuilder.append(paramString1.getMessage());
        QLog.d("ParseUtil", 2, localStringBuilder.toString());
      }
    }
    return Color.parseColor(paramString2);
  }
  
  public static long a(String paramString, long paramLong)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        long l = Long.valueOf(paramString.trim()).longValue();
        return l;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" parseLong error message=");
        localStringBuilder.append(paramString.getMessage());
        QLog.d("ParseUtil", 2, localStringBuilder.toString());
      }
    }
    return paramLong;
  }
  
  public static String a(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (paramJSONObject != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return paramString2;
      }
      paramJSONObject = paramJSONObject.optString(paramString1);
      if (TextUtils.isEmpty(paramJSONObject)) {
        return paramString2;
      }
      return paramJSONObject;
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.ParseUtil
 * JD-Core Version:    0.7.0.1
 */
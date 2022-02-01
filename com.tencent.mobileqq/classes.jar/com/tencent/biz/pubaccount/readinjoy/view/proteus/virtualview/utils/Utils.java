package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Color;

public class Utils
{
  private static final String TAG = "Utils_TMTEST";
  private static int UED_SCREEN = 375;
  private static float sDensity;
  private static int sScreenWidth;
  
  public static int dp2px(double paramDouble)
  {
    if (sDensity < 0.0F) {}
    for (float f = 1.0F; paramDouble >= 0.0D; f = sDensity) {
      return (int)(f * paramDouble + 0.5D);
    }
    paramDouble = -paramDouble;
    return -(int)(f * paramDouble + 0.5D);
  }
  
  public static void init(float paramFloat, int paramInt)
  {
    sDensity = paramFloat;
    sScreenWidth = paramInt;
  }
  
  public static boolean isDigit(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static boolean isEL(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() != 0)
      {
        int i = paramString.length();
        if ((paramString.charAt(0) != '$') || (paramString.charAt(1) != '{') || (paramString.charAt(i - 1) != '}'))
        {
          bool1 = bool2;
          if (paramString.charAt(0) == '@')
          {
            bool1 = bool2;
            if (paramString.charAt(1) == '{')
            {
              bool1 = bool2;
              if (paramString.charAt(i - 1) != '}') {}
            }
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean isHex(char paramChar)
  {
    return ((paramChar >= '0') && (paramChar <= '9')) || ((paramChar >= 'a') && (paramChar <= 'f')) || ((paramChar >= 'A') && (paramChar <= 'F'));
  }
  
  public static boolean isSpace(char paramChar)
  {
    return (' ' == paramChar) || ('\t' == paramChar) || ('\n' == paramChar);
  }
  
  public static boolean isThreeUnknown(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      int i = paramString.length();
      return (paramString.charAt(0) == '@') && (paramString.charAt(1) == '{') && (paramString.charAt(i - 1) == '}');
    }
    return false;
  }
  
  public static int parseColor(String paramString)
  {
    try
    {
      int i = Integer.valueOf(Color.parseColor(paramString)).intValue();
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static int px2dp(float paramFloat)
  {
    if (sDensity < 0.0F) {}
    for (float f = 1.0F;; f = sDensity) {
      return (int)(paramFloat / f + 0.5F);
    }
  }
  
  public static int rp2px(double paramDouble)
  {
    return (int)(sScreenWidth * paramDouble / UED_SCREEN + 0.5D);
  }
  
  public static int rp2px(int paramInt, double paramDouble)
  {
    sScreenWidth = paramInt;
    return rp2px(paramDouble);
  }
  
  public static void setUedScreenWidth(int paramInt)
  {
    UED_SCREEN = paramInt;
  }
  
  public static Boolean toBoolean(Object paramObject)
  {
    if ((paramObject instanceof Boolean)) {
      return (Boolean)paramObject;
    }
    if ((paramObject instanceof String))
    {
      paramObject = (String)paramObject;
      if ("true".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(true);
      }
      if ("false".equalsIgnoreCase(paramObject)) {
        return Boolean.valueOf(false);
      }
    }
    return null;
  }
  
  public static Double toDouble(Object paramObject)
  {
    if ((paramObject instanceof Double)) {
      return (Double)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Double.valueOf(((Number)paramObject).doubleValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = Double.valueOf((String)paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  public static Float toFloat(Object paramObject)
  {
    if ((paramObject instanceof Float)) {
      return (Float)paramObject;
    }
    if ((paramObject instanceof Double)) {
      return Float.valueOf(((Double)paramObject).floatValue());
    }
    if ((paramObject instanceof Number)) {
      return Float.valueOf(((Number)paramObject).floatValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        paramObject = Float.valueOf((String)paramObject);
        return paramObject;
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  public static Integer toInteger(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {
      return (Integer)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Integer.valueOf(((Number)paramObject).intValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        int i = (int)Double.parseDouble((String)paramObject);
        return Integer.valueOf(i);
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  public static Long toLong(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return (Long)paramObject;
    }
    if ((paramObject instanceof Number)) {
      return Long.valueOf(((Number)paramObject).longValue());
    }
    if ((paramObject instanceof String)) {
      try
      {
        long l = Double.parseDouble((String)paramObject);
        return Long.valueOf(l);
      }
      catch (NumberFormatException paramObject) {}
    }
    return null;
  }
  
  public static String toString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if (paramObject != null) {
      return String.valueOf(paramObject);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils
 * JD-Core Version:    0.7.0.1
 */
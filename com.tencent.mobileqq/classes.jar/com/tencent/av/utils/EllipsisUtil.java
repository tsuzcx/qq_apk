package com.tencent.av.utils;

import android.text.TextPaint;

public class EllipsisUtil
{
  public static float a(String paramString, TextPaint paramTextPaint)
  {
    return paramTextPaint.measureText(paramString);
  }
  
  public static float a(StringBuilder paramStringBuilder, String paramString, TextPaint paramTextPaint, float paramFloat)
  {
    if (paramString == null) {
      return paramFloat;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      float f = paramTextPaint.measureText(paramString, i, 1);
      if (f >= paramFloat) {
        break;
      }
      paramFloat -= f;
      paramStringBuilder.append(paramString[i]);
      i += 1;
    }
    return paramFloat;
  }
  
  public static float b(StringBuilder paramStringBuilder, String paramString, TextPaint paramTextPaint, float paramFloat)
  {
    float f = paramTextPaint.measureText("...");
    if (f > a(paramStringBuilder, paramString, paramTextPaint, paramFloat - f)) {
      paramStringBuilder.append("...");
    }
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.EllipsisUtil
 * JD-Core Version:    0.7.0.1
 */
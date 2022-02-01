package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;

public class UIUtilBase
{
  protected static Paint.FontMetricsInt fm = new Paint.FontMetricsInt();
  
  public static int getTextHeight(int paramInt)
  {
    Paint localPaint = new Paint();
    localPaint.setTextSize(paramInt);
    localPaint.getFontMetricsInt(fm);
    localPaint.setAntiAlias(true);
    return (int)Math.ceil(fm.descent - fm.ascent);
  }
  
  public static int getTextHeight(Paint paramPaint, int paramInt)
  {
    paramPaint.setTextSize(paramInt);
    paramPaint.getFontMetricsInt(fm);
    paramPaint.setAntiAlias(true);
    return (int)Math.ceil(fm.descent - fm.ascent);
  }
  
  public static int getTextWidth(String paramString, Paint paramPaint, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      return 0;
    }
    float f = paramPaint.getTextSize();
    paramPaint.setTextSize(paramInt);
    paramInt = (int)paramPaint.measureText(paramString);
    paramPaint.setTextSize(f);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.UIUtilBase
 * JD-Core Version:    0.7.0.1
 */
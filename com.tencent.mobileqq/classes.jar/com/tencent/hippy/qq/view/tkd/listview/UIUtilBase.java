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
    double d1 = fm.descent;
    double d2 = fm.ascent;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (int)Math.ceil(d1 - d2);
  }
  
  public static int getTextHeight(Paint paramPaint, int paramInt)
  {
    paramPaint.setTextSize(paramInt);
    paramPaint.getFontMetricsInt(fm);
    paramPaint.setAntiAlias(true);
    double d1 = fm.descent;
    double d2 = fm.ascent;
    Double.isNaN(d1);
    Double.isNaN(d2);
    return (int)Math.ceil(d1 - d2);
  }
  
  public static int getTextWidth(String paramString, Paint paramPaint, int paramInt)
  {
    if ((paramString != null) && (!"".equals(paramString.trim())))
    {
      float f = paramPaint.getTextSize();
      paramPaint.setTextSize(paramInt);
      paramInt = (int)paramPaint.measureText(paramString);
      paramPaint.setTextSize(f);
      return paramInt;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.UIUtilBase
 * JD-Core Version:    0.7.0.1
 */
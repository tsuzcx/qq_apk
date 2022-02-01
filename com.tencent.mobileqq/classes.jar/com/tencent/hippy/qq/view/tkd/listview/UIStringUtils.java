package com.tencent.hippy.qq.view.tkd.listview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.text.TextUtils;
import com.tencent.widget.immersive.ImmersiveUtils;

public class UIStringUtils
{
  private static Paint.FontMetricsInt fm = new Paint.FontMetricsInt();
  private static float mPaintOffset = ImmersiveUtils.dpToPx(1.0F);
  
  public static void drawText(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, String paramString)
  {
    paramPaint.setAntiAlias(true);
    paramPaint.setTextAlign(Paint.Align.LEFT);
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.getFontMetricsInt(fm);
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - paramPaint.ascent() - mPaintOffset, paramPaint);
    paramPaint.setAntiAlias(false);
  }
  
  public static String getFileExt(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.lastIndexOf('.');
      if (i >= 0) {
        return paramString.substring(i + 1);
      }
    }
    return null;
  }
  
  public static boolean isEmpty(String paramString)
  {
    return (paramString == null) || ("".equals(paramString.trim()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.UIStringUtils
 * JD-Core Version:    0.7.0.1
 */
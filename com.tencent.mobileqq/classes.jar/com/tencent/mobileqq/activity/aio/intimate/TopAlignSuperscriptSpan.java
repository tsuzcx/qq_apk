package com.tencent.mobileqq.activity.aio.intimate;

import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignSuperscriptSpan
  extends SuperscriptSpan
{
  private int a = 2;
  private float b = 0.0F;
  
  public TopAlignSuperscriptSpan() {}
  
  public TopAlignSuperscriptSpan(float paramFloat)
  {
    double d = paramFloat;
    if ((d > 0.0D) && (d < 1.0D)) {
      this.b = paramFloat;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (paramTextPaint != null)
    {
      float f1 = paramTextPaint.ascent();
      paramTextPaint.setTextSize(paramTextPaint.getTextSize() / this.a);
      float f2 = paramTextPaint.getFontMetrics().ascent;
      float f3 = paramTextPaint.baselineShift;
      float f4 = this.b;
      paramTextPaint.baselineShift = ((int)(f3 + (f1 - f1 * f4 - (f2 - f4 * f2))));
    }
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.TopAlignSuperscriptSpan
 * JD-Core Version:    0.7.0.1
 */
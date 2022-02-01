package com.tencent.mobileqq.activity.aio.intimate;

import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignSuperscriptSpan
  extends SuperscriptSpan
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 2;
  
  public TopAlignSuperscriptSpan() {}
  
  public TopAlignSuperscriptSpan(float paramFloat)
  {
    double d = paramFloat;
    if ((d > 0.0D) && (d < 1.0D)) {
      this.jdField_a_of_type_Float = paramFloat;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (paramTextPaint != null)
    {
      float f1 = paramTextPaint.ascent();
      paramTextPaint.setTextSize(paramTextPaint.getTextSize() / this.jdField_a_of_type_Int);
      float f2 = paramTextPaint.getFontMetrics().ascent;
      float f3 = paramTextPaint.baselineShift;
      float f4 = this.jdField_a_of_type_Float;
      paramTextPaint.baselineShift = ((int)(f3 + (f1 - f1 * f4 - (f2 - f4 * f2))));
    }
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.TopAlignSuperscriptSpan
 * JD-Core Version:    0.7.0.1
 */
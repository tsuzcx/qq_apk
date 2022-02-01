package com.tencent.mobileqq.activity.aio.intimate;

import android.graphics.Paint.FontMetrics;
import android.text.TextPaint;
import android.text.style.SuperscriptSpan;

public class TopAlignSuperscriptSpan
  extends SuperscriptSpan
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 2;
  
  public TopAlignSuperscriptSpan() {}
  
  public TopAlignSuperscriptSpan(float paramFloat)
  {
    if ((paramFloat > 0.0D) && (paramFloat < 1.0D)) {
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
      paramTextPaint.baselineShift = ((int)(f1 - this.jdField_a_of_type_Float * f1 - (f2 - this.jdField_a_of_type_Float * f2) + f3));
    }
  }
  
  public void updateMeasureState(TextPaint paramTextPaint)
  {
    updateDrawState(paramTextPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.TopAlignSuperscriptSpan
 * JD-Core Version:    0.7.0.1
 */
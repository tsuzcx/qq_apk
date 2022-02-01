package com.tencent.biz.qqcircle.widgets.span;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;

public class CustomTypeFaceSpan
  extends MetricAffectingSpan
{
  private Typeface a;
  private float b = 0.0F;
  
  public CustomTypeFaceSpan(Typeface paramTypeface, int paramInt)
  {
    this.a = paramTypeface;
    this.b = paramInt;
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    Typeface localTypeface = this.a;
    if (localTypeface != null) {
      paramTextPaint.setTypeface(localTypeface);
    }
    float f = this.b;
    if (f > 0.0F) {
      paramTextPaint.setTextSize(f);
    }
  }
  
  public void updateMeasureState(@NonNull TextPaint paramTextPaint)
  {
    Typeface localTypeface = this.a;
    if (localTypeface != null) {
      paramTextPaint.setTypeface(localTypeface);
    }
    float f = this.b;
    if (f > 0.0F) {
      paramTextPaint.setTextSize(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.span.CustomTypeFaceSpan
 * JD-Core Version:    0.7.0.1
 */
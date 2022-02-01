package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec>
{
  S a;
  protected DrawableWithAnimatedVisibilityChange a;
  
  public DrawingDelegate(S paramS)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec = paramS;
  }
  
  abstract int a();
  
  abstract void a(@NonNull Canvas paramCanvas, @FloatRange(from=0.0D, to=1.0D) float paramFloat);
  
  abstract void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint);
  
  abstract void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint, @FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2, @ColorInt int paramInt);
  
  protected void a(@NonNull DrawableWithAnimatedVisibilityChange paramDrawableWithAnimatedVisibilityChange)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange = paramDrawableWithAnimatedVisibilityChange;
  }
  
  abstract int b();
  
  void b(@NonNull Canvas paramCanvas, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.a();
    a(paramCanvas, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.DrawingDelegate
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

final class CircularDrawingDelegate
  extends DrawingDelegate<CircularProgressIndicatorSpec>
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 1;
  private float b;
  private float c;
  
  public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    super(paramCircularProgressIndicatorSpec);
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, RectF paramRectF)
  {
    float f1;
    if (paramBoolean) {
      f1 = -1.0F;
    } else {
      f1 = 1.0F;
    }
    paramCanvas.save();
    paramCanvas.rotate(paramFloat3);
    paramFloat3 = this.c;
    float f2 = paramFloat1 / 2.0F;
    float f3 = f1 * paramFloat2;
    paramCanvas.drawRect(paramFloat3 - f2 + paramFloat2, Math.min(0.0F, this.jdField_a_of_type_Int * f3), this.c + f2 - paramFloat2, Math.max(0.0F, f3 * this.jdField_a_of_type_Int), paramPaint);
    paramCanvas.translate(this.c - f2 + paramFloat2, 0.0F);
    paramCanvas.drawArc(paramRectF, 180.0F, -f1 * 90.0F * this.jdField_a_of_type_Int, true, paramPaint);
    paramCanvas.translate(paramFloat1 - paramFloat2 * 2.0F, 0.0F);
    paramCanvas.drawArc(paramRectF, 0.0F, f1 * 90.0F * this.jdField_a_of_type_Int, true, paramPaint);
    paramCanvas.restore();
  }
  
  private int c()
  {
    return ((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).f + ((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).g * 2;
  }
  
  public int a()
  {
    return c();
  }
  
  public void a(@NonNull Canvas paramCanvas, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    float f1 = ((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).f / 2.0F + ((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).g;
    paramCanvas.translate(f1, f1);
    paramCanvas.rotate(-90.0F);
    float f2 = -f1;
    paramCanvas.clipRect(f2, f2, f1, f1);
    int i;
    if (((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).h == 0) {
      i = 1;
    } else {
      i = -1;
    }
    this.jdField_a_of_type_Int = i;
    this.jdField_a_of_type_Float = (((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int * paramFloat);
    this.b = (((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).b * paramFloat);
    this.c = ((((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).f - ((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int) / 2.0F);
    if (((this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.c()) && (((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).d == 2)) || ((this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.b()) && (((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).e == 1)))
    {
      this.c += (1.0F - paramFloat) * ((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int / 2.0F;
      return;
    }
    if (((this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.c()) && (((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).d == 1)) || ((this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.b()) && (((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).e == 2))) {
      this.c -= (1.0F - paramFloat) * ((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int / 2.0F;
    }
  }
  
  void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint)
  {
    int i = MaterialColors.b(((CircularProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).c, this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.getAlpha());
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeCap(Paint.Cap.BUTT);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(i);
    paramPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    float f = this.c;
    paramCanvas.drawArc(new RectF(-f, -f, f, f), 0.0F, 360.0F, false, paramPaint);
  }
  
  void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint, @FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2, @ColorInt int paramInt)
  {
    if (paramFloat1 == paramFloat2) {
      return;
    }
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeCap(Paint.Cap.BUTT);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(paramInt);
    paramPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    paramInt = this.jdField_a_of_type_Int;
    float f = paramFloat1 * 360.0F * paramInt;
    if (paramFloat2 >= paramFloat1) {
      paramFloat1 = paramFloat2 - paramFloat1;
    } else {
      paramFloat1 = paramFloat2 + 1.0F - paramFloat1;
    }
    paramFloat1 = paramFloat1 * 360.0F * paramInt;
    paramFloat2 = this.c;
    paramCanvas.drawArc(new RectF(-paramFloat2, -paramFloat2, paramFloat2, paramFloat2), f, paramFloat1, false, paramPaint);
    if ((this.b > 0.0F) && (Math.abs(paramFloat1) < 360.0F))
    {
      paramPaint.setStyle(Paint.Style.FILL);
      paramFloat2 = this.b;
      RectF localRectF = new RectF(-paramFloat2, -paramFloat2, paramFloat2, paramFloat2);
      a(paramCanvas, paramPaint, this.jdField_a_of_type_Float, this.b, f, true, localRectF);
      a(paramCanvas, paramPaint, this.jdField_a_of_type_Float, this.b, f + paramFloat1, false, localRectF);
    }
  }
  
  public int b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularDrawingDelegate
 * JD-Core Version:    0.7.0.1
 */
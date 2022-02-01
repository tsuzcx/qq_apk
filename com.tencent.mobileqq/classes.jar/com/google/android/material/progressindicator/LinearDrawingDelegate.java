package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.color.MaterialColors;

final class LinearDrawingDelegate
  extends DrawingDelegate<LinearProgressIndicatorSpec>
{
  private float a;
  private float b;
  private float c;
  
  public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(paramLinearProgressIndicatorSpec);
    this.jdField_a_of_type_Float = 300.0F;
  }
  
  private static void a(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, RectF paramRectF)
  {
    paramCanvas.save();
    paramCanvas.translate(paramFloat3, 0.0F);
    if (!paramBoolean) {
      paramCanvas.rotate(180.0F);
    }
    paramFloat3 = -paramFloat2;
    float f = -paramFloat1 / 2.0F + paramFloat2;
    paramFloat1 = paramFloat1 / 2.0F - paramFloat2;
    paramCanvas.drawRect(paramFloat3, f, 0.0F, paramFloat1, paramPaint);
    paramCanvas.save();
    paramCanvas.translate(0.0F, f);
    paramCanvas.drawArc(paramRectF, 180.0F, 90.0F, true, paramPaint);
    paramCanvas.restore();
    paramCanvas.translate(0.0F, paramFloat1);
    paramCanvas.drawArc(paramRectF, 180.0F, -90.0F, true, paramPaint);
    paramCanvas.restore();
  }
  
  public int a()
  {
    return -1;
  }
  
  public void a(@NonNull Canvas paramCanvas, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    Rect localRect = paramCanvas.getClipBounds();
    this.jdField_a_of_type_Float = localRect.width();
    float f1 = ((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int;
    paramCanvas.translate(localRect.width() / 2.0F, localRect.height() / 2.0F + Math.max(0.0F, (localRect.height() - ((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int) / 2.0F));
    if (((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Boolean) {
      paramCanvas.scale(-1.0F, 1.0F);
    }
    if (((this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.c()) && (((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).d == 1)) || ((this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.b()) && (((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).e == 2))) {
      paramCanvas.scale(1.0F, -1.0F);
    }
    if ((this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.c()) || (this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.b())) {
      paramCanvas.translate(0.0F, ((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int * (paramFloat - 1.0F) / 2.0F);
    }
    float f2 = this.jdField_a_of_type_Float;
    paramCanvas.clipRect(-f2 / 2.0F, -f1 / 2.0F, f2 / 2.0F, f1 / 2.0F);
    this.b = (((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int * paramFloat);
    this.c = (((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).b * paramFloat);
  }
  
  void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint)
  {
    int i = MaterialColors.b(((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).c, this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorDrawableWithAnimatedVisibilityChange.getAlpha());
    float f1 = -this.jdField_a_of_type_Float / 2.0F + this.c;
    float f2 = -f1;
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(i);
    float f3 = this.b;
    paramCanvas.drawRect(f1, -f3 / 2.0F, f2, f3 / 2.0F, paramPaint);
    f3 = this.c;
    RectF localRectF = new RectF(-f3, -f3, f3, f3);
    a(paramCanvas, paramPaint, this.b, this.c, f1, true, localRectF);
    a(paramCanvas, paramPaint, this.b, this.c, f2, false, localRectF);
  }
  
  public void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint, @FloatRange(from=0.0D, to=1.0D) float paramFloat1, @FloatRange(from=0.0D, to=1.0D) float paramFloat2, @ColorInt int paramInt)
  {
    if (paramFloat1 == paramFloat2) {
      return;
    }
    float f1 = this.jdField_a_of_type_Float;
    float f3 = -f1 / 2.0F;
    float f2 = this.c;
    paramFloat1 = f3 + f2 + (f1 - f2 * 2.0F) * paramFloat1;
    paramFloat2 = -f1 / 2.0F + f2 + (f1 - f2 * 2.0F) * paramFloat2;
    paramPaint.setStyle(Paint.Style.FILL);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(paramInt);
    f1 = this.b;
    paramCanvas.drawRect(paramFloat1, -f1 / 2.0F, paramFloat2, f1 / 2.0F, paramPaint);
    f1 = this.c;
    RectF localRectF = new RectF(-f1, -f1, f1, f1);
    a(paramCanvas, paramPaint, this.b, this.c, paramFloat1, true, localRectF);
    a(paramCanvas, paramPaint, this.b, this.c, paramFloat2, false, localRectF);
  }
  
  public int b()
  {
    return ((LinearProgressIndicatorSpec)this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec).jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearDrawingDelegate
 * JD-Core Version:    0.7.0.1
 */
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
  private int c = 1;
  private float d;
  private float e;
  private float f;
  
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
    paramFloat3 = this.f;
    float f2 = paramFloat1 / 2.0F;
    float f3 = f1 * paramFloat2;
    paramCanvas.drawRect(paramFloat3 - f2 + paramFloat2, Math.min(0.0F, this.c * f3), this.f + f2 - paramFloat2, Math.max(0.0F, f3 * this.c), paramPaint);
    paramCanvas.translate(this.f - f2 + paramFloat2, 0.0F);
    paramCanvas.drawArc(paramRectF, 180.0F, -f1 * 90.0F * this.c, true, paramPaint);
    paramCanvas.translate(paramFloat1 - paramFloat2 * 2.0F, 0.0F);
    paramCanvas.drawArc(paramRectF, 0.0F, f1 * 90.0F * this.c, true, paramPaint);
    paramCanvas.restore();
  }
  
  private int c()
  {
    return ((CircularProgressIndicatorSpec)this.a).g + ((CircularProgressIndicatorSpec)this.a).h * 2;
  }
  
  public int a()
  {
    return c();
  }
  
  public void a(@NonNull Canvas paramCanvas, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    float f1 = ((CircularProgressIndicatorSpec)this.a).g / 2.0F + ((CircularProgressIndicatorSpec)this.a).h;
    paramCanvas.translate(f1, f1);
    paramCanvas.rotate(-90.0F);
    float f2 = -f1;
    paramCanvas.clipRect(f2, f2, f1, f1);
    int i;
    if (((CircularProgressIndicatorSpec)this.a).i == 0) {
      i = 1;
    } else {
      i = -1;
    }
    this.c = i;
    this.d = (((CircularProgressIndicatorSpec)this.a).a * paramFloat);
    this.e = (((CircularProgressIndicatorSpec)this.a).b * paramFloat);
    this.f = ((((CircularProgressIndicatorSpec)this.a).g - ((CircularProgressIndicatorSpec)this.a).a) / 2.0F);
    if (((this.b.d()) && (((CircularProgressIndicatorSpec)this.a).e == 2)) || ((this.b.c()) && (((CircularProgressIndicatorSpec)this.a).f == 1)))
    {
      this.f += (1.0F - paramFloat) * ((CircularProgressIndicatorSpec)this.a).a / 2.0F;
      return;
    }
    if (((this.b.d()) && (((CircularProgressIndicatorSpec)this.a).e == 1)) || ((this.b.c()) && (((CircularProgressIndicatorSpec)this.a).f == 2))) {
      this.f -= (1.0F - paramFloat) * ((CircularProgressIndicatorSpec)this.a).a / 2.0F;
    }
  }
  
  void a(@NonNull Canvas paramCanvas, @NonNull Paint paramPaint)
  {
    int i = MaterialColors.b(((CircularProgressIndicatorSpec)this.a).d, this.b.getAlpha());
    paramPaint.setStyle(Paint.Style.STROKE);
    paramPaint.setStrokeCap(Paint.Cap.BUTT);
    paramPaint.setAntiAlias(true);
    paramPaint.setColor(i);
    paramPaint.setStrokeWidth(this.d);
    float f1 = this.f;
    paramCanvas.drawArc(new RectF(-f1, -f1, f1, f1), 0.0F, 360.0F, false, paramPaint);
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
    paramPaint.setStrokeWidth(this.d);
    paramInt = this.c;
    float f1 = paramFloat1 * 360.0F * paramInt;
    if (paramFloat2 >= paramFloat1) {
      paramFloat1 = paramFloat2 - paramFloat1;
    } else {
      paramFloat1 = paramFloat2 + 1.0F - paramFloat1;
    }
    paramFloat1 = paramFloat1 * 360.0F * paramInt;
    paramFloat2 = this.f;
    paramCanvas.drawArc(new RectF(-paramFloat2, -paramFloat2, paramFloat2, paramFloat2), f1, paramFloat1, false, paramPaint);
    if ((this.e > 0.0F) && (Math.abs(paramFloat1) < 360.0F))
    {
      paramPaint.setStyle(Paint.Style.FILL);
      paramFloat2 = this.e;
      RectF localRectF = new RectF(-paramFloat2, -paramFloat2, paramFloat2, paramFloat2);
      a(paramCanvas, paramPaint, this.d, this.e, f1, true, localRectF);
      a(paramCanvas, paramPaint, this.d, this.e, f1 + paramFloat1, false, localRectF);
    }
  }
  
  public int b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularDrawingDelegate
 * JD-Core Version:    0.7.0.1
 */
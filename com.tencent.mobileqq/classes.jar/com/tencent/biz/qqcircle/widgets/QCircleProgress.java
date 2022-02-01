package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class QCircleProgress
  extends ImageView
{
  int a;
  float b;
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  int i;
  Paint j;
  float k;
  RectF l = new RectF();
  boolean m = true;
  boolean n = true;
  
  public QCircleProgress(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QCircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.b = getResources().getDisplayMetrics().density;
    this.c = getResources().getColor(2131166114);
    this.f = getResources().getColor(2131165990);
    this.e = 51;
    this.g = 255;
    this.d = getResources().getColor(2131166040);
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setStyle(Paint.Style.STROKE);
  }
  
  public float getProgress()
  {
    return this.k;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.h = getWidth();
    this.i = getHeight();
    this.j.setColor(this.c);
    if (this.m) {
      this.j.setAlpha(this.e * 255 / 100);
    }
    this.j.setShadowLayer(9.0F, 0.0F, 0.0F, this.d);
    RectF localRectF = this.l;
    int i1 = this.a;
    localRectF.set(i1, i1, this.h - i1, this.i - i1);
    paramCanvas.drawArc(this.l, -90.0F, 360.0F, false, this.j);
    this.j.setColor(this.f);
    if (this.n) {
      this.j.setAlpha(this.g * 255 / 100);
    }
    this.j.setShadowLayer(9.0F, 0.0F, 0.0F, this.d);
    localRectF = this.l;
    i1 = this.a;
    localRectF.set(i1, i1, this.h - i1, this.i - i1);
    localRectF = this.l;
    double d1 = this.k;
    Double.isNaN(d1);
    paramCanvas.drawArc(localRectF, -90.0F, (float)(d1 * 3.6D), false, this.j);
  }
  
  public void setBgAndProgressColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = paramInt2;
    this.e = paramInt1;
    this.f = paramInt4;
    this.g = paramInt3;
  }
  
  public void setBgAndProgressUseAlpha(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.m = paramBoolean1;
    this.n = paramBoolean2;
  }
  
  public void setProgress(float paramFloat)
  {
    if (paramFloat > 100.0F) {
      this.k = 100.0F;
    } else if (paramFloat < 0.0F) {
      this.k = 0.0F;
    } else {
      this.k = paramFloat;
    }
    invalidate();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    double d1 = paramFloat * this.b;
    Double.isNaN(d1);
    this.a = ((int)(d1 + 0.5D));
    this.j.setStrokeWidth(this.a);
  }
  
  public void setmShadowColor(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleProgress
 * JD-Core Version:    0.7.0.1
 */
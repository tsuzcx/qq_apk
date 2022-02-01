package com.tencent.av.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class QavPanelWave
{
  int a;
  float b;
  float c;
  float d;
  float e = 0.0F;
  final float f = 0.5F;
  final float g = 0.05F;
  Paint h;
  Path i;
  boolean j;
  PointF k;
  float l;
  
  public QavPanelWave(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, PointF paramPointF, boolean paramBoolean)
  {
    if (paramPaint == null) {
      return;
    }
    if (paramPointF == null) {
      return;
    }
    this.a = paramInt;
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
    this.h = paramPaint;
    this.k = paramPointF;
    this.j = paramBoolean;
    this.i = new Path();
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.l = paramFloat1;
    float f1 = this.e;
    getClass();
    if (f1 - paramFloat2 > 0.1F)
    {
      getClass();
      paramFloat1 = f1 - 0.1F;
    }
    else
    {
      getClass();
      paramFloat1 = paramFloat2;
      if (paramFloat2 - f1 > 0.1F)
      {
        getClass();
        paramFloat1 = f1 + 0.1F;
      }
    }
    getClass();
    this.e = Math.min(paramFloat1, 0.5F);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!a()) {
      return;
    }
    float f7 = this.c * 0.5F;
    float f4 = this.b;
    float f8 = f4 * 0.5F;
    if (!this.j)
    {
      m = this.a;
      f1 = new float[] { 1.0F, 0.714F, 0.429F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }[m];
    }
    else
    {
      f1 = (1.0F - this.a / 3.0F) * 1.5F - 0.5F;
    }
    float f3 = this.e;
    float f2;
    if (!this.j) {
      f2 = f7 - 4.0F;
    } else {
      f2 = f8 / 6.0F;
    }
    this.i.rewind();
    double d1 = f4;
    Double.isNaN(d1);
    int m = (int)(d1 * 0.01D);
    d1 = f2;
    Double.isNaN(d1);
    double d2 = f1 * f3;
    Double.isNaN(d2);
    f3 = (float)(0.8D * d1 * d2);
    Double.isNaN(d1);
    Double.isNaN(d2);
    float f9 = (float)(d1 * 1.0D * d2);
    d1 = this.d;
    Double.isNaN(d1);
    float f10 = (float)(d1 * 6.283185307179586D) / f4;
    float f11 = this.a + this.l;
    float f12;
    for (float f1 = 0.0F;; f1 += f12)
    {
      f12 = m;
      if (f1 >= f4 + f12) {
        break;
      }
      float f5;
      if (!this.j)
      {
        d1 = f3;
        d2 = Math.sin(f1 * f10 + f11);
        Double.isNaN(d1);
        f5 = (float)(d1 * d2);
      }
      else
      {
        d1 = f9;
        d2 = Math.sin(f1 * f10 + f11);
        Double.isNaN(d1);
        f5 = (float)(d1 * d2);
      }
      if (!this.j)
      {
        f5 += f7;
        if (f1 == 0.0F) {
          this.i.moveTo(f1, f5);
        } else {
          this.i.lineTo(f1, f5);
        }
      }
      else
      {
        float f6 = f1;
        d1 = f5 + f8 - f2;
        d2 = f6 / f4 * 2.0F;
        Double.isNaN(d2);
        d2 *= 3.141592653589793D;
        double d3 = Math.cos(d2);
        Double.isNaN(d1);
        double d4 = f8;
        Double.isNaN(d4);
        f5 = (float)(d3 * d1 + d4);
        d2 = Math.sin(d2);
        Double.isNaN(d1);
        d3 = f7;
        Double.isNaN(d3);
        float f13 = (float)(d1 * d2 + d3);
        if (f6 == 0.0F) {
          this.i.moveTo(f5, f13);
        } else {
          this.i.lineTo(f5, f13);
        }
      }
    }
    paramCanvas.drawPath(this.i, this.h);
  }
  
  boolean a()
  {
    if (this.b > 0.0F)
    {
      if (this.c <= 0.0F) {
        return false;
      }
      if (this.d <= 0.0F) {
        return false;
      }
      if (this.h == null) {
        return false;
      }
      if (this.i == null) {
        return false;
      }
      return this.k != null;
    }
    return false;
  }
  
  public void b()
  {
    this.l = 0.0F;
    this.e = 0.0F;
  }
  
  public Paint c()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelWave
 * JD-Core Version:    0.7.0.1
 */
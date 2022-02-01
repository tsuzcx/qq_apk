package com.tencent.av.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;

public class QavPanelWave
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  PointF jdField_a_of_type_AndroidGraphicsPointF;
  boolean jdField_a_of_type_Boolean;
  float b;
  float c;
  float d = 0.0F;
  final float e = 0.5F;
  final float f = 0.05F;
  float g;
  
  public QavPanelWave(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, Paint paramPaint, PointF paramPointF, boolean paramBoolean)
  {
    if (paramPaint == null) {
      return;
    }
    if (paramPointF == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
    this.jdField_a_of_type_AndroidGraphicsPaint = paramPaint;
    this.jdField_a_of_type_AndroidGraphicsPointF = paramPointF;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public Paint a()
  {
    return this.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public void a()
  {
    this.g = 0.0F;
    this.d = 0.0F;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.g = paramFloat1;
    float f1 = this.d;
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
    this.d = Math.min(paramFloat1, 0.5F);
  }
  
  public void a(Canvas paramCanvas)
  {
    if (!a()) {
      return;
    }
    float f7 = this.b * 0.5F;
    float f4 = this.jdField_a_of_type_Float;
    float f8 = f4 * 0.5F;
    if (!this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_a_of_type_Int;
      f1 = new float[] { 1.0F, 0.714F, 0.429F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F }[i];
    }
    else
    {
      f1 = (1.0F - this.jdField_a_of_type_Int / 3.0F) * 1.5F - 0.5F;
    }
    float f3 = this.d;
    float f2;
    if (!this.jdField_a_of_type_Boolean) {
      f2 = f7 - 4.0F;
    } else {
      f2 = f8 / 6.0F;
    }
    this.jdField_a_of_type_AndroidGraphicsPath.rewind();
    double d1 = f4;
    Double.isNaN(d1);
    int i = (int)(d1 * 0.01D);
    d1 = f2;
    Double.isNaN(d1);
    double d2 = f1 * f3;
    Double.isNaN(d2);
    f3 = (float)(0.8D * d1 * d2);
    Double.isNaN(d1);
    Double.isNaN(d2);
    float f9 = (float)(d1 * 1.0D * d2);
    d1 = this.c;
    Double.isNaN(d1);
    float f10 = (float)(d1 * 6.283185307179586D) / f4;
    float f11 = this.jdField_a_of_type_Int + this.g;
    float f12;
    for (float f1 = 0.0F;; f1 += f12)
    {
      f12 = i;
      if (f1 >= f4 + f12) {
        break;
      }
      float f5;
      if (!this.jdField_a_of_type_Boolean)
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
      if (!this.jdField_a_of_type_Boolean)
      {
        f5 += f7;
        if (f1 == 0.0F) {
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f5);
        } else {
          this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f1, f5);
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
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f5, f13);
        } else {
          this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f5, f13);
        }
      }
    }
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  boolean a()
  {
    if (this.jdField_a_of_type_Float > 0.0F)
    {
      if (this.b <= 0.0F) {
        return false;
      }
      if (this.c <= 0.0F) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null) {
        return false;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        return false;
      }
      return this.jdField_a_of_type_AndroidGraphicsPointF != null;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelWave
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqstory.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public class RingView$DrawInfo
{
  public float a;
  public int a;
  public final Paint a;
  public final RectF a;
  public boolean a;
  public float b;
  public int b;
  public boolean b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public RingView$DrawInfo(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, int paramInt4, float paramFloat2, int paramInt5, int paramInt6, Paint.Style paramStyle)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Int = paramInt4;
    this.jdField_b_of_type_Float = paramFloat2;
    this.e = paramInt5;
    this.f = paramInt6;
    b();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(paramStyle);
  }
  
  private void b()
  {
    float f1;
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Int <= 0)
    {
      f1 = this.jdField_a_of_type_Float;
      if ((f1 <= 0.0F) || (f1 > 1.0F))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("radius/radiusRatio = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("/");
        localStringBuilder.append(this.jdField_a_of_type_Float);
        localStringBuilder.append(" is invalid !");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    if (this.jdField_b_of_type_Int <= 0)
    {
      f1 = this.jdField_b_of_type_Float;
      if ((f1 > 0.0F) && (f1 <= 1.0F)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mThickness/mThicknessRatio = ");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("/");
      localStringBuilder.append(this.jdField_b_of_type_Float);
      localStringBuilder.append(" is invalid !");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat;
    if (this.jdField_a_of_type_Int <= 0)
    {
      paramFloat = this.jdField_a_of_type_Float;
      if ((paramFloat <= 0.0F) || (paramFloat > 1.0F))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("radius/radiusRatio = ");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("/");
        localStringBuilder.append(this.jdField_a_of_type_Float);
        localStringBuilder.append(" is invalid !");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      boolean bool;
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getStyle() != Paint.Style.STROKE) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, bool, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
      RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      int j = this.c;
      paramCanvas.drawArc(localRectF, j, this.d - j, bool, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.g == paramInt1) && (this.h == paramInt2) && (this.i == paramInt3)) {
      return false;
    }
    this.g = paramInt1;
    this.h = paramInt2;
    this.i = paramInt3;
    int j = this.jdField_a_of_type_Int;
    if (j <= 0) {
      j = (int)(this.jdField_a_of_type_Float * paramInt3);
    }
    int k = this.jdField_b_of_type_Int;
    if (k > 0) {
      paramInt3 = k;
    } else {
      paramInt3 = (int)(this.jdField_b_of_type_Float * paramInt3);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(paramInt3);
    paramInt3 = j - paramInt3 / 2;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    localRectF.left = (paramInt1 - paramInt3);
    localRectF.right = (paramInt1 + paramInt3);
    localRectF.top = (paramInt2 - paramInt3);
    localRectF.bottom = (paramInt2 + paramInt3);
    this.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void b(int paramInt, float paramFloat)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_Float = paramFloat;
    if (this.jdField_b_of_type_Int <= 0)
    {
      paramFloat = this.jdField_b_of_type_Float;
      if ((paramFloat <= 0.0F) || (paramFloat > 1.0F))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mThickness/mThicknessRatio = ");
        localStringBuilder.append(this.jdField_b_of_type_Int);
        localStringBuilder.append("/");
        localStringBuilder.append(this.jdField_b_of_type_Float);
        localStringBuilder.append(" is invalid !");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean equals(Object paramObject)
  {
    return this == paramObject;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DrawInfo{mAngleStart=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mAngleEnd=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mRadius=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mRadiusRatio=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", mThickness=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mThicknessRatio=");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append(", mForeground=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mBackground=");
    localStringBuilder.append(this.f);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.RingView.DrawInfo
 * JD-Core Version:    0.7.0.1
 */
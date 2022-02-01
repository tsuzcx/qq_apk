package com.tencent.biz.qqstory.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public class RingView$DrawInfo
{
  public boolean a = true;
  public int b;
  public float c;
  public int d;
  public float e;
  public int f;
  public int g;
  public int h;
  public int i;
  public boolean j = false;
  public final Paint k = new Paint();
  public final RectF l = new RectF();
  public int m;
  public int n;
  public int o;
  
  public RingView$DrawInfo(int paramInt1, int paramInt2, int paramInt3, float paramFloat1, int paramInt4, float paramFloat2, int paramInt5, int paramInt6, Paint.Style paramStyle)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.b = paramInt3;
    this.c = paramFloat1;
    this.d = paramInt4;
    this.e = paramFloat2;
    this.h = paramInt5;
    this.i = paramInt6;
    b();
    this.k.setAntiAlias(true);
    this.k.setStyle(paramStyle);
  }
  
  private void b()
  {
    float f1;
    StringBuilder localStringBuilder;
    if (this.b <= 0)
    {
      f1 = this.c;
      if ((f1 <= 0.0F) || (f1 > 1.0F))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("radius/radiusRatio = ");
        localStringBuilder.append(this.b);
        localStringBuilder.append("/");
        localStringBuilder.append(this.c);
        localStringBuilder.append(" is invalid !");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    if (this.d <= 0)
    {
      f1 = this.e;
      if ((f1 > 0.0F) && (f1 <= 1.0F)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("mThickness/mThicknessRatio = ");
      localStringBuilder.append(this.d);
      localStringBuilder.append("/");
      localStringBuilder.append(this.e);
      localStringBuilder.append(" is invalid !");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
  }
  
  public void a()
  {
    this.j = true;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.b = paramInt;
    this.c = paramFloat;
    if (this.b <= 0)
    {
      paramFloat = this.c;
      if ((paramFloat <= 0.0F) || (paramFloat > 1.0F))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("radius/radiusRatio = ");
        localStringBuilder.append(this.b);
        localStringBuilder.append("/");
        localStringBuilder.append(this.c);
        localStringBuilder.append(" is invalid !");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    this.a = true;
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (!this.j)
    {
      boolean bool;
      if (this.k.getStyle() != Paint.Style.STROKE) {
        bool = true;
      } else {
        bool = false;
      }
      this.k.setColor(this.i);
      paramCanvas.drawArc(this.l, 0.0F, 360.0F, bool, this.k);
      this.k.setColor(this.h);
      RectF localRectF = this.l;
      int i1 = this.f;
      paramCanvas.drawArc(localRectF, i1, this.g - i1, bool, this.k);
    }
  }
  
  protected boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((!this.a) && (this.m == paramInt1) && (this.n == paramInt2) && (this.o == paramInt3)) {
      return false;
    }
    this.m = paramInt1;
    this.n = paramInt2;
    this.o = paramInt3;
    int i1 = this.b;
    if (i1 <= 0) {
      i1 = (int)(this.c * paramInt3);
    }
    int i2 = this.d;
    if (i2 > 0) {
      paramInt3 = i2;
    } else {
      paramInt3 = (int)(this.e * paramInt3);
    }
    this.k.setStrokeWidth(paramInt3);
    paramInt3 = i1 - paramInt3 / 2;
    RectF localRectF = this.l;
    localRectF.left = (paramInt1 - paramInt3);
    localRectF.right = (paramInt1 + paramInt3);
    localRectF.top = (paramInt2 - paramInt3);
    localRectF.bottom = (paramInt2 + paramInt3);
    this.a = false;
    return true;
  }
  
  public void b(int paramInt, float paramFloat)
  {
    this.d = paramInt;
    this.e = paramFloat;
    if (this.d <= 0)
    {
      paramFloat = this.e;
      if ((paramFloat <= 0.0F) || (paramFloat > 1.0F))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mThickness/mThicknessRatio = ");
        localStringBuilder.append(this.d);
        localStringBuilder.append("/");
        localStringBuilder.append(this.e);
        localStringBuilder.append(" is invalid !");
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    this.a = true;
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
    localStringBuilder.append(this.f);
    localStringBuilder.append(", mAngleEnd=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mRadius=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mRadiusRatio=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", mThickness=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", mThicknessRatio=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mForeground=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mBackground=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.RingView.DrawInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class AnimationItem
{
  private Drawable a;
  private ItemStatus b;
  private Collision c;
  private Stretch d;
  private Rect e;
  private Rect f;
  private long g;
  private long h = 0L;
  private double i;
  private String j;
  private AnimationItem.ItemAnimationCallback k;
  
  public AnimationItem(Drawable paramDrawable, Point paramPoint, ItemStatus.Velocity paramVelocity, ItemStatus.Acceleration paramAcceleration, long paramLong, double paramDouble, boolean paramBoolean, String paramString, int paramInt)
  {
    this.a = paramDrawable;
    this.j = paramString;
    this.i = paramDouble;
    this.g = paramLong;
    paramDouble = this.a.getIntrinsicWidth();
    double d1 = this.i;
    Double.isNaN(paramDouble);
    double d2 = this.a.getIntrinsicHeight();
    double d3 = this.i;
    Double.isNaN(d2);
    this.b = new ItemStatus();
    this.b.a(paramPoint, paramDouble * d1, d2 * d3, paramInt);
    this.b.b.a(paramVelocity);
    this.b.c.a(paramAcceleration);
    if (paramBoolean) {
      this.b.d = 3;
    }
    this.c = new Collision(this.b);
    this.d = new Stretch(this.b, this.a, this.i);
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (paramDouble1 * 2.0D + paramDouble2 * paramDouble3) / 2.0D * paramDouble3;
  }
  
  private int a(long paramLong)
  {
    if (this.b.d == 2)
    {
      paramLong = paramLong - this.b.f - 2000L;
      if (paramLong > 0L)
      {
        if (paramLong > 700L)
        {
          this.b.d = 1;
          return 0;
        }
        return (int)(255L - paramLong * 255L / 700L);
      }
    }
    return 255;
  }
  
  private void b(long paramLong)
  {
    long l = this.h;
    if (l > 0L)
    {
      paramLong -= l;
      double d1 = 1.0D;
      double d2;
      if (paramLong > 500L)
      {
        this.b.d = 0;
        d2 = 1.0D;
      }
      else if (paramLong < 100L)
      {
        d2 = paramLong;
        Double.isNaN(d2);
        d1 = d2 * 1.0D / 100.0D;
        Double.isNaN(d2);
        d2 = 1.0D + d2 * 0.4D / 100.0D;
        d1 += 1.0D;
      }
      else
      {
        double d3;
        if (paramLong < 200L)
        {
          d2 = paramLong - 100L;
          Double.isNaN(d2);
          d1 = 2.0D + -0.4D * d2 / 100.0D;
          Double.isNaN(d2);
          d3 = d2 * -0.6D / 100.0D;
          d2 = 1.4D;
        }
        for (;;)
        {
          d2 = d3 + d2;
          break label321;
          if (paramLong < 300L)
          {
            d2 = paramLong - 200L;
            Double.isNaN(d2);
            d1 = -0.6D * d2 / 100.0D + 1.6D;
            Double.isNaN(d2);
            d3 = d2 * 0.5D / 100.0D;
            d2 = 0.8D;
          }
          else
          {
            if (paramLong >= 400L) {
              break;
            }
            d2 = paramLong - 300L;
            Double.isNaN(d2);
            d1 = 1.0D + 0.2D * d2 / 100.0D;
            Double.isNaN(d2);
            d3 = d2 * -0.3D / 100.0D;
            d2 = 1.3D;
          }
        }
        d1 = paramLong - 400L;
        Double.isNaN(d1);
        d1 = d1 * -0.2D / 100.0D;
        d2 = 1.0D;
        d1 += 1.2D;
      }
      label321:
      this.d.a(d1, d2);
      c();
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    float f1;
    if (this.b.e > 0.0D)
    {
      double d1 = this.b.a.left;
      double d2 = this.b.e;
      Double.isNaN(d1);
      double d3 = this.a.getIntrinsicHeight();
      Double.isNaN(d3);
      f1 = (float)((d1 - d2) * 360.0D / (d3 * 3.141592653589793D * this.i));
    }
    else
    {
      f1 = 0.0F;
    }
    paramCanvas.rotate(f1, this.b.a.centerX(), this.b.a.centerY());
  }
  
  private void c()
  {
    if (this.b.a.left < this.e.left) {
      this.b.a.offset(this.e.left - this.b.a.left, 0.0F);
    }
    if (this.b.a.right > this.e.right) {
      this.b.a.offset(this.e.right - this.b.a.right, 0.0F);
    }
    if (this.b.a.top < this.e.top) {
      this.b.a.offset(0.0F, this.e.top - this.b.a.top);
    }
    if (this.b.a.bottom > this.e.bottom) {
      this.b.a.offset(0.0F, this.e.bottom - this.b.a.bottom);
    }
  }
  
  private void c(long paramLong)
  {
    double d1 = paramLong - this.g;
    Double.isNaN(d1);
    double d3 = d1 / 1000.0D;
    d1 = a(this.b.b.a, this.b.c.a, d3);
    double d2 = a(this.b.b.b, this.b.c.b, d3);
    ItemStatus.Velocity localVelocity = this.b.b;
    localVelocity.a += this.b.c.a * d3;
    localVelocity = this.b.b;
    localVelocity.b += this.b.c.b * d3;
    d3 *= 0.0D;
    double d4 = this.b.b.a;
    double d5 = this.b.b.b;
    localVelocity = this.b.b;
    localVelocity.a += d4 * d3;
    localVelocity = this.b.b;
    localVelocity.b += d3 * d5;
    this.b.a.offset((float)d1, (float)d2);
  }
  
  public String a()
  {
    return this.j;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.e == null)
    {
      this.e = new Rect();
      this.e.set(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    }
    if (this.f == null) {
      this.f = new Rect();
    }
  }
  
  public void a(Canvas paramCanvas, long paramLong, Drawable paramDrawable)
  {
    a(paramCanvas);
    if (this.b.d == 3) {
      b(paramLong);
    } else {
      this.d.a(paramLong, this.g);
    }
    int m;
    if (this.b.d != 1)
    {
      c(paramLong);
      m = this.c.a(this.e, this.b.a);
      if (m != 0)
      {
        this.c.a(this.e, paramLong);
        m = this.d.a(m);
        if ((m != 0) && (this.b.d != 2) && (this.b.d != 3)) {
          this.d.a(m, paramLong);
        }
      }
    }
    if (this.b.d != 1)
    {
      m = paramCanvas.save();
      b(paramCanvas);
      int n = a(paramLong);
      this.b.a.round(this.f);
      paramDrawable.setAlpha(n);
      paramDrawable.setBounds(this.f);
      paramDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(m);
    }
    else
    {
      paramCanvas = this.k;
      if (paramCanvas != null) {
        paramCanvas.a(this);
      }
    }
    this.g = paramLong;
    if (this.h == 0L) {
      this.h = paramLong;
    }
  }
  
  public void a(AnimationItem.ItemAnimationCallback paramItemAnimationCallback)
  {
    this.k = paramItemAnimationCallback;
  }
  
  public long b()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.AnimationItem
 * JD-Core Version:    0.7.0.1
 */
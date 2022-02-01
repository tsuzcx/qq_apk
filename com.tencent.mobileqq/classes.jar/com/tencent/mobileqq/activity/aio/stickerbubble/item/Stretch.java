package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class Stretch
{
  private long a;
  private double b = 1.0D;
  private double c = 1.0D;
  private double d = 1.0D;
  private double e = 1.0D;
  private ItemStatus f;
  private Drawable g;
  private double h;
  
  public Stretch(ItemStatus paramItemStatus, Drawable paramDrawable, double paramDouble)
  {
    this.f = paramItemStatus;
    this.g = paramDrawable;
    this.h = paramDouble;
  }
  
  private void a()
  {
    this.b = 1.0D;
    this.c = 1.0D;
  }
  
  private double b(long paramLong1, long paramLong2)
  {
    if (Math.abs(this.e - this.c) < 0.01D) {
      return this.c;
    }
    paramLong1 -= paramLong2;
    double d1 = this.e;
    double d2 = this.c;
    double d3;
    if (d1 < d2)
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.e = (d1 + d3 / 1000.0D);
      this.e = Math.min(d2, this.e);
    }
    else
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.e = (d1 - d3 / 1000.0D);
      this.e = Math.max(d2, this.e);
    }
    return this.e;
  }
  
  private double c(long paramLong1, long paramLong2)
  {
    if (Math.abs(this.d - this.b) < 0.01D) {
      return this.b;
    }
    paramLong1 -= paramLong2;
    double d1 = this.d;
    double d2 = this.b;
    double d3;
    if (d1 < d2)
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.d = (d1 + d3 / 1000.0D);
      this.d = Math.min(d2, this.d);
    }
    else
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.d = (d1 - d3 / 1000.0D);
      this.d = Math.max(d2, this.d);
    }
    return this.d;
  }
  
  protected int a(int paramInt)
  {
    if (((paramInt & 0x1) > 0) && (Math.abs(this.f.b.a) > 100.0D)) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if ((paramInt & 0x2) > 0)
    {
      i = j;
      if (Math.abs(this.f.b.a) > 100.0D) {
        i = j | 0x2;
      }
    }
    int j = i;
    if ((paramInt & 0x4) > 0)
    {
      j = i;
      if (Math.abs(this.f.b.b) > 100.0D) {
        j = i | 0x4;
      }
    }
    i = j;
    if ((paramInt & 0x8) > 0)
    {
      i = j;
      if (Math.abs(this.f.b.b) > 100.0D) {
        i = j | 0x8;
      }
    }
    return i;
  }
  
  protected void a(double paramDouble1, double paramDouble2)
  {
    double d2 = this.f.a.centerX();
    double d1 = this.f.a.centerY();
    double d5 = this.g.getIntrinsicWidth();
    double d6 = this.h;
    Double.isNaN(d5);
    double d3 = this.g.getIntrinsicHeight();
    double d4 = this.h;
    Double.isNaN(d3);
    RectF localRectF = this.f.a;
    paramDouble1 = d5 * d6 * paramDouble1 / 2.0D;
    Double.isNaN(d2);
    localRectF.left = ((float)(d2 - paramDouble1));
    localRectF = this.f.a;
    Double.isNaN(d2);
    localRectF.right = ((float)(d2 + paramDouble1));
    localRectF = this.f.a;
    paramDouble1 = d3 * d4 * paramDouble2 / 2.0D;
    Double.isNaN(d1);
    localRectF.top = ((float)(d1 - paramDouble1));
    localRectF = this.f.a;
    Double.isNaN(d1);
    localRectF.bottom = ((float)(d1 + paramDouble1));
  }
  
  protected void a(int paramInt, long paramLong)
  {
    this.a = paramLong;
    this.b = 1.0D;
    this.c = 1.0D;
    if (((paramInt & 0x1) > 0) || ((paramInt & 0x2) > 0)) {
      this.b = Math.max(0.8D, 1.0D - Math.abs(this.f.b.a) * 0.0003D);
    }
    if (((paramInt & 0x4) > 0) || ((paramInt & 0x8) > 0)) {
      this.c = Math.max(0.8D, 1.0D - Math.abs(this.f.b.b) * 0.0003D);
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (paramLong1 - this.a > 170L) {
      a();
    }
    this.d = c(paramLong1, paramLong2);
    this.e = b(paramLong1, paramLong2);
    a(this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.Stretch
 * JD-Core Version:    0.7.0.1
 */
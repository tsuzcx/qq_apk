package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.Rect;
import android.graphics.RectF;

public class Collision
{
  private double a = -0.8D;
  private int b = 0;
  private int c = 0;
  private ItemStatus d;
  
  public Collision(ItemStatus paramItemStatus)
  {
    this.d = paramItemStatus;
  }
  
  private void a(int paramInt, Rect paramRect, RectF paramRectF)
  {
    double d3 = 0.0D;
    if ((paramInt & 0x1) > 0)
    {
      d1 = paramRectF.left - paramRect.left;
      Double.isNaN(d1);
      d1 *= -1.8D;
      this.d.b.a *= -0.8D;
    }
    else
    {
      d1 = 0.0D;
    }
    double d2 = d1;
    if ((paramInt & 0x2) > 0)
    {
      d1 = paramRectF.right - paramRect.right;
      Double.isNaN(d1);
      d2 = d1 * -1.8D;
      this.d.b.a *= -0.8D;
    }
    double d1 = d3;
    if ((paramInt & 0x4) > 0)
    {
      d1 = paramRectF.top - paramRect.top;
      Double.isNaN(d1);
      d1 *= -1.8D;
      this.d.b.b *= -0.8D;
    }
    if ((paramInt & 0x8) > 0)
    {
      d1 = paramRectF.bottom - paramRect.bottom;
      d3 = this.a;
      Double.isNaN(d1);
      d1 *= (d3 - 1.0D);
      this.d.b.b *= this.a;
    }
    this.d.a.offset((float)d2, (float)d1);
  }
  
  protected int a(Rect paramRect, RectF paramRectF)
  {
    if (paramRect.left > paramRectF.left) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramRect.right < paramRectF.right) {
      i = j ^ 0x2;
    }
    int j = i;
    if (paramRect.top > paramRectF.top) {
      j = i ^ 0x4;
    }
    i = j;
    if (paramRect.bottom < paramRectF.bottom) {
      i = j ^ 0x8;
    }
    return i;
  }
  
  protected void a(Rect paramRect, long paramLong)
  {
    int i = a(paramRect, this.d.a);
    if (i != 0)
    {
      Object localObject;
      if ((i & 0x8) > 0)
      {
        this.b += 1;
        localObject = this.d.b;
        ((ItemStatus.Velocity)localObject).a *= 0.95D;
        if ((this.d.d != 2) && (this.b >= 3))
        {
          localObject = this.d;
          ((ItemStatus)localObject).d = 2;
          ((ItemStatus)localObject).f = paramLong;
        }
      }
      this.c += 1;
      if (this.c == 3)
      {
        localObject = this.d;
        ((ItemStatus)localObject).e = ((ItemStatus)localObject).a.left;
        this.d.c.b = 2000.0D;
        this.a = -0.5D;
      }
      a(i, paramRect, this.d.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.Collision
 * JD-Core Version:    0.7.0.1
 */
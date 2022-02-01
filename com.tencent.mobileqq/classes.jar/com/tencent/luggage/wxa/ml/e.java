package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.ma.e.h;
import com.tencent.luggage.wxa.qz.o;

public class e
{
  public boolean a;
  protected int b;
  protected int c;
  protected int d;
  protected int e;
  protected int f;
  protected int g;
  private e.h h = e.h.a;
  
  private void a(float paramFloat1, float paramFloat2)
  {
    int i = this.b;
    int j = this.c;
    if (i < j)
    {
      this.g = ((int)(i / paramFloat1));
      this.f = i;
      if (this.g > j)
      {
        this.f = ((int)(j * paramFloat1));
        this.g = j;
      }
    }
    else
    {
      this.f = ((int)(j * paramFloat1));
      this.g = j;
      if (this.f > i)
      {
        this.g = ((int)(i / paramFloat1));
        this.f = i;
      }
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    int i = this.b;
    int j = this.c;
    if (i > j)
    {
      this.g = ((int)(i / paramFloat1));
      this.f = i;
      if (this.g < j)
      {
        this.f = ((int)(j * paramFloat1));
        this.g = j;
      }
    }
    else
    {
      this.f = ((int)(j * paramFloat1));
      this.g = j;
      if (this.f < i)
      {
        this.g = ((int)(i / paramFloat1));
        this.f = i;
      }
    }
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    this.g = this.c;
    this.f = this.b;
  }
  
  private void d(float paramFloat1, float paramFloat2)
  {
    if (!this.a)
    {
      i = this.b;
      j = this.c;
      if (i < j)
      {
        this.g = ((int)(i / paramFloat1));
        this.f = i;
        return;
      }
      this.f = ((int)(j * paramFloat1));
      this.g = j;
      return;
    }
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      i = this.b;
      j = this.c;
      if (i < j)
      {
        this.g = ((int)(i / paramFloat1));
        this.f = i;
        return;
      }
      this.f = ((int)(j * paramFloat1));
      this.g = j;
      return;
    }
    int i = this.b;
    int j = this.c;
    if (i > j)
    {
      this.g = ((int)(i / paramFloat1));
      this.f = i;
      return;
    }
    this.f = ((int)(j * paramFloat1));
    this.g = j;
  }
  
  public void a()
  {
    this.c = 0;
    this.b = 0;
    this.e = 0;
    this.d = 0;
    this.g = 0;
    this.f = 0;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.b == paramInt1) && (this.c == paramInt2) && (this.d == paramInt3) && (this.e == paramInt4)) {
      return true;
    }
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    float f1 = this.d * 1.0F / this.e;
    float f2 = this.b * 1.0F / this.c;
    if (this.h == e.h.a) {
      d(f1, f2);
    } else if (this.h == e.h.c) {
      a(f1, f2);
    } else if (this.h == e.h.b) {
      c(f1, f2);
    } else if (this.h == e.h.d) {
      b(f1, f2);
    } else {
      d(f1, f2);
    }
    o.e("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", new Object[] { Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Float.valueOf(f2), Float.valueOf(f1) });
    return false;
  }
  
  public boolean a(e.h paramh)
  {
    int i;
    if (this.h == paramh) {
      i = 1;
    } else {
      i = 0;
    }
    o.d("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", new Object[] { this.h, paramh });
    this.h = paramh;
    a();
    return i ^ 0x1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.e
 * JD-Core Version:    0.7.0.1
 */
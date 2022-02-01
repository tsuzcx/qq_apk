package com.tencent.luggage.wxa.nf;

import com.tencent.luggage.wxa.ge.f;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

public class g
  implements f
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private String g;
  private float h;
  private float i;
  
  private void a(float paramFloat1, float paramFloat2)
  {
    int j = this.a;
    int k = this.b;
    if (j < k)
    {
      this.f = ((int)(j / paramFloat1));
      this.e = j;
      if (this.f > k)
      {
        this.e = ((int)(k * paramFloat1));
        this.f = k;
      }
    }
    else
    {
      this.e = ((int)(k * paramFloat1));
      this.f = k;
      if (this.e > j)
      {
        this.f = ((int)(j / paramFloat1));
        this.e = j;
      }
    }
  }
  
  private void b(float paramFloat1, float paramFloat2)
  {
    int j = this.a;
    int k = this.b;
    if (j > k)
    {
      this.f = ((int)(j / paramFloat1));
      this.e = j;
      if (this.f < k)
      {
        this.e = ((int)(k * paramFloat1));
        this.f = k;
      }
    }
    else
    {
      this.e = ((int)(k * paramFloat1));
      this.f = k;
      if (this.e < j)
      {
        this.f = ((int)(j / paramFloat1));
        this.e = j;
      }
    }
  }
  
  private void c(float paramFloat1, float paramFloat2)
  {
    this.f = this.b;
    this.e = this.a;
  }
  
  private void d(float paramFloat1, float paramFloat2)
  {
    if (Math.abs(paramFloat1 - paramFloat2) > 0.05D)
    {
      j = this.a;
      k = this.b;
      if (j < k)
      {
        this.f = ((int)(j / paramFloat1));
        this.e = j;
        return;
      }
      this.e = ((int)(k * paramFloat1));
      this.f = k;
      return;
    }
    int j = this.a;
    int k = this.b;
    if (j > k)
    {
      this.f = ((int)(j / paramFloat1));
      this.e = j;
      return;
    }
    this.e = ((int)(k * paramFloat1));
    this.f = k;
  }
  
  public float a()
  {
    return this.h;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (af.c(paramString))
    {
      o.c("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, scale type is null");
      return false;
    }
    if ((paramInt1 != 0) && (paramInt2 != 0) && (paramInt3 != 0) && (paramInt4 != 0))
    {
      if ((paramString.equalsIgnoreCase(this.g)) && (this.a == paramInt1) && (this.b == paramInt2) && (this.c == paramInt3) && (this.d == paramInt4))
      {
        o.c("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, same as last calculated");
        return true;
      }
      this.g = paramString;
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      float f1 = this.c * 1.0F / this.d;
      float f2 = this.a * 1.0F / this.b;
      if (this.g.equalsIgnoreCase("contain")) {
        a(f1, f2);
      } else if (this.g.equalsIgnoreCase("fill")) {
        c(f1, f2);
      } else if (this.g.equalsIgnoreCase("cover")) {
        b(f1, f2);
      } else {
        d(f1, f2);
      }
      f1 = this.e;
      paramInt1 = this.a;
      this.h = (f1 * 1.0F / paramInt1);
      this.i = (this.f * 1.0F / this.b);
      o.e("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, screen[%d, %d], video[%d, %d], measure[%d, %d], scale[%f, %f]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Float.valueOf(this.h), Float.valueOf(this.i) });
      return true;
    }
    o.c("MicroMsg.SameLayer.AppBrandVideoScaleHandler", "calculateScale, width or height is 0");
    return false;
  }
  
  public float b()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.g
 * JD-Core Version:    0.7.0.1
 */
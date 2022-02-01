package com.tencent.luggage.wxa.gs;

public class i
  extends f
{
  private float i = 1.0F;
  private boolean j = true;
  
  private int a(int paramInt, boolean paramBoolean)
  {
    float f1 = this.i;
    float f2 = paramInt;
    int k = (int)(f1 * f2);
    if (k > this.f)
    {
      this.i = (this.f / f2);
      f1 = this.i;
      if (f1 < 1.0F) {
        this.i = (f1 - (1.0F - f1) / 16.0F);
      }
      return a(k, false);
    }
    if (k < this.g)
    {
      this.i = (this.g / f2);
      f1 = this.i;
      if (f1 < 1.0F) {
        this.i = (f1 - (1.0F - f1) / 16.0F);
      }
      return a(k, false);
    }
    if ((paramBoolean) && (paramInt < this.f) && (paramInt > this.g))
    {
      f1 = this.i;
      if (f1 < 1.0F) {
        this.i = (f1 + (1.0F - f1) / 16.0F);
      } else {
        this.i = 1.0F;
      }
      this.j = false;
    }
    return k;
  }
  
  protected byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.j = true;
    int k = 0;
    while (k < paramInt2)
    {
      int m = 0;
      int n = 0;
      while (m < paramInt1)
      {
        n += this.a[m][k];
        m += 1;
      }
      m = a(n, this.j);
      if (k == paramInt2 / 2) {
        this.j = true;
      }
      this.d[k] = a(m);
      k += 1;
    }
    return a(paramInt3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.i
 * JD-Core Version:    0.7.0.1
 */
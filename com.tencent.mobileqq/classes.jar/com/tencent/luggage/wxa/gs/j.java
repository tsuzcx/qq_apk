package com.tencent.luggage.wxa.gs;

public class j
  extends f
{
  private float i = 128.0F;
  private float j = 128.0F;
  private float k = 128.0F;
  private int l = 44100;
  private int m;
  private float n;
  private float o;
  
  public j()
  {
    int i1 = this.l;
    this.m = ((int)(i1 * 0.02F * 2.0F * 16.0F / 8.0F));
    this.n = (i1 / this.m);
    this.o = 1.0F;
  }
  
  protected byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = 0;
    while (i2 < paramInt2)
    {
      int i3 = 0;
      int i1 = 0;
      while (i3 < paramInt1)
      {
        i1 += this.a[i3][i2];
        if (i1 > this.f) {
          this.i *= 32768.0F / i1;
        } else if (i1 < this.g) {
          this.i *= 32768.0F / i1;
        }
        i3 += 1;
      }
      float f1 = this.i;
      float f2 = this.j;
      if (f1 >= f2)
      {
        float f3 = this.n;
        float f4 = this.o;
        this.i = (((f2 + 1.0F) * f3 + f1 * f4) / (f3 + f4));
      }
      else
      {
        this.i = ((f2 + f1) / 2.0F);
      }
      f1 = this.i;
      this.j = f1;
      i3 = i1;
      if ((int)(f1 * 128.0F) >> 7 != 128)
      {
        double d1 = this.k * f1 / 128.0F;
        double d2 = i1;
        Double.isNaN(d2);
        Double.isNaN(d1);
        i3 = (int)(d2 * d1) / 128;
      }
      this.d[i2] = a(i3);
      i2 += 1;
    }
    return a(paramInt3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.j
 * JD-Core Version:    0.7.0.1
 */
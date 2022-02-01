package com.tencent.luggage.wxa.gs;

public class a
  extends f
{
  protected byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    while (j < paramInt2)
    {
      int k = 0;
      float f1 = 0.0F;
      float f2 = 0.0F;
      while (k < paramInt1)
      {
        double d1 = f2;
        double d2 = Math.pow(this.a[k][j], 2.0D);
        double d3 = Math.signum(this.a[k][j]);
        Double.isNaN(d3);
        Double.isNaN(d1);
        f2 = (float)(d1 + d2 * d3);
        f1 += Math.abs(this.a[k][j]);
        k += 1;
      }
      if (f1 == 0.0F) {
        k = 0;
      } else {
        k = (int)(f2 / f1);
      }
      short[] arrayOfShort = this.d;
      int i;
      if (f1 == 0.0F) {
        i = 0;
      } else {
        i = a(k);
      }
      arrayOfShort[j] = i;
      j += 1;
    }
    return a(paramInt3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.gs;

public class b
  extends f
{
  private int b(int paramInt1, int paramInt2)
  {
    double d1 = paramInt1 + paramInt2;
    double d2 = Math.sqrt(2.0D);
    Double.isNaN(d1);
    return (int)(d1 / d2);
  }
  
  protected byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    while (j < paramInt2)
    {
      int k = 0;
      int i = 1;
      while (k < paramInt1)
      {
        if (k == 0) {
          i = this.a[k][j];
        } else {
          i = b(i, this.a[k][j]);
        }
        k += 1;
      }
      this.d[j] = a(i);
      j += 1;
    }
    return a(paramInt3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.b
 * JD-Core Version:    0.7.0.1
 */
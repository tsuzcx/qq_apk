package com.tencent.luggage.wxa.gs;

public class m
  extends f
{
  protected byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      int k = 0;
      while (j < paramInt1)
      {
        k += this.a[j][i];
        j += 1;
      }
      this.d[i] = ((short)(k / paramInt1));
      i += 1;
    }
    return a(paramInt3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.m
 * JD-Core Version:    0.7.0.1
 */
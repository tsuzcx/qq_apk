package com.tencent.luggage.wxa.gs;

public class l
  extends f
{
  private float a(float paramFloat1, float paramFloat2)
  {
    float f;
    int i;
    if ((paramFloat1 < 0.0F) && (paramFloat2 < 0.0F))
    {
      f = paramFloat1 + paramFloat2;
      paramFloat2 = paramFloat1 * paramFloat2;
      i = this.g;
    }
    for (paramFloat1 = f;; paramFloat1 = f)
    {
      return paramFloat1 - paramFloat2 / i;
      if ((paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F)) {
        break;
      }
      f = paramFloat1 + paramFloat2;
      paramFloat2 = paramFloat1 * paramFloat2;
      i = this.f;
    }
    return paramFloat1 + paramFloat2;
  }
  
  protected byte[] a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt2)
    {
      int j = 0;
      float f = 1.0F;
      while (j < paramInt1)
      {
        if (j == 0) {
          f = this.a[j][i];
        } else {
          f = a(f, this.a[j][i]);
        }
        j += 1;
      }
      j = (int)f;
      this.d[i] = a(j);
      i += 1;
    }
    return a(paramInt3, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.tf;

public class a
{
  short[] a;
  int b;
  
  public a(int paramInt)
  {
    this.b = paramInt;
    this.a = new short[1 << paramInt];
  }
  
  public static int a(short[] paramArrayOfShort, int paramInt1, b paramb, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int k = 1;
    while (i < paramInt2)
    {
      int m = paramb.a(paramArrayOfShort, paramInt1 + k);
      k = (k << 1) + m;
      j |= m << i;
      i += 1;
    }
    return j;
  }
  
  public int a(b paramb)
  {
    int i = this.b;
    int j = 1;
    while (i != 0)
    {
      j = paramb.a(this.a, j) + (j << 1);
      i -= 1;
    }
    return j - (1 << this.b);
  }
  
  public void a()
  {
    b.a(this.a);
  }
  
  public int b(b paramb)
  {
    int i = 0;
    int j = 0;
    int k = 1;
    while (i < this.b)
    {
      int m = paramb.a(this.a, k);
      k = (k << 1) + m;
      j |= m << i;
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.tf.a
 * JD-Core Version:    0.7.0.1
 */
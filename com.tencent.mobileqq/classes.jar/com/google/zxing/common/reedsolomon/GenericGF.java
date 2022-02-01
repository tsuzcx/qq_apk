package com.google.zxing.common.reedsolomon;

public final class GenericGF
{
  public static final GenericGF a = new GenericGF(285, 256);
  private int[] b;
  private int[] c;
  private GenericGFPoly d;
  private GenericGFPoly e;
  private final int f;
  private final int g;
  private boolean h = false;
  
  public GenericGF(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.f = paramInt2;
    if (paramInt2 <= 0) {
      b();
    }
  }
  
  static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }
  
  private void b()
  {
    int i = this.f;
    this.b = new int[i];
    this.c = new int[i];
    int j = 0;
    i = 1;
    for (;;)
    {
      int m = this.f;
      if (j >= m) {
        break;
      }
      this.b[j] = i;
      int k = i << 1;
      i = k;
      if (k >= m) {
        i = (k ^ this.g) & m - 1;
      }
      j += 1;
    }
    i = 0;
    while (i < this.f - 1)
    {
      this.c[this.b[i]] = i;
      i += 1;
    }
    this.d = new GenericGFPoly(this, new int[] { 0 });
    this.e = new GenericGFPoly(this, new int[] { 1 });
    this.h = true;
  }
  
  private void c()
  {
    if (!this.h) {
      b();
    }
  }
  
  int a(int paramInt)
  {
    c();
    return this.b[paramInt];
  }
  
  GenericGFPoly a()
  {
    c();
    return this.d;
  }
  
  GenericGFPoly a(int paramInt1, int paramInt2)
  {
    c();
    if (paramInt1 >= 0)
    {
      if (paramInt2 == 0) {
        return this.d;
      }
      int[] arrayOfInt = new int[paramInt1 + 1];
      arrayOfInt[0] = paramInt2;
      return new GenericGFPoly(this, arrayOfInt);
    }
    throw new IllegalArgumentException();
  }
  
  int b(int paramInt)
  {
    c();
    if (paramInt != 0) {
      return this.c[paramInt];
    }
    throw new IllegalArgumentException();
  }
  
  int c(int paramInt)
  {
    c();
    if (paramInt != 0) {
      return this.b[(this.f - this.c[paramInt] - 1)];
    }
    throw new ArithmeticException();
  }
  
  int c(int paramInt1, int paramInt2)
  {
    c();
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int[] arrayOfInt1 = this.b;
      int[] arrayOfInt2 = this.c;
      return arrayOfInt1[((arrayOfInt2[paramInt1] + arrayOfInt2[paramInt2]) % (this.f - 1))];
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGF
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.te;

class b$b
{
  b.b.a[] a;
  int b;
  int c;
  int d;
  
  b$b(b paramb) {}
  
  b.b.a a(int paramInt, byte paramByte)
  {
    b.b.a[] arrayOfa = this.a;
    int i = this.d;
    int j = this.b;
    return arrayOfa[(((paramInt & i) << j) + ((paramByte & 0xFF) >>> 8 - j))];
  }
  
  public void a()
  {
    int j = this.b;
    int k = this.c;
    int i = 0;
    while (i < 1 << j + k)
    {
      this.a[i].a();
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.a != null) && (this.b == paramInt2) && (this.c == paramInt1)) {
      return;
    }
    this.c = paramInt1;
    this.d = ((1 << paramInt1) - 1);
    this.b = paramInt2;
    paramInt2 = 1 << this.b + this.c;
    this.a = new b.b.a[paramInt2];
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      this.a[paramInt1] = new b.b.a(this);
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.te.b.b
 * JD-Core Version:    0.7.0.1
 */
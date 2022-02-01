package com.tencent.luggage.wxa.te;

import com.tencent.luggage.wxa.tf.a;

class b$a
{
  short[] a = new short[2];
  a[] b = new a[16];
  a[] c = new a[16];
  a d = new a(8);
  int e = 0;
  
  b$a(b paramb) {}
  
  public int a(com.tencent.luggage.wxa.tf.b paramb, int paramInt)
  {
    if (paramb.a(this.a, 0) == 0) {
      return this.b[paramInt].a(paramb);
    }
    if (paramb.a(this.a, 1) == 0) {
      paramInt = this.c[paramInt].a(paramb);
    } else {
      paramInt = this.d.a(paramb) + 8;
    }
    return paramInt + 8;
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.tf.b.a(this.a);
    int i = 0;
    while (i < this.e)
    {
      this.b[i].a();
      this.c[i].a();
      i += 1;
    }
    this.d.a();
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      int i = this.e;
      if (i >= paramInt) {
        break;
      }
      this.b[i] = new a(3);
      this.c[this.e] = new a(3);
      this.e += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.te.b.a
 * JD-Core Version:    0.7.0.1
 */
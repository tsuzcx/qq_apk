package com.tencent.luggage.wxa.y;

import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.v.a.a;
import com.tencent.luggage.wxa.v.b;
import java.nio.ByteBuffer;

public final class c
  implements b
{
  private final m a = new m();
  private final l b = new l();
  private u c;
  
  public com.tencent.luggage.wxa.v.a a(com.tencent.luggage.wxa.v.e parame)
  {
    if ((this.c == null) || (parame.d != this.c.c()))
    {
      this.c = new u(parame.c);
      this.c.c(parame.c - parame.d);
    }
    parame = parame.b;
    byte[] arrayOfByte = parame.array();
    int i = parame.limit();
    this.a.a(arrayOfByte, i);
    this.b.a(arrayOfByte, i);
    this.b.b(39);
    long l = this.b.c(1) << 32 | this.b.c(32);
    this.b.b(20);
    i = this.b.c(12);
    int j = this.b.c(8);
    parame = null;
    this.a.d(14);
    if (j != 0)
    {
      if (j != 255)
      {
        if (j != 4)
        {
          if (j != 5)
          {
            if (j == 6) {
              parame = g.a(this.a, l, this.c);
            }
          }
          else {
            parame = d.a(this.a, l, this.c);
          }
        }
        else {
          parame = f.a(this.a);
        }
      }
      else {
        parame = a.a(this.a, i, l);
      }
    }
    else {
      parame = new e();
    }
    if (parame == null) {
      return new com.tencent.luggage.wxa.v.a(new a.a[0]);
    }
    return new com.tencent.luggage.wxa.v.a(new a.a[] { parame });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.y.c
 * JD-Core Version:    0.7.0.1
 */
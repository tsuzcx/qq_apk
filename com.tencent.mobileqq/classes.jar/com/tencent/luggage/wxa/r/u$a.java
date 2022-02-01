package com.tencent.luggage.wxa.r;

import android.util.SparseArray;
import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.l.f;

class u$a
  implements q
{
  private final l b = new l(new byte[4]);
  
  public u$a(u paramu) {}
  
  public void a(m paramm)
  {
    if (paramm.g() != 0) {
      return;
    }
    paramm.d(7);
    int j = paramm.b() / 4;
    int i = 0;
    while (i < j)
    {
      paramm.a(this.b, 4);
      int k = this.b.c(16);
      this.b.b(3);
      if (k == 0)
      {
        this.b.b(13);
      }
      else
      {
        k = this.b.c(13);
        u.a(this.a).put(k, new r(new u.b(this.a, k)));
        u.b(this.a);
      }
      i += 1;
    }
    if (u.c(this.a) != 2) {
      u.a(this.a).remove(0);
    }
  }
  
  public void a(com.tencent.luggage.wxa.ao.u paramu, f paramf, v.d paramd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.u.a
 * JD-Core Version:    0.7.0.1
 */
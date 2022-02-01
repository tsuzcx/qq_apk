package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.l.f;
import com.tencent.luggage.wxa.l.l;

public final class t
  implements q
{
  private u a;
  private l b;
  private boolean c;
  
  public void a(m paramm)
  {
    if (!this.c)
    {
      if (this.a.c() == -9223372036854775807L) {
        return;
      }
      this.b.a(k.a(null, "application/x-scte35", this.a.c()));
      this.c = true;
    }
    int i = paramm.b();
    this.b.a(paramm, i);
    this.b.a(this.a.b(), 1, i, 0, null);
  }
  
  public void a(u paramu, f paramf, v.d paramd)
  {
    this.a = paramu;
    paramd.a();
    this.b = paramf.a(paramd.b(), 4);
    this.b.a(k.a(paramd.c(), "application/x-scte35", null, -1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.t
 * JD-Core Version:    0.7.0.1
 */
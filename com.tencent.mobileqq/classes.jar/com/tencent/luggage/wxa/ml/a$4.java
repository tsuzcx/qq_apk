package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.b.f;
import com.tencent.luggage.wxa.qz.o;

class a$4
  implements b.f
{
  a$4(a parama) {}
  
  public void a(b paramb)
  {
    if ((paramb != this.a.a) && (paramb != null))
    {
      o.c("MicroMsg.Video.AbstractVideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramb, this.a.a });
      a.a(this.a, paramb);
      return;
    }
    a.a(this.a, true);
    a locala = this.a;
    int i;
    if (paramb != null) {
      i = paramb.i();
    } else {
      i = 0;
    }
    a.a(locala, i);
    locala = this.a;
    if (paramb != null) {
      i = paramb.j();
    } else {
      i = 0;
    }
    a.b(locala, i);
    o.d("MicroMsg.Video.AbstractVideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(a.a(this.a)), Integer.valueOf(a.b(this.a)), Boolean.valueOf(a.e(this.a)) });
    a.d(this.a);
    if ((a.a(this.a) != 0) && (a.b(this.a) != 0))
    {
      if (a.e(this.a))
      {
        this.a.a.l();
        this.a.a.b(a.f(this.a));
        a.b(this.a, false);
      }
    }
    else if (a.e(this.a))
    {
      this.a.a.l();
      a.b(this.a, false);
      this.a.a.b(a.f(this.a));
    }
    if (a.c(this.a) != null) {
      a.c(this.a).z();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.4
 * JD-Core Version:    0.7.0.1
 */
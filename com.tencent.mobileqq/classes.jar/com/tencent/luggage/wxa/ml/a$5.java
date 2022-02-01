package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.b.g;
import com.tencent.luggage.wxa.qz.o;

class a$5
  implements b.g
{
  a$5(a parama) {}
  
  public void a(b paramb)
  {
    int i;
    if (paramb != null) {
      i = paramb.h();
    } else {
      i = -1;
    }
    o.d("MicroMsg.Video.AbstractVideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(a.e(this.a)), Boolean.valueOf(a.g(this.a)) });
    if (a.e(this.a))
    {
      if (a.g(this.a)) {
        return;
      }
      this.a.f();
    }
    else
    {
      this.a.d();
    }
    if (a.h(this.a) != null) {
      a.h(this.a).b(a.e(this.a));
    }
    a.a(this.a, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.5
 * JD-Core Version:    0.7.0.1
 */
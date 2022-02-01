package com.tencent.luggage.wxa.ml;

import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.mi.b.h;
import com.tencent.luggage.wxa.qz.o;

class a$3
  implements b.h
{
  a$3(a parama) {}
  
  public void a(b paramb, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramb != this.a.a)
      {
        o.c("MicroMsg.Video.AbstractVideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramb, this.a.a });
        return;
      }
      a.a(this.a, paramb.i());
      a.b(this.a, paramb.j());
      paramb = new StringBuilder();
      paramb.append("on size change size:( ");
      paramb.append(a.a(this.a));
      paramb.append(" , ");
      paramb.append(a.b(this.a));
      paramb.append(" )");
      o.d("MicroMsg.Video.AbstractVideoTextureView", paramb.toString());
      if (a.c(this.a) != null) {
        a.c(this.a).c(a.a(this.a), a.b(this.a));
      }
    }
    catch (Exception paramb)
    {
      o.a("MicroMsg.Video.AbstractVideoTextureView", paramb, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    a.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ml.a.3
 * JD-Core Version:    0.7.0.1
 */
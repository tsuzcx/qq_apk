package com.tencent.luggage.wxa.gq;

import java.util.List;

class a$1
  implements m
{
  a$1(a parama) {}
  
  public void a(b paramb)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "decode process end");
    k.b(paramb);
  }
  
  public void a(n paramn)
  {
    if (paramn == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "process decoder is null");
      return;
    }
    com.tencent.luggage.wxa.if.b localb = paramn.w();
    paramn.q();
    paramn.n();
    paramn.g();
    paramn = a.a(this.a);
    if (localb != null) {}
    try
    {
      if (a.b(this.a).contains(localb.c)) {
        a.b(this.a).remove(localb.c);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.a.1
 * JD-Core Version:    0.7.0.1
 */
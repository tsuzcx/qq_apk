package com.tencent.luggage.wxa.kx;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.capsulebar.i.a;

public final class i
{
  private long a = 0L;
  private i.a b;
  
  public void a()
  {
    o.d("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitleImmediately");
    l.a(new i.3(this));
  }
  
  public void a(d paramd)
  {
    o.d("MicroMsg.LbsBlinkHelper", "startBlinkSubTitle");
    l.a(new i.1(this, paramd));
  }
  
  public void b(d paramd)
  {
    o.d("MicroMsg.LbsBlinkHelper", "stopBlinkSubTitle");
    l.a(new i.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.fy.m;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;

class d$29
  implements m
{
  d$29(d paramd) {}
  
  public void a()
  {
    o.e(d.b(this.a), "playAudio");
    if (!d.F(this.a).getAndSet(true)) {
      d.b(this.a, new d.29.1(this));
    }
  }
  
  public void b()
  {
    o.e(d.b(this.a), "playVideo");
    if (d.F(this.a).getAndSet(false)) {
      d.a(this.a, new d.29.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.29
 * JD-Core Version:    0.7.0.1
 */
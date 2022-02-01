package com.tencent.luggage.wxa.ga;

import android.os.Handler;
import com.tencent.luggage.wxa.fy.m;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;

class a$10
  implements m
{
  a$10(a parama) {}
  
  public void a()
  {
    o.e(a.b(this.a), "playAudio");
    if (!a.k(this.a).getAndSet(true)) {
      a.a(this.a, new a.10.1(this));
    }
  }
  
  public void b()
  {
    o.e(a.b(this.a), "playVideo");
    if ((a.k(this.a).getAndSet(false)) && (a.l(this.a) != null)) {
      a.l(this.a).post(new a.10.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.a.10
 * JD-Core Version:    0.7.0.1
 */
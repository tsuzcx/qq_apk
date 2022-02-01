package com.tencent.luggage.wxa.ga;

import java.util.concurrent.atomic.AtomicBoolean;

class a$10$2
  implements Runnable
{
  a$10$2(a.10 param10) {}
  
  public void run()
  {
    if (a.k(this.a.a).get()) {
      return;
    }
    if (a.i(this.a.a) != null)
    {
      a.i(this.a.a).a(a.m(this.a.a));
      if (!a.i(this.a.a).e()) {
        a.i(this.a.a).a("play", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ga.a.10.2
 * JD-Core Version:    0.7.0.1
 */
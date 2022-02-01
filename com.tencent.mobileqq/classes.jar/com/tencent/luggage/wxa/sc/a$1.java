package com.tencent.luggage.wxa.sc;

import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.f;

final class a$1
  implements Runnable
{
  a$1(Runnable paramRunnable) {}
  
  public void run()
  {
    this.a.run();
    c.b.c(Thread.currentThread(), Thread.currentThread().getName(), Thread.currentThread().getId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sc.a.1
 * JD-Core Version:    0.7.0.1
 */
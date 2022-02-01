package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.ro.e.a;
import java.util.concurrent.CountDownLatch;

class r$a$1
  implements e.a
{
  r$a$1(r.a parama, i parami, CountDownLatch paramCountDownLatch) {}
  
  public void a(Object paramObject)
  {
    this.a.a = paramObject;
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.r.a.1
 * JD-Core Version:    0.7.0.1
 */
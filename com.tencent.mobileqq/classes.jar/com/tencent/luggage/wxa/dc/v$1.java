package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ob.a.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

class v$1
  implements p<Resp>
{
  v$1(v paramv, AtomicReference paramAtomicReference, CountDownLatch paramCountDownLatch) {}
  
  public void a(a.a parama, int paramInt, String paramString)
  {
    this.a.set(null);
    this.b.countDown();
  }
  
  public void a(Resp paramResp)
  {
    this.a.set(paramResp);
    this.b.countDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.v.1
 * JD-Core Version:    0.7.0.1
 */
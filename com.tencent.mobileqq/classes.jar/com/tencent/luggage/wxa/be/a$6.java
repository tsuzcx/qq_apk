package com.tencent.luggage.wxa.be;

import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;

class a$6
  implements Runnable
{
  a$6(a parama, t.a parama1) {}
  
  public void run()
  {
    o.d("MicroMsg.AppBrandCameraView", "currentOrientationRecord %s, lateOrientationState: %s", new Object[] { this.a.toString(), a.c(this.b).toString() });
    if ((af.c(a.l(this.b)) >= 750L) && (a.m(this.b).get()) && (this.a == a.c(this.b)))
    {
      o.d("MicroMsg.AppBrandCameraView", "reopen camera");
      this.b.g();
      this.b.a();
    }
    a.a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.lw;

import java.lang.ref.WeakReference;

class h$2
  implements Runnable
{
  h$2(h paramh, j paramj, WeakReference paramWeakReference, int paramInt, long paramLong) {}
  
  public void run()
  {
    this.a.i();
    com.tencent.luggage.wxa.jx.h localh = (com.tencent.luggage.wxa.jx.h)this.b.get();
    if (localh == null) {
      return;
    }
    h.a(this.e, this.a.c, this.a.d, this.a.e, localh, this.c);
    h.a(this.e, 1, this.a.c, this.a.d * 1000, this.d, localh);
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lw.h.2
 * JD-Core Version:    0.7.0.1
 */
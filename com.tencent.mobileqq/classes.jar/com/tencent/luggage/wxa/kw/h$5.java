package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.pp.i;
import com.tencent.luggage.wxa.pw.e;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

class h$5
  implements Runnable
{
  h$5(h paramh, WeakReference paramWeakReference, i parami, e parame, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    u localu = (u)this.a.get();
    if (localu != null)
    {
      if (localu.aj() == null) {
        return;
      }
      this.b.a(this.c, this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.h.5
 * JD-Core Version:    0.7.0.1
 */
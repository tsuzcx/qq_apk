package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.pp.ae;
import com.tencent.luggage.wxa.pp.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

class e$1
  implements Runnable
{
  e$1(e parame, WeakReference paramWeakReference, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    u localu = (u)this.a.get();
    if (localu == null) {
      return;
    }
    if (localu.ac() != null) {
      localu.ac().i();
    }
    String str;
    if (o.b(localu, this.b)) {
      str = "ok";
    } else {
      str = "fail";
    }
    localu.a(this.c, this.d.b(str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.e.1
 * JD-Core Version:    0.7.0.1
 */
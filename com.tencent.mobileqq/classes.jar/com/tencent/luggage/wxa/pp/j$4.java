package com.tencent.luggage.wxa.pp;

import com.tencent.luggage.wxa.hv.c;
import com.tencent.luggage.wxa.hv.h;
import com.tencent.luggage.wxa.jx.y;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

class j$4
  implements af
{
  j$4(j paramj, WeakReference paramWeakReference, int paramInt) {}
  
  public void a(int paramInt)
  {
    try
    {
      u localu = (u)this.a.get();
      if (localu == null) {
        return;
      }
      int i = g.a(paramInt);
      localu.a("onKeyboardShow", h.b().a("inputId", this.b).a("height", i).toString());
      new y().a(paramInt, localu.p(), localu, Integer.valueOf(this.b));
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.j.4
 * JD-Core Version:    0.7.0.1
 */
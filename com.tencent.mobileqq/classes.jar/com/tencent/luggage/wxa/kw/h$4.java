package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.jx.y;
import com.tencent.luggage.wxa.pp.ab;
import com.tencent.luggage.wxa.pp.i.b;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

class h$4
  implements i.b
{
  h$4(h paramh, WeakReference paramWeakReference) {}
  
  public void a(ab paramab, int paramInt)
  {
    try
    {
      u localu = (u)this.a.get();
      if (localu == null) {
        return;
      }
      h.a(this.b, paramab.a(), paramInt, localu);
      new y().a(paramInt, localu.p(), localu, Integer.valueOf(paramab.a()));
      return;
    }
    catch (Exception paramab) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.h.4
 * JD-Core Version:    0.7.0.1
 */
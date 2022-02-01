package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.pp.ab;
import com.tencent.luggage.wxa.pp.j;
import com.tencent.luggage.wxa.pw.h;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Locale;

class i$1
  implements Runnable
{
  i$1(i parami, u paramu, int paramInt1, h paramh, int paramInt2) {}
  
  public void run()
  {
    if (j.a().a(this.a, this.b, this.c))
    {
      this.a.a(this.d, this.e.b("ok"));
      return;
    }
    ab localab = com.tencent.luggage.wxa.pp.o.a(this.a, this.b);
    if ((localab instanceof com.tencent.luggage.wxa.pp.i))
    {
      ((com.tencent.luggage.wxa.pp.i)localab).a(this.c);
      this.a.a(this.d, this.e.b("ok"));
      return;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrand.JsApiUpdateInput", String.format(Locale.US, "AppBrandInputInvokeHandler with inputID(%d) 404", new Object[] { Integer.valueOf(this.b) }));
    this.a.a(this.d, this.e.b(String.format(Locale.US, "fail found no input with %d", new Object[] { Integer.valueOf(this.b) })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.i.1
 * JD-Core Version:    0.7.0.1
 */
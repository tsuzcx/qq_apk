package com.tencent.luggage.wxa.pp;

import com.tencent.luggage.wxa.qt.a;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

class i$3
  implements Runnable
{
  i$3(i parami, a parama) {}
  
  public void run()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, before run checkForInput");
    this.a.a = true;
    u localu;
    if (this.b.f == null) {
      localu = null;
    } else {
      localu = (u)this.b.f.get();
    }
    if (localu != null)
    {
      if (i.d(this.b) == null) {
        return;
      }
      if (o.c(localu) != this.b) {
        return;
      }
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandInputInvokeHandler", "ensureInputFocusedWithSoftKeyboard, run checkForInput");
      h.a().b(localu.aj());
      ak.b(i.d(this.b));
      if ((i.e(this.b) != null) && (i.e(this.b).b(null))) {
        i.e(this.b).j();
      }
      i.d(this.b).a(this.b.e);
      i.d(this.b).setFocusable(true);
      i.d(this.b).setFocusableInTouchMode(true);
      i.e(this.b).a(i.d(this.b));
      i.d(this.b).requestFocus();
      ak.b(i.d(this.b));
      if (i.e(this.b) != null) {
        i.e(this.b).f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.3
 * JD-Core Version:    0.7.0.1
 */
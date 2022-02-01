package com.tencent.luggage.wxa.pp;

import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;

class i$8
  implements x.e
{
  i$8(i parami) {}
  
  public void a(int paramInt)
  {
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrandInputInvokeHandler", "[appInput], onSmileyPanelVisibilityChanged = %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt != 2)
    {
      if ((paramInt == 0) && (i.d(this.a) != null)) {
        i.d(this.a).requestFocus();
      }
      i.k(this.a);
      if ((this.a.f != null) && (this.a.f.get() != null)) {
        o.a((u)this.a.f.get(), i.d(this.a));
      }
    }
    else
    {
      i.a(this.a, i.d.a);
      i.j(this.a);
      i.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.8
 * JD-Core Version:    0.7.0.1
 */
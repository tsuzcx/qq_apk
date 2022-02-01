package com.tencent.luggage.wxa.pp;

import com.tencent.luggage.wxa.pt.a;
import com.tencent.luggage.wxa.pt.b;
import com.tencent.luggage.wxa.qz.o;

class i$16
  implements b
{
  i$16(i parami) {}
  
  public void a()
  {
    if (i.d(this.a) == null) {
      return;
    }
    o.e("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { i.d(this.a).getEditableText() });
    i.f(this.a).a(i.d(this.a).getEditableText(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.i.16
 * JD-Core Version:    0.7.0.1
 */
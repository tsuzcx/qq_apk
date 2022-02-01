package com.tencent.luggage.wxa.pp;

import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.pv.a;
import com.tencent.luggage.wxa.qz.o;

class x$1
  implements Runnable
{
  x$1(x paramx) {}
  
  public void run()
  {
    if (x.a(this.a) != null)
    {
      if (!ViewCompat.isAttachedToWindow(x.a(this.a))) {
        return;
      }
      if (x.b(this.a).h())
      {
        o.e("MicroMsg.AppBrandSoftKeyboardPanel", "postMeasure inLayout, skip");
        this.a.post(this);
        return;
      }
      x.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.x.1
 * JD-Core Version:    0.7.0.1
 */
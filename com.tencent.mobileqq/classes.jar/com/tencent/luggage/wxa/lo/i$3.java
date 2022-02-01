package com.tencent.luggage.wxa.lo;

import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.picker.a;

class i$3
  implements Runnable
{
  i$3(i parami, a parama) {}
  
  public void run()
  {
    if ((this.a.getPicker() != null) && ((this.a.getPicker() instanceof View))) {
      ((View)this.a.getPicker()).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lo.i.3
 * JD-Core Version:    0.7.0.1
 */
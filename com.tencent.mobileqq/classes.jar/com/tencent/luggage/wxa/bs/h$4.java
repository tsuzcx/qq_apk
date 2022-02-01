package com.tencent.luggage.wxa.bs;

import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.page.ar;

class h$4
  implements ar
{
  h$4(h paramh) {}
  
  public void a(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout != null) && (paramFrameLayout.getParent() == null)) {
      this.a.a.addView(paramFrameLayout, 0, new ViewGroup.LayoutParams(-1, -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.h.4
 * JD-Core Version:    0.7.0.1
 */
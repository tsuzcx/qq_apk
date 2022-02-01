package com.tencent.luggage.wxa.bi;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.ui.f;

class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public void run()
  {
    if (a.b(this.a) != null) {
      com.tencent.mm.plugin.appbrand.ui.a.a(a.b(this.a));
    }
    a locala = this.a;
    a.a(locala, locala.b());
    if (a.b(this.a) == null) {
      return;
    }
    if ((a.b(this.a) instanceof f)) {
      ((f)a.b(this.a)).a(new a.4.1(this));
    }
    if (a.b(this.a).getParent() != this.a.n())
    {
      if (a.b(this.a).getParent() != null) {
        ((ViewGroup)a.b(this.a).getParent()).removeView(a.b(this.a));
      }
      this.a.n().addView(a.b(this.a), new ViewGroup.LayoutParams(-1, -1));
    }
    this.a.n().bringChildToFront(a.b(this.a));
    a.b(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.a.4
 * JD-Core Version:    0.7.0.1
 */
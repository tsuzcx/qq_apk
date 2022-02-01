package com.tencent.luggage.wxa.bs;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.i;

class h$1
  implements View.OnAttachStateChangeListener
{
  h$1(h paramh) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    o.d("Luggage.Game.WAGamePageViewRenderer", "WAGamePageView onAttachedToWindow, notify mb foreground once");
    h.a(this.a).getMagicBrush().b();
    h.a(this.a).post(new h.1.1(this, this));
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.h.1
 * JD-Core Version:    0.7.0.1
 */
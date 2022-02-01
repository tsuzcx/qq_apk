package com.tencent.luggage.wxa.pq;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListView;

class c$3
  implements ViewTreeObserver.OnPreDrawListener
{
  c$3(c paramc, ListView paramListView, int paramInt) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    c.c(this.c, this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.c.3
 * JD-Core Version:    0.7.0.1
 */
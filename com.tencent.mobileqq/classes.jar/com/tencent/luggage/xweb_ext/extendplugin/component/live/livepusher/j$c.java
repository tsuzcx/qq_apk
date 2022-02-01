package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.view.MotionEvent;

class j$c
  implements Runnable
{
  private MotionEvent b;
  
  private j$c(j paramj) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    this.b = paramMotionEvent;
  }
  
  public void run()
  {
    if ((j.m(this.a)) && (j.n(this.a) != 0) && (j.o(this.a) != 0)) {
      j.a(this.a, this.b.getX() / j.n(this.a), this.b.getY() / j.o(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.c
 * JD-Core Version:    0.7.0.1
 */
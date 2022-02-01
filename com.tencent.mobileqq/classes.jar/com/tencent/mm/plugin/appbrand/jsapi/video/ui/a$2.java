package com.tencent.mm.plugin.appbrand.jsapi.video.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class a$2
  extends GestureDetector.SimpleOnGestureListener
{
  a$2(a parama) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    a.c(this.a).removeCallbacks(a.b(this.a));
    a.a(this.a).b();
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent1 != null) && (paramMotionEvent2 != null))
    {
      if (a.d(this.a) == a.a.a) {
        if (Math.abs(paramFloat1) > Math.abs(paramFloat2)) {
          a.a(this.a, a.a.d);
        } else if (paramMotionEvent1.getX() < a.c(this.a).getMeasuredWidth() / 2) {
          a.a(this.a, a.a.c);
        } else {
          a.a(this.a, a.a.b);
        }
      }
      paramFloat1 = paramMotionEvent2.getX();
      paramFloat2 = paramMotionEvent1.getX();
      float f1 = paramMotionEvent2.getY();
      float f2 = paramMotionEvent1.getY();
      return a.a(this.a, paramMotionEvent1, paramMotionEvent2, paramFloat1 - paramFloat2, f1 - f2);
    }
    return true;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    a.c(this.a).postDelayed(a.b(this.a), 200L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.sdk.a;

import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;

final class if$a
  extends GestureDetector.SimpleOnGestureListener
{
  private PointF b = new PointF();
  private boolean c = true;
  
  private if$a(if paramif) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public final boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      return true;
    case 0: 
      this.c = true;
      if.d(this.a).setIsLongpressEnabled(false);
      this.b.set(paramMotionEvent.getX(), paramMotionEvent.getY());
      if.a(this.a).f(f1, f2);
      return true;
    case 1: 
      if (this.c) {
        if.a(this.a).a(f1, f2);
      }
      this.b.set(0.0F, 0.0F);
      if.d(this.a).setIsLongpressEnabled(true);
      if.a(this.a).h(f1, f2);
      return true;
    }
    float f3 = this.b.x;
    float f4 = this.b.y;
    if ((Math.abs(f1 - f3) > 10.0F) || (Math.abs(f2 - f4) > 10.0F))
    {
      this.c = false;
      if.a(this.a).g(f1, f2);
    }
    if.d(this.a).setIsLongpressEnabled(true);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if.a(this.a).c(paramFloat1, paramFloat2);
    return true;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    if (!if.c(this.a)) {
      if.a(this.a).e(paramMotionEvent.getX(), paramMotionEvent.getY());
    }
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((if.b(this.a) != null) && (if.b(this.a).get() != null) && (((pt)if.b(this.a).get()).u()))
    {
      double d = Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (((paramMotionEvent1 != null) && ((paramMotionEvent1.getX() < 0.0F) || (paramMotionEvent1.getY() < 0.0F))) || ((paramMotionEvent2 != null) && ((paramMotionEvent2.getX() < 0.0F) || (paramMotionEvent2.getY() < 0.0F))) || (d > 50.0D)) {
        return true;
      }
    }
    if.a(this.a).d(-paramFloat1, -paramFloat2);
    return true;
  }
  
  public final boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if.a(this.a).b(f1, f2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.if.a
 * JD-Core Version:    0.7.0.1
 */
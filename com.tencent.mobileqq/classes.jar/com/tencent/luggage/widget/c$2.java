package com.tencent.luggage.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class c$2
  extends GestureDetector.SimpleOnGestureListener
{
  c$2(c paramc, Context paramContext) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((c.g(this.b)) && (c.c(this.b)) && (c.d(this.b) != null))
    {
      c.a(this.b, this.a);
      if (c.h(this.b))
      {
        c.a(this.b, new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
        localc = this.b;
        c.b(localc, new PointF(c.d(localc).x, c.d(this.b).y));
        localc = this.b;
        c.a(localc, c.f(localc));
        c.a(this.b, true);
        c.b(this.b, true);
        c.b(this.b, -1.0F);
        localc = this.b;
        c.c(localc, localc.a(c.i(localc)));
        c.d(this.b, new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
        paramMotionEvent = this.b;
        c.e(paramMotionEvent, new PointF(c.j(paramMotionEvent).x, c.j(this.b).y));
        c.c(this.b, false);
        return false;
      }
      c localc = this.b;
      c.a(localc, localc.a(new PointF(paramMotionEvent.getX(), paramMotionEvent.getY())), new PointF(paramMotionEvent.getX(), paramMotionEvent.getY()));
      return true;
    }
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((c.b(this.b)) && (c.c(this.b)) && (c.d(this.b) != null) && (paramMotionEvent1 != null) && (paramMotionEvent2 != null) && ((Math.abs(paramMotionEvent1.getX() - paramMotionEvent2.getX()) > 50.0F) || (Math.abs(paramMotionEvent1.getY() - paramMotionEvent2.getY()) > 50.0F)) && ((Math.abs(paramFloat1) > 500.0F) || (Math.abs(paramFloat2) > 500.0F)) && (!c.e(this.b)))
    {
      paramMotionEvent1 = new PointF(c.d(this.b).x + paramFloat1 * 0.25F, c.d(this.b).y + paramFloat2 * 0.25F);
      paramFloat1 = (this.b.getWidth() / 2 - paramMotionEvent1.x) / c.f(this.b);
      paramFloat2 = (this.b.getHeight() / 2 - paramMotionEvent1.y) / c.f(this.b);
      c.b.a(c.b.a(new c.b(this.b, new PointF(paramFloat1, paramFloat2), null).a(1), false), 3).a();
      return true;
    }
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.b.performClick();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.c.2
 * JD-Core Version:    0.7.0.1
 */
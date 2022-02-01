package com.tencent.luggage.wxa.rx;

import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.List;

public class d
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, c
{
  private GestureDetector a;
  private a b;
  private com.tencent.neattextview.textview.layout.a c;
  private com.tencent.luggage.wxa.rw.c d;
  private View e;
  
  protected void a(int paramInt)
  {
    com.tencent.luggage.wxa.rw.c localc = this.d;
    if (localc != null)
    {
      localc.a(false);
      this.e.invalidate();
      this.d = null;
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.b.getOnDoubleClickListener() != null)
    {
      this.b.getOnDoubleClickListener().a(this.e, paramMotionEvent);
      return true;
    }
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    if (this.b.a()) {
      return false;
    }
    if (this.c.a() == null)
    {
      Log.w("NeatViewTouchListener", "ClickInfo is null");
      return false;
    }
    Iterator localIterator = this.c.a().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.wxa.rw.c localc = (com.tencent.luggage.wxa.rw.c)localIterator.next();
      if (localc.a(paramMotionEvent.getX() - this.b.getHorizontalOffset(), paramMotionEvent.getY() - this.b.getVerticalOffset()))
      {
        this.d = localc;
        localc.a(true);
        this.e.postInvalidate();
        return true;
      }
    }
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    a(3);
    return false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    a(1);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    if (this.b.a()) {
      return false;
    }
    paramMotionEvent = this.d;
    if (paramMotionEvent != null) {
      paramMotionEvent.a(this.e);
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.b.getLayout() == null) {
      return false;
    }
    this.c = this.b.getLayout();
    this.e = paramView;
    boolean bool = this.a.onTouchEvent(paramMotionEvent);
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      a(2);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rx.d
 * JD-Core Version:    0.7.0.1
 */
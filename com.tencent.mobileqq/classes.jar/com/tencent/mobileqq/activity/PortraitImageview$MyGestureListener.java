package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

class PortraitImageview$MyGestureListener
  extends PortraitImageview.SimpleOnGestureListener
{
  private PortraitImageview$MyGestureListener(PortraitImageview paramPortraitImageview) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.getScale() > this.a.b())
    {
      paramMotionEvent = this.a;
      paramMotionEvent.a(paramMotionEvent.b());
    }
    else
    {
      PortraitImageview localPortraitImageview = this.a;
      localPortraitImageview.a(localPortraitImageview.b() * 3.0F, paramMotionEvent.getX(), paramMotionEvent.getY(), 350.0F);
    }
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((paramMotionEvent1 != null) && (paramMotionEvent1.getPointerCount() > 1)) || ((paramMotionEvent2 != null) && (paramMotionEvent2.getPointerCount() > 1)) || ((this.a.b != null) && (this.a.b.isInProgress()))) {
      return false;
    }
    paramMotionEvent1 = this.a;
    paramMotionEvent1.removeCallbacks(paramMotionEvent1.a);
    this.a.a(-paramFloat1, -paramFloat2);
    paramMotionEvent1 = this.a;
    paramMotionEvent1.setImageMatrix(paramMotionEvent1.getImageViewMatrix());
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.j != null)
    {
      this.a.j.a();
      return false;
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */
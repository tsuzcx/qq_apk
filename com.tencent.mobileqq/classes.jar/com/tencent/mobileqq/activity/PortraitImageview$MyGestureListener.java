package com.tencent.mobileqq.activity;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

class PortraitImageview$MyGestureListener
  extends PortraitImageview.SimpleOnGestureListener
{
  private PortraitImageview$MyGestureListener(PortraitImageview paramPortraitImageview) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.a.a() > this.a.c())
    {
      paramMotionEvent = this.a;
      paramMotionEvent.a(paramMotionEvent.c());
    }
    else
    {
      PortraitImageview localPortraitImageview = this.a;
      localPortraitImageview.a(localPortraitImageview.c() * 3.0F, paramMotionEvent.getX(), paramMotionEvent.getY(), 350.0F);
    }
    return true;
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (((paramMotionEvent1 != null) && (paramMotionEvent1.getPointerCount() > 1)) || ((paramMotionEvent2 != null) && (paramMotionEvent2.getPointerCount() > 1)) || ((this.a.jdField_a_of_type_AndroidViewScaleGestureDetector != null) && (this.a.jdField_a_of_type_AndroidViewScaleGestureDetector.isInProgress()))) {
      return false;
    }
    paramMotionEvent1 = this.a;
    paramMotionEvent1.removeCallbacks(paramMotionEvent1.jdField_a_of_type_JavaLangRunnable);
    this.a.a(-paramFloat1, -paramFloat2);
    paramMotionEvent1 = this.a;
    paramMotionEvent1.setImageMatrix(paramMotionEvent1.a());
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$OnImageTouchedListener != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview$OnImageTouchedListener.a();
      return false;
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PortraitImageview.MyGestureListener
 * JD-Core Version:    0.7.0.1
 */
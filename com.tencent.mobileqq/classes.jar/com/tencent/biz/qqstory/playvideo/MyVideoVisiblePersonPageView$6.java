package com.tencent.biz.qqstory.playvideo;

import android.app.Dialog;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class MyVideoVisiblePersonPageView$6
  extends GestureDetector.SimpleOnGestureListener
{
  MyVideoVisiblePersonPageView$6(MyVideoVisiblePersonPageView paramMyVideoVisiblePersonPageView) {}
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if ((paramMotionEvent2 != null) && (paramMotionEvent1 != null))
    {
      paramFloat1 = Math.abs(paramMotionEvent2.getX() - paramMotionEvent1.getX());
      float f = Math.abs(paramMotionEvent2.getY() - paramMotionEvent1.getY());
      double d1 = paramFloat1;
      double d2 = Math.sqrt(paramFloat1 * paramFloat1 + f * f);
      Double.isNaN(d1);
      d1 = Math.abs(Math.asin(d1 / d2));
      if ((paramFloat2 > 0.0F) && (d1 < 0.5235987755982988D) && (this.a.l == 0)) {
        this.a.m.dismiss();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.MyVideoVisiblePersonPageView.6
 * JD-Core Version:    0.7.0.1
 */
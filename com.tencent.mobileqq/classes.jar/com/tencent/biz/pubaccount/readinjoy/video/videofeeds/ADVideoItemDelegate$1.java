package com.tencent.biz.pubaccount.readinjoy.video.videofeeds;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;

class ADVideoItemDelegate$1
  extends GestureDetector.SimpleOnGestureListener
{
  ADVideoItemDelegate$1(ADVideoItemDelegate paramADVideoItemDelegate) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((ADVideoItemDelegate.a(this.a) != null) && (ADVideoItemDelegate.a(this.a).ac != null)) {
      this.a.c.a(ADVideoItemDelegate.a(this.a).ac, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((ADVideoItemDelegate.a(this.a) != null) && (ADVideoItemDelegate.a(this.a).h != null)) {
      this.a.c.onClick(ADVideoItemDelegate.a(this.a).h);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate.1
 * JD-Core Version:    0.7.0.1
 */
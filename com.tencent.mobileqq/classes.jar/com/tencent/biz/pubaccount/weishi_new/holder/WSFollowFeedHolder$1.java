package com.tencent.biz.pubaccount.weishi_new.holder;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSFollowFeedHolder$1
  extends GestureDetector.SimpleOnGestureListener
{
  WSFollowFeedHolder$1(WSFollowFeedHolder paramWSFollowFeedHolder) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    WSLog.b("WSFollowFeedHolder", "VideoLayout onDoubleTap");
    WSFollowFeedHolder.a(this.a, paramMotionEvent);
    WSFollowFeedHolder.a(this.a, true);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    WSLog.b("WSFollowFeedHolder", "VideoLayout onSingleTapConfirmed");
    WSFollowFeedHolder.a(this.a);
    WSFollowFeedHolder.a(this.a, false);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.holder.WSFollowFeedHolder.1
 * JD-Core Version:    0.7.0.1
 */
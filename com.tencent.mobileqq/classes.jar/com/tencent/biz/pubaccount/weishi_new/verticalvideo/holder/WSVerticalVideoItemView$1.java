package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSVerticalVideoItemView$1
  extends GestureDetector.SimpleOnGestureListener
{
  WSVerticalVideoItemView$1(WSVerticalVideoItemView paramWSVerticalVideoItemView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    WSLog.b("WSVerticalVideoItemView", "itemView onDoubleTap");
    WSVerticalVideoItemView.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    WSLog.b("WSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    WSVerticalVideoItemView.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoItemView.1
 * JD-Core Version:    0.7.0.1
 */
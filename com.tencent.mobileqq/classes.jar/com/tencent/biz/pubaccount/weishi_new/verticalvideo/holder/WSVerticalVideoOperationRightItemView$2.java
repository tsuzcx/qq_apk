package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSVerticalVideoOperationRightItemView$2
  extends GestureDetector.SimpleOnGestureListener
{
  WSVerticalVideoOperationRightItemView$2(WSVerticalVideoOperationRightItemView paramWSVerticalVideoOperationRightItemView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    WSLog.b("WSVerticalVideoOperationRightItemView", "itemView onDoubleTap");
    WSVerticalVideoOperationRightItemView.a(this.a, paramMotionEvent);
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    WSLog.b("WSVerticalVideoOperationRightItemView", "itemView onSingleTapConfirmed");
    WSVerticalVideoOperationRightItemView.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoOperationRightItemView.2
 * JD-Core Version:    0.7.0.1
 */
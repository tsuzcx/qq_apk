package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class GdtAdWSVerticalVideoItemView$1
  extends GestureDetector.SimpleOnGestureListener
{
  GdtAdWSVerticalVideoItemView$1(GdtAdWSVerticalVideoItemView paramGdtAdWSVerticalVideoItemView) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    WSLog.b("GdtAdWSVerticalVideoItemView", "itemView onSingleTapConfirmed");
    GdtAdWSVerticalVideoItemView.a(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalVideoItemView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.imagecollection;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class PublicAccountImageCollectionAdapter$PublicAccountOnGestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private PublicAccountImageCollectionAdapter$PublicAccountOnGestureListener(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.doubleTapFlag = true;
    PublicAccountImageCollectionAdapter.e(this.a);
    return false;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((!(PublicAccountImageCollectionAdapter.f(this.a).getTag() instanceof PublicAccountImageCollectionAdapter.CoverHolder)) || (((PublicAccountImageCollectionAdapter.f(this.a).getTag() instanceof PublicAccountImageCollectionAdapter.CoverHolder)) && (!PublicAccountImageCollectionAdapter.g(this.a).b(PublicAccountImageCollectionAdapter.f(this.a)).booleanValue()))) {
      PublicAccountImageCollectionAdapter.h(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter.PublicAccountOnGestureListener
 * JD-Core Version:    0.7.0.1
 */
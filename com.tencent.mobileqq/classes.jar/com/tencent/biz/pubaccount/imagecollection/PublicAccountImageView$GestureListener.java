package com.tencent.biz.pubaccount.imagecollection;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class PublicAccountImageView$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private final PublicAccountImageView.MatrixTouchListener b;
  
  public PublicAccountImageView$GestureListener(PublicAccountImageView paramPublicAccountImageView, PublicAccountImageView.MatrixTouchListener paramMatrixTouchListener)
  {
    this.b = paramMatrixTouchListener;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.g(this.a);
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.g(this.a);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView.GestureListener
 * JD-Core Version:    0.7.0.1
 */
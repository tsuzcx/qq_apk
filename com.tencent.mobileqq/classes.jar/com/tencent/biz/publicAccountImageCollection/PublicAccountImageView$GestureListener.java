package com.tencent.biz.publicAccountImageCollection;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class PublicAccountImageView$GestureListener
  extends GestureDetector.SimpleOnGestureListener
{
  private final PublicAccountImageView.MatrixTouchListener jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView$MatrixTouchListener;
  
  public PublicAccountImageView$GestureListener(PublicAccountImageView paramPublicAccountImageView, PublicAccountImageView.MatrixTouchListener paramMatrixTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView$MatrixTouchListener = paramMatrixTouchListener;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    return false;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    PublicAccountImageView.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageView);
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageView.GestureListener
 * JD-Core Version:    0.7.0.1
 */
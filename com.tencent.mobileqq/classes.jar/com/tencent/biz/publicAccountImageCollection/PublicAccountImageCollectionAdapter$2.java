package com.tencent.biz.publicAccountImageCollection;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class PublicAccountImageCollectionAdapter$2
  implements View.OnTouchListener
{
  PublicAccountImageCollectionAdapter$2(PublicAccountImageCollectionAdapter paramPublicAccountImageCollectionAdapter, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    PublicAccountImageCollectionAdapter.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter, paramView);
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter.d = this.jdField_a_of_type_Int;
    PublicAccountImageCollectionAdapter.a(this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionAdapter).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionAdapter.2
 * JD-Core Version:    0.7.0.1
 */
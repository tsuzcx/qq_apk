package com.tencent.biz.pubaccount.imagecollection;

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
    PublicAccountImageCollectionAdapter.a(this.b, paramView);
    paramView = this.b;
    paramView.k = this.a;
    PublicAccountImageCollectionAdapter.c(paramView).onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionAdapter.2
 * JD-Core Version:    0.7.0.1
 */
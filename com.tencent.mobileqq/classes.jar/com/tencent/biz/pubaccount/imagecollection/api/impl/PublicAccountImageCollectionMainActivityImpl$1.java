package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView;
import com.tencent.qphone.base.util.QLog;

class PublicAccountImageCollectionMainActivityImpl$1
  implements View.OnTouchListener
{
  PublicAccountImageCollectionMainActivityImpl$1(PublicAccountImageCollectionMainActivityImpl paramPublicAccountImageCollectionMainActivityImpl) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (PublicAccountImageCollectionMainActivityImpl.access$100(this.a))
    {
      this.a.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("current operation is");
        paramView.append(paramMotionEvent.getAction());
        QLog.d("qqBaseActivity", 2, paramView.toString());
      }
      if ((paramMotionEvent.getAction() == 1) && (this.a.currentValues[0] < this.a.initValues[0]))
      {
        PublicAccountImageCollectionMainActivityImpl.access$200(this.a).setImageMatrix(this.a.initMatrix);
        PublicAccountImageCollectionMainActivityImpl.access$200(this.a).setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      return true;
    }
    this.a.mScaleGestureDetector.onTouchEvent(paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */
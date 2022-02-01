package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyBaseViewController;
import java.lang.ref.WeakReference;

class ReadInJoyFeedsActivity$OnDoubleClick
  extends GestureDetector.SimpleOnGestureListener
{
  private WeakReference<ReadInJoyBaseViewController> a = null;
  
  public ReadInJoyFeedsActivity$OnDoubleClick(ReadInJoyBaseViewController paramReadInJoyBaseViewController)
  {
    this.a = new WeakReference(paramReadInJoyBaseViewController);
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((ReadInJoyBaseViewController)this.a.get()).a(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.OnDoubleClick
 * JD-Core Version:    0.7.0.1
 */
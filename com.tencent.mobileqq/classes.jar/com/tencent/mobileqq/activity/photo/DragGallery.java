package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import bkkt;
import com.tencent.qphone.base.util.QLog;

public class DragGallery
  extends ProGallery
{
  private MotionEvent a;
  
  public DragGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MotionEvent a()
  {
    return this.jdField_a_of_type_AndroidViewMotionEvent;
  }
  
  public void a()
  {
    if (Math.abs(this.h) == 0) {}
    for (float f = 999.0F;; f = Math.abs(this.i) / Math.abs(this.h))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DragGallery", 2, "scrollY : " + Math.abs(this.i) + " scrollX : " + Math.abs(this.h) + " ratio : " + f);
      }
      if (((this.j == 1) || (this.j == -1)) && (f >= 6.0F) && (this.h < 10))
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        if (this.jdField_a_of_type_Bkkt != null) {
          this.jdField_a_of_type_Bkkt.b(this.mSelectedPosition);
        }
      }
      return;
    }
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.DragGallery
 * JD-Core Version:    0.7.0.1
 */
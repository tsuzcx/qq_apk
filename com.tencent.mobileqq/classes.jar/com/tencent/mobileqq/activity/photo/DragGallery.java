package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery.OnScollListener;

public class DragGallery
  extends ProGallery
{
  private MotionEvent a;
  
  public DragGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void disPatchToParent()
  {
    float f;
    if (Math.abs(this.scrollX) == 0) {
      f = 999.0F;
    } else {
      f = Math.abs(this.scrollY) / Math.abs(this.scrollX);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scrollY : ");
      localStringBuilder.append(Math.abs(this.scrollY));
      localStringBuilder.append(" scrollX : ");
      localStringBuilder.append(Math.abs(this.scrollX));
      localStringBuilder.append(" ratio : ");
      localStringBuilder.append(f);
      QLog.d("DragGallery", 2, localStringBuilder.toString());
    }
    if (((this.mScrollState == 1) || (this.mScrollState == -1)) && (f >= 6.0F) && (this.scrollX < 10))
    {
      getParent().requestDisallowInterceptTouchEvent(false);
      if (this.mOnScollListener != null) {
        this.mOnScollListener.onScrollEnd(this.mSelectedPosition);
      }
    }
  }
  
  public MotionEvent getSingleTapConfirmedEvent()
  {
    return this.a;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onDown(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    this.a = paramMotionEvent;
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.DragGallery
 * JD-Core Version:    0.7.0.1
 */
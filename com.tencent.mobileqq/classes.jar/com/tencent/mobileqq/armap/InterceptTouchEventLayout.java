package com.tencent.mobileqq.armap;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class InterceptTouchEventLayout
  extends RelativeLayout
{
  private InterceptTouchEventLayout.InterceptTouchEventListener jdField_a_of_type_ComTencentMobileqqArmapInterceptTouchEventLayout$InterceptTouchEventListener;
  private boolean jdField_a_of_type_Boolean;
  
  public InterceptTouchEventLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public InterceptTouchEventLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InterceptTouchEventLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapInterceptTouchEventLayout$InterceptTouchEventListener != null) {
      return this.jdField_a_of_type_ComTencentMobileqqArmapInterceptTouchEventLayout$InterceptTouchEventListener.OnInterceptTouchEvent(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setInterceptTouchEventFlag(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setInterceptTouchEventListener(InterceptTouchEventLayout.InterceptTouchEventListener paramInterceptTouchEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapInterceptTouchEventLayout$InterceptTouchEventListener = paramInterceptTouchEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.InterceptTouchEventLayout
 * JD-Core Version:    0.7.0.1
 */
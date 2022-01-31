package com.tencent.mobileqq.activity.aio.item;

import adbk;
import adbl;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;

public class ArkAppRootLayout
  extends RelativeLayout
{
  private adbl jdField_a_of_type_Adbl;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private boolean jdField_a_of_type_Boolean;
  
  public ArkAppRootLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ArkAppRootLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ArkAppRootLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, new adbk(this));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = paramMotionEvent.getActionMasked();
      if (i != 0) {
        break label32;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label32:
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setCallback(adbl paramadbl)
  {
    this.jdField_a_of_type_Adbl = paramadbl;
  }
  
  public void setDisableParentReturn(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout
 * JD-Core Version:    0.7.0.1
 */
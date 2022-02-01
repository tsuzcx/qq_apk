package com.tencent.mobileqq.activity.history.widget;

import ajbk;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class DispatchTouchEventLinearLayout
  extends LinearLayout
{
  private ajbk a;
  
  public DispatchTouchEventLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DispatchTouchEventLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DispatchTouchEventLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a != null) {
      this.a.a(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnDispatchListener(ajbk paramajbk)
  {
    this.a = paramajbk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.DispatchTouchEventLinearLayout
 * JD-Core Version:    0.7.0.1
 */
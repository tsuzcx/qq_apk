package com.tencent.mobileqq.activity.history.widget;

import aieo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class DispatchTouchEventRelativeLayout
  extends RelativeLayout
{
  private aieo a;
  
  public DispatchTouchEventRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DispatchTouchEventRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DispatchTouchEventRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public void setOnDispatchListener(aieo paramaieo)
  {
    this.a = paramaieo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
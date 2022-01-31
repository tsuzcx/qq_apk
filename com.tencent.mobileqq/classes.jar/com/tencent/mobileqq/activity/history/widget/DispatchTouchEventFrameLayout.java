package com.tencent.mobileqq.activity.history.widget;

import aiem;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class DispatchTouchEventFrameLayout
  extends FrameLayout
{
  private aiem a;
  
  public DispatchTouchEventFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public DispatchTouchEventFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DispatchTouchEventFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  
  public void setOnDispatchListener(aiem paramaiem)
  {
    this.a = paramaiem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.DispatchTouchEventFrameLayout
 * JD-Core Version:    0.7.0.1
 */
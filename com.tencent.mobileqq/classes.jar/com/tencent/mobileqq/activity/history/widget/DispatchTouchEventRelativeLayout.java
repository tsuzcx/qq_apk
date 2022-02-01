package com.tencent.mobileqq.activity.history.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class DispatchTouchEventRelativeLayout
  extends RelativeLayout
{
  private DispatchTouchEventRelativeLayout.OnDispatchListener a;
  
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
    DispatchTouchEventRelativeLayout.OnDispatchListener localOnDispatchListener = this.a;
    if (localOnDispatchListener != null) {
      localOnDispatchListener.a(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnDispatchListener(DispatchTouchEventRelativeLayout.OnDispatchListener paramOnDispatchListener)
  {
    this.a = paramOnDispatchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
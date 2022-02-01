package com.tencent.mobileqq.activity.history.widget;

import ajxa;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class DispatchTouchEventRelativeLayout
  extends RelativeLayout
{
  private ajxa a;
  
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
  
  public void setOnDispatchListener(ajxa paramajxa)
  {
    this.a = paramajxa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.widget.DispatchTouchEventRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
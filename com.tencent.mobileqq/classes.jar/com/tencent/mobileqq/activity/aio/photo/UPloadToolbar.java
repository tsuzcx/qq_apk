package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;

public class UPloadToolbar
  extends RelativeLayout
{
  public UPloadToolbar(Context paramContext)
  {
    super(paramContext);
  }
  
  public UPloadToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public UPloadToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    paramMotionEvent = getParent();
    if (paramMotionEvent != null) {
      paramMotionEvent.requestDisallowInterceptTouchEvent(true);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.UPloadToolbar
 * JD-Core Version:    0.7.0.1
 */
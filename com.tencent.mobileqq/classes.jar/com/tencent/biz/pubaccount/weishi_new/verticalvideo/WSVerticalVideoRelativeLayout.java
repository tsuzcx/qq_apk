package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import vor;

public class WSVerticalVideoRelativeLayout
  extends RelativeLayout
{
  private vor a;
  
  public WSVerticalVideoRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSVerticalVideoRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.a(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setDispatchTouchEventListener(vor paramvor)
  {
    this.a = paramvor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
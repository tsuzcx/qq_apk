package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class AETouchNotifyRelativeLayout
  extends RelativeLayout
{
  private AETouchNotifyRelativeLayout.IAETouchNotify a;
  
  public AETouchNotifyRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AETouchNotifyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AETouchNotifyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      AETouchNotifyRelativeLayout.IAETouchNotify localIAETouchNotify = this.a;
      if (localIAETouchNotify != null) {
        localIAETouchNotify.a(paramMotionEvent);
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setIaeTouchNotify(AETouchNotifyRelativeLayout.IAETouchNotify paramIAETouchNotify)
  {
    this.a = paramIAETouchNotify;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AETouchNotifyRelativeLayout
 * JD-Core Version:    0.7.0.1
 */
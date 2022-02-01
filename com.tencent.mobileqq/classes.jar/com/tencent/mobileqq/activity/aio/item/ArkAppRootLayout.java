package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;

public class ArkAppRootLayout
  extends RelativeLayout
{
  private boolean a = false;
  private GestureDetector b;
  private ArkAppRootLayout.ArkSearchReportCallback c;
  
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
    this.b = new GestureDetector(paramContext, new ArkAppRootLayout.1(this));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.b;
    if (localGestureDetector != null) {
      localGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a)
    {
      int i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setCallback(ArkAppRootLayout.ArkSearchReportCallback paramArkSearchReportCallback)
  {
    this.c = paramArkSearchReportCallback;
  }
  
  public void setDisableParentReturn(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout
 * JD-Core Version:    0.7.0.1
 */
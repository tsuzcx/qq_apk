package com.tencent.biz.pubaccount.weishi_new.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class WSTopEdgeGestureLayout
  extends TopGestureLayout
{
  private float a;
  private int b;
  private int c;
  private boolean d = true;
  
  public WSTopEdgeGestureLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WSTopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WSTopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.b = WeishiUIUtil.c();
    this.c = ViewConfiguration.getTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.d) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = paramMotionEvent.getX();
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      int i = getWidth();
      float f = this.a;
      if (((f < this.b) || (Math.abs(i - f) < this.b)) && (Math.abs(this.a - paramMotionEvent.getX()) > this.c)) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setIsIntercept(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.main.WSTopEdgeGestureLayout
 * JD-Core Version:    0.7.0.1
 */
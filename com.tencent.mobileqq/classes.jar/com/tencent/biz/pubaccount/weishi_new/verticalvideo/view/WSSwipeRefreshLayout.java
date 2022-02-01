package com.tencent.biz.pubaccount.weishi_new.verticalvideo.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class WSSwipeRefreshLayout
  extends SwipeRefreshLayout
{
  private WSSwipeRefreshLayout.OnInterceptTouchEventListener a;
  
  public WSSwipeRefreshLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSSwipeRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    ViewParent localViewParent = getParent();
    if ((this.a != null) && (this.a.a())) {}
    for (boolean bool = true;; bool = false)
    {
      localViewParent.requestDisallowInterceptTouchEvent(bool);
      if ((this.a == null) || (this.a.b())) {
        break;
      }
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setOnInterceptTouchEventListener(WSSwipeRefreshLayout.OnInterceptTouchEventListener paramOnInterceptTouchEventListener)
  {
    this.a = paramOnInterceptTouchEventListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.view.WSSwipeRefreshLayout
 * JD-Core Version:    0.7.0.1
 */
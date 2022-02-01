package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.view.MotionEvent;

public abstract interface CommonRefreshLayout$MiniAppScrollListener
{
  public abstract void onFlingScrollHeader(int paramInt1, int paramInt2);
  
  public abstract void onTouchMoving(CommonRefreshLayout paramCommonRefreshLayout, int paramInt, MotionEvent paramMotionEvent);
  
  public abstract int onViewCompleteAfterRefresh(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout.MiniAppScrollListener
 * JD-Core Version:    0.7.0.1
 */
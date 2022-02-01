package com.tencent.hippy.qq.view.tkd.listview;

import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.OnScrollFinishListener;

public abstract interface HippyTKDRefreshHeader$RefreshableCallback
{
  public abstract void completeRefresh(int paramInt);
  
  public abstract void completeRefresh(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, boolean paramBoolean, long paramLong, int paramInt6, Promise paramPromise, int paramInt7);
  
  public abstract int getHeight();
  
  public abstract int getOffsetY();
  
  public abstract boolean getOverScrollEnabled();
  
  public abstract int getTotalHeight();
  
  public abstract int getWidth();
  
  public abstract void onAboutToRefresh();
  
  public abstract void onRefresh();
  
  public abstract void onShowToast();
  
  public abstract void postDelayedDelegate(Runnable paramRunnable, long paramLong);
  
  public abstract void postInvalidate();
  
  public abstract void removeCallbacksDelegate(Runnable paramRunnable);
  
  public abstract void removeOnScrollFinishListener();
  
  public abstract void scrollBack(int paramInt1, RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener, int paramInt2);
  
  public abstract void scrollToShowHeader(int paramInt, RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener);
  
  public abstract void scrollToShowHeaderAtOnce(int paramInt);
  
  public abstract void scrollToShowHeaderSmooth(int paramInt);
  
  public abstract void scrollToTop(RecyclerViewBase.OnScrollFinishListener paramOnScrollFinishListener, int paramInt);
  
  public abstract void scrollToTopAtOnce();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.RefreshableCallback
 * JD-Core Version:    0.7.0.1
 */
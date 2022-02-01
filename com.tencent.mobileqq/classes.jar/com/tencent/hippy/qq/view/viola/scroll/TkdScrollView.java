package com.tencent.hippy.qq.view.viola.scroll;

import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.views.scroll.HippyScrollView;

public abstract interface TkdScrollView
  extends HippyScrollView
{
  public abstract void callLoadMoreFinish();
  
  public abstract void callScrollToPosition(int paramInt1, int paramInt2, Promise paramPromise);
  
  public abstract void callScrollToTop(boolean paramBoolean);
  
  public abstract void setPreloadDistance(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.viola.scroll.TkdScrollView
 * JD-Core Version:    0.7.0.1
 */
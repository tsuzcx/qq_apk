package com.tencent.biz.qqcircle.richframework.util.preloadview;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;

class LayoutPreLoader$ViewStubPreloadViewListener
  implements LayoutPreLoader.RequestPreloadViewListener
{
  private final ViewStub b;
  private final LayoutPreLoader.RequestPreloadViewListener c;
  
  LayoutPreLoader$ViewStubPreloadViewListener(LayoutPreLoader paramLayoutPreLoader, ViewStub paramViewStub, @NonNull LayoutPreLoader.RequestPreloadViewListener paramRequestPreloadViewListener)
  {
    this.b = paramViewStub;
    this.c = paramRequestPreloadViewListener;
  }
  
  public void onPreloadResult(View paramView)
  {
    LayoutPreLoader.a(this.a, this.b, paramView, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.util.preloadview.LayoutPreLoader.ViewStubPreloadViewListener
 * JD-Core Version:    0.7.0.1
 */
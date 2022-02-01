package com.tencent.ad.tangram.canvas.views.canvas.framework;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;

class AdCanvasPageView$1
  implements Runnable
{
  AdCanvasPageView$1(AdCanvasPageView paramAdCanvasPageView, View paramView, FrameLayout.LayoutParams paramLayoutParams) {}
  
  public void run()
  {
    if (this.val$view != null) {
      this.val$view.post(new AdCanvasPageView.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasPageView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;

class FrameHelperActivity$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FrameHelperActivity$2(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.c.getVisibility() == 0) && ((this.a.a() instanceof ReadinjoyTabFrame))) {
      this.a.c.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.kandian.biz.tab.api.IReadInJoyTabFrame;
import com.tencent.mobileqq.qroute.QRoute;

class FrameHelperActivity$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  FrameHelperActivity$2(FrameHelperActivity paramFrameHelperActivity) {}
  
  public void onGlobalLayout()
  {
    if ((this.a.af.getVisibility() == 0) && ((((IReadInJoyTabFrame)QRoute.api(IReadInJoyTabFrame.class)).isReadInJoyTabFrame(this.a.v())) || (this.a.w() == FrameControllerUtil.k))) {
      this.a.af.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.2
 * JD-Core Version:    0.7.0.1
 */
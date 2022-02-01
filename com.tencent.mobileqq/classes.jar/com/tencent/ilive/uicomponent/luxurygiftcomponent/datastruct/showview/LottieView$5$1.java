package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.util.Log;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.lottie.LottieAnimationViewInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

class LottieView$5$1
  implements Runnable
{
  public void run()
  {
    try
    {
      this.b.a.setComposition(this.a);
      if (!this.b.a.isShown())
      {
        LogInterface localLogInterface = LottieView.access$400(this.b.a).getLogger();
        String str = LottieView.access$200(this.b.a);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("play LottieView.this.isShown() ");
        localStringBuilder.append(this.b.a.isShown());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
        localLogInterface = LottieView.access$400(this.b.a).getLogger();
        str = LottieView.access$200(this.b.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play LottieView.this.getParent() ");
        localStringBuilder.append(this.b.a.getParent());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
        this.b.a.setVisibility(0);
        localLogInterface = LottieView.access$400(this.b.a).getLogger();
        str = LottieView.access$200(this.b.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play after visible LottieView.this.isShown() ");
        localStringBuilder.append(this.b.a.isShown());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
        localLogInterface = LottieView.access$400(this.b.a).getLogger();
        str = LottieView.access$200(this.b.a);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("play LottieView.this.getParent() ");
        localStringBuilder.append(this.b.a.getParent());
        localLogInterface.i(str, localStringBuilder.toString(), new Object[0]);
      }
      LottieView.access$900(this.b.a).playAnimation();
      return;
    }
    catch (Exception localException)
    {
      Log.getStackTraceString(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.5.1
 * JD-Core Version:    0.7.0.1
 */
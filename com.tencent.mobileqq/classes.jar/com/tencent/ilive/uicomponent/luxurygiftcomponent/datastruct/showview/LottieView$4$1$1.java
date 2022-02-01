package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.util.Log;
import com.airbnb.lottie.LottieComposition;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;

class LottieView$4$1$1
  implements Runnable
{
  LottieView$4$1$1(LottieView.4.1 param1, LottieComposition paramLottieComposition) {}
  
  public void run()
  {
    try
    {
      this.this$2.this$1.this$0.setComposition(this.val$lottieComposition);
      if (!this.this$2.this$1.this$0.isShown())
      {
        LottieView.access$400(this.this$2.this$1.this$0).getLogger().i(LottieView.access$200(this.this$2.this$1.this$0), "play LottieView.this.isShown() " + this.this$2.this$1.this$0.isShown(), new Object[0]);
        LottieView.access$400(this.this$2.this$1.this$0).getLogger().i(LottieView.access$200(this.this$2.this$1.this$0), "play LottieView.this.getParent() " + this.this$2.this$1.this$0.getParent(), new Object[0]);
        this.this$2.this$1.this$0.setVisibility(0);
        LottieView.access$400(this.this$2.this$1.this$0).getLogger().i(LottieView.access$200(this.this$2.this$1.this$0), "play after visible LottieView.this.isShown() " + this.this$2.this$1.this$0.isShown(), new Object[0]);
        LottieView.access$400(this.this$2.this$1.this$0).getLogger().i(LottieView.access$200(this.this$2.this$1.this$0), "play LottieView.this.getParent() " + this.this$2.this$1.this$0.getParent(), new Object[0]);
      }
      this.this$2.this$1.this$0.playAnimation();
      return;
    }
    catch (Exception localException)
    {
      Log.getStackTraceString(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.4.1.1
 * JD-Core Version:    0.7.0.1
 */
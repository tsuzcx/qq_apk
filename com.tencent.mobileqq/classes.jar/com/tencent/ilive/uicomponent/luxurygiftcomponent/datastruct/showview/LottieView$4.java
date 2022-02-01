package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import com.tencent.falco.base.libapi.lottie.LottieCompositionInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import java.io.InputStream;

class LottieView$4
  implements Runnable
{
  LottieView$4(LottieView paramLottieView) {}
  
  public void run()
  {
    InputStream localInputStream = LottieView.access$600(LottieView.access$500(this.this$0));
    if (localInputStream != null)
    {
      LottieView localLottieView = this.this$0;
      LottieView.access$702(localLottieView, LottieView.access$400(localLottieView).getLottieComposition().a(localInputStream, LottieView.access$800(this.this$0)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.4
 * JD-Core Version:    0.7.0.1
 */
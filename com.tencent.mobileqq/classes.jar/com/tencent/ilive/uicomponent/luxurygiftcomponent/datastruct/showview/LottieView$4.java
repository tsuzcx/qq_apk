package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import com.airbnb.lottie.LottieComposition.Factory;
import java.io.InputStream;

class LottieView$4
  implements Runnable
{
  LottieView$4(LottieView paramLottieView) {}
  
  public void run()
  {
    InputStream localInputStream = LottieView.access$600(LottieView.access$500(this.this$0));
    if (localInputStream != null) {
      LottieView.access$702(this.this$0, LottieComposition.Factory.fromInputStream(localInputStream, new LottieView.4.1(this)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.4
 * JD-Core Version:    0.7.0.1
 */
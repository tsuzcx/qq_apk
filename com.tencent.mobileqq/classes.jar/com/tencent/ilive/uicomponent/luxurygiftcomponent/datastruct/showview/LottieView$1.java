package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview;

import android.graphics.Bitmap;
import com.tencent.falco.base.libapi.lottie.LiveLottieApi.ImageAssetDelegate;
import com.tencent.falco.base.libapi.lottie.LiveLottieImageAsset;

class LottieView$1
  implements LiveLottieApi.ImageAssetDelegate
{
  LottieView$1(LottieView paramLottieView) {}
  
  public Bitmap fetchBitmap(LiveLottieImageAsset paramLiveLottieImageAsset)
  {
    LottieView localLottieView = this.this$0;
    return LottieView.access$000(localLottieView, localLottieView.getContext(), paramLiveLottieImageAsset);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.LottieView.1
 * JD-Core Version:    0.7.0.1
 */
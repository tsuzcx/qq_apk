package com.tencent.biz.pubaccount.weishi_new.live;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

final class WSLiveAnimation$3
  implements ImageAssetDelegate
{
  WSLiveAnimation$3(Bitmap paramBitmap1, Bitmap paramBitmap2) {}
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (TextUtils.equals(paramLottieImageAsset.getFileName(), "img_1.jpg")) {
      return WSLiveAnimation.a(this.a, 108, 108);
    }
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.live.WSLiveAnimation.3
 * JD-Core Version:    0.7.0.1
 */
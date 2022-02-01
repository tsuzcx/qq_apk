package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;

class PokeItemHelper$2$1
  implements ImageAssetDelegate
{
  PokeItemHelper$2$1(PokeItemHelper.2 param2) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    return (Bitmap)GlobalImageCache.a.get(paramLottieImageAsset.getKey());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PokeItemHelper.2.1
 * JD-Core Version:    0.7.0.1
 */
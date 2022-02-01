package com.tencent.mobileqq.activity.aio.anim.friendship.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class LottieAnimDirector$3
  implements ImageAssetDelegate
{
  LottieAnimDirector$3(LottieAnimDirector paramLottieAnimDirector) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = 320;
    try
    {
      paramLottieImageAsset = ImageUtil.a(LottieAnimDirector.a(this.a) + "images/" + paramLottieImageAsset.getFileName(), localOptions);
      return paramLottieImageAsset;
    }
    catch (Exception paramLottieImageAsset)
    {
      QLog.e("LottieAnimDirector", 1, "Delegate decode bitmap error");
      return null;
    }
    catch (OutOfMemoryError paramLottieImageAsset)
    {
      QLog.e("LottieAnimDirector", 1, "Delegate decode bitmap OOM");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.3
 * JD-Core Version:    0.7.0.1
 */
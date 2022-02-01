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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(LottieAnimDirector.a(this.a));
      localStringBuilder.append("images/");
      localStringBuilder.append(paramLottieImageAsset.getFileName());
      paramLottieImageAsset = ImageUtil.a(localStringBuilder.toString(), localOptions);
      return paramLottieImageAsset;
    }
    catch (Exception paramLottieImageAsset)
    {
      break label78;
    }
    catch (OutOfMemoryError paramLottieImageAsset)
    {
      label67:
      label78:
      label86:
      break label67;
    }
    QLog.e("LottieAnimDirector", 1, "Delegate decode bitmap OOM");
    break label86;
    QLog.e("LottieAnimDirector", 1, "Delegate decode bitmap error");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.friendship.impl.LottieAnimDirector.3
 * JD-Core Version:    0.7.0.1
 */
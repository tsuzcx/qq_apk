package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class LottieAnimation$2
  implements ImageAssetDelegate
{
  LottieAnimation$2(LottieAnimation paramLottieAnimation, String paramString) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject1;
    if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) == null) {
      localObject1 = null;
    }
    for (;;)
    {
      return localObject1;
      Object localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inScaled = true;
      ((BitmapFactory.Options)localObject2).inDensity = LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).getContext().getResources().getDisplayMetrics().densityDpi;
      try
      {
        String str = this.jdField_a_of_type_JavaLangString + File.separator + paramLottieImageAsset.getFileName();
        if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) != null)
        {
          paramLottieImageAsset = (Bitmap)LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).get(str);
          localObject1 = paramLottieImageAsset;
          if (paramLottieImageAsset != null) {
            continue;
          }
          try
          {
            localObject2 = BitmapFactory.decodeFile(str, (BitmapFactory.Options)localObject2);
            localObject1 = localObject2;
            paramLottieImageAsset = (LottieImageAsset)localObject2;
            if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) == null) {
              continue;
            }
            paramLottieImageAsset = (LottieImageAsset)localObject2;
            LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).put(str, localObject2);
            return localObject2;
          }
          catch (Exception localException1) {}
          if (QLog.isColorLevel()) {
            QLog.d("LottieAnimation", 2, "playNextAnim setImageAssetDelegate Exception");
          }
          localException1.printStackTrace();
          return paramLottieImageAsset;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramLottieImageAsset = null;
          continue;
          paramLottieImageAsset = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.LottieAnimation.2
 * JD-Core Version:    0.7.0.1
 */
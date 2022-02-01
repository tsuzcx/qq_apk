package com.tencent.mobileqq.activity.aio.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

class LottieAnimation$3
  implements ImageAssetDelegate
{
  LottieAnimation$3(LottieAnimation paramLottieAnimation, String paramString) {}
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    Object localObject1 = LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation);
    Object localObject2 = null;
    Object localObject4 = null;
    if (localObject1 == null) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inScaled = true;
    localOptions.inDensity = LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).getContext().getResources().getDisplayMetrics().densityDpi;
    localObject1 = localObject2;
    for (;;)
    {
      try
      {
        localObject5 = new StringBuilder();
        localObject1 = localObject2;
        ((StringBuilder)localObject5).append(this.jdField_a_of_type_JavaLangString);
        localObject1 = localObject2;
        ((StringBuilder)localObject5).append(File.separator);
        localObject1 = localObject2;
        ((StringBuilder)localObject5).append(paramLottieImageAsset.getFileName());
        localObject1 = localObject2;
        localObject5 = ((StringBuilder)localObject5).toString();
        paramLottieImageAsset = localObject4;
        localObject1 = localObject2;
        if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) != null)
        {
          localObject1 = localObject2;
          paramLottieImageAsset = (Bitmap)LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).get(localObject5);
        }
        if (paramLottieImageAsset != null) {
          return paramLottieImageAsset;
        }
        localObject1 = paramLottieImageAsset;
        try
        {
          localObject2 = BitmapFactory.decodeFile((String)localObject5, localOptions);
          paramLottieImageAsset = (LottieImageAsset)localObject2;
          localObject2 = paramLottieImageAsset;
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          localObject1 = paramLottieImageAsset;
          localOutOfMemoryError2.printStackTrace();
          localObject1 = paramLottieImageAsset;
          if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) < 10)
          {
            localObject1 = paramLottieImageAsset;
            localObject3 = new StringBuilder();
            localObject1 = paramLottieImageAsset;
            ((StringBuilder)localObject3).append("Lottie get bitmap oom. path = ");
            localObject1 = paramLottieImageAsset;
            ((StringBuilder)localObject3).append((String)localObject5);
            localObject1 = paramLottieImageAsset;
            QLog.e("LottieAnimation", 1, ((StringBuilder)localObject3).toString());
            localObject1 = paramLottieImageAsset;
            LottieAnimation.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation);
          }
          localObject1 = paramLottieImageAsset;
        }
      }
      catch (Exception paramLottieImageAsset)
      {
        Object localObject5;
        Object localObject3;
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim setImageAssetDelegate Exception");
        }
        paramLottieImageAsset.printStackTrace();
        paramLottieImageAsset = (LottieImageAsset)localObject1;
      }
      try
      {
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        localObject1 = paramLottieImageAsset;
        localObject3 = BitmapFactory.decodeFile((String)localObject5, localOptions);
        paramLottieImageAsset = (LottieImageAsset)localObject3;
      }
      catch (OutOfMemoryError localOutOfMemoryError1) {}
    }
    localObject3 = paramLottieImageAsset;
    localObject1 = paramLottieImageAsset;
    if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) < 10)
    {
      localObject1 = paramLottieImageAsset;
      localObject3 = new StringBuilder();
      localObject1 = paramLottieImageAsset;
      ((StringBuilder)localObject3).append("Lottie get bitmap RGB_565 oom. path = ");
      localObject1 = paramLottieImageAsset;
      ((StringBuilder)localObject3).append((String)localObject5);
      localObject1 = paramLottieImageAsset;
      QLog.e("LottieAnimation", 1, ((StringBuilder)localObject3).toString());
      localObject1 = paramLottieImageAsset;
      LottieAnimation.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation);
      localObject3 = paramLottieImageAsset;
    }
    if (localObject3 != null)
    {
      localObject1 = localObject3;
      paramLottieImageAsset = (LottieImageAsset)localObject3;
      if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) != null)
      {
        localObject1 = localObject3;
        LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).put(localObject5, localObject3);
        return localObject3;
      }
    }
    else
    {
      localObject1 = localObject3;
      paramLottieImageAsset = new StringBuilder();
      localObject1 = localObject3;
      paramLottieImageAsset.append("Lottie get bitmap is null, path = ");
      localObject1 = localObject3;
      paramLottieImageAsset.append((String)localObject5);
      localObject1 = localObject3;
      QLog.e("LottieAnimation", 1, paramLottieImageAsset.toString());
      return localObject3;
    }
    return paramLottieImageAsset;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.LottieAnimation.3
 * JD-Core Version:    0.7.0.1
 */
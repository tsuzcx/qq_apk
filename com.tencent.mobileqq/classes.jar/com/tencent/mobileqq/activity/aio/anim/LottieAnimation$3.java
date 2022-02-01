package com.tencent.mobileqq.activity.aio.anim;

import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

class LottieAnimation$3
  implements OnCompositionLoadedListener
{
  LottieAnimation$3(LottieAnimation paramLottieAnimation, FileInputStream paramFileInputStream) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation) == null) {
      if (QLog.isColorLevel()) {
        QLog.d("LottieAnimation", 2, "LottieComposition.Factory.fromInputStream mLottieView is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_JavaIoFileInputStream != null) {
          this.jdField_a_of_type_JavaIoFileInputStream.close();
        }
        if (paramLottieComposition != null)
        {
          LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).setComposition(paramLottieComposition);
          LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).loop(false);
          LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).setVisibility(0);
          LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).playAnimation();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream succ");
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
        }
        if (QLog.isColorLevel()) {
          QLog.d("LottieAnimation", 2, "playNextAnim fromInputStream composition null");
        }
        LottieAnimation.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation).clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimLottieAnimation.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.LottieAnimation.3
 * JD-Core Version:    0.7.0.1
 */
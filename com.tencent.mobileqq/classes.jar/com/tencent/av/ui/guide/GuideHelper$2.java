package com.tencent.av.ui.guide;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.dinifly.LottieDrawable;

class GuideHelper$2
  implements GuideHelper.LottieDrawableHelper.LottieDrawableLoadedListener
{
  GuideHelper$2(GuideHelper paramGuideHelper, long paramLong, Context paramContext, int paramInt) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = paramLottieDrawable;
    if ((paramLottieDrawable != null) && (this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramLottieDrawable);
      GuideHelper.a(this.jdField_a_of_type_ComTencentAvUiGuideGuideHelper, this.jdField_a_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.2
 * JD-Core Version:    0.7.0.1
 */
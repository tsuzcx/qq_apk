package com.tencent.av.ui.guide;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.qphone.base.util.QLog;

class GuideHelper$ViewInfo
{
  View jdField_a_of_type_AndroidViewView = null;
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  View b = null;
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.w("GuideHelper", 1, "show[" + paramBoolean + "]");
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        if (!paramBoolean) {
          break label113;
        }
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewViewStub != null) {
        this.jdField_a_of_type_AndroidViewViewStub.setVisibility(i);
      }
      if (this.b != null) {
        this.b.setVisibility(i);
      }
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(i);
      }
      return;
      i = 8;
      break;
      label113:
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.ViewInfo
 * JD-Core Version:    0.7.0.1
 */
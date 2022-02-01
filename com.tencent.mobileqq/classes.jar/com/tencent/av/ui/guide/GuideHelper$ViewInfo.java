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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show[");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("]");
    QLog.w("GuideHelper", 1, ((StringBuilder)localObject).toString());
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null) {
      if (paramBoolean)
      {
        ((LottieDrawable)localObject).pauseAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
      else
      {
        ((LottieDrawable)localObject).pauseAnimation();
      }
    }
    localObject = this.jdField_a_of_type_AndroidViewViewStub;
    if (localObject != null) {
      ((ViewStub)localObject).setVisibility(i);
    }
    localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(i);
    }
    localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.guide.GuideHelper.ViewInfo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.recent;

import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PollBanner
  implements Animation.AnimationListener
{
  private int jdField_a_of_type_Int;
  public Handler a;
  private BannerFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout;
  private List jdField_a_of_type_JavaUtilList;
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "onAnimationEnd");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.setAnimEnd(true);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 2)
    {
      paramAnimation = ((Banner)this.jdField_a_of_type_JavaUtilList.get((this.jdField_a_of_type_Int + 1) % i)).a;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.removeViewAt(i - 1);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.addView(paramAnimation);
        paramAnimation.setVisibility(8);
        ((Banner)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a.setVisibility(0);
      }
    }
    for (;;)
    {
      if (i > 0) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.removeViewAt(this.jdField_a_of_type_Int - 1);
      break;
      if (i > 0)
      {
        paramAnimation = ((Banner)this.jdField_a_of_type_JavaUtilList.get((this.jdField_a_of_type_Int + 1) % i)).a;
        ((Banner)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a.setVisibility(0);
        paramAnimation.setVisibility(8);
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "onAnimationStart");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerFrameLayout.setAnimEnd(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.PollBanner
 * JD-Core Version:    0.7.0.1
 */
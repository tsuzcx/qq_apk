package com.tencent.mobileqq.banner;

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
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private BannerFrameLayout jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout;
  private List<Banner> jdField_a_of_type_JavaUtilList;
  private Animation b;
  
  public void a()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "startAnim mBannerList = " + this.jdField_a_of_type_JavaUtilList + ", size = " + i);
    }
    if (i <= 1) {
      return;
    }
    Banner localBanner1 = (Banner)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int % i);
    Banner localBanner2 = (Banner)this.jdField_a_of_type_JavaUtilList.get((this.jdField_a_of_type_Int + 1) % i);
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.indexOfChild(localBanner1.a) == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.addView(localBanner1.a);
      localBanner1.a.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.indexOfChild(localBanner2.a) == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.addView(localBanner2.a);
      localBanner2.a.setVisibility(8);
    }
    localBanner1.a.startAnimation(this.b);
    localBanner2.a.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    int j = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = j;
    this.jdField_a_of_type_Int = (j % i);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PollBanner", 2, "onAnimationEnd");
    }
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.setAnimEnd(true);
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 2)
    {
      paramAnimation = ((Banner)this.jdField_a_of_type_JavaUtilList.get((this.jdField_a_of_type_Int + 1) % i)).a;
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.removeViewAt(i - 1);
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.addView(paramAnimation);
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
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.removeViewAt(this.jdField_a_of_type_Int - 1);
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
    this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.setAnimEnd(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.banner.PollBanner
 * JD-Core Version:    0.7.0.1
 */
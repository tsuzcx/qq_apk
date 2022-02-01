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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startAnim mBannerList = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilList);
      ((StringBuilder)localObject).append(", size = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("PollBanner", 2, ((StringBuilder)localObject).toString());
    }
    if (i <= 1) {
      return;
    }
    Object localObject = (Banner)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int % i);
    Banner localBanner = (Banner)this.jdField_a_of_type_JavaUtilList.get((this.jdField_a_of_type_Int + 1) % i);
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.indexOfChild(((Banner)localObject).a) == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.addView(((Banner)localObject).a);
      ((Banner)localObject).a.setVisibility(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.indexOfChild(localBanner.a) == -1)
    {
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.addView(localBanner.a);
      localBanner.a.setVisibility(8);
    }
    ((Banner)localObject).a.startAnimation(this.b);
    localBanner.a.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
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
      int j = this.jdField_a_of_type_Int;
      if (j == 0) {
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.removeViewAt(i - 1);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.removeViewAt(j - 1);
      }
      this.jdField_a_of_type_ComTencentMobileqqBannerBannerFrameLayout.addView(paramAnimation);
      paramAnimation.setVisibility(8);
      ((Banner)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a.setVisibility(0);
    }
    else if (i > 0)
    {
      paramAnimation = ((Banner)this.jdField_a_of_type_JavaUtilList.get((this.jdField_a_of_type_Int + 1) % i)).a;
      ((Banner)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).a.setVisibility(0);
      paramAnimation.setVisibility(8);
    }
    if (i > 0) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 3000L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.banner.PollBanner
 * JD-Core Version:    0.7.0.1
 */
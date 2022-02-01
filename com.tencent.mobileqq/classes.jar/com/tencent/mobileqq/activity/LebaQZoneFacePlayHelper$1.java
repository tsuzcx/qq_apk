package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class LebaQZoneFacePlayHelper$1
  implements Animation.AnimationListener
{
  LebaQZoneFacePlayHelper$1(LebaQZoneFacePlayHelper paramLebaQZoneFacePlayHelper, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_Boolean) && (LebaQZoneFacePlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper) != null) && (LebaQZoneFacePlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper).size() >= 2)) {
      LebaQZoneFacePlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper).sendEmptyMessageDelayed(1688002, 1400L);
    }
    if (LebaQZoneFacePlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper) != null)
    {
      LebaQZoneFacePlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper).a();
      LebaQZoneFacePlayHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityLebaQZoneFacePlayHelper, null);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaQZoneFacePlayHelper.1
 * JD-Core Version:    0.7.0.1
 */
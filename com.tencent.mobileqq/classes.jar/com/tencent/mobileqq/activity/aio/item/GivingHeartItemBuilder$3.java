package com.tencent.mobileqq.activity.aio.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ViewAnimation;

class GivingHeartItemBuilder$3
  extends AnimatorListenerAdapter
{
  GivingHeartItemBuilder$3(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    if (this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation != null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.mImageLayer = null;
      paramAnimator = ((ViewGroup)((Activity)this.a.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288);
      if (paramAnimator != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation.setDuration(this.a.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.getDuration());
        paramAnimator.startAnimation(this.a.jdField_a_of_type_ComTencentMobileqqDiniflyViewAnimation);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.helper;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;

class JdTipHelper$1
  implements Animation.AnimationListener
{
  JdTipHelper$1(JdTipHelper paramJdTipHelper) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    try
    {
      if ((this.a.jdField_b_of_type_AndroidViewAnimationAnimation != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramAnimation == this.a.jdField_a_of_type_AndroidViewAnimationAnimation))
      {
        paramAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772305);
        paramAnimation.setInterpolator(new LinearInterpolator());
        this.a.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367040));
        this.a.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131367041));
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.clearAnimation();
        this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(this.a.jdField_b_of_type_AndroidViewAnimationAnimation);
        this.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(paramAnimation);
        this.a.jdField_b_of_type_AndroidWidgetImageView.startAnimation(paramAnimation);
        return;
      }
      if ((paramAnimation == this.a.c) && (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout) != -1)) {
        this.a.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      return;
    }
    catch (Throwable paramAnimation) {}
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.JdTipHelper.1
 * JD-Core Version:    0.7.0.1
 */
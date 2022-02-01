package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class MiniMsgTabFragment$2$1
  implements Animation.AnimationListener
{
  MiniMsgTabFragment$2$1(MiniMsgTabFragment.2 param2, Activity paramActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$2.a.a.getCount() == 1) && (!MiniMsgTabFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$2.a)))
    {
      paramAnimation = MiniMsgTabFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$2.a);
      paramAnimation.putExtra("miniAppID", MiniMsgTabFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgTabFragment$2.a));
      paramAnimation.putExtra("clickID", -1);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramAnimation);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.2.1
 * JD-Core Version:    0.7.0.1
 */
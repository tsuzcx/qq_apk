package com.tencent.av.wtogether.fragment;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AVGroupFileSelectFragment$4
  implements Animation.AnimationListener
{
  AVGroupFileSelectFragment$4(AVGroupFileSelectFragment paramAVGroupFileSelectFragment, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).setAnimation(null);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).offsetTopAndBottom(this.jdField_a_of_type_Int);
    AVGroupFileSelectFragment.a(this.jdField_a_of_type_ComTencentAvWtogetherFragmentAVGroupFileSelectFragment).requestLayout();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.fragment.AVGroupFileSelectFragment.4
 * JD-Core Version:    0.7.0.1
 */
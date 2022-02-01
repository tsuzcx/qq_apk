package com.tencent.mobileqq.apollo.api.ui.impl;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class CmShowEmotionAdapter$5$1$1$1
  implements Animation.AnimationListener
{
  CmShowEmotionAdapter$5$1$1$1(CmShowEmotionAdapter.5.1.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.a.a.a.b.removeView(this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloLinearLayout$ViewHolder.a = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ui.impl.CmShowEmotionAdapter.5.1.1.1
 * JD-Core Version:    0.7.0.1
 */
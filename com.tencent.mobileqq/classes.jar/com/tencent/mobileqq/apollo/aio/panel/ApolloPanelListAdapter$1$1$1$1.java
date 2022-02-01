package com.tencent.mobileqq.apollo.aio.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

class ApolloPanelListAdapter$1$1$1$1
  implements Animation.AnimationListener
{
  ApolloPanelListAdapter$1$1$1$1(ApolloPanelListAdapter.1.1.1 param1) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.a.a.a.b.removeView(this.a.a.a.jdField_a_of_type_AndroidWidgetRelativeLayout);
    this.a.a.a.jdField_a_of_type_ComTencentMobileqqApolloViewApolloLinearLayout$ViewHolder.a = null;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelListAdapter.1.1.1.1
 * JD-Core Version:    0.7.0.1
 */
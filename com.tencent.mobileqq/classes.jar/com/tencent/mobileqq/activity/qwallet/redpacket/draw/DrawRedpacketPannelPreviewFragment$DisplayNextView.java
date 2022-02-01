package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;

final class DrawRedpacketPannelPreviewFragment$DisplayNextView
  implements Animation.AnimationListener
{
  private final View jdField_a_of_type_AndroidViewView;
  private final boolean jdField_a_of_type_Boolean;
  private final View b;
  
  private DrawRedpacketPannelPreviewFragment$DisplayNextView(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, boolean paramBoolean, View paramView1, View paramView2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.b = paramView2;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedpacketPannelPreviewFragment).post(new DrawRedpacketPannelPreviewFragment.SwapViews(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedpacketPannelPreviewFragment, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_AndroidViewView, this.b));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.DisplayNextView
 * JD-Core Version:    0.7.0.1
 */
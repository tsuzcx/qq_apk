package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.widget.LinearLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class WSTabLayout$3
  implements ValueAnimator.AnimatorUpdateListener
{
  WSTabLayout$3(WSTabLayout paramWSTabLayout, LinearLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = (int)(-WSTabLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout) * f);
    this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.topMargin = i;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout.3
 * JD-Core Version:    0.7.0.1
 */
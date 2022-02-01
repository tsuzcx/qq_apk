package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;

class SlideActiveAnimController$5
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideActiveAnimController$5(SlideActiveAnimController paramSlideActiveAnimController, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInjoySlideAnimLayout.a.setTranslationY(this.jdField_a_of_type_Float - paramValueAnimator.floatValue());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setTranslationY(-paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController.5
 * JD-Core Version:    0.7.0.1
 */
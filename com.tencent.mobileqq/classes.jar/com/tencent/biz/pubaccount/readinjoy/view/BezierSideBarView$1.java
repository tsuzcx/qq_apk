package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class BezierSideBarView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  BezierSideBarView$1(BezierSideBarView paramBezierSideBarView, ValueAnimator.AnimatorUpdateListener paramAnimatorUpdateListener) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    BezierSideBarView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewBezierSideBarView.invalidate();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener != null) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator$AnimatorUpdateListener.onAnimationUpdate(paramValueAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BezierSideBarView.1
 * JD-Core Version:    0.7.0.1
 */
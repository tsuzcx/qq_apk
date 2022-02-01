package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.TextView;

class CaptureOperateTouchLayout$IndicatorTouchListener$3
  implements ValueAnimator.AnimatorUpdateListener
{
  CaptureOperateTouchLayout$IndicatorTouchListener$3(CaptureOperateTouchLayout.IndicatorTouchListener paramIndicatorTouchListener, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setX(f);
    CaptureOperateTouchLayout.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewCaptureOperateTouchLayout$IndicatorTouchListener.a).setX(f + this.jdField_a_of_type_AndroidViewView.getWidth() * 0.32F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.CaptureOperateTouchLayout.IndicatorTouchListener.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.ViewGroup.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class VariableSizeTextView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  VariableSizeTextView$1(VariableSizeTextView paramVariableSizeTextView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (f == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.b)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setFocusable(true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setClickable(true);
    }
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((int)(f + 0.5F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView.1
 * JD-Core Version:    0.7.0.1
 */
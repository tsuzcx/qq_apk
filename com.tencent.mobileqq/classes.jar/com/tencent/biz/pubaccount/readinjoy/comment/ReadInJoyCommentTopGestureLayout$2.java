package com.tencent.biz.pubaccount.readinjoy.comment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class ReadInJoyCommentTopGestureLayout$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ReadInJoyCommentTopGestureLayout$2(ReadInJoyCommentTopGestureLayout paramReadInJoyCommentTopGestureLayout, ViewGroup.LayoutParams paramLayoutParams, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentTopGestureLayout.2
 * JD-Core Version:    0.7.0.1
 */
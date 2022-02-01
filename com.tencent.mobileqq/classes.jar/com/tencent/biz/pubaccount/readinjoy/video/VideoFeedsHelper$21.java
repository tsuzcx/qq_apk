package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

final class VideoFeedsHelper$21
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    localLayoutParams.width = (this.jdField_a_of_type_Int + paramValueAnimator.x);
    int i = this.b;
    localLayoutParams.height = (paramValueAnimator.y + i);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.21
 * JD-Core Version:    0.7.0.1
 */
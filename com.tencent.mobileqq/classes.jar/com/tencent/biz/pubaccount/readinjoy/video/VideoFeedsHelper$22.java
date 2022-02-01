package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.view.WindowManager;

final class VideoFeedsHelper$22
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((this.jdField_a_of_type_AndroidViewWindowManager == null) || (this.jdField_a_of_type_AndroidViewViewGroup == null)) {
      return;
    }
    paramValueAnimator = (Point)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = paramValueAnimator.y;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = paramValueAnimator.x;
    this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper.22
 * JD-Core Version:    0.7.0.1
 */
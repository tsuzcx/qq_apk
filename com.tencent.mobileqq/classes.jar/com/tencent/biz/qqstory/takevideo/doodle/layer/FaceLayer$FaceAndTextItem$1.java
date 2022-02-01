package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class FaceLayer$FaceAndTextItem$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FaceLayer$FaceAndTextItem$1(FaceLayer.FaceAndTextItem paramFaceAndTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.d = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem.1
 * JD-Core Version:    0.7.0.1
 */
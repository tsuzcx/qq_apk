package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class FaceLayer$FaceItem$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FaceLayer$FaceItem$1(FaceLayer.FaceItem paramFaceItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.K = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.z.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem.1
 * JD-Core Version:    0.7.0.1
 */
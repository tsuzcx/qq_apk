package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$3
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$3(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.K = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.m.u();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem.3
 * JD-Core Version:    0.7.0.1
 */
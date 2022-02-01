package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEEditorApplyAllLoadingView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorApplyAllLoadingView$2(AEEditorApplyAllLoadingView paramAEEditorApplyAllLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorApplyAllLoadingView.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

class AEEditorApplyAllLoadingView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AEEditorApplyAllLoadingView$1(AEEditorApplyAllLoadingView paramAEEditorApplyAllLoadingView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = paramValueAnimator.getAnimatedFraction();
    int i = (int)(AEEditorApplyAllLoadingView.a(this.a, f) * -90.0F + 90.0F);
    AEEditorApplyAllLoadingView.a(this.a).setPadding(0, i, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorApplyAllLoadingView.1
 * JD-Core Version:    0.7.0.1
 */
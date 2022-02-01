package com.tencent.aelight.camera.ae.play;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;

class EditTextViewer$2
  implements ValueAnimator.AnimatorUpdateListener
{
  EditTextViewer$2(EditTextViewer paramEditTextViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    EditTextViewer.access$000(this.this$0).setAlpha(i);
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.EditTextViewer.2
 * JD-Core Version:    0.7.0.1
 */
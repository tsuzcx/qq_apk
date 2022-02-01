package com.tencent.aelight.camera.aeeditor.module.text;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;

class AEEditorTextControlPanel$7
  implements Runnable
{
  AEEditorTextControlPanel$7(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void run()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(AEEditorTextControlPanel.h(this.this$0), "translationY", new float[] { 150.0F, 0.0F });
    localObjectAnimator.addListener(new AEEditorTextControlPanel.7.1(this));
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.setDuration(350L);
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.text.AEEditorTextControlPanel.7
 * JD-Core Version:    0.7.0.1
 */
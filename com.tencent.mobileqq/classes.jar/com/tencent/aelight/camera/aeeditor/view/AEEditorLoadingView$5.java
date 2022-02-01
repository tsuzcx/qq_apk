package com.tencent.aelight.camera.aeeditor.view;

import android.animation.Animator;
import android.widget.RelativeLayout;

class AEEditorLoadingView$5
  extends AEEditorLoadingView.SimpleAnimatorListener
{
  AEEditorLoadingView$5(AEEditorLoadingView paramAEEditorLoadingView)
  {
    super(null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.a();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEEditorLoadingView.c(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView.5
 * JD-Core Version:    0.7.0.1
 */
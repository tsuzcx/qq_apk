package com.tencent.aelight.camera.aeeditor.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;

class AEEditorLoadingView$7
  extends AEEditorLoadingView.SimpleAnimatorListener
{
  AEEditorLoadingView$7(AEEditorLoadingView paramAEEditorLoadingView, AnimatorSet paramAnimatorSet)
  {
    super(null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEEditorLoadingView.d(this.b).g().a(new AEEditorLoadingView.7.1(this));
    AEEditorLoadingView.e(this.b).g().a(new AEEditorLoadingView.7.2(this));
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView.7
 * JD-Core Version:    0.7.0.1
 */
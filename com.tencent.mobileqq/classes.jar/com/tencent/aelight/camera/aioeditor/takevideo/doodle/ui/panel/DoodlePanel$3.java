package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;

class DoodlePanel$3
  extends AnimatorListenerAdapter
{
  public void onAnimationStart(Animator paramAnimator)
  {
    DoodlePanel.a(this.a).setAlpha(0.0F);
    DoodlePanel.a(this.a).setVisibility(0);
    DoodlePanel.a(this.a).setTranslationY(DoodlePanel.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.3
 * JD-Core Version:    0.7.0.1
 */
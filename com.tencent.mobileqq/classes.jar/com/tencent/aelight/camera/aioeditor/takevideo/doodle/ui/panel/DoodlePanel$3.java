package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.DoodleColorAndModeView;

class DoodlePanel$3
  extends AnimatorListenerAdapter
{
  DoodlePanel$3(DoodlePanel paramDoodlePanel) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    DoodlePanel.b(this.a).setAlpha(0.0F);
    DoodlePanel.b(this.a).setVisibility(0);
    DoodlePanel.b(this.a).setTranslationY(DoodlePanel.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.panel.DoodlePanel.3
 * JD-Core Version:    0.7.0.1
 */
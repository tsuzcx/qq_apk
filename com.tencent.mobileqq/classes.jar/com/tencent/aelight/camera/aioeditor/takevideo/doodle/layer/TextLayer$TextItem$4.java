package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;

class TextLayer$TextItem$4
  extends AnimatorListenerAdapter
{
  TextLayer$TextItem$4(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator end!");
    paramAnimator = this.a;
    paramAnimator.K = 1.0F;
    paramAnimator.J = false;
    paramAnimator.m.u();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator start!");
    this.a.J = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem.4
 * JD-Core Version:    0.7.0.1
 */
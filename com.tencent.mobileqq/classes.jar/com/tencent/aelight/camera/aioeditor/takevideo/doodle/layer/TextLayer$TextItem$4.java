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
    paramAnimator.p = 1.0F;
    paramAnimator.e = false;
    paramAnimator.a.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b(TextLayer.a, "scaleAnimator start!");
    this.a.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem.4
 * JD-Core Version:    0.7.0.1
 */
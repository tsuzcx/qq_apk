package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;

class TextLayer$TextItem$3
  extends AnimatorListenerAdapter
{
  TextLayer$TextItem$3(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SLog.b("TextLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b("TextLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.a.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b("TextLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem.3
 * JD-Core Version:    0.7.0.1
 */
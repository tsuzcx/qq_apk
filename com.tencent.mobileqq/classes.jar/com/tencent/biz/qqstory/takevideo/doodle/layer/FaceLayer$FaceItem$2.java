package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;

class FaceLayer$FaceItem$2
  extends AnimatorListenerAdapter
{
  FaceLayer$FaceItem$2(FaceLayer.FaceItem paramFaceItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SLog.b("FaceLayer", "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b("FaceLayer", "scaleAnimator end!");
    this.a.p = 1.0F;
    this.a.c = false;
    this.a.b.g();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b("FaceLayer", "scaleAnimator start!");
    this.a.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem.2
 * JD-Core Version:    0.7.0.1
 */
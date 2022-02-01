package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;

class FaceLayer$FaceItem$2
  extends AnimatorListenerAdapter
{
  FaceLayer$FaceItem$2(FaceLayer.FaceItem paramFaceItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    SLog.b(FaceLayer.a, "scaleAnimator cancel!");
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b(FaceLayer.a, "scaleAnimator end!");
    paramAnimator = this.a;
    paramAnimator.p = 1.0F;
    paramAnimator.e = false;
    paramAnimator.b.k();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b(FaceLayer.a, "scaleAnimator start!");
    this.a.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem.2
 * JD-Core Version:    0.7.0.1
 */
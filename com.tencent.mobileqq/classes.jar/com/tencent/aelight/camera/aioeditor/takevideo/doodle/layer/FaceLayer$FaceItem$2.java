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
    paramAnimator.K = 1.0F;
    paramAnimator.J = false;
    paramAnimator.z.u();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    SLog.b(FaceLayer.a, "scaleAnimator start!");
    this.a.J = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem.2
 * JD-Core Version:    0.7.0.1
 */
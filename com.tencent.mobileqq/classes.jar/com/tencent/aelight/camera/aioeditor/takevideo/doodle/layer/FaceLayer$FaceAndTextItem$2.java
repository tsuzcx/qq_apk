package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class FaceLayer$FaceAndTextItem$2
  extends D8SafeAnimatorListener
{
  FaceLayer$FaceAndTextItem$2(FaceLayer.FaceAndTextItem paramFaceAndTextItem) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.j = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.j = false;
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    this.a.j = true;
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.j = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceAndTextItem.2
 * JD-Core Version:    0.7.0.1
 */
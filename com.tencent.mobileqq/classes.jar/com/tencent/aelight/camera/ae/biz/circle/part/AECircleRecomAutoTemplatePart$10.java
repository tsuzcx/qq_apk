package com.tencent.aelight.camera.ae.biz.circle.part;

import android.animation.Animator;
import android.view.ViewGroup;
import com.tencent.aelight.camera.ae.view.scrollingheader.ScrollingHeaderLayout;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AECircleRecomAutoTemplatePart$10
  extends D8SafeAnimatorListener
{
  AECircleRecomAutoTemplatePart$10(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ((ViewGroup)AECircleRecomAutoTemplatePart.g(this.a).getParent()).removeViewAt(0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart.10
 * JD-Core Version:    0.7.0.1
 */
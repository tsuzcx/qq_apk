package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.Animator;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class QIMProviderContainerView$2
  extends D8SafeAnimatorListener
{
  QIMProviderContainerView$2(QIMProviderContainerView paramQIMProviderContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.c.setVisibility(0);
    QIMProviderContainerView.a(this.a, true);
    QIMProviderContainerView.a(this.a);
    if (QLog.isColorLevel())
    {
      paramAnimator = new StringBuilder();
      paramAnimator.append("panelOpened : ");
      paramAnimator.append(QIMProviderContainerView.a(this.a));
      QLog.d("ProviderContainerView", 2, paramAnimator.toString());
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.2
 * JD-Core Version:    0.7.0.1
 */
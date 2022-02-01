package com.tencent.av.ui;

import android.animation.Animator;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.QavMuteButtonForeGroundDrawable;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class QavPanel$5
  extends D8SafeAnimatorListener
{
  QavPanel$5(QavPanel paramQavPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QavPanel.a(this.a))
    {
      paramAnimator = this.a.U.b().k();
      paramAnimator.a("tryPlayBtnMuteAnimation onAnimationEnd", true);
      paramAnimator.c("tryPlayBtnMuteAnimation onAnimationEnd", 1);
      this.a.a("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
      return;
    }
    this.a.U.b().c("tryPlayBtnMuteAnimation onAnimationEnd", 1);
    this.a.a("tryPlayBtnMuteAnimation onAnimationEnd", 2, 1, false);
    QavPanel.b(this.a).a(false, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QavPanel.c(this.a).a(false);
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPanel.5
 * JD-Core Version:    0.7.0.1
 */
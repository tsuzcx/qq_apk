package com.tencent.gdtad.views.canvas.components.danmaku;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class GdtDanmakuPresenter$1
  implements Animator.AnimatorListener
{
  GdtDanmakuPresenter$1(GdtDanmakuPresenter paramGdtDanmakuPresenter, GdtDanmakuItemView paramGdtDanmakuItemView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    GdtDanmakuPresenter.a(this.b, this.a);
    this.b.removeView(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.danmaku.GdtDanmakuPresenter.1
 * JD-Core Version:    0.7.0.1
 */
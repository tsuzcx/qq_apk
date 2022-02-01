package com.tencent.av.ui;

import android.animation.Animator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class QavDoubleVideoSharpnessMangaer$3
  extends D8SafeAnimatorListener
{
  QavDoubleVideoSharpnessMangaer$3(QavDoubleVideoSharpnessMangaer paramQavDoubleVideoSharpnessMangaer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QavDoubleVideoSharpnessMangaer.a(this.a).setAlpha(0.0F);
    QavDoubleVideoSharpnessMangaer.a(this.a).setVisibility(0);
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;

class QavDoubleVideoSharpnessMangaer$3
  implements Animator.AnimatorListener
{
  QavDoubleVideoSharpnessMangaer$3(QavDoubleVideoSharpnessMangaer paramQavDoubleVideoSharpnessMangaer) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator) {}
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    QavDoubleVideoSharpnessMangaer.a(this.a).setAlpha(0.0F);
    QavDoubleVideoSharpnessMangaer.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.QavDoubleVideoSharpnessMangaer.3
 * JD-Core Version:    0.7.0.1
 */
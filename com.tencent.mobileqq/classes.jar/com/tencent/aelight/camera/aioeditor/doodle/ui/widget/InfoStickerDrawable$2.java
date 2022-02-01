package com.tencent.aelight.camera.aioeditor.doodle.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class InfoStickerDrawable$2
  implements Animator.AnimatorListener
{
  InfoStickerDrawable$2(InfoStickerDrawable paramInfoStickerDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (InfoStickerDrawable.a(this.a) != null) {
      InfoStickerDrawable.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable.2
 * JD-Core Version:    0.7.0.1
 */
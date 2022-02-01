package com.tencent.biz.qqcircle.immersive.personal.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;

class QFSPersonalTitleBarPart$8
  extends AnimatorListenerAdapter
{
  QFSPersonalTitleBarPart$8(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart) {}
  
  @RequiresApi(api=16)
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    QFSPersonalTitleBarPart.e(this.a).setAlpha(1.0F);
    QFSPersonalTitleBarPart.e(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.widget.ImageView;

class ReadInJoyLikeButton$1
  implements Animator.AnimatorListener
{
  ReadInJoyLikeButton$1(ReadInJoyLikeButton paramReadInJoyLikeButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ReadInJoyLikeButton.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyLikeButton.a(this.a).setSelected(this.a.isSelected());
    ReadInJoyLikeButton.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyLikeButton.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton.1
 * JD-Core Version:    0.7.0.1
 */
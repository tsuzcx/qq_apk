package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.ImageView;

class ReadInJoyLikeButton$2
  implements Animator.AnimatorListener
{
  ReadInJoyLikeButton$2(ReadInJoyLikeButton paramReadInJoyLikeButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ReadInJoyLikeButton.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyLikeButton.a(this.a, false);
    ReadInJoyLikeButton.a(this.a).setSelected(this.a.isSelected());
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoyLikeButton.2
 * JD-Core Version:    0.7.0.1
 */
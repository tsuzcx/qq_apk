package com.tencent.mobileqq.avatar.dynamicavatar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class SelectCoverActivity$7
  extends AnimatorListenerAdapter
{
  SelectCoverActivity$7(SelectCoverActivity paramSelectCoverActivity, View paramView1, View paramView2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setAlpha(1.0F);
    this.b.setVisibility(8);
    this.c.o = null;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setAlpha(1.0F);
    this.b.setVisibility(8);
    this.c.o = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity.7
 * JD-Core Version:    0.7.0.1
 */
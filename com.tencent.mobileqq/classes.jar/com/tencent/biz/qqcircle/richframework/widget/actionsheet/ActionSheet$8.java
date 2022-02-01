package com.tencent.biz.qqcircle.richframework.widget.actionsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ActionSheet$8
  extends AnimatorListenerAdapter
{
  ActionSheet$8(ActionSheet paramActionSheet) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    this.a.h();
    ActionSheet.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet.8
 * JD-Core Version:    0.7.0.1
 */
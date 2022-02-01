package com.tencent.mobileqq.activity.aio.rebuild;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import android.widget.ImageView;

class ConfessChatPie$3$1$1
  implements Animator.AnimatorListener
{
  ConfessChatPie$3$1$1(ConfessChatPie.3.1 param1) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (ConfessChatPie.a(this.a.a.this$0) != null) {
      ConfessChatPie.a(this.a.a.this$0).setVisibility(0);
    }
    if (ConfessChatPie.a(this.a.a.this$0) != null) {
      ConfessChatPie.a(this.a.a.this$0).setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.ConfessChatPie.3.1.1
 * JD-Core Version:    0.7.0.1
 */
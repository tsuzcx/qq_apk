package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;

class DiscussionMemberActivity$1
  implements Animation.AnimationListener
{
  DiscussionMemberActivity$1(DiscussionMemberActivity paramDiscussionMemberActivity, TranslateAnimation paramTranslateAnimation1, Dialog paramDialog, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.a)
    {
      this.b.show();
      this.e.c.setAnimation(null);
      DiscussionMemberActivity.a(this.e).setVisibility(8);
      return;
    }
    if (paramAnimation == this.c)
    {
      this.e.c.setAnimation(null);
      this.e.c.offsetTopAndBottom(this.d);
      this.e.c.requestLayout();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.1
 * JD-Core Version:    0.7.0.1
 */
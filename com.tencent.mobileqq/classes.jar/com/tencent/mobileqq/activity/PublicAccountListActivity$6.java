package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

class PublicAccountListActivity$6
  implements Animation.AnimationListener
{
  PublicAccountListActivity$6(PublicAccountListActivity paramPublicAccountListActivity, TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.a)
    {
      this.d.t.show();
      this.d.b.setAnimation(null);
      this.d.c.setVisibility(8);
      return;
    }
    if (paramAnimation == this.b)
    {
      this.d.b.setAnimation(null);
      this.d.b.offsetTopAndBottom(this.c);
      this.d.b.requestLayout();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicAccountListActivity.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

class TroopMemberListActivity$30
  implements Animation.AnimationListener
{
  TroopMemberListActivity$30(TroopMemberListActivity paramTroopMemberListActivity, TranslateAnimation paramTranslateAnimation1, TranslateAnimation paramTranslateAnimation2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.a)
    {
      this.d.mSearchDialog.show();
      this.d.mRootView.setAnimation(null);
      this.d.mTitleBar.setVisibility(8);
      return;
    }
    if (paramAnimation == this.b)
    {
      this.d.mRootView.setAnimation(null);
      this.d.mRootView.offsetTopAndBottom(this.c);
      this.d.mRootView.requestLayout();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.30
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.weishi_new.follow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class WSFollowTabMuteGuideController$2
  extends AnimatorListenerAdapter
{
  WSFollowTabMuteGuideController$2(WSFollowTabMuteGuideController paramWSFollowTabMuteGuideController) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSFollowTabMuteGuideController.b(this.a).setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.follow.WSFollowTabMuteGuideController.2
 * JD-Core Version:    0.7.0.1
 */
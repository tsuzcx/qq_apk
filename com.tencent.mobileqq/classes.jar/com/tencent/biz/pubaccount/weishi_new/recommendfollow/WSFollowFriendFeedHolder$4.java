package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;

class WSFollowFriendFeedHolder$4
  implements Animator.AnimatorListener
{
  WSFollowFriendFeedHolder$4(WSFollowFriendFeedHolder paramWSFollowFriendFeedHolder) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    WSFollowFriendFeedHolder.b(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSFollowFriendFeedHolder.c(this.a);
    WSFollowFriendFeedHolder.b(this.a).setVisibility(8);
    WSFollowFriendFeedHolder.b(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.weishi_new.recommendfollow;

import android.animation.Animator;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class WSFollowFriendFeedHolder$4
  extends D8SafeAnimatorListener
{
  WSFollowFriendFeedHolder$4(WSFollowFriendFeedHolder paramWSFollowFriendFeedHolder) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    WSFollowFriendFeedHolder.j(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSFollowFriendFeedHolder.i(this.a);
    WSFollowFriendFeedHolder.j(this.a).setVisibility(8);
    WSFollowFriendFeedHolder.j(this.a).removeAnimatorListener(this);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommendfollow.WSFollowFriendFeedHolder.4
 * JD-Core Version:    0.7.0.1
 */
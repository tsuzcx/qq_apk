package com.tencent.biz.pubaccount.weishi_new.like;

import android.animation.Animator;
import android.view.ViewGroup;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import java.util.List;

class WSDoubleLikeAnimation$1
  extends D8SafeAnimatorListener
{
  WSDoubleLikeAnimation$1(WSDoubleLikeAnimation paramWSDoubleLikeAnimation, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSDoubleLikeAnimation.a(this.b).removeView(this.a);
    this.a.removeAnimatorListener(this);
    WSDoubleLikeAnimation.b(this.b).remove(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSDoubleLikeAnimation.1
 * JD-Core Version:    0.7.0.1
 */
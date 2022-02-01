package com.tencent.biz.pubaccount.weishi_new.like;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import java.util.List;

class WSDoubleLikeAnimation$1
  implements Animator.AnimatorListener
{
  WSDoubleLikeAnimation$1(WSDoubleLikeAnimation paramWSDoubleLikeAnimation, DiniFlyAnimationView paramDiniFlyAnimationView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    WSDoubleLikeAnimation.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSDoubleLikeAnimation).removeView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.removeAnimatorListener(this);
    WSDoubleLikeAnimation.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newLikeWSDoubleLikeAnimation).remove(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.like.WSDoubleLikeAnimation.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class ReadInJoySocializeRecommendFollowView$8
  implements Animator.AnimatorListener
{
  ReadInJoySocializeRecommendFollowView$8(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView).isShowRecommendList = false;
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.8
 * JD-Core Version:    0.7.0.1
 */
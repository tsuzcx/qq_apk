package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WSVerticalItemWidgetAdvBigCardController$2
  extends AnimatorListenerAdapter
{
  private boolean jdField_a_of_type_Boolean = false;
  
  WSVerticalItemWidgetAdvBigCardController$2(WSVerticalItemWidgetAdvBigCardController paramWSVerticalItemWidgetAdvBigCardController, int paramInt1, int paramInt2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = new StringBuilder();
    paramAnimator.append("ease-out onAnimationEnd, from:");
    paramAnimator.append(this.jdField_a_of_type_Int);
    paramAnimator.append(" to:");
    paramAnimator.append(this.b);
    paramAnimator.append(", isCancel:");
    paramAnimator.append(this.jdField_a_of_type_Boolean);
    WSLog.a("WSAdvBigCardController", paramAnimator.toString());
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController);
    if (WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController) != null) {
      WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAdvBigCardController.2
 * JD-Core Version:    0.7.0.1
 */
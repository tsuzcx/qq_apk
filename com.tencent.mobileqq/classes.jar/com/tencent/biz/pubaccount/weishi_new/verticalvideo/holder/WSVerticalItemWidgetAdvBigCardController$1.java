package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSBigCardCommercialInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

class WSVerticalItemWidgetAdvBigCardController$1
  extends AnimatorListenerAdapter
{
  WSVerticalItemWidgetAdvBigCardController$1(WSVerticalItemWidgetAdvBigCardController paramWSVerticalItemWidgetAdvBigCardController, int paramInt1, int paramInt2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController;
    WSVerticalItemWidgetAdvBigCardController.a(paramAnimator, WSVerticalItemWidgetAdvBigCardController.a(paramAnimator).c());
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = new StringBuilder();
    paramAnimator.append("ease-in onAnimationStart, from:");
    paramAnimator.append(this.jdField_a_of_type_Int);
    paramAnimator.append(" to:");
    paramAnimator.append(this.b);
    WSLog.a("WSAdvBigCardController", paramAnimator.toString());
    WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController).setVisibility(0);
    if (WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController) != null) {
      WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController).a();
    }
    WSVerticalBeaconReport.a(WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController).a(), WSVerticalItemWidgetAdvBigCardController.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController).b(), (WSVerticalItemData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoHolderWSVerticalItemWidgetAdvBigCardController.a(), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAdvBigCardController.1
 * JD-Core Version:    0.7.0.1
 */
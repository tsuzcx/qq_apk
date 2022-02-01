package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RIJSkinOperationPopupStep$3
  implements View.OnClickListener
{
  RIJSkinOperationPopupStep$3(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep, FrameLayout paramFrameLayout, int paramInt, QQAppInterface paramQQAppInterface) {}
  
  public void onClick(View paramView)
  {
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep));
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep, null);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == this.jdField_a_of_type_Int) {
      SharedPreUtils.s(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.3
 * JD-Core Version:    0.7.0.1
 */
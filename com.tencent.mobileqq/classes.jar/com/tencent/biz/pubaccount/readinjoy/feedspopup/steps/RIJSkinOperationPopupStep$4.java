package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.skin.GuideData;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.RefreshData;
import com.tencent.biz.pubaccount.readinjoy.skin.SkinData;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

class RIJSkinOperationPopupStep$4
  implements View.OnClickListener
{
  RIJSkinOperationPopupStep$4(RIJSkinOperationPopupStep paramRIJSkinOperationPopupStep, QQAppInterface paramQQAppInterface, FrameLayout paramFrameLayout, GuideData paramGuideData) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ReadInJoyRefreshManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
    if (((ReadInJoyRefreshManager)localObject).a() == 1)
    {
      ((ReadInJoyRefreshManager)localObject).a(false);
      localObject = ((ReadInJoyRefreshManager)localObject).a(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep), 0);
      if (localObject != null)
      {
        ((RefreshData)localObject).isShown = false;
        SharedPreUtils.f(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((RefreshData)localObject).toJson().toString(), 0);
      }
    }
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep).a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep));
    RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep, null);
    SharedPreUtils.s(RIJSkinOperationPopupStep.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFeedspopupStepsRIJSkinOperationPopupStep), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.toJson().toString());
    if (QLog.isColorLevel()) {
      QLog.d("RIJSkinOperationPopupStep", 2, "set skin: id = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoySkinGuideData.skinData.id);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJSkinOperationPopupStep.4
 * JD-Core Version:    0.7.0.1
 */
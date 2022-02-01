package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.view.View;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcshopReportHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class EqqAccountDetailActivityImpl$16
  implements ActionSheet.OnButtonClickListener
{
  EqqAccountDetailActivityImpl$16(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, ActionSheet paramActionSheet, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.messageSettingActionSheetHasClick) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl;
    paramView.messageSettingActionSheetHasClick = true;
    IPublicAccountConfigAttr.PaConfigInfo localPaConfigInfo = this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountConfigAttr$PaConfigInfo;
    int i = paramInt + 1;
    paramView.changeMsgState(localPaConfigInfo, i);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if ((((EcShopAssistantManager)this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin)) && (this.jdField_a_of_type_Int != paramInt)) {
      ((EcshopReportHandler)this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243867, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplEqqAccountDetailActivityImpl.uin, null, null, null, i, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.16
 * JD-Core Version:    0.7.0.1
 */
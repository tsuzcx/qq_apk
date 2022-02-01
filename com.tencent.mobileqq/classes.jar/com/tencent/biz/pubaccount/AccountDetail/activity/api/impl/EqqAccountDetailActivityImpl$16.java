package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.view.View;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
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
  EqqAccountDetailActivityImpl$16(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl, PaConfigAttr.PaConfigInfo paramPaConfigInfo, ActionSheet paramActionSheet, int paramInt) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.messageSettingActionSheetHasClick) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.messageSettingActionSheetHasClick = true;
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.changeMsgState(this.jdField_a_of_type_ComTencentBizPubaccountPaConfigAttr$PaConfigInfo, paramInt + 1);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    } while ((!((EcShopAssistantManager)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.app.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin)) || (this.jdField_a_of_type_Int == paramInt));
    ((EcshopReportHandler)this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a(134243867, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivityApiImplEqqAccountDetailActivityImpl.uin, null, null, null, paramInt + 1, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.16
 * JD-Core Version:    0.7.0.1
 */
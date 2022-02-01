package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountDetailGroupListContainer$14
  implements ActionSheet.OnButtonClickListener
{
  AccountDetailGroupListContainer$14(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.f) {
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer;
    int j = 1;
    paramView.f = true;
    int i;
    if (paramInt + 1 == 1)
    {
      i = j;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
    else
    {
      j = 3;
      i = j;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new AccountDetailGroupListContainer.14.1(this, i));
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
    PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.name, paramInt);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.14
 * JD-Core Version:    0.7.0.1
 */
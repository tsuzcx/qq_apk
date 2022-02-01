package com.tencent.biz.pubaccount.AccountDetail.view;

import android.view.View;
import com.tencent.biz.pubaccount.PaConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountDetailGroupListContainer$14
  implements ActionSheet.OnButtonClickListener
{
  AccountDetailGroupListContainer$14(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, PaConfigAttr.PaConfigInfo paramPaConfigInfo, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = 1;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.f) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.f = true;
    if (paramInt + 1 == 1)
    {
      if (!AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString)) {
        break label229;
      }
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
      i = 1;
    }
    label229:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver = new NewPublicAccountObserver(new AccountDetailGroupListContainer.14.1(this, i));
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppletsNewPublicAccountObserver);
      PublicAccountStateReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name, paramInt);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
      int j = 3;
      i = j;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.14
 * JD-Core Version:    0.7.0.1
 */
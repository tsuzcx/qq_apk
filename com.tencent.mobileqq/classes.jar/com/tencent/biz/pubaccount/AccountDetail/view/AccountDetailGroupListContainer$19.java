package com.tencent.biz.pubaccount.AccountDetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountDetailGroupListContainer$19
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$19(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, int paramInt) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.d)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.e = true;
      if (this.jdField_a_of_type_Int == 0)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_num", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
        str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "jumpTo:" + str);
      }
      AccountDetailGroupListContainer.c(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer, str);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString;
      continue;
      ReportController.b(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin);
      str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=" + this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer.19
 * JD-Core Version:    0.7.0.1
 */
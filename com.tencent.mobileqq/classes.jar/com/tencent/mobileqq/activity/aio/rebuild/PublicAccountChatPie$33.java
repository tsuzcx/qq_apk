package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.ui.CustomMenuBar;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublicAccountChatPie$33
  implements View.OnClickListener
{
  PublicAccountChatPie$33(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.o = true;
    this.a.jdField_a_of_type_ComTencentBizUiCustomMenuBar.setVisibility(8);
    if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    }
    if (this.a.g != null) {
      this.a.g.setVisibility(0);
    }
    if (this.a.h != null) {
      this.a.h.setVisibility(0);
    }
    this.a.aw();
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountManager.getPublicAccountMenuType(this.a.b()) != 0) {
      ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005EC5", "0X8005EC5", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.33
 * JD-Core Version:    0.7.0.1
 */
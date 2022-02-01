package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PASingleItemBuilder$1
  implements View.OnClickListener
{
  PASingleItemBuilder$1(PASingleItemBuilder paramPASingleItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySPEventReport.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, null);
    PASingleItemBuilder.Holder localHolder = (PASingleItemBuilder.Holder)AIOUtils.a(paramView);
    ChatMessage localChatMessage = localHolder.a;
    MessageForPubAccount localMessageForPubAccount;
    if ((localChatMessage instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)localChatMessage;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {}
    }
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (localChatMessage.istroop == 1))
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        if (((TroopBindPublicAccountMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localChatMessage.uniseq)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
        }
      }
      PASingleItemBuilder.a(this.a, localHolder, localChatMessage, l);
      PASingleItemBuilder.a(this.a, localChatMessage);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
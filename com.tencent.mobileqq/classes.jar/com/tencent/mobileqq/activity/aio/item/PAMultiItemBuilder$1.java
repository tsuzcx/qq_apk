package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class PAMultiItemBuilder$1
  implements View.OnClickListener
{
  PAMultiItemBuilder$1(PAMultiItemBuilder paramPAMultiItemBuilder) {}
  
  public void onClick(View paramView)
  {
    PAMultiItemBuilder.Holder localHolder = (PAMultiItemBuilder.Holder)paramView.getTag();
    Object localObject = AIOUtils.a(paramView);
    MessageForPubAccount localMessageForPubAccount;
    if ((localObject instanceof MessageForPubAccount))
    {
      localMessageForPubAccount = (MessageForPubAccount)localObject;
      if ((localMessageForPubAccount.mPAMessage == null) || (localMessageForPubAccount.mPAMessage.mMsgId <= 0L)) {}
    }
    for (long l = localMessageForPubAccount.mPAMessage.mMsgId;; l = -1L)
    {
      if ((localHolder == null) || (!(localObject instanceof MessageForPubAccount))) {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener holder = " + localHolder + ", msg = " + localObject);
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localMessageForPubAccount = (MessageForPubAccount)localObject;
        if ((localMessageForPubAccount.mPAMessage != null) && (localMessageForPubAccount.mPAMessage.items != null) && (!localMessageForPubAccount.mPAMessage.items.isEmpty())) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener mPAMessage or items is empty !");
        }
      }
      PAMessage.Item localItem = (PAMessage.Item)localMessageForPubAccount.mPAMessage.items.get(localHolder.d);
      ReadinjoySPEventReport.a().a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, null);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "mp_msg_msgpic_click", "aio_morpic_click", localHolder.d + 1, 0, "", "", Long.toString(localMessageForPubAccount.mPAMessage.mMsgId), "");
        if (localMessageForPubAccount.istroop == 1)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          if (((TroopBindPublicAccountMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, localMessageForPubAccount.uniseq)) {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          }
        }
      }
      if (TextUtils.isEmpty(localItem.a_actionData)) {}
      for (localObject = localItem.actionData;; localObject = localItem.a_actionData)
      {
        PAMultiItemBuilder.a(this.a, localItem, localHolder, (String)localObject, l);
        PAMultiItemBuilder.a(this.a, localMessageForPubAccount, localHolder, l, (String)localObject);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
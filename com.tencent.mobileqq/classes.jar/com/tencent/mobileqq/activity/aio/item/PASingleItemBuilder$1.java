package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PASingleItemBuilder$1
  implements View.OnClickListener
{
  PASingleItemBuilder$1(PASingleItemBuilder paramPASingleItemBuilder) {}
  
  public void onClick(View paramView)
  {
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportPubAioItemClick(this.a.d.b, null);
    PASingleItemBuilder.Holder localHolder = (PASingleItemBuilder.Holder)AIOUtils.b(paramView);
    ChatMessage localChatMessage = localHolder.q;
    if ((localChatMessage instanceof MessageForPubAccount))
    {
      MessageForPubAccount localMessageForPubAccount = (MessageForPubAccount)localChatMessage;
      if ((localMessageForPubAccount.mPAMessage != null) && (localMessageForPubAccount.mPAMessage.mMsgId > 0L))
      {
        l = localMessageForPubAccount.mPAMessage.mMsgId;
        break label92;
      }
    }
    long l = -1L;
    label92:
    if ((this.a.a != null) && (localChatMessage.istroop == 1))
    {
      ReportController.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.d.b, "", "", "");
      if (((TroopBindPublicAccountMgr)this.a.a.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).b(this.a.d.b, localChatMessage.uniseq)) {
        ReportController.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.d.b, "", "", "");
      }
    }
    PASingleItemBuilder.a(this.a, localHolder, localChatMessage, l);
    PASingleItemBuilder.a(this.a, localChatMessage);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PASingleItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
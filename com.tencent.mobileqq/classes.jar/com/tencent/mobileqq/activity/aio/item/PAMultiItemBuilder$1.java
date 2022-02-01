package com.tencent.mobileqq.activity.aio.item;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.qroute.QRoute;
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
    Object localObject1 = AIOUtils.a(paramView);
    boolean bool = localObject1 instanceof MessageForPubAccount;
    Object localObject2;
    if (bool)
    {
      localObject2 = (MessageForPubAccount)localObject1;
      if ((((MessageForPubAccount)localObject2).mPAMessage != null) && (((MessageForPubAccount)localObject2).mPAMessage.mMsgId > 0L))
      {
        l = ((MessageForPubAccount)localObject2).mPAMessage.mMsgId;
        break label69;
      }
    }
    long l = -1L;
    label69:
    if ((localHolder != null) && (bool))
    {
      localObject2 = (MessageForPubAccount)localObject1;
      if ((((MessageForPubAccount)localObject2).mPAMessage != null) && (((MessageForPubAccount)localObject2).mPAMessage.items != null) && (!((MessageForPubAccount)localObject2).mPAMessage.items.isEmpty()))
      {
        PAMessage.Item localItem = (PAMessage.Item)((MessageForPubAccount)localObject2).mPAMessage.items.get(localHolder.j);
        ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportPubAioItemClick(this.a.d.b, null);
        if (this.a.a != null)
        {
          ReportController.b(this.a.a, "P_CliOper", "Pb_account_lifeservice", this.a.d.b, "mp_msg_msgpic_click", "aio_morpic_click", localHolder.j + 1, 0, "", "", Long.toString(((MessageForPubAccount)localObject2).mPAMessage.mMsgId), "");
          if (((MessageForPubAccount)localObject2).istroop == 1)
          {
            ReportController.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "Clk_all", 0, 0, this.a.d.b, "", "", "");
            if (((TroopBindPublicAccountMgr)this.a.a.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER)).b(this.a.d.b, ((MessageForPubAccount)localObject2).uniseq)) {
              ReportController.b(this.a.a, "P_CliOper", "Grp_public", "", "oper", "top_one", 0, 0, this.a.d.b, "", "", "");
            }
          }
        }
        if (TextUtils.isEmpty(localItem.a_actionData)) {
          localObject1 = localItem.actionData;
        } else {
          localObject1 = localItem.a_actionData;
        }
        PAMultiItemBuilder.a(this.a, localItem, localHolder, (String)localObject1, l);
        PAMultiItemBuilder.a(this.a, (MessageForPubAccount)localObject2, localHolder, l, (String)localObject1);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ChatItemBuilder", 2, "PAMultiItemBuilder onClickListener mPAMessage or items is empty !");
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("PAMultiItemBuilder onClickListener holder = ");
      ((StringBuilder)localObject2).append(localHolder);
      ((StringBuilder)localObject2).append(", msg = ");
      ((StringBuilder)localObject2).append(localObject1);
      QLog.d("ChatItemBuilder", 2, ((StringBuilder)localObject2).toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PAMultiItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
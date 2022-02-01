package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopFeeMsgItemBuilder$1
  implements View.OnClickListener
{
  TroopFeeMsgItemBuilder$1(TroopFeeMsgItemBuilder paramTroopFeeMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    TroopFeeMsgItemBuilder.TroopFeeMsgHolder localTroopFeeMsgHolder = (TroopFeeMsgItemBuilder.TroopFeeMsgHolder)AIOUtils.a(paramView);
    Object localObject = (MessageForTroopFee)localTroopFeeMsgHolder.a;
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("url", ((MessageForTroopFee)localObject).actionUrl);
    paramView.getContext().startActivity(localIntent);
    localObject = ((TroopManager)this.a.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(localTroopFeeMsgHolder.b);
    int i;
    if (localObject != null)
    {
      if (!((TroopInfo)localObject).isTroopOwner(this.a.a.getCurrentAccountUin())) {
        break label161;
      }
      i = 0;
    }
    for (;;)
    {
      ReportController.b(this.a.a, "P_CliOper", "Grp_pay", "", "grp_aio", "Clk_payobj", 0, 0, localTroopFeeMsgHolder.b, i + "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label161:
      if (((TroopInfo)localObject).isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFeeMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
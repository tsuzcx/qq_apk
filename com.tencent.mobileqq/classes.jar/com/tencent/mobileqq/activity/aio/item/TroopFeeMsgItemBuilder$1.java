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
import mqq.app.AppRuntime;

class TroopFeeMsgItemBuilder$1
  implements View.OnClickListener
{
  TroopFeeMsgItemBuilder$1(TroopFeeMsgItemBuilder paramTroopFeeMsgItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = (TroopFeeMsgItemBuilder.TroopFeeMsgHolder)AIOUtils.a(paramView);
    Object localObject2 = (MessageForTroopFee)((TroopFeeMsgItemBuilder.TroopFeeMsgHolder)localObject1).a;
    Object localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
    ((Intent)localObject3).putExtra("url", ((MessageForTroopFee)localObject2).actionUrl);
    paramView.getContext().startActivity((Intent)localObject3);
    localObject2 = ((TroopManager)this.a.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(((TroopFeeMsgItemBuilder.TroopFeeMsgHolder)localObject1).b);
    if (localObject2 != null)
    {
      int i;
      if (((TroopInfo)localObject2).isTroopOwner(this.a.a.getCurrentAccountUin())) {
        i = 0;
      } else if (((TroopInfo)localObject2).isAdmin()) {
        i = 1;
      } else {
        i = 2;
      }
      localObject2 = this.a.a;
      localObject1 = ((TroopFeeMsgItemBuilder.TroopFeeMsgHolder)localObject1).b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append("");
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_pay", "", "grp_aio", "Clk_payobj", 0, 0, (String)localObject1, ((StringBuilder)localObject3).toString(), "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFeeMsgItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */
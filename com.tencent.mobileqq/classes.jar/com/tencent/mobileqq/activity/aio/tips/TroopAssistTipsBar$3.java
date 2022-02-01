package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssistTipsBar$3
  implements View.OnClickListener
{
  TroopAssistTipsBar$3(TroopAssistTipsBar paramTroopAssistTipsBar) {}
  
  public void onClick(View paramView)
  {
    TroopAssistTipsBar.a(this.a).setTroopMsgFilterToServer(TroopAssistTipsBar.a(this.a).a, Integer.valueOf(4));
    TroopAssistTipsBar.a(this.a).a();
    TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.a).a, TroopAssistTipsBar.a(this.a));
    TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a);
    ReportController.b(TroopAssistTipsBar.a(this.a), "P_CliOper", "Grp_msg", "", "AIOchat", "Clk_setmsg", 0, 0, TroopAssistTipsBar.a(this.a).a, "", "", "");
    QQAppInterface localQQAppInterface = TroopAssistTipsBar.a(this.a);
    String str2 = TroopAssistTipsBar.a(this.a).a;
    if (TroopAssistTipsBar.a(this.a).getTroopMask(TroopAssistTipsBar.a(this.a).a) == 3) {}
    for (String str1 = "1";; str1 = "0")
    {
      ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_confirm", 0, 0, str2, str1, "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.3
 * JD-Core Version:    0.7.0.1
 */
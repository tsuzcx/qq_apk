package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssistTipsBar$2
  implements View.OnClickListener
{
  TroopAssistTipsBar$2(TroopAssistTipsBar paramTroopAssistTipsBar) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a())
    {
      TroopAssistantManager.a().a(TroopAssistTipsBar.a(this.a), TroopAssistTipsBar.a(this.a).a);
      TroopAssistTipsBar.a(this.a).a();
      QQAppInterface localQQAppInterface = TroopAssistTipsBar.a(this.a);
      String str2 = TroopAssistTipsBar.a(this.a).a;
      String str1;
      if (TroopAssistTipsBar.a(this.a).getTroopMask(TroopAssistTipsBar.a(this.a).a) == 3) {
        str1 = "1";
      } else {
        str1 = "0";
      }
      ReportController.b(localQQAppInterface, "dc00899", "Grp_msg", "", "aio-topbar", "Clk_close", 0, 0, str2, str1, "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.2
 * JD-Core Version:    0.7.0.1
 */
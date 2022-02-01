package com.tencent.mobileqq.activity.aio.tips;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class TroopAssistTipsBar$1
  implements Runnable
{
  TroopAssistTipsBar$1(TroopAssistTipsBar paramTroopAssistTipsBar) {}
  
  public void run()
  {
    if ((TroopAssistTipsBar.a(this.this$0).getTroopMask(TroopAssistTipsBar.a(this.this$0).a) != 2) && (TroopAssistTipsBar.a(this.this$0).getTroopMask(TroopAssistTipsBar.a(this.this$0).a) != 3)) {
      return;
    }
    if (!TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.this$0), TroopAssistTipsBar.a(this.this$0).a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopAssistTipsBar", 2, "getTroopAssistTipInRange false, return ");
      }
      return;
    }
    if (TroopAssistTipsBar.a(this.this$0).a(this.this$0, new Object[0]))
    {
      TroopAssistantManager.a().c(TroopAssistTipsBar.a(this.this$0), TroopAssistTipsBar.a(this.this$0).a);
      ReportController.b(TroopAssistTipsBar.a(this.this$0), "CliOper", "", "", "Grp_helper", "Aio_grp_banner", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.TroopAssistTipsBar.1
 * JD-Core Version:    0.7.0.1
 */
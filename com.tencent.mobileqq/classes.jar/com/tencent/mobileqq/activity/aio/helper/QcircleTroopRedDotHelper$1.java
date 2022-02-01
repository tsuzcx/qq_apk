package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;

class QcircleTroopRedDotHelper$1
  implements Runnable
{
  QcircleTroopRedDotHelper$1(QcircleTroopRedDotHelper paramQcircleTroopRedDotHelper) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.a != null))
    {
      if (this.this$0.a.a.a() == null) {
        return;
      }
      if (AIOTroopQcircleRedDotManager.a()) {
        AIOTroopQcircleRedDotManager.a().c(this.this$0.a.d(), this.this$0.a, this.this$0.a.a.a());
      }
      if (AIOTroopQcircleRedDotManager.b()) {
        AIOTroopQcircleRedDotManager.a().a(this.this$0.a, this.this$0.a.a.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.1
 * JD-Core Version:    0.7.0.1
 */
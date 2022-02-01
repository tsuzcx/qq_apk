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
    if ((this.this$0.b != null) && (this.this$0.b.V != null))
    {
      if (this.this$0.b.V.a() == null) {
        return;
      }
      if (AIOTroopQcircleRedDotManager.b()) {
        AIOTroopQcircleRedDotManager.a().c(this.this$0.b.ag(), this.this$0.b, this.this$0.b.V.a());
      }
      if (AIOTroopQcircleRedDotManager.c()) {
        AIOTroopQcircleRedDotManager.a().a(this.this$0.b, this.this$0.b.V.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.1
 * JD-Core Version:    0.7.0.1
 */
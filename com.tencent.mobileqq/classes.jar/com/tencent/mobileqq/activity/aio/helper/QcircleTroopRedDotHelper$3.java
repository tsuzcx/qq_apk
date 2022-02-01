package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import java.util.List;

class QcircleTroopRedDotHelper$3
  implements Runnable
{
  QcircleTroopRedDotHelper$3(QcircleTroopRedDotHelper paramQcircleTroopRedDotHelper, TroopChatPie paramTroopChatPie, List paramList) {}
  
  public void run()
  {
    if (AIOTroopQcircleRedDotManager.b()) {
      AIOTroopQcircleRedDotManager.a().b(this.this$0.b.ag(), this.a, this.b);
    }
    if (AIOTroopQcircleRedDotManager.c()) {
      AIOTroopQcircleRedDotManager.a().b(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper.3
 * JD-Core Version:    0.7.0.1
 */
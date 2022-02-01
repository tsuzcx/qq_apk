package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.TroopTipsHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$5
  implements Runnable
{
  TroopChatPie$5(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(700L);
    }
    catch (InterruptedException localInterruptedException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, QLog.getStackTraceString(localInterruptedException));
      }
    }
    if ((!this.this$0.ch) && (!this.a) && (this.this$0.d.getTroopMask(this.this$0.ah.b) == 3) && (!((TroopTipsHelper)this.this$0.g.a(109)).c()))
    {
      TroopChatPie localTroopChatPie = this.this$0;
      localTroopChatPie.ch = true;
      localTroopChatPie.m.post(new TroopChatPie.5.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.5
 * JD-Core Version:    0.7.0.1
 */
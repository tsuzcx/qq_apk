package com.tencent.mobileqq.activity.aio.core;

import ailw;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopChatPie$8
  implements Runnable
{
  TroopChatPie$8(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(700L);
      if ((!this.this$0.r) && (!this.a) && (this.this$0.app.getTroopMask(this.this$0.sessionInfo.curFriendUin) == 3) && ((this.this$0.a == null) || (!this.this$0.a.a())))
      {
        this.this$0.r = true;
        this.this$0.uiHandler.post(new TroopChatPie.8.1(this));
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, QLog.getStackTraceString(localInterruptedException));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.8
 * JD-Core Version:    0.7.0.1
 */
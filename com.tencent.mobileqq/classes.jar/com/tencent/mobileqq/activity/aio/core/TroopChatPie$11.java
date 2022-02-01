package com.tencent.mobileqq.activity.aio.core;

import bgqd;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopChatPie$11
  implements Runnable
{
  TroopChatPie$11(TroopChatPie paramTroopChatPie, bgqd parambgqd) {}
  
  public void run()
  {
    if (this.a.a(this.this$0.app, this.this$0.sessionInfo)) {}
    for (int i = 1;; i = 0)
    {
      ThreadManager.getUIHandler().post(new TroopChatPie.11.1(this, i));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.TroopChatPie.11
 * JD-Core Version:    0.7.0.1
 */
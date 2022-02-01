package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import mqq.os.MqqHandler;

class TroopManager$11
  implements Runnable
{
  TroopManager$11(TroopManager paramTroopManager, String paramString) {}
  
  public void run()
  {
    TroopInfo localTroopInfo = (TroopInfo)this.this$0.a.find(TroopInfo.class, this.a);
    ThreadManager.getUIHandler().post(new TroopManager.11.1(this, localTroopInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.11
 * JD-Core Version:    0.7.0.1
 */
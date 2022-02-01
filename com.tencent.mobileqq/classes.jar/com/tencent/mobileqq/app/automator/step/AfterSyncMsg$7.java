package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.natmem.NatMemAPI;

class AfterSyncMsg$7
  implements Runnable
{
  AfterSyncMsg$7(AfterSyncMsg paramAfterSyncMsg) {}
  
  public void run()
  {
    NatMemAPI.a(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.7
 * JD-Core Version:    0.7.0.1
 */
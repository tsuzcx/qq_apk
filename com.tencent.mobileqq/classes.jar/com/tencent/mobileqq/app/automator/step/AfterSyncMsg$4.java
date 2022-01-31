package com.tencent.mobileqq.app.automator.step;

import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;
import nbp;

class AfterSyncMsg$4
  implements Runnable
{
  AfterSyncMsg$4(AfterSyncMsg paramAfterSyncMsg) {}
  
  public void run()
  {
    if (!nbp.a.get()) {
      nbp.a(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.4
 * JD-Core Version:    0.7.0.1
 */
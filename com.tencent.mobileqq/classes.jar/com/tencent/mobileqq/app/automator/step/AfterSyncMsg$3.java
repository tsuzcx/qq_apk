package com.tencent.mobileqq.app.automator.step;

import com.tencent.biz.bmqq.util.BmqqSegmentUtil;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;

class AfterSyncMsg$3
  implements Runnable
{
  AfterSyncMsg$3(AfterSyncMsg paramAfterSyncMsg) {}
  
  public void run()
  {
    if (!BmqqSegmentUtil.a.get()) {
      BmqqSegmentUtil.a(BaseApplicationImpl.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;

class AfterSyncMsg$4
  implements Runnable
{
  AfterSyncMsg$4(AfterSyncMsg paramAfterSyncMsg) {}
  
  public void run()
  {
    if (this.this$0.a.a.getApplication() != null) {
      ZhituManager.a(this.this$0.a.a).a(this.this$0.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg.4
 * JD-Core Version:    0.7.0.1
 */
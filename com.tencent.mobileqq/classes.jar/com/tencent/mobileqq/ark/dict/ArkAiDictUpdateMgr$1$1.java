package com.tencent.mobileqq.ark.dict;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ArkAiDictUpdateMgr$1$1
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$1$1(ArkAiDictUpdateMgr.1 param1, DictConfig paramDictConfig1, ArkAiDictUpdateMgr.UpdateState paramUpdateState, DictConfig paramDictConfig2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.i("ArkDict.Update", 1, String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { ArkAiDictUpdateMgr.c(this.a) }));
      this.b.b = false;
    }
    synchronized (this.b)
    {
      ArkAiDictUpdateMgr.UpdateState localUpdateState2 = this.b;
      int i = localUpdateState2.a - 1;
      localUpdateState2.a = i;
      if (i != 0) {
        return;
      }
      if (this.b.b)
      {
        QLog.i("ArkDict.Update", 1, "updateWordDict, all success");
        ArkAiDictUpdateMgr.b(this.c);
        ArkAiDictUpdateMgr.d(this.c);
        ArkAiDictMgr.b(ArkAiDictUpdateMgr.a(this.d.this$0));
      }
      else
      {
        QLog.i("ArkDict.Update", 1, "updateWordDict, one or more tasks failed.");
      }
      try
      {
        ArkAiDictUpdateMgr.b(this.d.this$0, false);
        if (ArkAiDictUpdateMgr.c(this.d.this$0))
        {
          ArkAiDictUpdateMgr.a(this.d.this$0, false);
          QLog.i("ArkDict.Update", 1, "updateWordDict, pending update task exists, wait 5 second and update");
          ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new ArkAiDictUpdateMgr.1.1.1(this), 5000);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.1.1
 * JD-Core Version:    0.7.0.1
 */
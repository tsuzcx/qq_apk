package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.data.DraftTextInfo;
import java.lang.ref.WeakReference;

class GetTextDraftJob$2
  implements Runnable
{
  GetTextDraftJob$2(GetTextDraftJob paramGetTextDraftJob, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    BaseChatPie localBaseChatPie = (BaseChatPie)GetTextDraftJob.a(this.this$0).get();
    if (localBaseChatPie == null) {
      return;
    }
    localBaseChatPie.setTextDraft(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob.2
 * JD-Core Version:    0.7.0.1
 */
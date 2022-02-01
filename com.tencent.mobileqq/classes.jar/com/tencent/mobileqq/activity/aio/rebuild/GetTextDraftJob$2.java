package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIODraftHelper;
import com.tencent.mobileqq.data.DraftTextInfo;
import java.lang.ref.WeakReference;

class GetTextDraftJob$2
  implements Runnable
{
  GetTextDraftJob$2(GetTextDraftJob paramGetTextDraftJob, DraftTextInfo paramDraftTextInfo) {}
  
  public void run()
  {
    Object localObject = (BaseChatPie)GetTextDraftJob.a(this.this$0).get();
    if (localObject == null) {
      return;
    }
    localObject = (AIODraftHelper)((BaseChatPie)localObject).q(111);
    if (localObject == null) {
      return;
    }
    ((AIODraftHelper)localObject).a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob.2
 * JD-Core Version:    0.7.0.1
 */
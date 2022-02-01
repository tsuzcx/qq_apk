package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CMSBornPlayer$CMSActionContext$reset$1
  implements Runnable
{
  CMSBornPlayer$CMSActionContext$reset$1(CMSBornPlayer.CMSActionContext paramCMSActionContext) {}
  
  public final void run()
  {
    QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayer", 1, this.this$0.a().d() + " timeout(" + CMSBornPlayer.a.a() + "ms)!! callback timeout");
    CMSBornPlayer.Companion.a(CMSBornPlayer.a, this.this$0, CMSActionStatus.ERROR_TIME_OUT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayer.CMSActionContext.reset.1
 * JD-Core Version:    0.7.0.1
 */
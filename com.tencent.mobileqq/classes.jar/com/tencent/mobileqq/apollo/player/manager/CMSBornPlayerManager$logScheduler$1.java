package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$logScheduler$1", "Ljava/lang/Runnable;", "run", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager$logScheduler$1
  implements Runnable
{
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentActionState\n ");
    localStringBuilder.append(CMSBornPlayerManager.a(CMSBornPlayerManager.a));
    QLog.e("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, localStringBuilder.toString());
    if ((CMSBornPlayerManager.b(CMSBornPlayerManager.a)) && (CMSBornPlayerManager.c(CMSBornPlayerManager.a)))
    {
      QLog.w("[cmshow][scripted][CMSPlayer]CMSBornPlayerManager", 1, "try destroy on everything done");
      CMSBornPlayerManager.a.a();
      CMSBornPlayerManager.b(CMSBornPlayerManager.a).clear();
      CMSBornPlayerManager.c(CMSBornPlayerManager.a).clear();
    }
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)this, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.logScheduler.1
 * JD-Core Version:    0.7.0.1
 */
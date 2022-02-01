package com.tencent.mobileqq.apollo.player.manager;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.PriorityQueue;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$tryStartQueueWhenEnvReady$scheduler$1", "Ljava/lang/Runnable;", "run", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager$tryStartQueueWhenEnvReady$scheduler$1
  implements Runnable
{
  public void run()
  {
    if (CMSBornPlayerManager.a(CMSBornPlayerManager.a))
    {
      QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "tryStartQueueWhenEnvReady checkEnvReady success, start queue!!, current recordQueue size:" + CMSBornPlayerManager.a(CMSBornPlayerManager.a).size());
      CMSBornPlayerManager.a(CMSBornPlayerManager.a);
      return;
    }
    QLog.w("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "tryStartQueueWhenEnvReady after 1000ms, current recordQueue size:" + CMSBornPlayerManager.a(CMSBornPlayerManager.a).size());
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.tryStartQueueWhenEnvReady.scheduler.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.player.manager;

import amvy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/player/manager/CMSBornPlayerManager$logScheduler$1", "Ljava/lang/Runnable;", "run", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CMSBornPlayerManager$logScheduler$1
  implements Runnable
{
  public void run()
  {
    QLog.e("cmshow_scripted_[CMSPlayer]CMSBornPlayerManager", 1, "currentActionState\n " + amvy.a(amvy.a));
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)this, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.manager.CMSBornPlayerManager.logScheduler.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.meme.manager;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import mqq.os.MqqHandler;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/apollo/meme/manager/MemeBornPlayerManager$logScheduler$1", "Ljava/lang/Runnable;", "run", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class MemeBornPlayerManager$logScheduler$1
  implements Runnable
{
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("currentActionState\n ");
    localStringBuilder.append(MemeBornPlayerManager.i(MemeBornPlayerManager.a));
    QLog.e("[cmshow][MemePlayer]MemeBornPlayerManager", 1, localStringBuilder.toString());
    if ((MemeBornPlayerManager.j(MemeBornPlayerManager.a)) && (MemeBornPlayerManager.k(MemeBornPlayerManager.a)))
    {
      QLog.w("[cmshow][MemePlayer]MemeBornPlayerManager", 1, "try destroy on everything done");
      MemeBornPlayerManager.a.b();
      MemeBornPlayerManager.l(MemeBornPlayerManager.a).clear();
      MemeBornPlayerManager.m(MemeBornPlayerManager.a).clear();
    }
    ThreadManager.getSubThreadHandler().postDelayed((Runnable)this, 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.manager.MemeBornPlayerManager.logScheduler.1
 * JD-Core Version:    0.7.0.1
 */
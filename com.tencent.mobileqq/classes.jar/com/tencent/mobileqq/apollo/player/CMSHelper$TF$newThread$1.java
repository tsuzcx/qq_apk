package com.tencent.mobileqq.apollo.player;

import android.os.Process;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CMSHelper$TF$newThread$1
  implements Runnable
{
  CMSHelper$TF$newThread$1(CMSHelper.TF paramTF, Runnable paramRunnable) {}
  
  public final void run()
  {
    Process.setThreadPriority(CMSHelper.TF.a(this.this$0));
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.player.CMSHelper.TF.newThread.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.meme;

import android.os.Process;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class MemeHelper$TF$newThread$1
  implements Runnable
{
  MemeHelper$TF$newThread$1(MemeHelper.TF paramTF, Runnable paramRunnable) {}
  
  public final void run()
  {
    Process.setThreadPriority(MemeHelper.TF.a(this.this$0));
    this.a.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.MemeHelper.TF.newThread.1
 * JD-Core Version:    0.7.0.1
 */
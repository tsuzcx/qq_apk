package com.tencent.crossengine.util;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/crossengine/util/VSyncScheduler$vSyncCallback$1", "Landroid/view/Choreographer$FrameCallback;", "doFrame", "", "frameTimeNanos", "", "library_release"}, k=1, mv={1, 1, 16})
public final class VSyncScheduler$vSyncCallback$1
  implements Choreographer.FrameCallback
{
  public void doFrame(long paramLong)
  {
    if (VSyncScheduler.a(this.a).get() < 1)
    {
      VSyncScheduler.a(this.a).incrementAndGet();
      VSyncScheduler.h(this.a).execute(VSyncScheduler.i(this.a));
    }
    Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.util.VSyncScheduler.vSyncCallback.1
 * JD-Core Version:    0.7.0.1
 */
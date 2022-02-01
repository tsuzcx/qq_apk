package com.tencent.android.gldrawable.api.base;

import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class InternalApiImpl$waitAndTryLoad$1
  implements Runnable
{
  InternalApiImpl$waitAndTryLoad$1(InternalApiImpl paramInternalApiImpl, CountDownLatch paramCountDownLatch) {}
  
  public final void run()
  {
    synchronized (this.this$0)
    {
      if (!this.this$0.isDynamicReady()) {
        this.this$0.realLoadApk$api_release();
      }
      Unit localUnit = Unit.INSTANCE;
      this.$latch.countDown();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.android.gldrawable.api.base.InternalApiImpl.waitAndTryLoad.1
 * JD-Core Version:    0.7.0.1
 */
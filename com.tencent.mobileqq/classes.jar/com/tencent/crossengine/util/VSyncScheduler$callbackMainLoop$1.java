package com.tencent.crossengine.util;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class VSyncScheduler$callbackMainLoop$1
  implements Runnable
{
  VSyncScheduler$callbackMainLoop$1(VSyncScheduler paramVSyncScheduler) {}
  
  public final void run()
  {
    VSyncScheduler.a(this.this$0).decrementAndGet();
    long l2 = System.nanoTime();
    long l1;
    if (VSyncScheduler.b(this.this$0) == 0L) {
      l1 = 0L;
    } else {
      l1 = l2 - VSyncScheduler.b(this.this$0);
    }
    if ((l1 < 0L) || (VSyncScheduler.c(this.this$0)))
    {
      VSyncScheduler.a(this.this$0, false);
      l1 = VSyncScheduler.d(this.this$0);
    }
    VSyncScheduler.a(this.this$0, l2);
    VSyncScheduler localVSyncScheduler = this.this$0;
    VSyncScheduler.b(localVSyncScheduler, VSyncScheduler.e(localVSyncScheduler) + l1);
    if (VSyncScheduler.f(this.this$0).a(VSyncScheduler.e(this.this$0))) {
      VSyncScheduler.g(this.this$0).a(VSyncScheduler.e(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.util.VSyncScheduler.callbackMainLoop.1
 * JD-Core Version:    0.7.0.1
 */
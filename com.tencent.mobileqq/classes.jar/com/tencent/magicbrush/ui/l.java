package com.tencent.magicbrush.ui;

import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameIntervalNanos", "", "frameRefreshRate", "", "frameTimeNanos", "latency", "com/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1", "Lcom/tencent/magicbrush/ui/SchedulerLockerAnimationFrameHandler$latency$1;", "skippedFrameCount", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
final class l
  extends a
  implements Runnable
{
  private final int b = 60;
  private final long c = 1000000000L / this.b;
  private int d;
  private final l.a e = new l.a();
  private long f;
  @NotNull
  private final a.b g = a.b.d;
  
  public l(@NotNull MBRuntime paramMBRuntime, @NotNull c paramc)
  {
    super(paramMBRuntime, paramc);
  }
  
  @NotNull
  public a.b f()
  {
    return this.g;
  }
  
  public void g() {}
  
  public void h()
  {
    this.f = 0L;
    l().a((Runnable)this);
  }
  
  public void i()
  {
    this.f = 0L;
  }
  
  public void j() {}
  
  public void run()
  {
    if (!b()) {
      return;
    }
    if (this.f == 0L) {
      this.f = System.nanoTime();
    }
    long l1 = System.nanoTime();
    long l2 = l1 - this.f;
    long l3 = this.c;
    if (l2 >= l3)
    {
      this.d = ((int)(l2 / l3));
      this.f = (l1 - l2 % l3);
    }
    this.e.a(this.f);
    double d1 = this.f;
    Double.isNaN(d1);
    a(d1 / 1000000.0D);
    l1 = System.nanoTime();
    l2 = this.f;
    l3 = this.c;
    this.f = (l2 + l3);
    while ((l1 - l2 < l3) && (System.nanoTime() < this.f)) {}
    l().a((Runnable)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.l
 * JD-Core Version:    0.7.0.1
 */
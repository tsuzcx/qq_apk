package com.tencent.crossengine.util;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.MainThread;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/crossengine/util/VSyncScheduler;", "", "vSyncListener", "Lcom/tencent/crossengine/util/IVSyncListener;", "targetFps", "", "scheduleExecutor", "Ljava/util/concurrent/Executor;", "(Lcom/tencent/crossengine/util/IVSyncListener;FLjava/util/concurrent/Executor;)V", "callbackMainLoop", "Ljava/lang/Runnable;", "fpsStabilizer", "Lcom/tencent/crossengine/util/FpsStabilizer;", "lastFrameTimeNanos", "", "pendingVSyncCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "requestResetFrameDuration", "", "totalDrawTimeNanos", "vSyncCallback", "Landroid/view/Choreographer$FrameCallback;", "getDefaultFrameDuration", "startScheduleVSync", "", "stopScheduleVSync", "Companion", "library_release"}, k=1, mv={1, 1, 16})
public final class VSyncScheduler
{
  public static final VSyncScheduler.Companion a = new VSyncScheduler.Companion(null);
  private final AtomicInteger b;
  private final FpsStabilizer c;
  private volatile boolean d;
  private long e;
  private long f;
  private final Runnable g;
  private final Choreographer.FrameCallback h;
  private final IVSyncListener i;
  private final float j;
  private final Executor k;
  
  public VSyncScheduler(@NotNull IVSyncListener paramIVSyncListener, float paramFloat, @NotNull Executor paramExecutor)
  {
    this.i = paramIVSyncListener;
    this.j = paramFloat;
    this.k = paramExecutor;
    this.b = new AtomicInteger();
    this.c = new FpsStabilizer();
    this.g = ((Runnable)new VSyncScheduler.callbackMainLoop.1(this));
    this.h = ((Choreographer.FrameCallback)new VSyncScheduler.vSyncCallback.1(this));
    this.c.a(this.j);
  }
  
  private final long c()
  {
    float f1 = this.j;
    if (f1 > 0) {
      return ((float)TimeUnit.SECONDS.toNanos(1L) / f1);
    }
    return TimeUnit.SECONDS.toNanos(1L) / 60;
  }
  
  @MainThread
  public final void a()
  {
    Choreographer.getInstance().postFrameCallback(this.h);
  }
  
  @MainThread
  public final void b()
  {
    Choreographer.getInstance().removeFrameCallback(this.h);
    this.d = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.crossengine.util.VSyncScheduler
 * JD-Core Version:    0.7.0.1
 */
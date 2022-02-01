package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "bridge", "Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "getBridge", "()Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "choreographer", "Landroid/view/Choreographer;", "getChoreographer", "()Landroid/view/Choreographer;", "setChoreographer", "(Landroid/view/Choreographer;)V", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "", "onDestroy", "onPause", "onResume", "MainThreadChoreographerBridge", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
final class d
  extends a
{
  private final f b = new f();
  @NotNull
  private final a.b c = a.b.b;
  @Nullable
  private volatile Choreographer d;
  @NotNull
  private final d.a e = new d.a(this);
  
  public d(@NotNull MBRuntime paramMBRuntime, @NotNull c paramc)
  {
    super(paramMBRuntime, paramc);
  }
  
  public final void a(@Nullable Choreographer paramChoreographer)
  {
    this.d = paramChoreographer;
  }
  
  @NotNull
  public a.b f()
  {
    return this.c;
  }
  
  public void g()
  {
    com.tencent.luggage.wxa.gk.f.a.a((Function0)new d.b(this));
  }
  
  public void h()
  {
    if (this.d != null)
    {
      Choreographer localChoreographer = this.d;
      if (localChoreographer == null) {
        Intrinsics.throwNpe();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.e);
      localChoreographer = this.d;
      if (localChoreographer == null) {
        Intrinsics.throwNpe();
      }
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this.e);
    }
  }
  
  public void i()
  {
    if (this.d != null)
    {
      Choreographer localChoreographer = this.d;
      if (localChoreographer == null) {
        Intrinsics.throwNpe();
      }
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this.e);
    }
  }
  
  public void j() {}
  
  @Nullable
  public final Choreographer m()
  {
    return this.d;
  }
  
  @NotNull
  public final d.a n()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d
 * JD-Core Version:    0.7.0.1
 */
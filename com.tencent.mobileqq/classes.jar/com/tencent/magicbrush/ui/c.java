package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.magicbrush.MBRuntime;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/ChoreographerInJsThreadAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Landroid/view/Choreographer$FrameCallback;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "choreographer", "Landroid/view/Choreographer;", "latency", "Lcom/tencent/magicbrush/ui/LatencyCalculator;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "tryGetTimes", "", "doFrame", "", "frameTimeNanos", "", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "onCreate", "onDestroy", "onPause", "onResume", "tryGetChoreographer", "tryLaterIfFailed", "", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
final class c
  extends a
  implements Choreographer.FrameCallback
{
  private final f b = new f();
  private Choreographer c;
  private int d;
  @NotNull
  private final a.b e = a.b.a;
  
  public c(@NotNull MBRuntime paramMBRuntime, @NotNull com.tencent.magicbrush.handler.c paramc)
  {
    super(paramMBRuntime, paramc);
  }
  
  private final Choreographer a(boolean paramBoolean)
  {
    Object localObject = this.c;
    if (localObject != null) {
      return localObject;
    }
    Choreographer localChoreographer = (Choreographer)null;
    this.d += 1;
    try
    {
      localObject = Choreographer.getInstance();
    }
    catch (Exception localException)
    {
      int i = this.d;
      if (i != 1)
      {
        localObject = localChoreographer;
        if (i % 100000 != 0) {}
      }
      else
      {
        localObject = (Throwable)localException;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("get choreographer failed [");
        localStringBuilder.append(this.d);
        localStringBuilder.append("] times. but it's ok, i will try it later if needed. ");
        localStringBuilder.append(localException);
        c.c.a("AnimationFrameHandler", (Throwable)localObject, localStringBuilder.toString(), new Object[0]);
        localObject = localChoreographer;
      }
    }
    if ((localObject == null) && (paramBoolean))
    {
      l().a((Runnable)new c.a(this));
      return null;
    }
    if (localObject != null) {
      this.c = ((Choreographer)localObject);
    }
    return localObject;
  }
  
  public void doFrame(long paramLong)
  {
    if (b())
    {
      this.b.a(paramLong);
      Choreographer localChoreographer = this.c;
      if (localChoreographer != null) {
        localChoreographer.postFrameCallback((Choreographer.FrameCallback)this);
      }
      double d1 = paramLong;
      Double.isNaN(d1);
      a(d1 / 1000000.0D);
    }
  }
  
  @NotNull
  public a.b f()
  {
    return this.e;
  }
  
  public void g() {}
  
  public void h()
  {
    Choreographer localChoreographer = a(true);
    if (localChoreographer != null) {
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this);
    }
    if (localChoreographer != null) {
      localChoreographer.postFrameCallback((Choreographer.FrameCallback)this);
    }
  }
  
  public void i()
  {
    Choreographer localChoreographer = this.c;
    if (localChoreographer != null) {
      localChoreographer.removeFrameCallback((Choreographer.FrameCallback)this);
    }
  }
  
  public void j() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.c
 * JD-Core Version:    0.7.0.1
 */
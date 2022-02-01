package com.tencent.magicbrush.ui;

import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.gi.c.c;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "isRunning", "", "()Z", "setRunning", "(Z)V", "getJsThreadHandler", "()Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "locker", "Ljava/lang/Object;", "getLocker", "()Ljava/lang/Object;", "getRuntime", "()Lcom/tencent/magicbrush/MBRuntime;", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "create", "", "destroy", "getLatency", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Latency;", "notifyAnimationFrame", "frameTimeMillis", "", "onCreate", "onDestroy", "onPause", "onResume", "pause", "resume", "Companion", "Latency", "Strategy", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public abstract class a
{
  public static final a.a a = new a.a(null);
  @NotNull
  private final Object b;
  private boolean c;
  @NotNull
  private final MBRuntime d;
  @NotNull
  private final c e;
  
  public a(@NotNull MBRuntime paramMBRuntime, @NotNull c paramc)
  {
    this.d = paramMBRuntime;
    this.e = paramc;
    this.b = new Object();
  }
  
  @JvmStatic
  @NotNull
  public static final a a(@NotNull MBRuntime paramMBRuntime, @NotNull c paramc, @NotNull a.b paramb)
  {
    return a.a(paramMBRuntime, paramc, paramb);
  }
  
  @MainThread
  private final void m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnimationFrameHandler[");
    localStringBuilder.append(f().name());
    localStringBuilder.append("] create ");
    Thread localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
    localStringBuilder.append(localThread.getName());
    c.c.b("AnimationFrameHandler", localStringBuilder.toString(), new Object[0]);
    g();
  }
  
  @NotNull
  protected final Object a()
  {
    return this.b;
  }
  
  public final void a(double paramDouble)
  {
    this.d.a(paramDouble);
  }
  
  protected final boolean b()
  {
    return this.c;
  }
  
  public final void c()
  {
    c.c.b("AnimationFrameHandler", "AnimationFrameHandler[%s] resume", new Object[] { f().name() });
    synchronized (this.b)
    {
      boolean bool = this.c;
      if (bool) {
        return;
      }
      h();
      this.c = true;
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  public final void d()
  {
    c.c.b("AnimationFrameHandler", "AnimationFrameHandler[%s] pause", new Object[] { f().name() });
    synchronized (this.b)
    {
      boolean bool = this.c;
      if (!bool) {
        return;
      }
      i();
      this.c = false;
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  public final void e()
  {
    c.c.b("AnimationFrameHandler", "AnimationFrameHandler[%s] destroy", new Object[] { f().name() });
    synchronized (this.b)
    {
      if (this.c)
      {
        c.c.b("AnimationFrameHandler", "AnimationFrameHandler[%s] pause automatically", new Object[] { f().name() });
        d();
      }
      j();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
  }
  
  @NotNull
  public abstract a.b f();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  @NotNull
  public final MBRuntime k()
  {
    return this.d;
  }
  
  @NotNull
  public final c l()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.a
 * JD-Core Version:    0.7.0.1
 */
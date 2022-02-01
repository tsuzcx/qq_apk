package com.tencent.magicbrush.ui;

import android.os.SystemClock;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.handler.c;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/EglSurfaceSwapLockerAFHandler;", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler;", "Ljava/lang/Runnable;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "jsThreadHandler", "Lcom/tencent/magicbrush/handler/MBJsThreadHandler;", "(Lcom/tencent/magicbrush/MBRuntime;Lcom/tencent/magicbrush/handler/MBJsThreadHandler;)V", "frameTimeMillis", "", "strategy", "Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "getStrategy", "()Lcom/tencent/magicbrush/ui/AnimationFrameHandler$Strategy;", "onCreate", "", "onDestroy", "onPause", "onResume", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
final class e
  extends a
  implements Runnable
{
  @NotNull
  private final a.b b = a.b.c;
  private double c;
  
  public e(@NotNull MBRuntime paramMBRuntime, @NotNull c paramc)
  {
    super(paramMBRuntime, paramc);
  }
  
  @NotNull
  public a.b f()
  {
    return this.b;
  }
  
  public void g() {}
  
  public void h()
  {
    l().a((Runnable)this);
  }
  
  public void i()
  {
    this.c = 0.0D;
  }
  
  public void j() {}
  
  public void run()
  {
    if (b())
    {
      l().a((Runnable)this);
      if (this.c == 0.0D) {
        this.c = SystemClock.elapsedRealtime();
      }
      a(this.c);
      this.c = SystemClock.elapsedRealtime();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.e
 * JD-Core Version:    0.7.0.1
 */
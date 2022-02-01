package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import androidx.annotation.MainThread;
import com.tencent.magicbrush.handler.c;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler$MainThreadChoreographerBridge;", "Landroid/view/Choreographer$FrameCallback;", "Ljava/lang/Runnable;", "(Lcom/tencent/magicbrush/ui/ChoreographerInMainThreadAFHandler;)V", "frameTimeNanos", "", "getFrameTimeNanos", "()J", "setFrameTimeNanos", "(J)V", "doFrame", "", "run", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
final class d$a
  implements Choreographer.FrameCallback, Runnable
{
  private long b;
  
  @MainThread
  public void doFrame(long paramLong)
  {
    this.b = paramLong;
    d.a(this.a).a(paramLong);
    this.a.l().a((Runnable)this.a.n());
  }
  
  public void run()
  {
    if (this.a.b()) {
      synchronized (this.a.a())
      {
        Object localObject2 = this.a.m();
        if (localObject2 != null)
        {
          ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.a.n());
          localObject2 = Unit.INSTANCE;
        }
        ??? = this.a;
        double d = this.b;
        Double.isNaN(d);
        ((d)???).a(d / 1000000.0D);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d.a
 * JD-Core Version:    0.7.0.1
 */
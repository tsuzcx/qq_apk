package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 13})
final class d$b
  extends Lambda
  implements Function0<Unit>
{
  d$b(d paramd)
  {
    super(0);
  }
  
  public final void a()
  {
    synchronized (this.a.a())
    {
      this.a.a(Choreographer.getInstance());
      if (this.a.b())
      {
        localObject2 = this.a.m();
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((Choreographer)localObject2).postFrameCallback((Choreographer.FrameCallback)this.a.n());
      }
      Object localObject2 = Unit.INSTANCE;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.d.b
 * JD-Core Version:    0.7.0.1
 */
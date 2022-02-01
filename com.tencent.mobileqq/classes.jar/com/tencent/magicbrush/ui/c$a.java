package com.tencent.magicbrush.ui;

import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.luggage.wxa.gi.c.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 13})
final class c$a
  implements Runnable
{
  c$a(c paramc) {}
  
  public final void run()
  {
    if (!this.a.b()) {
      return;
    }
    Object localObject = c.a(this.a, true);
    if (localObject != null)
    {
      ((Choreographer)localObject).removeFrameCallback((Choreographer.FrameCallback)this.a);
      ((Choreographer)localObject).postFrameCallback((Choreographer.FrameCallback)this.a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Aha! we get a choreographer after try [");
      ((StringBuilder)localObject).append(c.a(this.a));
      ((StringBuilder)localObject).append("] times ");
      c.c.b("AnimationFrameHandler", ((StringBuilder)localObject).toString(), new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.magicbrush.ui.c.a
 * JD-Core Version:    0.7.0.1
 */
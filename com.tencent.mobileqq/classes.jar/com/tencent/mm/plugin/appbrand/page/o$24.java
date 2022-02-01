package com.tencent.mm.plugin.appbrand.page;

import android.os.SystemClock;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.animation.Animation;
import android.view.animation.Interpolator;

class o$24
  implements Choreographer.FrameCallback
{
  o$24(o paramo, long paramLong1, long paramLong2, bg parambg, m paramm1, m paramm2, Animation paramAnimation) {}
  
  public void doFrame(long paramLong)
  {
    float f1 = ((float)(SystemClock.elapsedRealtime() - this.a) + 0.0F) / (float)this.b;
    if (1.0F <= f1)
    {
      o.a(this.g, this.c, this.d, this.e);
      return;
    }
    int i = (int)(this.f.getInterpolator().getInterpolation(f1) * 100.0F);
    o.k(this.g).a(this.c, this.d, this.e, i);
    Choreographer.getInstance().postFrameCallback(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.o.24
 * JD-Core Version:    0.7.0.1
 */
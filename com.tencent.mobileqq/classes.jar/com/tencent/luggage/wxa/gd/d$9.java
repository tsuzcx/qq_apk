package com.tencent.luggage.wxa.gd;

import com.tencent.luggage.wxa.mi.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;

class d$9
  implements Runnable
{
  d$9(d paramd, int paramInt) {}
  
  public void run()
  {
    o.d(d.b(this.b), "handleWebViewBackground, type:%s, autoPauseIfNative:%s, autoPauseIfNavigate:%s, isRuntimeInBackground:%s, isPlayingWhenEnterBackground:%s", new Object[] { Integer.valueOf(this.a), Boolean.valueOf(d.q(this.b)), Boolean.valueOf(d.r(this.b)), Boolean.valueOf(d.s(this.b)), this.b.b() });
    if (((this.a == 2) && (!d.q(this.b))) || ((this.a == 1) && (!d.r(this.b)) && (!d.s(this.b))))
    {
      if (this.b.c())
      {
        o.d(d.b(this.b), "handleWebViewBackground, video not auto pause, try resume, type:%s", new Object[] { Integer.valueOf(this.a) });
        d.a(this.b, false);
        return;
      }
      o.d(d.b(this.b), "handleWebViewBackground, video not auto pause, ignore resume, type:%s", new Object[] { Integer.valueOf(this.a) });
      return;
    }
    if ((d.g(this.b) != null) && (d.p(this.b)) && (this.b.b() == null))
    {
      boolean bool = d.g(this.b).f();
      this.b.a(new AtomicBoolean(bool));
      o.d(d.b(this.b), "handleWebViewBackground runnable, video playing state when enter background:%s", new Object[] { Boolean.valueOf(bool) });
      if ((d.t(this.b)) && (1 != this.a) && (d.u(this.b)))
      {
        o.d(d.b(this.b), "handleWebViewBackground runnable, background play audio is enabled, do not pause");
        return;
      }
      if (d.v(this.b))
      {
        o.d(d.b(this.b), "handleWebViewBackground runnable, i am pip player, do not pause");
        return;
      }
      d.w(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.9
 * JD-Core Version:    0.7.0.1
 */
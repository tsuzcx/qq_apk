package com.tencent.luggage.wxa.op;

import android.graphics.Point;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.pd.r;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.e;

class b$2
  implements Runnable
{
  b$2(b paramb, Point paramPoint1, Point paramPoint2, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (b.d(this.e))
    {
      o.d(b.b(this.e), "handleVideoPage2PipStart, true == mHandleStarted");
      return;
    }
    int i = b.e(this.e).a();
    int j = b.e(this.e).b();
    int k = this.a.x;
    int m = this.b.x;
    int n = this.a.y;
    int i1 = this.b.y;
    o.d(b.b(this.e), "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(k + m), Integer.valueOf(n + i1) });
    b.c(this.e).a(b.a(this.e, this.a.x, this.a.y, this.b));
    b.a(this.e, this.c, this.d, i, j);
    b.c(this.e).a(b.f(this.e), b.g(this.e));
    b localb = this.e;
    b.a(localb, 0.0F, b.h(localb), b.i(this.e), b.j(this.e), b.k(this.e), b.l(this.e), b.m(this.e), b.n(this.e), b.o(this.e), b.p(this.e), b.q(this.e), b.r(this.e), b.s(this.e));
    b.a(this.e, true);
    if (b.t(this.e) != null)
    {
      o.d(b.b(this.e), "handleVideoPage2PipStart, run afterStartTask");
      b.t(this.e).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.b.2
 * JD-Core Version:    0.7.0.1
 */
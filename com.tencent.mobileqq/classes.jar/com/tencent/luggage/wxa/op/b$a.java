package com.tencent.luggage.wxa.op;

import android.graphics.Point;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.e.a;

class b$a
  implements e.a
{
  private int b;
  private int c;
  @Nullable
  private Point d = null;
  
  private b$a(b paramb) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    o.e(b.b(this.a), "MyOnStablePositionChangeListener, onStablePositionChange");
    if (b.a(this.a))
    {
      o.d(b.b(this.a), "onStablePositionChange, onVideoPositionGot, released");
      return;
    }
    paramInt1 = b.u(this.a).c();
    paramInt2 = b.u(this.a).d();
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      int i = b.e(this.a).a();
      int j = b.e(this.a).b();
      if (this.d == null) {
        this.d = b.v(this.a);
      }
      Point localPoint = this.d;
      if (localPoint == null)
      {
        o.c(b.b(this.a), "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        return;
      }
      int k = this.b;
      int m = this.c + localPoint.y;
      o.d(b.b(this.a), "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
      b.a(this.a, paramInt1, paramInt2, i, j, k, m);
      return;
    }
    o.c(b.b(this.a), "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.b.a
 * JD-Core Version:    0.7.0.1
 */
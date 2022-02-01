package com.tencent.luggage.wxa.op;

import android.graphics.Point;
import com.tencent.luggage.wxa.lp.h.a;
import com.tencent.luggage.wxa.qz.o;

class b$3
  implements h.a
{
  b$3(b paramb, Point paramPoint, Runnable paramRunnable) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (b.a(this.c))
    {
      o.d(b.b(this.c), "handleVideoPage2PipStart, onVideoPositionGot, released");
      return;
    }
    Point localPoint = this.a;
    localPoint.x = paramInt1;
    localPoint.y = paramInt2;
    this.b.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.b.3
 * JD-Core Version:    0.7.0.1
 */
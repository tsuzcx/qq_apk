package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.b.x;

class c$10
  implements Runnable
{
  c$10(c paramc, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void run()
  {
    if (this.a != null) {
      a.a().g();
    }
    if (this.a == null)
    {
      if (c.b(this.e) != null)
      {
        c.b(this.e).d();
        c.a(this.e, null);
      }
      return;
    }
    if (c.b(this.e) == null) {
      if ((c.c(this.e) > 0) && (c.d(this.e) > 0))
      {
        c.a(this.e, new x());
        c.b(this.e).a(true);
        if (!c.b(this.e).a())
        {
          TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
          c.b(this.e).d();
          c.a(this.e, null);
          return;
        }
        c.b(this.e).a(c.c(this.e), c.d(this.e));
      }
      else
      {
        TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
        return;
      }
    }
    c.b(this.e).c(true);
    c.b(this.e).a(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.c.10
 * JD-Core Version:    0.7.0.1
 */
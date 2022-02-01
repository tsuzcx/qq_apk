package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.beauty.b.m;

class c$6
  implements Runnable
{
  c$6(c paramc, float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3) {}
  
  public void run()
  {
    if (c.a(this.f) != null) {
      a.a().e();
    }
    if ((c.h(this.f) == null) && (c.i(this.f) == null))
    {
      if (c.a(this.f) != null)
      {
        c.a(this.f).d();
        c.a(this.f, null);
      }
    }
    else
    {
      if (c.a(this.f) == null)
      {
        c localc = this.f;
        c.a(localc, c.f(localc), c.g(this.f), c.j(this.f), c.h(this.f), c.k(this.f), c.i(this.f), c.l(this.f));
        return;
      }
      c.a(this.f).a(this.a, this.b, this.c, this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.beauty.c.6
 * JD-Core Version:    0.7.0.1
 */
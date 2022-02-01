package com.tencent.map.sdk.a;

import android.os.Handler;

public final class pt$1
  implements Runnable
{
  public pt$1(pt parampt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean, float paramFloat5) {}
  
  public final void run()
  {
    Object localObject1 = this.g;
    pt.a((pt)localObject1, pt.a((pt)localObject1) + this.a);
    localObject1 = this.g;
    pt.a((pt)localObject1, this.b, pt.a((pt)localObject1));
    if (pt.b(this.g) < 10)
    {
      pt.c(this.g).postDelayed(this, 16L);
      return;
    }
    pt.a(this.g, this.b, this.c);
    float f1 = this.d;
    if ((f1 >= 3.0F) && (f1 <= 20.0F))
    {
      if (this.e)
      {
        localObject1 = new pt.1.1(this);
        Object localObject2 = pt.d(this.g).c;
        int i = (int)this.d;
        localObject2 = ((kl)localObject2).h.g();
        if ((0L != ((pf)localObject2).b) && (((pf)localObject2).f != null)) {
          ((pf)localObject2).f.a(new pf.18((pf)localObject2, i));
        }
        ((Runnable)localObject1).run();
        return;
      }
      pt.d(this.g).c.a(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pt.1
 * JD-Core Version:    0.7.0.1
 */
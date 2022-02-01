package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.s;
import com.tencent.luggage.wxa.sv.b;

class m$4
  extends b
{
  private int b = -1;
  
  m$4(m paramm) {}
  
  public int a(boolean paramBoolean)
  {
    return 1;
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if (this.a.getContainer() != null)
    {
      Object localObject = this.a.getContainer().getCurrentPage();
      m localm = this.a;
      if (localObject == localm)
      {
        if (m.b(localm).a("scene_swipe_back", null))
        {
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandPage", "[onScrollStateChange] navigate back be intercepted");
          this.a.t();
          return;
        }
        localObject = this.a.getContainer();
        localm = m.b(this.a).b(this.a);
        if (localObject == null)
        {
          com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandPage", "onScrollStateChange, null == pageContainer");
        }
        else
        {
          float f = 100.0F * paramFloat;
          int i = (int)Math.ceil(f);
          if ((i != 0) && (-1 != this.b))
          {
            if (100 > i) {
              ((o)localObject).a(bg.c, this.a, localm, f);
            }
          }
          else if (m.c(this.a)) {
            ((o)localObject).b(bg.c, this.a, localm);
          } else {
            ((o)localObject).a(bg.c, this.a, localm);
          }
          this.b = i;
        }
        if (paramInt != 0)
        {
          m.a(this.a, true);
        }
        else
        {
          m.a(this.a, false);
          this.b = -1;
        }
        if (Float.compare(1.0F, paramFloat) <= 0)
        {
          if (this.a.a[0] == 0)
          {
            if (localm != null) {
              m.a(this.a, m.d(localm), 0.0F);
            }
            this.a.q();
            this.a.a[0] = true;
          }
        }
        else if (localm != null) {
          m.a(localm, paramFloat);
        }
        com.tencent.luggage.wxa.qz.o.f("MicroMsg.AppBrandPage", "scrollPercent %f", new Object[] { Float.valueOf(paramFloat) });
        if ((this.a.getContainer().getPageCount() == 1) && (this.a.getContainer().getRuntime().aL()) && (this.a.getContainer().getRuntime().aM() != null)) {
          this.a.getContainer().getRuntime().aM().a(paramInt, paramFloat);
        }
        return;
      }
    }
    this.a.setEnableGesture(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.m.4
 * JD-Core Version:    0.7.0.1
 */
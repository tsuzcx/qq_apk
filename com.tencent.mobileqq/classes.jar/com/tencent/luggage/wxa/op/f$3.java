package com.tencent.luggage.wxa.op;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.lp.b.a;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.lp.i.a;
import com.tencent.luggage.wxa.lp.j;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.bg;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.page.o.e;
import com.tencent.mm.plugin.appbrand.page.o.h;
import java.util.Map;

class f$3
  implements o.e
{
  private boolean b = false;
  
  f$3(f paramf) {}
  
  @Nullable
  public o.h a(@NonNull bg parambg, @Nullable m paramm1, @Nullable m paramm2)
  {
    Object localObject = f.a(paramm1);
    String str = f.a(paramm2);
    o.d(f.a(this.a), "onPageSwitchStart, pageOpenType: %s, oldPage: %s, page: %s", new Object[] { parambg, localObject, str });
    if ((paramm1 != null) && (paramm2 != null) && (f.j(this.a) != null))
    {
      boolean bool1;
      if ((f.q(this.a) != null) && (f.h(this.a) != null))
      {
        if (paramm2 == f.h(this.a)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.b = bool1;
        if ((this.b) || (bg.f == parambg) || (bg.g == parambg))
        {
          if (f.r(this.a) != null)
          {
            f.a(this.a, null);
            o.d(f.a(this.a), "onPageSwitchStart, mPipVideoTargetPageViewId about null");
            f.e(this.a, true);
            f.f(this.a, true);
            f.j(this.a).b();
            return o.h.b;
          }
          o.c(f.a(this.a), "onPageSwitchStart, null == mPipContainerOnPageSwitchHandler");
        }
        f.a(this.a, Integer.valueOf(paramm2.getCurrentPageView().hashCode()));
        o.d(f.a(this.a), "onPageSwitchStart, mPipVideoTargetPageViewId: %d(%s)", new Object[] { f.s(this.a), str });
        return null;
      }
      localObject = f.t(this.a);
      if (localObject == null) {
        return null;
      }
      if (paramm2.equals(((a)localObject).e())) {
        return null;
      }
      a.a locala = ((a)localObject).g();
      if (locala == null) {
        return null;
      }
      h localh = locala.f;
      i.a locala1 = locala.d;
      j localj = locala.g;
      if ((localh != null) && (locala1 != null) && (localj != null))
      {
        b.a locala2 = locala.b;
        bool1 = f.a(this.a, parambg, locala2);
        boolean bool2 = f.b(this.a, parambg, locala2);
        if ((bool1) || (bool2))
        {
          o.d(f.a(this.a), "onPageSwitchStart, transferTo");
          if (f.a(this.a, paramm1.getCurrentPageView(), localh, locala1, localj))
          {
            f.a(this.a, Integer.valueOf(paramm2.getCurrentPageView().hashCode()));
            o.d(f.a(this.a), "onPageSwitchStart, mPipVideoTargetPageViewId: %d(%s)", new Object[] { f.s(this.a), str });
            f.a(this.a, (a)localObject, locala);
            f.g(this.a, false);
            if ((f.d(this.a) != null) && (f.e(this.a) != null))
            {
              paramm1 = f.e(this.a);
              paramm2 = f.d(this.a).h;
              if (bool1) {
                parambg = b.a.b;
              } else {
                parambg = b.a.c;
              }
              paramm1.b(paramm2, parambg);
            }
            f.e(this.a, true);
            f.f(this.a, false);
            f.j(this.a).b();
            return o.h.a;
          }
        }
        return null;
      }
      return null;
    }
    return null;
  }
  
  public void a(@NonNull bg parambg, @Nullable m paramm1, @Nullable m paramm2, float paramFloat)
  {
    if ((f.c(this.a)) && (f.q(this.a) != null) && (f.r(this.a) != null))
    {
      if (f.u(this.a))
      {
        f.r(this.a).a(100.0F - paramFloat);
        return;
      }
      f.r(this.a).a(paramFloat);
    }
  }
  
  public void b(@NonNull bg parambg, @Nullable m paramm1, @Nullable m paramm2)
  {
    o.d(f.a(this.a), "onPageSwitchEnd, pageOpenType: %s, oldPage: %s, page: %s", new Object[] { parambg, f.a(paramm1), f.a(paramm2) });
    if (paramm1 != null)
    {
      paramm2 = (a)f.p(this.a).get(Integer.valueOf(paramm1.getCurrentPageView().hashCode()));
      if ((paramm2 != null) && (bg.c == parambg) && (paramm1 != f.h(this.a))) {
        paramm2.c();
      }
    }
    if ((f.c(this.a)) && (f.u(this.a)))
    {
      parambg = f.a(this.a);
      paramm1 = new StringBuilder();
      paramm1.append("onPageSwitchEnd, tryTransferFrom, isBack: ");
      paramm1.append(this.b);
      o.d(parambg, paramm1.toString());
      if (f.h(this.a, true))
      {
        if ((f.e(this.a) != null) && (f.d(this.a) != null))
        {
          parambg = e.g;
          if (f.b(this.a)) {
            parambg = e.a;
          } else if (!this.b) {
            parambg = e.e;
          }
          f.e(this.a).a(f.d(this.a).h, parambg);
        }
        if (!this.b) {
          o.d(f.a(this.a), "onPageSwitchEnd, clearPipVideoRelated");
        }
        parambg = this.a;
        boolean bool = this.b;
        f.a(parambg, bool ^ true, bool ^ true);
      }
      f.a(this.a, false);
      f.f(this.a, false);
      f.e(this.a, false);
    }
    if ((f.c(this.a)) && (f.q(this.a) != null) && (f.r(this.a) != null))
    {
      f.r(this.a).b();
      f.e(this.a, false);
      if (f.j(this.a) != null) {
        f.j(this.a).b(true);
      }
    }
    if ((f.v(this.a)) && (f.q(this.a) != null) && (f.j(this.a) != null))
    {
      o.d(f.a(this.a), "onPageSwitchEnd, transferFrom for other video is playing");
      f.j(this.a).post(new f.3.1(this));
    }
  }
  
  public void c(@NonNull bg parambg, @Nullable m paramm1, @Nullable m paramm2)
  {
    String str = f.a(paramm1);
    paramm2 = f.a(paramm2);
    o.d(f.a(this.a), "onPageSwitchCancel, type: %s, oldPage: %s, newPage: %s", new Object[] { parambg, str, paramm2 });
    if ((f.c(this.a)) && (f.h(this.a) != null) && (f.j(this.a) != null))
    {
      f.a(this.a, null);
      o.d(f.a(this.a), "onPageSwitchCancel, mPipVideoTargetPageViewId about null");
      int i;
      if ((paramm1 == f.h(this.a)) && (f.h(this.a, true)))
      {
        if ((f.e(this.a) != null) && (f.d(this.a) != null)) {
          f.e(this.a).a(f.d(this.a).h, e.g);
        }
        f.a(this.a, false, false);
        i = 1;
      }
      else
      {
        i = 0;
      }
      if ((f.u(this.a)) && (f.r(this.a) != null)) {
        f.r(this.a).b();
      }
      f.e(this.a, false);
      f.f(this.a, false);
      f.j(this.a).b(0x1 ^ i);
      return;
    }
    if (!f.c(this.a))
    {
      if (paramm1 == null)
      {
        o.c(f.a(this.a), "onPageSwitchCancel, oldPage is null");
        return;
      }
      f.a(this.a, Integer.valueOf(paramm1.getCurrentPageView().hashCode()));
      o.d(f.a(this.a), "onPageSwitchCancel, mPipVideoTargetPageViewId: %d(%s)", new Object[] { f.s(this.a), paramm2 });
      return;
    }
    o.d(f.a(this.a), "onPageSwitchCancel, isTransfering but mPipVideoRelatedPage or mPipContainerView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.3
 * JD-Core Version:    0.7.0.1
 */
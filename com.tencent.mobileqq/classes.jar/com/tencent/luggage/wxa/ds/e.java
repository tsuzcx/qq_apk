package com.tencent.luggage.wxa.ds;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jj.a.d;
import com.tencent.luggage.wxa.jx.t;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.or.n;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;

public final class e
{
  private boolean a = false;
  private int b;
  private int c;
  private boolean d = false;
  private final Map<String, Object> e = new HashMap();
  private boolean f = false;
  private final u g;
  private final t h = new t();
  
  public e(u paramu)
  {
    this.g = paramu;
  }
  
  private <EVENT extends t> void a(EVENT paramEVENT)
  {
    Object localObject = e();
    if (localObject == null) {
      return;
    }
    int[] arrayOfInt = w.a(f());
    Map localMap = c();
    localMap.put("originalPageOrientation", ((a.d)localObject).m);
    localMap.put("lastPageOrientation", i());
    localObject = this.g;
    paramEVENT.a((u)localObject, ((u)localObject).getComponentId(), this.g.ag().getWidth(), this.g.ag().getHeight(), arrayOfInt[0], arrayOfInt[1], this.g.y().getOrientationHandler().a(), localMap);
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    e.b localb2 = e.b.a(i());
    e.b localb1 = localb2;
    if (localb2 == null) {
      localb1 = e.b.a;
    }
    boolean bool2 = ArrayUtils.contains(e.b.h, localb1);
    boolean bool1 = false;
    if (bool2)
    {
      if (paramInt1 > paramInt2) {
        bool1 = true;
      }
      return bool1;
    }
    if (e.b.a == localb1)
    {
      int i;
      if (paramInt2 > paramInt1) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return true;
      }
      if (k())
      {
        if ((this.g.y().getOrientationHandler().a() != e.b.a) && (this.g.Y().getRequestedOrientation() != 1)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          if (paramInt1 > 0) {
            i = 1;
          } else {
            i = 0;
          }
          int j;
          if (paramInt2 > 0) {
            j = 1;
          } else {
            j = 0;
          }
          if ((i & j) != 0)
          {
            bool1 = true;
            break label176;
          }
        }
        bool1 = false;
        label176:
        o.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "isViewSizeMatchedByRequestedOrientation, activityInMultiWindowMode width[%d] height[%d] ret[%b]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool1) });
        return bool1;
      }
      return false;
    }
    return true;
  }
  
  @NonNull
  private Map<String, Object> c()
  {
    HashMap localHashMap = new HashMap(this.e);
    this.e.clear();
    return localHashMap;
  }
  
  private boolean d()
  {
    return this.g.d();
  }
  
  private a.d e()
  {
    return this.g.am();
  }
  
  private h f()
  {
    return this.g.p();
  }
  
  private String g()
  {
    return this.g.getAppId();
  }
  
  private String h()
  {
    return this.g.an();
  }
  
  private String i()
  {
    return this.g.aF();
  }
  
  private View j()
  {
    return this.g.ag();
  }
  
  private boolean k()
  {
    boolean bool3 = this.g.y() instanceof n;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 24)
      {
        bool1 = bool2;
        if (this.g.Y() != null)
        {
          bool1 = bool2;
          if (this.g.Y().isInMultiWindowMode()) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void l()
  {
    if (!d()) {
      return;
    }
    if (this.f)
    {
      a(new e.a(null));
      this.f = false;
      o.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", new Object[] { g(), h(), i() });
      return;
    }
    a(this.h);
  }
  
  public void a()
  {
    if (this.a)
    {
      o.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onForeground dispatch ViewDidResize appId[%s] url[%s]", new Object[] { g(), h() });
      l();
      this.a = false;
    }
    this.d = true;
  }
  
  public void a(h paramh)
  {
    int i = j().getWidth();
    int j = j().getHeight();
    if ((i > 0) && (j > 0))
    {
      boolean bool1;
      if ((i == this.b) && (j == this.c)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      this.b = i;
      this.c = j;
      paramh = w.a(this.g);
      boolean bool2;
      if ((a(i, j)) && (a(paramh[0], paramh[1]))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3;
      if ((this.b != 0) && (this.c != 0)) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      o.d("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", new Object[] { g(), h(), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(this.d), Boolean.valueOf(this.a) });
      if (((bool3) && (bool1) && (bool2)) || ((this.f) && (bool2))) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (this.d)
        {
          l();
          return;
        }
        this.a = true;
        return;
      }
      this.a = false;
      return;
    }
    o.b("Luggage.AppBrandPageViewResizedEmitter[pageOrientation]", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), g(), h() });
  }
  
  public void a(@Nullable Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      this.e.putAll(paramMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void b()
  {
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.e
 * JD-Core Version:    0.7.0.1
 */
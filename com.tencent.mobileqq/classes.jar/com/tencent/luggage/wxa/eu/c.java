package com.tencent.luggage.wxa.eu;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.jj.k;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.an;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.page.bm;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Map;

public class c
  extends ax<com.tencent.luggage.wxa.em.c>
{
  public c(@NonNull com.tencent.luggage.wxa.em.c paramc)
  {
    super(paramc);
  }
  
  protected final ap a()
  {
    if ((b().supportFeature(2002)) && (b().supportFeature(2004))) {
      return new c.1(this, this);
    }
    return super.a();
  }
  
  public boolean a(String paramString)
  {
    boolean bool = super.a(paramString);
    a.a((com.tencent.luggage.wxa.em.c)y());
    return bool;
  }
  
  protected final an a_(@NonNull Context paramContext)
  {
    paramContext = new bm(paramContext);
    k.a(paramContext.getOriginUserAgent());
    return paramContext;
  }
  
  @Nullable
  public bm b()
  {
    if ((E() instanceof bm)) {
      return (bm)E();
    }
    if ((E() instanceof af))
    {
      am localam = ((af)E()).b();
      if ((localam instanceof bm)) {
        return (bm)localam;
      }
    }
    return null;
  }
  
  public void e()
  {
    y().getClass();
    if (com.tencent.luggage.wxa.ev.a.a((u)y())) {
      com.tencent.luggage.wxa.qc.a.a(((com.tencent.luggage.wxa.em.c)y()).getJsRuntime(), ((com.tencent.luggage.wxa.em.c)y()).i().getComponentId(), ((com.tencent.luggage.wxa.em.c)y()).getComponentId(), o());
    }
    super.e();
  }
  
  public Map<String, m> j()
  {
    return new com.tencent.luggage.wxa.em.a().b();
  }
  
  public void l()
  {
    y().getClass();
    if (com.tencent.luggage.wxa.ev.a.a((u)y()))
    {
      com.tencent.luggage.wxa.qc.a.a();
      com.tencent.luggage.wxa.qc.a.b(E(), ((com.tencent.luggage.wxa.em.c)y()).getComponentId(), o());
      com.tencent.luggage.wxa.qc.a.a(E(), ((com.tencent.luggage.wxa.em.c)y()).getComponentId(), o());
    }
  }
  
  public final n m()
  {
    return (n)a(n.class);
  }
  
  public final int q()
  {
    return n().j().n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.eu.c
 * JD-Core Version:    0.7.0.1
 */
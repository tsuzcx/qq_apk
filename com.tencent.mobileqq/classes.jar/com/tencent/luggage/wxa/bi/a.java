package com.tencent.luggage.wxa.bi;

import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.da.g;
import com.tencent.luggage.wxa.iu.ae.a;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e;
import java.util.concurrent.TimeUnit;

public class a
  extends com.tencent.luggage.wxa.ed.b
{
  private final long b;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private boolean f = false;
  private View g;
  
  public a(com.tencent.luggage.wxa.pa.a parama, Class<? extends com.tencent.luggage.wxa.ed.d> paramClass)
  {
    super(parama, paramClass);
    if (!(parama.g() instanceof com.tencent.luggage.ui.d)) {
      a(com.tencent.luggage.ui.d.a(parama.f()));
    }
    this.b = af.d();
  }
  
  private void a(com.tencent.luggage.wxa.do.c paramc, com.tencent.luggage.wxa.ew.b paramb, com.tencent.luggage.wxa.ou.d paramd, a.b paramb1)
  {
    new a.a(this, paramc, paramd, paramb1, paramc, paramb, paramb1).a();
  }
  
  protected com.tencent.luggage.wxa.ed.d a(@NonNull h paramh)
  {
    com.tencent.luggage.wxa.em.d locald = ae.a.a(paramh);
    if (locald != null)
    {
      locald.a(this);
      return locald;
    }
    return super.a(paramh);
  }
  
  @NonNull
  protected com.tencent.luggage.wxa.ou.d a()
  {
    com.tencent.luggage.wxa.ou.d locald = new com.tencent.luggage.wxa.ou.d();
    locald.c = 1168;
    return locald;
  }
  
  protected void a(com.tencent.luggage.wxa.do.c paramc, com.tencent.luggage.wxa.ew.b paramb, com.tencent.luggage.wxa.ou.d paramd) {}
  
  protected void a(com.tencent.luggage.wxa.ed.d paramd1, com.tencent.luggage.wxa.ed.d paramd2, h paramh)
  {
    if (paramd2.aw())
    {
      o.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "loadNew(), runtime(%s) initialized, should be preRendered, use loadExisted() instead", new Object[] { paramd2.aa() });
      super.b(paramd1, paramd2, paramh);
      return;
    }
    if (paramd2.Z())
    {
      o.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "loadNew(), runtime(%s) isLaunched, should be preRendered, use loadExisted() instead", new Object[] { paramd2.aa() });
      super.b(paramd1, paramd2, paramh);
      return;
    }
    if ((paramd1 != null) && (c.a(paramd1, paramd2, (com.tencent.luggage.wxa.do.c)paramh)))
    {
      o.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "loadNew(), runtime(%s) loadNewRuntimeUglyMaybe", new Object[] { paramd2.aa(), paramd2 });
      return;
    }
    super.a(paramd1, paramd2, paramh);
  }
  
  boolean a(@NonNull Intent paramIntent, String paramString)
  {
    if ("onCreate".equals(paramString)) {
      o.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "|runProfiled| constructed -> performLaunch %dms", new Object[] { Long.valueOf(af.d() - this.b) });
    }
    com.tencent.luggage.wxa.ew.b localb = new com.tencent.luggage.wxa.ew.b();
    if ((g.b(localb, paramIntent, "action")) && (!TextUtils.isEmpty(localb.a)))
    {
      com.tencent.luggage.wxa.nn.a locala = com.tencent.luggage.wxa.db.a.a(localb);
      locala.g = ((j)paramIntent.getParcelableExtra("referrer"));
      paramString = (com.tencent.luggage.wxa.ou.d)paramIntent.getParcelableExtra("statObject");
      com.tencent.luggage.wxa.ed.d locald = (com.tencent.luggage.wxa.ed.d)a(localb.a);
      if ((locald != null) && (locald.ab() == localb.e))
      {
        paramIntent = locald.j().m();
        locala.a(paramIntent);
        paramIntent.I = com.tencent.luggage.wxa.nn.a.b(localb.d);
        paramIntent.e();
        a(paramIntent, localb, paramString, null);
        return true;
      }
      this.d = true;
      paramString = (com.tencent.luggage.wxa.ou.d)paramIntent.getParcelableExtra("statObject");
      o.e("Luggage.AppBrandRuntimeContainerStandaloneImpl", "runtimeContainer cost %d", new Object[] { Long.valueOf(af.d() - this.b) });
      com.tencent.mm.plugin.appbrand.keylogger.d.a(localb.a, com.tencent.luggage.wxa.oy.a.f, "", TimeUnit.NANOSECONDS.toMillis(localb.j), af.d());
      paramIntent = paramString;
      if (paramString == null) {
        paramIntent = a();
      }
      locala.f = paramIntent;
      paramIntent = new com.tencent.luggage.wxa.cx.r(locala);
      paramIntent.a().b(new a.3(this, locala, localb)).a(com.tencent.luggage.wxa.rp.d.b, new a.2(this)).a(com.tencent.luggage.wxa.rp.d.b, new a.1(this, paramIntent));
      com.tencent.luggage.wxa.ef.d.a("RuntimeContainerProfile| create loading placeholder", new a.4(this));
      return true;
    }
    if (getActiveRuntime() == null)
    {
      s().d();
      Toast.makeText(s().g().getApplicationContext(), "Error Action", 0).show();
    }
    return false;
  }
  
  @Nullable
  protected View b()
  {
    return com.tencent.luggage.ui.a.a.a(u());
  }
  
  public void c()
  {
    this.f = true;
    if (this.d)
    {
      o.d("Luggage.AppBrandRuntimeContainerStandaloneImpl", "onResume, skip by mPerformingLoadNew");
      this.e = true;
      return;
    }
    super.c();
  }
  
  public void d()
  {
    this.f = false;
    this.e = false;
    super.d();
  }
  
  public void e()
  {
    this.c = true;
    super.e();
    if ((getContext() instanceof MutableContextWrapper)) {
      ((MutableContextWrapper)getContext()).setBaseContext(com.tencent.luggage.wxa.qz.r.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bi.a
 * JD-Core Version:    0.7.0.1
 */
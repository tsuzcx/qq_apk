package com.tencent.luggage.wxa.em;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.tencent.luggage.setting.ui.WxaSettingActivity.a;
import com.tencent.luggage.wxa.dc.s;
import com.tencent.luggage.wxa.dd.b.a;
import com.tencent.luggage.wxa.ec.g;
import com.tencent.luggage.wxa.jj.a.d;
import com.tencent.luggage.wxa.kx.j;
import com.tencent.luggage.wxa.kx.k;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collection;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.joor.Reflect;
import org.joor.ReflectException;

public class d
  extends com.tencent.luggage.wxa.ed.d
{
  private final b.a c = new d.1(this);
  @Nullable
  private f d;
  private boolean e;
  
  static
  {
    com.tencent.luggage.wxa.ed.h.a.a(true);
    com.tencent.luggage.wxa.ed.h.a.b(true);
    com.tencent.luggage.wxa.fw.a.b();
  }
  
  public d(@NonNull com.tencent.luggage.wxa.iu.n paramn)
  {
    super(paramn);
    a(paramn);
  }
  
  public d(@NonNull com.tencent.luggage.wxa.oq.c paramc)
  {
    super(paramc);
    a(null);
  }
  
  private void R()
  {
    com.tencent.luggage.wxa.mp.e locale = (com.tencent.luggage.wxa.mp.e)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.mp.e.class);
    if (locale != null) {
      locale.a(aa(), new d.4(this));
    }
  }
  
  @Nullable
  private a.d S()
  {
    if (!aw())
    {
      localObject = aj();
      if (localObject == null) {
        return null;
      }
      return ((com.tencent.luggage.wxa.jj.a)localObject).a(com.tencent.luggage.util.m.b(as()));
    }
    Object localObject = k();
    if (localObject == null) {
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.page.o)localObject).getCurrentPage();
    if (localObject == null) {
      return null;
    }
    return ((com.tencent.mm.plugin.appbrand.page.m)localObject).getPageConfig();
  }
  
  private void a(com.tencent.luggage.wxa.iu.d paramd, WxaSettingActivity.a parama)
  {
    if (paramd != null)
    {
      Object localObject = (j)paramd.c(j.class);
      if (!(localObject instanceof k))
      {
        com.tencent.luggage.wxa.qz.o.c("Luggage.STANDALONE.Runtime", "handleUserAuthChanged, invalid location state manager");
        return;
      }
      localObject = (k)localObject;
      boolean bool2 = parama.a;
      boolean bool3 = parama.b;
      boolean bool1;
      if ((!((k)localObject).a()) && (!bool2)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if ((((k)localObject).a()) && ((!bool3) || (!bool2))) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "handleUserAuthChanged, should stop location foreground:%s, should stop location background:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      if ((bool1) || (bool2))
      {
        ((k)localObject).j();
        ((k)localObject).a(paramd);
      }
      if (bool2)
      {
        com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "locationBackgroundStateChanged, not listening, appId[%s]", new Object[] { aa() });
        al().c();
      }
    }
  }
  
  @UiThread
  private void a(e.a parama, a.d paramd)
  {
    boolean bool = au();
    Object localObject = null;
    if (bool)
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "mayRequestOrientation mFinished is true return,mAppId:%s", new Object[] { aa() });
      parama.a(null, false);
      return;
    }
    if (t())
    {
      paramd = e.b.a(aj().f().a);
    }
    else if (paramd == null)
    {
      if (!X()) {
        paramd = (a.d)localObject;
      } else {
        throw new IllegalArgumentException("page config should not be NULL!!");
      }
    }
    else
    {
      paramd = e.b.a(paramd.m);
      if ((e.b.b(W().getOrientationHandler().a())) && (((com.tencent.luggage.wxa.do.a)b(com.tencent.luggage.wxa.do.a.class)).a))
      {
        parama.a(null, false);
        return;
      }
    }
    com.tencent.luggage.wxa.oq.e locale = W().getOrientationHandler();
    localObject = paramd;
    if (paramd == null) {
      localObject = e.b.a;
    }
    locale.a((e.b)localObject, parama);
  }
  
  public d.a D()
  {
    return d.a.a;
  }
  
  public final void E()
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "finish appId[%s] type[%d] hash[%d] isFinishing[%b] stacktrace=%s", new Object[] { aa(), Integer.valueOf(ab()), Integer.valueOf(hashCode()), Boolean.valueOf(av()), Log.getStackTraceString(new Throwable()) });
    if (av()) {
      return;
    }
    super.E();
  }
  
  public final boolean F()
  {
    return t() ^ true;
  }
  
  public com.tencent.luggage.wxa.eo.a G()
  {
    return (com.tencent.luggage.wxa.eo.a)super.j();
  }
  
  protected com.tencent.mm.plugin.appbrand.ui.d H()
  {
    com.tencent.luggage.ui.a locala = com.tencent.luggage.ui.a.a.a(ah());
    locala.a(this);
    return locala;
  }
  
  protected com.tencent.luggage.wxa.iu.h I()
  {
    if (u()) {
      return new com.tencent.luggage.standalone_ext.service.a(com.tencent.luggage.wxa.du.i.a);
    }
    if (t())
    {
      f localf = this.d;
      localf.getClass();
      return ((f)localf).b(this);
    }
    return new com.tencent.luggage.standalone_ext.service.a();
  }
  
  protected com.tencent.mm.plugin.appbrand.page.o J()
  {
    if (t())
    {
      f localf = this.d;
      localf.getClass();
      return ((f)localf).c(this);
    }
    return new b(ah(), this);
  }
  
  @Nullable
  public com.tencent.mm.plugin.appbrand.appstorage.n K()
  {
    return (com.tencent.mm.plugin.appbrand.appstorage.n)super.d(com.tencent.mm.plugin.appbrand.appstorage.n.class);
  }
  
  @CallSuper
  protected void L()
  {
    a(new d.3(this));
  }
  
  protected void M()
  {
    Object localObject = i();
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.STANDALONE.Runtime", "setupConfigs get NULL sysConfig, appId[%s]", new Object[] { aa() });
      return;
    }
    at().add(com.tencent.luggage.wxa.jj.e.a(this));
    at().add(com.tencent.luggage.wxa.jj.e.a((com.tencent.luggage.wxa.do.d)localObject));
    at().add(com.tencent.luggage.wxa.jj.e.b((com.tencent.luggage.wxa.do.d)localObject));
    at().add(com.tencent.luggage.wxa.jj.e.b(this));
    localObject = com.tencent.luggage.wxa.jj.e.c((com.tencent.luggage.wxa.do.d)localObject);
    ((com.tencent.luggage.wxa.om.a)localObject).b = (false | ((com.tencent.luggage.wxa.om.a)localObject).b);
    at().add(localObject);
    com.tencent.luggage.wxa.by.a.a(aa(), new d.5(this));
  }
  
  protected void N()
  {
    com.tencent.luggage.wxa.by.a.a(ae());
    new com.tencent.luggage.wxa.ec.f(this).g();
  }
  
  protected void O()
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "onPrepareDone appId:%s", new Object[] { aa() });
  }
  
  protected void P()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Luggage.STANDALONE.Runtime:");
    localStringBuilder.append(aa());
    a(localStringBuilder.toString());
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.iu.n paramn)
  {
    super.a(paramn);
    Context localContext;
    if (paramn != null)
    {
      localContext = paramn.getContext();
      if ((paramn instanceof com.tencent.luggage.wxa.iu.e))
      {
        paramn = ((com.tencent.luggage.wxa.iu.e)paramn).u();
        paramn.getClass();
        localContext = (Context)paramn;
      }
      if ((ag() instanceof com.tencent.luggage.ui.d)) {
        ((com.tencent.luggage.ui.d)ag()).setBaseContext(localContext);
      }
      if (aV() != null) {
        aV().a(localContext);
      }
      if (ae() != null) {
        ae().a(W());
      }
      if ((k() != null) && (k().getCurrentPage() != null)) {
        paramn = k().getCurrentPage().getCurrentPageView();
      } else {
        paramn = null;
      }
      if (paramn != null) {
        paramn.a(W());
      }
    }
    else if (G() != null)
    {
      com.tencent.luggage.ui.b localb = new com.tencent.luggage.ui.b(G().z, r.a());
      localContext = localb.getContext();
      paramn = localContext;
      if ((localContext instanceof com.tencent.luggage.ui.d)) {
        paramn = ((com.tencent.luggage.ui.d)localContext).getBaseContext();
      }
      if ((ag() instanceof com.tencent.luggage.ui.d)) {
        ((com.tencent.luggage.ui.d)ag()).setBaseContext(paramn);
      }
      if (aV() != null) {
        aV().a(paramn);
      }
      if (ae() != null) {
        ae().a(localb);
      }
      if (k() != null) {
        p.a(k(), localb);
      }
    }
  }
  
  protected void a(@Nullable com.tencent.luggage.wxa.jj.h paramh, String paramString)
  {
    if (paramh == null)
    {
      G().e();
      G().l = af.d();
    }
    super.a(paramh, paramString);
  }
  
  protected boolean a(com.tencent.luggage.wxa.jj.h paramh)
  {
    boolean bool = super.a(paramh);
    if ((bool) && (!aG())) {
      com.tencent.luggage.wxa.cx.d.a.b(this);
    }
    return bool;
  }
  
  protected boolean b(@NonNull com.tencent.luggage.wxa.jj.h paramh)
  {
    com.tencent.luggage.wxa.do.c localc = (com.tencent.luggage.wxa.do.c)paramh;
    Object localObject = G();
    com.tencent.luggage.wxa.ou.d locald = localc.f();
    paramh = aa();
    boolean bool = false;
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "shouldRelaunchOnConfigChanged, appId[%s] newPath[%s] oldPath[%s] currentPath[%s]", new Object[] { paramh, localc.I, ((com.tencent.luggage.wxa.do.c)localObject).I, k().getCurrentUrl() });
    if ((!this.e) && (locald.c != 1099))
    {
      if (localc.f().c == ((com.tencent.luggage.wxa.do.c)localObject).f().c)
      {
        if (TextUtils.isEmpty(localc.I)) {
          paramh = aj().h();
        } else {
          paramh = localc.I;
        }
        if (TextUtils.isEmpty(((com.tencent.luggage.wxa.do.c)localObject).I)) {
          localObject = aj().h();
        } else {
          localObject = ((com.tencent.luggage.wxa.do.c)localObject).I;
        }
        if ((StringUtils.equals((String)localObject, paramh)) && (StringUtils.equals(paramh, k().getCurrentUrl())))
        {
          com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "shouldRelaunchOnConfigChanged, both scene & path the same, return false, scene[%d], path[%s]", new Object[] { Integer.valueOf(localc.f().c), localc.I });
          return false;
        }
      }
      int i = locald.c;
      if (ArrayUtils.contains(new int[] { 1001, 1003, 1023, 1038, 1056, 1080, 1083, 1089, 1090, 1103, 1104, 1113, 1114, 1117, 1131 }, i))
      {
        com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "shouldRelaunch return false. keepNoRelaunch appId[%s] newScene[%d]", new Object[] { aa(), Integer.valueOf(locald.c) });
        return false;
      }
      com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "shouldRelaunchOnConfigChanged, fallback return true");
      return true;
    }
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "shouldRelaunch return true. appId[%s] mShouldRelaunchCausedByFunctionalPageOpen[%b] newScene[%d]", new Object[] { aa(), Boolean.valueOf(this.e), Integer.valueOf(locald.c) });
    if (locald.c == 1099) {
      bool = true;
    }
    this.e = bool;
    return true;
  }
  
  protected void c()
  {
    super.c();
    com.tencent.luggage.wxa.by.a.a(ae());
  }
  
  public void d()
  {
    if (t()) {}
    try
    {
      this.d = ((f)Reflect.on("com.tencent.luggage.standalone_ext.game.impl.StandaloneGameRuntimeSetupDelegateIMPL").create().get());
    }
    catch (ReflectException localReflectException)
    {
      label29:
      f localf;
      boolean bool;
      break label29;
    }
    throw new RuntimeException("Check your proguard config pls, you should keep 'com.tencent.luggage.standalone_ext.game.impl.StandaloneGameGlobalSetupDelegateIMPL' for mini-game support.");
    com.tencent.mm.plugin.appbrand.keylogger.d.a(aa(), com.tencent.luggage.wxa.oy.a.g);
    com.tencent.luggage.wxa.fa.b.a.a(new d.2(this));
    com.tencent.luggage.wxa.fa.b.a.a(this);
    super.d();
    a(com.tencent.luggage.wxa.ob.b.class, s.a);
    if (t())
    {
      localf = this.d;
      localf.getClass();
      ((f)localf).a(this);
    }
    new com.tencent.luggage.wxa.ec.f(this).g();
    L();
    R();
    if (l().c == 1099) {
      bool = true;
    } else {
      bool = false;
    }
    this.e = bool;
  }
  
  protected void e()
  {
    com.tencent.luggage.wxa.fa.b.a.a(this);
    super.e();
    new com.tencent.luggage.wxa.ec.i(this).g();
  }
  
  protected void m()
  {
    super.m();
    com.tencent.mm.plugin.appbrand.keylogger.d.b(aa(), com.tencent.luggage.wxa.oy.a.y);
    com.tencent.mm.plugin.appbrand.keylogger.d.b(com.tencent.luggage.wxa.oy.a.class, aa());
  }
  
  protected void n()
  {
    super.n();
    com.tencent.luggage.wxa.dd.i.a.a(this.c);
    com.tencent.mm.plugin.appbrand.keylogger.d.b(aa(), com.tencent.luggage.wxa.oy.a.g);
    com.tencent.mm.plugin.appbrand.keylogger.d.a(aa(), com.tencent.luggage.wxa.oy.a.y);
  }
  
  protected void o()
  {
    com.tencent.luggage.wxa.fa.b.a.b(this);
    super.o();
    com.tencent.luggage.wxa.by.a.b(ae());
    new g(this).g();
    com.tencent.luggage.wxa.dd.i.a.b(this.c);
    com.tencent.luggage.wxa.mx.c.b();
    com.tencent.luggage.wxa.mp.e locale = (com.tencent.luggage.wxa.mp.e)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.mp.e.class);
    if (locale != null) {
      locale.a(aa());
    }
  }
  
  public boolean t()
  {
    return G().g();
  }
  
  public final void y()
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.STANDALONE.Runtime", "close appId[%s] type[%d] hash[%d] stacktrace=%s", new Object[] { aa(), Integer.valueOf(ab()), Integer.valueOf(hashCode()), Log.getStackTraceString(new Throwable()) });
    super.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.d
 * JD-Core Version:    0.7.0.1
 */
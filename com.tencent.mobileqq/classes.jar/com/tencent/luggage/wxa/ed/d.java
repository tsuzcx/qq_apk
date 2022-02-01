package com.tencent.luggage.wxa.ed;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.g;
import com.tencent.luggage.wxa.iu.q;
import com.tencent.luggage.wxa.jj.e;
import com.tencent.luggage.wxa.jj.s.f;
import com.tencent.luggage.wxa.ku.ao;
import com.tencent.luggage.wxa.ny.h.a;
import com.tencent.luggage.wxa.on.i;
import com.tencent.luggage.wxa.on.k;
import com.tencent.luggage.wxa.ou.l.a;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.ak;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appstorage.n.a;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.widget.f;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import org.json.JSONObject;

public class d
  extends com.tencent.luggage.wxa.iu.d
{
  private com.tencent.mm.plugin.appbrand.ui.b c;
  private Boolean d = null;
  private volatile com.tencent.luggage.wxa.on.c e;
  
  static
  {
    ak.a(h.a);
    com.tencent.mm.plugin.appbrand.appcache.af.a(h.a.a);
  }
  
  public d(@NonNull com.tencent.luggage.wxa.iu.n paramn)
  {
    super(paramn);
  }
  
  protected d(@NonNull com.tencent.luggage.wxa.oq.c paramc)
  {
    super(paramc);
  }
  
  private com.tencent.luggage.wxa.jj.j a(com.tencent.luggage.wxa.jj.h paramh, @Nullable q paramq)
  {
    com.tencent.luggage.wxa.jj.j localj = new com.tencent.luggage.wxa.jj.j();
    localj.b = paramh.D;
    localj.a = 3;
    Object localObject = null;
    if (paramq == null) {
      paramh = null;
    } else {
      paramh = paramq.a.toString();
    }
    localj.c = paramh;
    if (paramq == null) {
      paramh = localObject;
    } else {
      paramh = paramq.b.toString();
    }
    localj.d = paramh;
    return localj;
  }
  
  private static boolean a(@NonNull com.tencent.luggage.wxa.do.c paramc)
  {
    return (paramc.d) && ((c(paramc)) || (b(paramc)));
  }
  
  private static boolean b(com.tencent.luggage.wxa.do.c paramc)
  {
    return paramc.f().c == 1101;
  }
  
  private static boolean c(@NonNull com.tencent.luggage.wxa.do.c paramc)
  {
    paramc = paramc.f();
    return (paramc.c == 1011) || (paramc.c == 1012) || (paramc.c == 1013);
  }
  
  private com.tencent.mm.plugin.appbrand.appstorage.n e(boolean paramBoolean)
  {
    com.tencent.mm.plugin.appbrand.appstorage.n localn = (com.tencent.mm.plugin.appbrand.appstorage.n)super.d(com.tencent.mm.plugin.appbrand.appstorage.n.class);
    if (localn == null)
    {
      if (!paramBoolean) {
        return localn;
      }
      throw new n.a();
    }
    return localn;
  }
  
  protected <T extends com.tencent.luggage.wxa.hw.a> T a(Class<T> paramClass)
  {
    if (com.tencent.luggage.wxa.on.j.class == paramClass) {
      return (com.tencent.luggage.wxa.hw.a)paramClass.cast(com.tencent.luggage.wxa.on.l.a);
    }
    if (i.class == paramClass)
    {
      k localk = new k(this);
      a(i.class, localk);
      return (com.tencent.luggage.wxa.hw.a)paramClass.cast(localk);
    }
    return super.a(paramClass);
  }
  
  protected com.tencent.luggage.wxa.jj.a a(boolean paramBoolean)
  {
    Object localObject2 = ad.a(this, "/app-config.json");
    Object localObject1 = localObject2;
    if (com.tencent.luggage.wxa.qz.af.c((String)localObject2))
    {
      localObject3 = i().S.e.iterator();
      do
      {
        do
        {
          localObject1 = localObject2;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = (ModulePkgInfo)((Iterator)localObject3).next();
        } while (!((ModulePkgInfo)localObject1).independent);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((ModulePkgInfo)localObject1).name);
        String str = ((ModulePkgInfo)localObject1).name;
        localObject1 = "/";
        if (str.endsWith("/")) {
          localObject1 = "";
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("app-config.json");
        localObject1 = ad.a(this, ((StringBuilder)localObject2).toString());
        localObject2 = localObject1;
      } while (com.tencent.luggage.wxa.qz.af.c((String)localObject1));
    }
    Object localObject3 = "{}";
    localObject2 = localObject3;
    if (paramBoolean)
    {
      localObject2 = ad.a(this, "/app-config-darkmode.json");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject2 = localObject3;
      }
    }
    localObject1 = com.tencent.luggage.wxa.jj.a.a(aa(), (String)localObject1, (String)localObject2, Boolean.parseBoolean(e(true).b("pruneWxConfigByPage")), t());
    if (!t())
    {
      ((com.tencent.luggage.wxa.jj.a)localObject1).f().a = j().H;
      ((com.tencent.luggage.wxa.jj.a)localObject1).f().b = true;
      return localObject1;
    }
    if (!((com.tencent.luggage.wxa.jj.a)localObject1).i().booleanValue()) {
      ((com.tencent.luggage.wxa.jj.a)localObject1).f().a = j().p.d;
    }
    return localObject1;
  }
  
  public final com.tencent.luggage.wxa.on.c a()
  {
    return this.e;
  }
  
  public final void a(com.tencent.luggage.wxa.do.c paramc, com.tencent.luggage.wxa.ou.d paramd)
  {
    if (paramc != null)
    {
      if (paramd == null) {
        return;
      }
      com.tencent.luggage.wxa.iu.n localn = af();
      if (localn == null)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.AppBrandRuntimeLU", "load with self.appId[%s] config[%s] stat[%d], skip by NULL container", new Object[] { aa(), paramc.D, Integer.valueOf(paramd.c) });
        return;
      }
      if ((localn instanceof b))
      {
        ((b)localn).a(this, paramc, paramd);
        return;
      }
      if ((localn instanceof c))
      {
        ((c)localn).a(this, paramc, paramd);
        return;
      }
      localn.a(this, paramc);
    }
  }
  
  protected void a(com.tencent.luggage.wxa.jj.h paramh, Object paramObject)
  {
    try
    {
      q.class.cast(paramObject);
      com.tencent.luggage.wxa.do.c localc = j().m();
      localc.h.a(a(paramh, (q)paramObject));
      paramObject = new com.tencent.luggage.wxa.ou.d();
      paramObject.c = 1038;
      if ((paramh instanceof com.tencent.luggage.wxa.do.c))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramh.D);
        localStringBuilder.append(':');
        paramh = (com.tencent.luggage.wxa.do.c)paramh;
        localStringBuilder.append(paramh.h());
        localStringBuilder.append(':');
        localStringBuilder.append(paramh.c + 1000);
        paramObject.d = localStringBuilder.toString();
      }
      localc.l = com.tencent.luggage.wxa.qz.af.d();
      localc.I = null;
      localc.e();
      localc.a(paramObject);
      d(localc);
      return;
    }
    catch (ClassCastException paramh)
    {
      throw new IllegalStateException("Only data as MiniProgramNavigationBackResult acceptable here.", paramh);
    }
  }
  
  protected final void a(com.tencent.luggage.wxa.on.c paramc)
  {
    if (paramc != null)
    {
      this.e = paramc;
      return;
    }
    throw new NullPointerException();
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.appstorage.n paramn)
  {
    if (f() == null)
    {
      if (paramn != null)
      {
        super.a(com.tencent.mm.plugin.appbrand.appstorage.n.class, paramn);
        return;
      }
      throw new NullPointerException();
    }
    throw new IllegalStateException("Duplicated call!!");
  }
  
  @CallSuper
  protected boolean a(com.tencent.luggage.wxa.jj.h paramh)
  {
    if (!aw()) {
      return false;
    }
    boolean bool1 = u();
    Object localObject = (com.tencent.luggage.wxa.do.c)paramh;
    boolean bool2 = a((com.tencent.luggage.wxa.do.c)localObject);
    int i;
    if (((!bool1) && (bool2)) || ((bool1) && (!bool2) && (c((com.tencent.luggage.wxa.do.c)localObject)))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.d = null;
      aF();
      return super.a(paramh);
    }
    if ((!aG()) && (!au()))
    {
      if ((d.a.a(ab())) && (((com.tencent.luggage.wxa.do.c)localObject).n != i().b()))
      {
        localObject = String.format(Locale.ENGLISH, "Updated InitConfig.appVersion != getSysConfig().appVersion, appId:%s, @smoothieli", new Object[] { aa() });
        com.tencent.luggage.wxa.qz.o.c("Luggage.WXA.AppBrandRuntimeLU", (String)localObject);
        if (X()) {
          junit.framework.a.a((String)localObject);
        } else {
          aF();
        }
      }
      if (b(paramh)) {
        aH();
      }
    }
    super.a(paramh);
    if ((!aG()) && (!au()) && (!av())) {
      com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.AppBrandRuntimeLU", "updateConfig [TEST_SCENE_TRACE] hash:%d, appId:%s, name:%s, willRelaunch:%b, scene:%d, sceneNote:%s, preScene:%d, preSceneNote:%s", new Object[] { Integer.valueOf(hashCode()), aa(), j().E, Boolean.valueOf(aI()), Integer.valueOf(l().c), l().d, Integer.valueOf(l().a), l().b });
    }
    return true;
  }
  
  public final int b()
  {
    if (d.a.b(ab())) {
      return 0;
    }
    return j().n;
  }
  
  protected boolean b(@NonNull com.tencent.luggage.wxa.jj.h paramh)
  {
    return TextUtils.isEmpty(paramh.I) ^ true;
  }
  
  @CallSuper
  protected void c()
  {
    super.c();
    l.a.a().a(aa(), l().c);
  }
  
  @CallSuper
  protected void d()
  {
    super.d();
    com.tencent.luggage.wxa.eb.b.a.a(this);
    g.a(aa());
    com.tencent.luggage.wxa.ov.l.a(this);
    com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.AppBrandRuntimeLU", "onCreate [TEST_SCENE_TRACE] hash:%d, appId:%s, name:%s, scene:%d, sceneNote:%s, preScene:%d, preSceneNote:%s", new Object[] { Integer.valueOf(hashCode()), aa(), j().E, Integer.valueOf(l().c), l().d, Integer.valueOf(l().a), l().b });
  }
  
  @CallSuper
  protected void e()
  {
    super.e();
    a().c();
    l.a.a().a(aa(), l().c);
  }
  
  public final com.tencent.mm.plugin.appbrand.appstorage.n f()
  {
    return e(false);
  }
  
  public ao g()
  {
    return (ao)super.z();
  }
  
  protected com.tencent.mm.plugin.appbrand.appstorage.o h()
  {
    Object localObject = i();
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.AppBrandRuntimeLU", "createFileSystem but get NUL sysConfig, appId:%s", new Object[] { aa() });
      localObject = new com.tencent.luggage.wxa.ku.a();
    }
    else
    {
      localObject = e.a((com.tencent.luggage.wxa.do.d)localObject);
    }
    return new ao(this, (com.tencent.luggage.wxa.ku.a)localObject);
  }
  
  public com.tencent.luggage.wxa.do.d i()
  {
    return (com.tencent.luggage.wxa.do.d)a(com.tencent.luggage.wxa.do.d.class, false);
  }
  
  public com.tencent.luggage.wxa.do.c j()
  {
    return (com.tencent.luggage.wxa.do.c)super.B();
  }
  
  public com.tencent.luggage.wxa.dz.a k()
  {
    return (com.tencent.luggage.wxa.dz.a)super.C();
  }
  
  public com.tencent.luggage.wxa.ou.d l()
  {
    return j().f();
  }
  
  @CallSuper
  protected void m()
  {
    super.m();
    q();
  }
  
  @CallSuper
  protected void n()
  {
    super.n();
    if (d(com.tencent.mm.plugin.appbrand.appstorage.n.class) == null) {
      a(com.tencent.mm.plugin.appbrand.appstorage.n.class, com.tencent.mm.plugin.appbrand.appcache.c.a);
    }
    a(new s(e(true), ad.b(this)));
    if (this.e != null) {
      return;
    }
    throw new IllegalStateException("Should ensure ApiPermissionController installed before init. Use #setApiPermissionController().");
  }
  
  @CallSuper
  protected void o()
  {
    super.o();
    com.tencent.luggage.wxa.eb.b.a.b(this);
    g.b(aa());
    r();
    if (a() != null) {
      a().a();
    }
    this.e = null;
    ao localao = g();
    if (localao != null)
    {
      com.tencent.mm.plugin.appbrand.appstorage.l locall = (com.tencent.mm.plugin.appbrand.appstorage.l)localao.a(com.tencent.mm.plugin.appbrand.appstorage.l.class);
      if (locall != null) {
        locall.e();
      }
      localao.b();
    }
  }
  
  @Nullable
  public com.tencent.mm.plugin.appbrand.ui.b p()
  {
    return this.c;
  }
  
  protected final boolean q()
  {
    if (!com.tencent.luggage.wxa.om.b.b(this)) {
      return false;
    }
    if (this.c != null) {
      return false;
    }
    com.tencent.luggage.wxa.om.b.a(this);
    this.c = s();
    if (this.c != null)
    {
      ai().addView(this.c);
      this.c.a();
    }
    return true;
  }
  
  protected final boolean r()
  {
    com.tencent.mm.plugin.appbrand.ui.b localb = this.c;
    if (localb != null)
    {
      if ((localb.getParent() instanceof ViewGroup))
      {
        this.c.b();
        ((ViewGroup)this.c.getParent()).removeView(this.c);
      }
      this.c = null;
      return true;
    }
    return false;
  }
  
  @Nullable
  protected com.tencent.mm.plugin.appbrand.ui.b s()
  {
    return new com.tencent.mm.plugin.appbrand.ui.b(ah(), this);
  }
  
  public boolean t()
  {
    return j().g();
  }
  
  public boolean u()
  {
    Boolean localBoolean = this.d;
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    localBoolean = Boolean.valueOf(a(j()));
    this.d = localBoolean;
    return localBoolean.booleanValue();
  }
  
  protected com.tencent.luggage.wxa.ny.a v()
  {
    return com.tencent.luggage.wxa.dy.a.a(this);
  }
  
  public final boolean w()
  {
    boolean bool2 = au();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (j().u == com.tencent.luggage.wxa.dw.d.b) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void x() {}
  
  public void y()
  {
    new com.tencent.luggage.wxa.ec.d(this).g();
    super.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.d
 * JD-Core Version:    0.7.0.1
 */
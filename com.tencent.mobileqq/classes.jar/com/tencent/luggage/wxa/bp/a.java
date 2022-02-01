package com.tencent.luggage.wxa.bp;

import android.graphics.Rect;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.ab;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.pd.l.a;
import com.tencent.luggage.wxa.pd.m;
import com.tencent.luggage.wxa.pd.m.a;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qw.jy;
import com.tencent.luggage.wxa.qw.mh;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.mm.appbrand.v8.c.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.appbrand.jsruntime.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class a<Service extends com.tencent.luggage.wxa.du.c>
  extends com.tencent.luggage.wxa.du.e<Service>
  implements b
{
  private volatile boolean a = false;
  private boolean b = false;
  private com.tencent.mm.plugin.appbrand.debugger.g c = null;
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private com.tencent.luggage.wxa.bk.e g = null;
  private com.tencent.luggage.wxa.dr.c h;
  private com.tencent.luggage.wxa.dr.a i;
  private com.tencent.luggage.wxa.dr.d j;
  private com.tencent.luggage.wxa.bm.e k = null;
  private com.tencent.luggage.wxa.ou.a l;
  private com.tencent.mm.plugin.appbrand.debugger.e m = null;
  
  public a(Service paramService)
  {
    super(paramService);
    a(b.class, this);
    c();
    this.l = new com.tencent.luggage.wxa.ou.a();
  }
  
  private void F()
  {
    try
    {
      Object localObject = ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime();
      if (localObject == null) {
        return;
      }
      localObject = (q)((i)localObject).a(q.class);
      if (localObject != null)
      {
        ((q)localObject).c(-8);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      o.a("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
    }
  }
  
  private void G()
  {
    try
    {
      Object localObject = ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime();
      if (localObject == null) {
        return;
      }
      localObject = (q)((i)localObject).a(q.class);
      if (localObject != null)
      {
        ((q)localObject).c(10);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      o.a("Luggage.AppBrandGameServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
    }
  }
  
  private void H()
  {
    boolean bool = true;
    if (this.g == null) {
      bool = false;
    }
    o.d("Luggage.AppBrandGameServiceLogicImp", "setup magicbrush. loaded?[%b]", new Object[] { Boolean.valueOf(bool) });
    if (this.g != null) {
      return;
    }
    ((com.tencent.luggage.wxa.du.c)y()).M();
    this.d = k();
    this.e = l();
    this.f = m();
    this.g = a(this.d, this.e, this.f, n());
    this.g.c();
    com.tencent.luggage.wxa.bk.a.a(this.g.b(), ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime());
    a.c localc = new a.c(this, null);
    this.g.b().s().a(localc);
    this.g.b().r().a(localc);
    this.g.b().t().addListener(new a.5(this));
    this.g.b().a(new a.6(this));
  }
  
  private void I()
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl mServiceReady = [%b], isRunning[%b]", new Object[] { Boolean.valueOf(this.a), Boolean.valueOf(((com.tencent.luggage.wxa.du.c)y()).d()) });
    if (this.a)
    {
      if (!((com.tencent.luggage.wxa.du.c)y()).d()) {
        return;
      }
      try
      {
        o.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.initImpl start");
        J();
        O();
        ((com.tencent.luggage.wxa.du.c)y()).a(new a.7(this));
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        if (!((com.tencent.luggage.wxa.du.c)y()).d()) {
          return;
        }
        throw localNullPointerException;
      }
    }
  }
  
  private void J()
  {
    K();
    ((com.tencent.luggage.wxa.du.c)y()).k();
  }
  
  private void K()
  {
    if (this.b) {
      return;
    }
    ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime().evaluateJavascript(com.tencent.luggage.wxa.pc.c.a("wxa_library/android.js"), null);
  }
  
  private void L()
  {
    String str = s();
    com.tencent.luggage.wxa.pd.l.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), str, new a.8(this));
  }
  
  private void M()
  {
    ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(778L, 14L, 1L, false);
  }
  
  private void N()
  {
    ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(778L, 13L, 1L, false);
  }
  
  private void O()
  {
    if (this.b) {
      return;
    }
    this.b = true;
    o.d("Luggage.AppBrandGameServiceLogicImp", "Inject WAGame to MainContext");
    L();
    String str = ((com.tencent.luggage.wxa.du.c)y()).A().a("WAGame.js");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("v");
    ((StringBuilder)localObject1).append(((com.tencent.luggage.wxa.du.c)y()).A().c());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    ab.a((com.tencent.luggage.wxa.iu.b)y(), ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime());
    N();
    long l1 = System.currentTimeMillis();
    boolean bool = ((com.tencent.luggage.wxa.du.c)y()).C();
    int n;
    if (str == null) {
      n = 0;
    } else {
      n = str.length();
    }
    localObject1 = new a.a(this, "WAGame.js", str, l1, n, bool);
    if ((((com.tencent.luggage.wxa.du.c)y()).i() != null) && (((com.tencent.luggage.wxa.du.c)y()).i().u()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(";(function(global) { var protectedConsole = global.console; Object.defineProperty(global, 'console', { get() { return protectedConsole; }, set() { } }); })(this);");
      ((StringBuilder)localObject2).append(str);
      str = ((StringBuilder)localObject2).toString();
      m.a((com.tencent.luggage.wxa.iu.h)y(), ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), "WAGame.js", str, m.a.a, (l.a)localObject1);
      return;
    }
    m.a((com.tencent.luggage.wxa.iu.h)y(), ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), "WAGame.js", "WAGame.js", (String)localObject2, t(), str, m.a.a, (l.a)localObject1);
  }
  
  private void P()
  {
    if ((((com.tencent.luggage.wxa.du.c)y()).C()) || (((com.tencent.luggage.wxa.du.c)y()).d())) {
      com.tencent.luggage.wxa.bu.a.a().a(r());
    }
  }
  
  private void Q()
  {
    t.a(new a.9(this));
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(778L, 15L, 1L, false);
  }
  
  private static boolean b(@NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    boolean bool2 = paramd.W() instanceof com.tencent.luggage.wxa.or.n;
    boolean bool1 = true;
    if (bool2)
    {
      int n = ((com.tencent.luggage.wxa.or.n)paramd.W()).t().getDefaultDisplay().getRotation();
      bool2 = ArrayUtils.contains(new int[] { 0, 1 }, n);
      if (e.b.a(paramd.aj().f().a) == e.b.a) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private void d(String paramString)
  {
    a().a(paramString);
  }
  
  protected com.tencent.luggage.wxa.bk.e a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    return new a.4(this, ((com.tencent.luggage.wxa.du.c)y()).getContext(), ((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), paramBoolean1, paramBoolean2, paramInt, paramBoolean3);
  }
  
  @NonNull
  public com.tencent.luggage.wxa.bm.e a()
  {
    if (this.k == null) {
      try
      {
        if (this.k == null) {
          this.k = new com.tencent.luggage.wxa.bm.e();
        }
      }
      finally {}
    }
    return this.k;
  }
  
  protected d a(Service paramService, s params)
  {
    return new d(paramService, params);
  }
  
  protected i a(String paramString, byte[] paramArrayOfByte)
  {
    paramString = new c.a(paramString, paramArrayOfByte);
    paramString.d = true;
    paramString.c = "1";
    paramString.f = true;
    paramString.i = new WeakReference(y());
    return new com.tencent.mm.plugin.appbrand.jsruntime.b(paramString);
  }
  
  protected void a(int paramInt) {}
  
  protected void a(com.tencent.luggage.wxa.iu.d paramd)
  {
    H();
    Object localObject = this.g;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.bk.e)localObject).b(paramd);
    }
    localObject = this.j;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dr.d)localObject).a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), (com.tencent.luggage.wxa.jx.h)y());
    }
    localObject = this.i;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dr.a)localObject).a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), y());
    }
    F();
    paramd.a(com.tencent.mm.plugin.appbrand.ui.h.class, new com.tencent.luggage.wxa.bv.a(paramd));
    r().t().addSurfaceListenerForAllViews(new a.2(this));
    this.l.a(paramd, new a.3(this));
  }
  
  protected void a(com.tencent.luggage.wxa.ou.a parama, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (parama.a() != null) && (parama.a().a)) {
      com.tencent.luggage.wxa.bu.a.a().a(parama.a().a, parama.a().b, parama.a().c);
    }
  }
  
  public void a(String paramString)
  {
    o.e("Luggage.AppBrandGameServiceLogicImp", "RemoteDebugInfo %s", new Object[] { paramString });
    jy localjy = new jy();
    localjy.b = ((com.tencent.luggage.wxa.du.c)y()).f().getComponentId();
    localjy.a = paramString;
    paramString = com.tencent.mm.plugin.appbrand.debugger.l.a(localjy, this.m, "domEvent");
    this.c.a(paramString);
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    com.tencent.luggage.wxa.do.d locald = ((com.tencent.luggage.wxa.du.c)y()).i().i();
    Object localObject2 = paramJSONObject.optJSONObject("wxAppInfo");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new JSONObject();
    }
    try
    {
      localObject2 = new JSONArray();
      n = 0;
      while (n < locald.D.y.length)
      {
        ((JSONArray)localObject2).put(locald.D.y[n]);
        n += 1;
      }
      ((com.tencent.luggage.wxa.du.c)y()).a((JSONObject)localObject1, "subContextImgDomain", localObject2);
    }
    catch (Exception localException)
    {
      int n;
      label106:
      int i3;
      int i2;
      int i1;
      break label106;
    }
    ((com.tencent.luggage.wxa.du.c)y()).a(paramJSONObject, "wxAppInfo", localObject1);
    o.d("Luggage.AppBrandGameServiceLogicImp", "dm.widthPixels %d, dm.heightPixels %d", new Object[] { Integer.valueOf(r().p().f()), Integer.valueOf(r().p().g()) });
    if (!b(((com.tencent.luggage.wxa.du.c)y()).i()))
    {
      o.b("Luggage.AppBrandGameServiceLogicImp", "hy: orientation judge failed! maybe because onConfigurationChange judgement and surface degree judgement not match");
      ((com.tencent.luggage.wxa.ot.c)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.c.class)).a(808L, 4L, 1L, false);
      ((com.tencent.luggage.wxa.ot.d)com.tencent.luggage.wxa.ba.e.b(com.tencent.luggage.wxa.ot.d.class)).a(18284, new Object[] { Integer.valueOf(1) });
    }
    ((com.tencent.luggage.wxa.du.c)y()).a(paramJSONObject, "screenWidth", Integer.valueOf(r().p().f()));
    ((com.tencent.luggage.wxa.du.c)y()).a(paramJSONObject, "screenHeight", Integer.valueOf(r().p().g()));
    ((com.tencent.luggage.wxa.du.c)y()).a(paramJSONObject, "devicePixelRatio", Float.valueOf(r().p().e()));
    ((com.tencent.luggage.wxa.du.c)y()).a(paramJSONObject, "statusBarHeight", Integer.valueOf(com.tencent.luggage.wxa.bw.a.a((com.tencent.luggage.wxa.du.c)y())));
    localObject1 = new HashMap(6);
    localObject2 = w.a((com.tencent.luggage.wxa.jx.h)y());
    i3 = localObject2[0];
    i2 = localObject2[1];
    localObject2 = ((com.tencent.luggage.wxa.du.c)y()).y().getSafeAreaInsets();
    if (localObject2 != null)
    {
      n = com.tencent.luggage.wxa.pc.g.a(((Rect)localObject2).left);
      i1 = com.tencent.luggage.wxa.pc.g.a(((Rect)localObject2).top);
      i3 = com.tencent.luggage.wxa.pc.g.a(Math.min(((Rect)localObject2).right, i3));
      i2 = com.tencent.luggage.wxa.pc.g.a(Math.min(((Rect)localObject2).bottom, i2));
      ((Map)localObject1).put("left", Integer.valueOf(n));
      ((Map)localObject1).put("top", Integer.valueOf(i1));
      ((Map)localObject1).put("right", Integer.valueOf(i3));
      ((Map)localObject1).put("bottom", Integer.valueOf(i2));
      ((Map)localObject1).put("width", Integer.valueOf(i3 - n));
      ((Map)localObject1).put("height", Integer.valueOf(i2 - i1));
      ((com.tencent.luggage.wxa.du.c)y()).a(paramJSONObject, "safeArea", localObject1);
    }
  }
  
  public String b()
  {
    JSONObject localJSONObject = ((com.tencent.luggage.wxa.du.c)y()).j();
    String str = ((com.tencent.luggage.wxa.du.c)y()).i().aj().b;
    return String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[] { localJSONObject.toString(), str });
  }
  
  public final boolean b(String paramString)
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "hy: do nothing in game service when called from modularizing helper");
    return false;
  }
  
  protected void c()
  {
    new com.tencent.luggage.wxa.bl.e().a();
  }
  
  public boolean d()
  {
    return true;
  }
  
  protected i e()
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "createJsRuntime");
    long l1 = System.currentTimeMillis();
    Object localObject2 = i();
    if (j())
    {
      if (com.tencent.luggage.wxa.hd.c.d()) {
        localObject1 = com.tencent.luggage.wxa.pc.c.b("wxa_library/v8_snapshot64.bin");
      } else {
        localObject1 = com.tencent.luggage.wxa.pc.c.b("wxa_library/v8_snapshot.bin");
      }
    }
    else {
      localObject1 = null;
    }
    Object localObject1 = a((String)localObject2, (byte[])localObject1);
    localObject2 = (s)((i)localObject1).a(s.class);
    localObject2 = a((com.tencent.luggage.wxa.du.c)y(), (s)localObject2);
    ((i)localObject1).setJsExceptionHandler(new a.1(this));
    ((d)localObject2).a((i)localObject1);
    o.d("Luggage.AppBrandGameServiceLogicImp", "[damonlei] createJsRuntime cost [%d]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    return localObject1;
  }
  
  protected void f()
  {
    super.f();
    this.h = new com.tencent.luggage.wxa.dr.c();
    this.h.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), y());
    this.i = new com.tencent.luggage.wxa.dr.a();
    this.i.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), y(), 1004);
    this.j = new com.tencent.luggage.wxa.dr.d();
    this.j.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), y(), 1);
  }
  
  protected void g()
  {
    super.g();
    Object localObject = this.g;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.bk.e)localObject).d();
    }
    localObject = this.h;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dr.c)localObject).a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime());
    }
    localObject = this.i;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dr.a)localObject).a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime());
    }
    localObject = this.j;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dr.d)localObject).a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime());
    }
    localObject = this.l;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.ou.a)localObject).b();
    }
  }
  
  protected void h()
  {
    super.h();
    Object localObject = this.g;
    if (localObject != null)
    {
      if (((com.tencent.luggage.wxa.bk.e)localObject).a() != null) {
        this.g.b().a(null);
      }
      this.g.e();
    }
    localObject = this.c;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.debugger.g)localObject).destroy();
    }
  }
  
  protected String i()
  {
    return null;
  }
  
  protected boolean j()
  {
    return true;
  }
  
  protected boolean k()
  {
    if (((com.tencent.luggage.wxa.du.c)y()).i() != null)
    {
      com.tencent.luggage.wxa.jj.a locala = ((com.tencent.luggage.wxa.du.c)y()).i().aj();
      if (locala.j() != null) {
        return locala.j().booleanValue();
      }
    }
    return true;
  }
  
  protected boolean l()
  {
    return true;
  }
  
  protected int m()
  {
    return 1;
  }
  
  protected boolean n()
  {
    return false;
  }
  
  protected String o()
  {
    return y.a();
  }
  
  public void p()
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "onRuntimeResume");
    super.p();
    F();
    com.tencent.mm.plugin.appbrand.debugger.g localg = this.c;
    if (localg != null) {
      localg.a();
    }
  }
  
  public void q()
  {
    super.q();
    G();
  }
  
  public com.tencent.magicbrush.e r()
  {
    return this.g.b();
  }
  
  protected String s()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.pc.c.a("wxa_library/android.js"));
    localStringBuilder.append(com.tencent.luggage.wxa.pc.c.a("wxa_library/shared_buffer.js"));
    localStringBuilder.append(com.tencent.luggage.wxa.pc.c.a("wxa_library/NativeGlobal-WAGame.js"));
    return localStringBuilder.toString();
  }
  
  protected int t()
  {
    return 0;
  }
  
  protected void u()
  {
    super.u();
    if ((((com.tencent.luggage.wxa.du.c)y()).i() != null) && (((com.tencent.luggage.wxa.du.c)y()).i().u()))
    {
      Q();
      m.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), "xdebug");
      if (((com.tencent.luggage.wxa.du.c)y()).D()) {
        m.b(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), ((com.tencent.luggage.wxa.du.c)y()).r());
      }
    }
  }
  
  protected void v()
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppServiceWC.init");
    this.a = true;
    I();
  }
  
  protected void w()
  {
    o.d("Luggage.AppBrandGameServiceLogicImp", "start preload");
    H();
    O();
    ((com.tencent.luggage.wxa.du.c)y()).N();
    o.d("Luggage.AppBrandGameServiceLogicImp", "WAGameAppService preloaded.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.a
 * JD-Core Version:    0.7.0.1
 */
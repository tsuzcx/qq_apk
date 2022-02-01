package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.oi.f;
import com.tencent.luggage.wxa.om.g;
import com.tencent.luggage.wxa.pd.l;
import com.tencent.luggage.wxa.pp.al;
import com.tencent.luggage.wxa.qz.ag;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a<PAGE extends com.tencent.luggage.wxa.dq.c>
  extends com.tencent.luggage.wxa.ds.a<PAGE>
  implements com.tencent.luggage.wxa.dq.d, com.tencent.luggage.wxa.oi.c
{
  private ViewGroup c;
  private am d;
  private boolean e = false;
  private boolean f = false;
  private String g;
  private String h;
  private y i;
  private aq j;
  private ab k;
  private az l;
  private boolean m;
  private a<PAGE>.d n;
  private ap o;
  private a.a p;
  private as q;
  
  public a(@NonNull PAGE paramPAGE)
  {
    super(paramPAGE);
  }
  
  private void K()
  {
    if (!r())
    {
      L();
      return;
    }
    if (this.l != null)
    {
      FrameLayout localFrameLayout = (FrameLayout)s();
      if (this.l.getParent() != localFrameLayout)
      {
        boolean bool = ((com.tencent.luggage.wxa.dq.c)y()).ah().g();
        ((com.tencent.luggage.wxa.dq.c)y()).ah().setLoadingIconVisibility(true);
        ((com.tencent.luggage.wxa.dq.c)y()).ah().setNavLoadingIconVisibilityResetListener(this.l);
        this.l.a(bool);
        if ((this.l.getParent() instanceof ViewGroup)) {
          ((ViewGroup)this.l.getParent()).removeView(this.l);
        }
        localFrameLayout.addView(this.l, new FrameLayout.LayoutParams(-1, -1));
      }
      this.l.a(p());
      this.l.a();
      this.l.bringToFront();
      com.tencent.luggage.wxa.qz.o.d("Luggage.AbstractMPPageViewRenderer", "revealWaitingReadyCover appId:%s, url:%s", new Object[] { o(), u() });
    }
  }
  
  private void L()
  {
    az localaz = this.l;
    if (localaz != null)
    {
      localaz.setVisibility(8);
      if (ViewCompat.isAttachedToWindow(this.l))
      {
        ((com.tencent.luggage.wxa.dq.c)y()).ah().setNavLoadingIconVisibilityResetListener(null);
        ((com.tencent.luggage.wxa.dq.c)y()).ah().setLoadingIconVisibility(this.l.a);
        ((ViewGroup)this.l.getParent()).removeView(this.l);
        com.tencent.luggage.wxa.qz.o.d("Luggage.AbstractMPPageViewRenderer", "dismissWaitingReadyCover appId:%s, url:%s", new Object[] { o(), u() });
      }
    }
  }
  
  private static f M()
  {
    a.8 local8 = new a.8();
    return (f)Proxy.newProxyInstance(f.class.getClassLoader(), new Class[] { f.class }, local8);
  }
  
  private y a(@NonNull am paramam)
  {
    return new y(p(), paramam);
  }
  
  private void a(@NonNull y paramy)
  {
    super.a(f.class, new a.5(this, (u)y(), paramy));
  }
  
  private void a(@NonNull JSONObject paramJSONObject, @NonNull String paramString, @Nullable Object paramObject)
  {
    ((com.tencent.luggage.wxa.dq.c)y()).a(paramJSONObject, paramString, paramObject);
  }
  
  private void b()
  {
    this.k.a(new a.3(this));
    if (v() != null) {
      v().a(new a.4(this));
    }
  }
  
  private void e(String paramString)
  {
    try
    {
      b(String.format(Locale.ENGLISH, "injectPageScript(%s)", new Object[] { paramString })).b(paramString);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.appcache.o localo)
    {
      label27:
      break label27;
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.AbstractMPPageViewRenderer", "injectPageScript appId[%s] url[%s] ScriptNotFoundException", new Object[] { o(), paramString });
    n().E();
  }
  
  private void m()
  {
    if (E() == null) {
      ((com.tencent.luggage.wxa.dq.c)y()).M();
    }
    E().a(p());
    E().setFullscreenImpl(((com.tencent.luggage.wxa.dq.c)y()).af());
  }
  
  private void q()
  {
    if ((System.currentTimeMillis() % 1000L == 1L) || (ag.a()) || (com.tencent.luggage.wxa.qz.c.b))
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.AbstractMPPageViewRenderer", "do observeLongTask");
      this.d.addJavascriptInterface(B(), "PageLongTaskReporter");
      this.m = true;
    }
  }
  
  protected final void A()
  {
    Object localObject = new JSONObject();
    int i1 = ((com.tencent.luggage.wxa.dq.c)y()).y().getVDisplayMetrics().widthPixels;
    float f1 = r.a().getResources().getDisplayMetrics().density;
    a((JSONObject)localObject, "width", Integer.valueOf((int)Math.ceil(i1 / f1)));
    a((JSONObject)localObject, "pixelRatio", Float.valueOf(f1));
    localObject = String.format(Locale.US, ";if(typeof __deviceInfo__ ==='undefined'){ var __deviceInfo__ = %s; } else {Object.assign(__deviceInfo__, %s)};", new Object[] { ((JSONObject)localObject).toString(), ((JSONObject)localObject).toString() });
    ((com.tencent.luggage.wxa.dq.c)y()).getJsRuntime().evaluateJavascript((String)localObject, null);
  }
  
  protected g B()
  {
    return new a.6(this);
  }
  
  protected final boolean C()
  {
    return this.m;
  }
  
  protected final ai D()
  {
    return this.n;
  }
  
  protected final am E()
  {
    return this.d;
  }
  
  @NonNull
  protected final ap F()
  {
    if (this.o == null)
    {
      this.o = a();
      if (this.o == null) {
        this.o = new at(this);
      }
    }
    return this.o;
  }
  
  protected final void G()
  {
    if (this.e) {
      return;
    }
    try
    {
      b("injectAppSharedPageFrameScript").a();
      this.e = true;
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.appcache.o localo) {}
  }
  
  protected final void H()
  {
    this.e = false;
    as localas = this.q;
    if (localas != null) {
      localas.a();
    }
    a(this.h);
  }
  
  protected void I() {}
  
  public final JSONObject J()
  {
    JSONObject localJSONObject = com.tencent.luggage.wxa.ef.c.a(n().ae().j());
    try
    {
      localJSONObject.put("isFirstPage", ((com.tencent.luggage.wxa.dq.c)y()).aL());
    }
    catch (JSONException localJSONException1)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put isFirstPage e=%s", new Object[] { o(), localJSONException1 });
    }
    for (;;)
    {
      try
      {
        if (n().j().u != com.tencent.luggage.wxa.dw.d.b) {
          break label142;
        }
        bool = true;
        localJSONObject.put("prerender", bool);
      }
      catch (JSONException localJSONException2)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.AbstractMPPageViewRenderer", "generateWxConfig appId[%s] put prerender e=%s", new Object[] { o(), localJSONException2 });
      }
      localJSONObject.remove("permission");
      localJSONObject.remove("subpackages");
      localJSONObject.remove("pages");
      return localJSONObject;
      label142:
      boolean bool = false;
    }
  }
  
  @Nullable
  public View a(@NonNull LayoutInflater paramLayoutInflater)
  {
    return new FrameLayout(paramLayoutInflater.getContext());
  }
  
  public RelativeLayout.LayoutParams a(@NonNull View paramView1, @Nullable View paramView2)
  {
    paramView1 = new RelativeLayout.LayoutParams(-1, -1);
    if (paramView2 != null)
    {
      if (paramView2.getId() == -1) {
        paramView2.setId(2131428551);
      }
      paramView1.addRule(2, paramView2.getId());
    }
    return paramView1;
  }
  
  protected abstract am a(@NonNull Context paramContext);
  
  protected ap a()
  {
    return null;
  }
  
  public <T> T a(Class<T> paramClass)
  {
    if (n.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.wxa.dq.c)y()).A());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.a(paramClass);
  }
  
  public void a(@NonNull d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, @Nullable Object paramObject) {}
  
  public void a(@NonNull com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    super.a(com.tencent.luggage.wxa.oi.a.class, new au((u)y()));
    super.a(paramb);
  }
  
  protected final void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.AbstractMPPageViewRenderer", "[!]injectScript appId[%s] name[%s] url[%s] hash[%d] source EMPTY", new Object[] { o(), paramString1, u(), Integer.valueOf(hashCode()) });
      return;
    }
    d.a locala = new d.a();
    locala.a = paramString1;
    locala.b = paramString2;
    locala.c = paramString2.length();
    long l1 = System.currentTimeMillis();
    com.tencent.luggage.wxa.qz.o.d("Luggage.AbstractMPPageViewRenderer", "injectScript start, appId[%s] name[%s] url[%s] hash[%d]", new Object[] { o(), paramString1, u(), Integer.valueOf(hashCode()) });
    localObject = null;
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        com.tencent.luggage.wxa.qz.o.c("Luggage.AbstractMPPageViewRenderer", "[!] injectScript, valid name is required, appId:%s, url:%s", new Object[] { o(), u() });
        paramString1 = localObject;
      }
      else
      {
        paramString1 = new URL("https", "servicewechat.com", paramString1);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = localObject;
      }
    }
    l.a(((com.tencent.luggage.wxa.dq.c)y()).getJsRuntime(), paramString1, paramString2, new a.7(this, locala, l1));
  }
  
  public boolean a(String paramString)
  {
    this.g = ((com.tencent.luggage.wxa.dq.c)y()).an();
    this.h = ((com.tencent.luggage.wxa.dq.c)y()).ao();
    a(this.i);
    b();
    com.tencent.luggage.wxa.jj.a.d locald = ((com.tencent.luggage.wxa.dq.c)y()).am();
    ((com.tencent.luggage.wxa.dq.c)y()).n();
    ((av)a(av.class)).b(locald.m);
    if (!((com.tencent.luggage.wxa.dq.c)y()).z().d(this.g))
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.AbstractMPPageViewRenderer", "Empty page content, appId[%s] url[%s], abort inject", new Object[] { o(), paramString });
      d(paramString);
      return false;
    }
    if (r()) {
      this.l = new az(p(), (u)y());
    }
    I();
    G();
    c(this.g);
    e(this.g);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    return false;
  }
  
  @NonNull
  protected final a.a b(String paramString)
  {
    if (this.p == null)
    {
      Object localObject;
      if (((s)((com.tencent.luggage.wxa.dq.c)y()).b(s.class)).a()) {
        localObject = new a.b(this, null);
      } else {
        localObject = new a.c(this, null);
      }
      this.p = ((a.a)localObject);
      this.q = as.a.a(this);
      com.tencent.luggage.wxa.qz.o.d("Luggage.AbstractMPPageViewRenderer", "getInjectionMode created mode name = %s, appId = %s, reason = %s", new Object[] { this.p.b(), o(), paramString });
    }
    return this.p;
  }
  
  public final am b(Context paramContext)
  {
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = p();
    }
    this.d = a((Context)localObject);
    q();
    paramContext = this.d;
    localObject = new a.d(this, (Context)localObject);
    this.n = ((a.d)localObject);
    paramContext.addJavascriptInterface(localObject, "__deviceInfo");
    return this.d;
  }
  
  @CallSuper
  public void b(@NonNull View paramView)
  {
    this.c = ((FrameLayout)paramView);
    this.c.addOnAttachStateChangeListener(new a.1(this));
    this.j = new al((u)y());
    m();
    E().setOnScrollChangedListener(this.j);
    E().setWebViewLayoutListener(this.j);
    this.j.setupWebViewTouchInterceptor(E());
    this.i = a(E());
    this.i.addView(this.j.getContainer());
    this.i.setOnPullDownOffsetListener(this.j);
    this.i.setOnPullDownListener(new a.2(this));
    this.c.addView(this.i);
    this.k = new ab(this.j.getContainer());
    this.k.a(((com.tencent.luggage.wxa.dq.c)y()).af());
    if (v() != null) {
      v().a(((com.tencent.luggage.wxa.dq.c)y()).af());
    }
  }
  
  @NonNull
  public final aq c()
  {
    return this.j;
  }
  
  protected final void c(String paramString)
  {
    try
    {
      b(String.format(Locale.ENGLISH, "injectModuleSharedPageFrameScript(%s)", new Object[] { paramString })).a(paramString);
      return;
    }
    catch (com.tencent.mm.plugin.appbrand.appcache.o localo)
    {
      label28:
      break label28;
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.AbstractMPPageViewRenderer", "injectModuleSharedPageFrameScript appId[%s] path[%s] ScriptNotFoundException", new Object[] { o(), paramString });
    n().E();
  }
  
  @NonNull
  public final ab d()
  {
    return this.k;
  }
  
  @CallSuper
  public void d(String paramString)
  {
    ((com.tencent.luggage.wxa.dq.c)y()).b(paramString);
  }
  
  public void e()
  {
    super.e();
    super.a(com.tencent.luggage.wxa.oi.d.class, new av((u)y()));
    super.a(com.tencent.luggage.wxa.oi.i.class, new ay((u)y()));
    super.a(f.class, M());
    com.tencent.luggage.wxa.ds.b.a((u)y());
    if (((com.tencent.luggage.wxa.dq.c)y()).f().aj().a())
    {
      E().setBackgroundColor(ContextCompat.getColor(p(), 2131165259));
      return;
    }
    E().setBackgroundColor(-1);
  }
  
  @CallSuper
  public void f()
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.AbstractMPPageViewRenderer", "dispatchForeground appId:%s, url:%s, mIsPageReady:%b", new Object[] { o(), u(), Boolean.valueOf(this.f) });
    super.f();
    E().f();
    ((com.tencent.luggage.wxa.dq.c)y()).o();
    if (!this.f) {
      K();
    }
  }
  
  @CallSuper
  public void g()
  {
    super.g();
    E().e();
  }
  
  public void h()
  {
    super.h();
    this.j.a(E());
    E().destroy();
    this.d = null;
    this.c.removeAllViewsInLayout();
    this.i.removeAllViewsInLayout();
    this.i = null;
    this.j = null;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public Map<String, m> j()
  {
    return new com.tencent.luggage.wxa.dm.a().b();
  }
  
  public void k()
  {
    com.tencent.luggage.wxa.qz.o.d("Luggage.AbstractMPPageViewRenderer", "dispatchPageReady appId:%s, url:%s", new Object[] { o(), u() });
    this.f = true;
    L();
  }
  
  public void l() {}
  
  @CallSuper
  protected boolean r()
  {
    return (y() == null) || (!((com.tencent.luggage.wxa.dq.c)y()).aL());
  }
  
  public final View s()
  {
    return this.c;
  }
  
  public final boolean t()
  {
    com.tencent.luggage.wxa.dq.c localc = (com.tencent.luggage.wxa.dq.c)y();
    return (localc != null) && (localc.d());
  }
  
  protected final String u()
  {
    return this.g;
  }
  
  @NonNull
  public ab v()
  {
    return n().aU();
  }
  
  protected final void w()
  {
    if (!TextUtils.isEmpty("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);"))
    {
      ((com.tencent.luggage.wxa.dq.c)y()).getJsRuntime().evaluateJavascript("(function (global) {\n        if (!Object.assign) {\n            Object.defineProperty(Object, \"assign\", {\n                enumerable: false,\n                configurable: true,\n                writable: true,\n                value: function (target, firstSource) {\n                    \"use strict\";\n                    if (target === undefined || target === null)\n                        throw new TypeError(\"Cannot convert first argument to object\");\n                    var to = Object(target);\n                    for (var i = 1; i < arguments.length; i++) {\n                        var nextSource = arguments[i];\n                        if (nextSource === undefined || nextSource === null) continue;\n                        var keysArray = Object.keys(Object(nextSource));\n                        for (var nextIndex = 0, len = keysArray.length; nextIndex < len; nextIndex++) {\n                            var nextKey = keysArray[nextIndex];\n                            var desc = Object.getOwnPropertyDescriptor(nextSource, nextKey);\n                            if (desc !== undefined && desc.enumerable) to[nextKey] = nextSource[nextKey];\n                        }\n                    }\n                    return to;\n                }\n            });\n        }\n})(this);", null);
      return;
    }
    if (!((com.tencent.luggage.wxa.dq.c)y()).L()) {
      return;
    }
    throw new IllegalAccessError("Cannot find object_polyfill.js");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a
 * JD-Core Version:    0.7.0.1
 */
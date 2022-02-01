package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.jx.az;
import com.tencent.luggage.wxa.oi.e;
import com.tencent.luggage.wxa.om.b;
import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import java.util.Locale;
import org.json.JSONObject;

class ax$3
  implements ba.a
{
  private final String b = "page-frame.html";
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  
  ax$3(ax paramax) {}
  
  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://servicewechat.com/");
    localStringBuilder.append(String.format(Locale.US, "%s/%d/", new Object[] { this.a.o(), Integer.valueOf(this.a.n().i().S.pkgVersion) }));
    return localStringBuilder.toString();
  }
  
  private String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append("page-frame.html");
    return localStringBuilder.toString();
  }
  
  private void g()
  {
    this.a.K().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[] { f() }), null);
  }
  
  private void h()
  {
    this.a.A();
    if (!this.e)
    {
      if (this.a.C()) {
        this.a.a("wxa_library/webview_pf.js", com.tencent.luggage.wxa.pc.c.a("wxa_library/webview_pf.js"));
      }
      this.e = true;
    }
    if (!this.c)
    {
      this.a.a("wxa_library/android.js", com.tencent.luggage.wxa.pc.c.a("wxa_library/android.js"));
      this.c = true;
    }
    if (!this.d)
    {
      ax localax = this.a;
      localax.a("WAWebview.js", localax.F().a("WAWebview.js"));
      this.d = true;
    }
  }
  
  private void i()
  {
    ax localax;
    if ((this.a.n().i().b) && (!this.a.n().u()))
    {
      localax = this.a;
      localax.a("WAVConsole.js", ((n)ax.a(localax, n.class)).a("WAVConsole.js"));
    }
    if (b.b(this.a.n()))
    {
      localax = this.a;
      localax.a("WAPerf.js", ((n)ax.b(localax, n.class)).a("WAPerf.js"));
    }
    if (this.a.n().u())
    {
      localax = this.a;
      localax.a("WARemoteDebug.js", ((n)ax.c(localax, n.class)).a("WARemoteDebug.js"));
    }
  }
  
  private void j()
  {
    this.a.K().a(";(function(){return window.devicePixelRatio})();", new ax.3.1(this));
  }
  
  public void a()
  {
    t.a((u)this.a.y());
    this.a.H();
    new j().a((u)this.a.y(), ((com.tencent.luggage.wxa.dq.c)this.a.y()).i());
  }
  
  public void a(boolean paramBoolean)
  {
    o.d("Luggage.MPPageViewRenderer", "injectEnvFields preload=%b, hash=%d, viewEngine.hash=%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.a.hashCode()), Integer.valueOf(this.a.K().hashCode()) });
    if (paramBoolean)
    {
      ((com.tencent.luggage.wxa.dq.c)this.a.y()).c(((com.tencent.luggage.wxa.dq.c)this.a.y()).K());
      h();
      return;
    }
    this.a.w();
    g();
    j();
    String str1 = this.a.J().toString();
    String str2 = String.format(Locale.US, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);", new Object[] { str1 });
    long l = System.currentTimeMillis();
    ax.a(this.a, new ax.a(null));
    ax.a.a(ax.b(this.a), str1);
    ax.a.a(ax.b(this.a), l);
    o.d("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate assignWxConfig start, hash=%d", new Object[] { Integer.valueOf(this.a.hashCode()) });
    this.a.K().a(ax.e("assignWxConfig"), str2, new ax.3.2(this));
    h();
    i();
    str1 = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { az.a("onWxConfigReady", "", 0) });
    o.d("Luggage.MPPageViewRenderer", "injectEnvFields, evaluate onWxConfigReady start, hash=%d", new Object[] { Integer.valueOf(this.a.hashCode()) });
    l = System.currentTimeMillis();
    this.a.K().a(ax.e("onWxConfigReady"), str1, new ax.3.3(this, l));
    ax.a(this.a, false);
    this.a.G();
  }
  
  public void b(boolean paramBoolean)
  {
    String str1;
    if (paramBoolean) {
      str1 = "https://servicewechat.com/preload/page-frame.html";
    } else {
      str1 = f();
    }
    String str2 = ((com.tencent.luggage.wxa.dq.c)this.a.y()).A().a("WAPageFrame.html");
    o.d("Luggage.MPPageViewRenderer", "loadPageFrame url[%s] preload[%b]", new Object[] { str1, Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.keylogger.d.a(this.a.o(), a.M);
      this.a.K().b(new ax.3.4(this));
    }
    this.a.K().a(str1, str2);
  }
  
  public boolean b()
  {
    if (this.a.E().a(e.class) != null) {
      return false;
    }
    boolean bool = t.b((u)this.a.y());
    if (bool)
    {
      this.a.d().f();
      this.c = false;
      this.d = false;
      this.e = false;
    }
    return bool;
  }
  
  public String c()
  {
    return e();
  }
  
  public u d()
  {
    return (u)this.a.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.debugger;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.nz.k.b;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qw.cg;
import com.tencent.luggage.wxa.qw.ch;
import com.tencent.luggage.wxa.qw.jt;
import com.tencent.luggage.wxa.qw.jx;
import com.tencent.luggage.wxa.qw.ka;
import com.tencent.luggage.wxa.qw.kk;
import com.tencent.luggage.wxa.qw.kl;
import com.tencent.luggage.wxa.qw.ko;
import com.tencent.luggage.wxa.qw.kr;
import com.tencent.luggage.wxa.qw.kt;
import com.tencent.luggage.wxa.qw.ku;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.page.am;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class g
  implements com.tencent.mm.plugin.appbrand.jsruntime.i
{
  k.b a = new g.2(this);
  private e b;
  private String c;
  private Activity d;
  private k e;
  private i f = new i();
  private com.tencent.luggage.wxa.du.c g;
  private m h;
  
  public g()
  {
    d();
  }
  
  private void a(int paramInt, String paramString, ValueCallback<String> paramValueCallback)
  {
    a locala = new a();
    if (!com.tencent.luggage.wxa.qz.af.c(this.c))
    {
      locala.c = this.c;
      this.c = null;
    }
    else
    {
      locala.c = j.a(paramString);
    }
    locala.b = System.currentTimeMillis();
    locala.d = paramString.length();
    locala.a = paramValueCallback;
    this.b.w().put(Integer.valueOf(paramInt), locala);
  }
  
  private void a(ku paramku, jt paramjt)
  {
    if (!l.a(this.b, paramjt, paramku.a, this.h, this.f)) {
      return;
    }
    o.d("MicroMsg.RemoteDebugJsEngine", "onLogin");
    if (paramku.b == null)
    {
      o.b("MicroMsg.RemoteDebugJsEngine", "onLogin room info is null");
      return;
    }
    if (paramku.b.a)
    {
      this.b.a(paramku.b);
      i();
      return;
    }
    g();
  }
  
  private void e()
  {
    if (this.e == null)
    {
      this.e = new k((com.tencent.luggage.wxa.nz.a)this.g.b(com.tencent.luggage.wxa.nz.a.class));
      this.f.a(this.e, this.b, this.h);
    }
    if (this.b.G())
    {
      k localk = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ws://localhost:");
      localStringBuilder.append(this.b.j().f);
      localk.a(localStringBuilder.toString(), this.a);
      return;
    }
    this.e.a("wss://wxagame.weixin.qq.com/remote/", this.a);
  }
  
  private void f()
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "login");
    this.b.c(1);
    Object localObject = new kt();
    ((kt)localObject).a = this.b.b();
    ((kt)localObject).b = this.b.c();
    localObject = l.a(1002, (com.tencent.luggage.wxa.qu.a)localObject);
    this.e.a((jt)localObject);
  }
  
  private void g()
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "joinRoom");
    this.b.c(2);
    Object localObject = new kr();
    ((kr)localObject).a = this.b.b();
    ((kr)localObject).c = this.b.j().b;
    ((kr)localObject).b = "";
    ((kr)localObject).d = this.b.j().c;
    localObject = l.a(1003, (com.tencent.luggage.wxa.qu.a)localObject);
    this.e.a((jt)localObject);
  }
  
  private void h()
  {
    Object localObject1 = this.g.A();
    ko localko = new ko();
    jx localjx = new jx();
    localko.b = localjx;
    Object localObject2 = (c)this.g.d(c.class);
    if (localObject2 != null) {
      localko.c = ((c)localObject2).b();
    }
    localko.e = this.g.i().i().S.md5;
    localko.f = 1;
    localObject2 = this.g.A().a("WAService.js");
    if (!com.tencent.luggage.wxa.qz.af.c((String)localObject2)) {
      localko.d = com.tencent.luggage.wxa.gl.c.a(((String)localObject2).getBytes());
    }
    localjx.e = ((com.tencent.mm.plugin.appbrand.appcache.f)localObject1).c();
    localjx.b = com.tencent.luggage.wxa.qv.a.c;
    localjx.a = com.tencent.luggage.wxa.qv.a.g;
    localjx.d = com.tencent.luggage.wxa.qz.d.a(this.d, 654316592);
    localjx.c = com.tencent.luggage.wxa.qv.a.f;
    localjx.g = this.d.getResources().getDisplayMetrics().density;
    localjx.f = (this.d.getResources().getDisplayMetrics().widthPixels / localjx.g);
    if ((this.g.e(com.tencent.luggage.wxa.dq.c.class) != null) && (((com.tencent.luggage.wxa.dq.c)this.g.e(com.tencent.luggage.wxa.dq.c.class)).aj() != null)) {
      localjx.h = ((com.tencent.luggage.wxa.dq.c)this.g.e(com.tencent.luggage.wxa.dq.c.class)).aj().getUserAgentString();
    }
    localObject1 = new kk();
    this.f.a((kk)localObject1);
    localko.a = ((kk)localObject1);
    localObject1 = l.a(localko, this.b, "setupContext");
    this.f.a((h)localObject1);
    o.e("MicroMsg.RemoteDebugJsEngine", "setupContext %s/%s/%d, %s", new Object[] { localko.d, localko.e, Integer.valueOf(localjx.e), localjx.h });
  }
  
  private void i()
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "onReady");
    this.b.c(3);
    b();
    this.f.a(this.b.d(), 2147483647);
    this.h.h();
  }
  
  public <T extends com.tencent.mm.plugin.appbrand.jsruntime.j> T a(Class<T> paramClass)
  {
    return null;
  }
  
  public void a()
  {
    this.h.bringToFront();
  }
  
  public void a(int paramInt, String paramString)
  {
    this.f.a(paramInt, paramString);
  }
  
  public void a(e parame)
  {
    this.b = parame;
    this.g = this.b.a();
    this.d = ((Activity)this.g.getContext());
    this.h = new m(this.d, this.b, new g.1(this));
    this.h.a(this.g.i());
    e();
    if (com.tencent.luggage.wxa.qz.af.c(this.b.c())) {
      c();
    }
  }
  
  public void a(h paramh)
  {
    this.f.a(paramh);
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public void a(URL paramURL, String paramString, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString, paramValueCallback);
  }
  
  public void a(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, ValueCallback<String> paramValueCallback)
  {
    evaluateJavascript(paramString3, paramValueCallback);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString) {}
  
  public void b()
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "clearPendingScript");
    Iterator localIterator = this.b.v().iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      evaluateJavascript((String)localPair.first, (ValueCallback)localPair.second);
    }
    this.b.v().clear();
  }
  
  public void c()
  {
    o.d("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
    cg localcg = new cg();
    ((b)this.g.a(b.class)).b("/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket", this.g.getAppId(), localcg, ch.class).a(new g.3(this));
  }
  
  public boolean d()
  {
    com.tencent.luggage.wxa.qy.a.a.a(new g.4(this));
    return true;
  }
  
  public void destroy()
  {
    this.f.d();
    this.f.h();
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    Object localObject = this.b;
    if (localObject == null)
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("FATAL");
      }
      return;
    }
    if (((e)localObject).y()) {
      return;
    }
    if (!this.b.x())
    {
      this.b.v().add(new Pair(paramString, paramValueCallback));
      this.c = null;
      return;
    }
    localObject = new ka();
    ((ka)localObject).b = this.b.t();
    ((ka)localObject).a = paramString;
    h localh = l.a((com.tencent.luggage.wxa.qu.a)localObject, this.b, "evaluateJavascript");
    this.f.a(localh);
    a(((ka)localObject).b, paramString, paramValueCallback);
  }
  
  public void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.jsruntime.h paramh) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.g
 * JD-Core Version:    0.7.0.1
 */
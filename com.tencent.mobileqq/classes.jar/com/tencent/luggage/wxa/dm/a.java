package com.tencent.luggage.wxa.dm;

import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.jx.ao;
import com.tencent.luggage.wxa.jx.ap;
import com.tencent.luggage.wxa.jx.aq;
import com.tencent.luggage.wxa.jx.ar;
import com.tencent.luggage.wxa.jx.at;
import com.tencent.luggage.wxa.jx.au;
import com.tencent.luggage.wxa.jx.av;
import com.tencent.luggage.wxa.jx.aw;
import com.tencent.luggage.wxa.jx.ax;
import com.tencent.luggage.wxa.jx.ay;
import com.tencent.luggage.wxa.jx.bc;
import com.tencent.luggage.wxa.lk.c.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.joor.Reflect;
import org.joor.ReflectException;

public class a
{
  private static a.a a;
  private Map<String, com.tencent.luggage.wxa.jx.m> b;
  private Map<String, com.tencent.luggage.wxa.jx.m> c;
  
  static
  {
    bc.a();
    com.tencent.luggage.wxa.ma.i.a();
    com.tencent.luggage.wxa.lk.c.a.a(com.tencent.luggage.wxa.oc.b.a);
    com.tencent.luggage.wxa.lo.d.a(com.tencent.luggage.wxa.oq.h.a);
    try
    {
      locala = (a.a)Reflect.on("com.tencent.luggage.sdk.FullSdkWxaMapViewFactory").create().get();
    }
    catch (ReflectException localReflectException)
    {
      a.a locala;
      label39:
      break label39;
    }
    com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.FullSdkJsApiPool", "<clinit> init FullSdkWxaMapViewFactory failed, maybe 'useWebGLMapComp' turned on");
    locala = null;
    if (locala != null) {
      a = locala;
    }
  }
  
  public Map<String, com.tencent.luggage.wxa.jx.m> a()
  {
    this.b = new HashMap();
    c();
    return this.b;
  }
  
  protected void a(com.tencent.luggage.wxa.jx.m paramm)
  {
    if (paramm != null)
    {
      if (com.tencent.luggage.wxa.qz.af.c(paramm.d())) {
        return;
      }
      this.b.put(paramm.d(), paramm);
    }
  }
  
  protected void a(List<com.tencent.luggage.wxa.jx.m> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((com.tencent.luggage.wxa.jx.m)paramList.next());
      }
    }
  }
  
  public Map<String, com.tencent.luggage.wxa.jx.m> b()
  {
    this.c = new HashMap();
    d();
    return this.c;
  }
  
  protected void b(com.tencent.luggage.wxa.jx.m paramm)
  {
    if (paramm != null)
    {
      if (com.tencent.luggage.wxa.qz.af.c(paramm.d())) {
        return;
      }
      this.c.put(paramm.d(), paramm);
    }
  }
  
  protected void b(List<com.tencent.luggage.wxa.jx.m> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 0) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        b((com.tencent.luggage.wxa.jx.m)paramList.next());
      }
    }
  }
  
  @CallSuper
  protected void c()
  {
    a(new com.tencent.luggage.wxa.lw.b());
    a(new com.tencent.luggage.wxa.lw.g());
    a(new com.tencent.luggage.wxa.lw.r());
    a(new com.tencent.luggage.wxa.lw.c());
    a(new com.tencent.luggage.wxa.lw.k());
    a(new com.tencent.luggage.wxa.lw.s());
    a(new com.tencent.luggage.wxa.ln.w());
    a(new com.tencent.luggage.wxa.ln.i());
    a(new com.tencent.luggage.wxa.ln.o());
    a(new com.tencent.luggage.wxa.ln.p());
    a(new com.tencent.luggage.wxa.ln.h());
    a(new ar());
    a(new com.tencent.luggage.wxa.kz.c());
    a(new com.tencent.luggage.wxa.mp.h());
    a(new com.tencent.luggage.wxa.mp.i());
    a(new com.tencent.luggage.wxa.mo.e());
    a(new com.tencent.luggage.wxa.mo.d());
    a(new com.tencent.luggage.wxa.mo.f());
    a(new com.tencent.luggage.wxa.kx.h());
    a(new com.tencent.luggage.wxa.lx.g());
    a(new com.tencent.luggage.wxa.jz.j());
    a(new com.tencent.luggage.wxa.lt.c());
    a(new com.tencent.luggage.wxa.kr.c());
    a(new com.tencent.luggage.wxa.kr.e());
    a(new com.tencent.luggage.wxa.ln.ag());
    a(new com.tencent.luggage.wxa.ln.ad());
    a(new com.tencent.luggage.wxa.ln.e());
    a(new com.tencent.luggage.wxa.ln.ac());
    a(new com.tencent.luggage.wxa.ln.d());
    a(new com.tencent.luggage.wxa.ln.c());
    a(new com.tencent.luggage.wxa.kq.e());
    a(new com.tencent.luggage.wxa.lx.k());
    a(new com.tencent.luggage.wxa.lx.l());
    a(new com.tencent.luggage.wxa.lx.j());
    a(new com.tencent.luggage.wxa.lt.b());
    a(new com.tencent.luggage.wxa.lt.d());
    a(new com.tencent.luggage.wxa.lt.f());
    a(new com.tencent.luggage.wxa.lt.e());
    a(new au());
    a(new com.tencent.luggage.wxa.kw.g());
    a(new com.tencent.luggage.wxa.jx.am());
    a(new com.tencent.luggage.wxa.mh.a());
    a(new com.tencent.luggage.wxa.mh.e());
    a(new com.tencent.luggage.wxa.mh.d());
    a(new com.tencent.luggage.wxa.mh.c());
    a(new com.tencent.luggage.wxa.mh.b());
    a(new com.tencent.luggage.wxa.kw.c());
    a(new com.tencent.luggage.wxa.lu.b());
    a(new com.tencent.luggage.wxa.lu.c());
    a(new com.tencent.luggage.wxa.lu.f());
    a(new com.tencent.luggage.wxa.lu.d());
    a(new com.tencent.luggage.wxa.lu.e());
    a(new com.tencent.luggage.wxa.lw.n());
    a(new com.tencent.luggage.wxa.lw.o());
    a(new com.tencent.luggage.wxa.mz.f());
    a(new com.tencent.luggage.wxa.kq.d());
    a(new com.tencent.luggage.wxa.lq.c());
    a(new com.tencent.luggage.wxa.lq.b());
    a(new com.tencent.luggage.wxa.lq.d());
    a(new com.tencent.luggage.wxa.lq.a());
    a(new ao());
    a(new com.tencent.luggage.wxa.lw.h());
    a(new com.tencent.luggage.wxa.lw.i());
    a(new com.tencent.luggage.wxa.kz.d());
    a(new com.tencent.luggage.wxa.ln.ah());
    a(new com.tencent.luggage.wxa.lv.c());
    a(new com.tencent.luggage.wxa.lx.c());
    a(new com.tencent.luggage.wxa.lx.e());
    a(new com.tencent.luggage.wxa.lx.n());
    a(new com.tencent.luggage.wxa.kf.l());
    a(new com.tencent.luggage.wxa.kf.b());
    a(new com.tencent.luggage.wxa.kf.g());
    a(new com.tencent.luggage.wxa.kf.o());
    a(new com.tencent.luggage.wxa.kf.p());
    a(new com.tencent.luggage.wxa.kf.h());
    a(new com.tencent.luggage.wxa.kf.j());
    a(new com.tencent.luggage.wxa.kf.n());
    a(new com.tencent.luggage.wxa.kf.e());
    a(new com.tencent.luggage.wxa.kf.c());
    a(new com.tencent.luggage.wxa.kf.a());
    a(new com.tencent.luggage.wxa.kf.f());
    a(new com.tencent.luggage.wxa.kf.d());
    a(new com.tencent.luggage.wxa.kf.m());
    a(new com.tencent.luggage.wxa.kf.q());
    a(new com.tencent.luggage.wxa.kf.k());
    a(new com.tencent.luggage.wxa.kf.i());
    a(new com.tencent.luggage.wxa.kg.c());
    a(new com.tencent.luggage.wxa.kg.d());
    a(new com.tencent.luggage.wxa.kg.e());
    a(new com.tencent.luggage.wxa.kg.f());
    a(new com.tencent.luggage.wxa.kg.g());
    a(new com.tencent.luggage.wxa.kg.h());
    a(new com.tencent.luggage.wxa.kg.i());
    a(new com.tencent.luggage.wxa.ln.n());
    a(new com.tencent.luggage.wxa.la.d());
    a(new aw());
    a(new com.tencent.luggage.wxa.jz.i());
    a(new com.tencent.luggage.wxa.jz.o());
    a(new com.tencent.luggage.wxa.jz.l());
    a(new com.tencent.luggage.wxa.lv.d());
    a(new com.tencent.luggage.wxa.lv.a());
    a(new aq());
    a(new com.tencent.luggage.wxa.kr.b());
    a(new com.tencent.luggage.wxa.ko.a());
    a(new com.tencent.luggage.wxa.lx.h());
    a(new com.tencent.luggage.wxa.lx.p());
    a(new com.tencent.luggage.wxa.lx.r());
    a(new com.tencent.luggage.wxa.lx.s());
    a(new com.tencent.luggage.wxa.lv.g());
    a(new com.tencent.luggage.wxa.lv.f());
    a(new com.tencent.luggage.wxa.lv.h());
    a(new com.tencent.luggage.wxa.kv.c());
    a(new com.tencent.luggage.wxa.kv.d());
    a(new com.tencent.luggage.wxa.kv.e());
    a(new com.tencent.luggage.wxa.mh.c());
    a(new com.tencent.luggage.wxa.kz.e());
    a(new com.tencent.luggage.wxa.kz.f());
    a(new com.tencent.luggage.wxa.jx.an());
    a(new com.tencent.luggage.wxa.lx.o());
    a(new com.tencent.luggage.wxa.jx.ag());
    a(new com.tencent.luggage.wxa.kq.g());
    a(new com.tencent.luggage.wxa.kt.i());
    a(new com.tencent.luggage.wxa.la.g());
    a(new com.tencent.luggage.wxa.la.e());
    a(new com.tencent.luggage.wxa.ln.v());
    a(new com.tencent.luggage.wxa.ln.aj());
    a(new at());
    a(new com.tencent.luggage.wxa.ln.y());
    a(new av());
    a(new com.tencent.luggage.wxa.ln.u());
    a(new com.tencent.luggage.wxa.lf.b(null));
    a(new com.tencent.luggage.wxa.lf.c(null));
    a(new com.tencent.luggage.wxa.lf.d());
    a(new com.tencent.luggage.wxa.le.b(null));
    a(new com.tencent.luggage.wxa.le.c(null));
    a(new com.tencent.luggage.wxa.le.d());
    a(new com.tencent.luggage.wxa.lg.b());
    a(new com.tencent.luggage.wxa.lg.c());
    a(new com.tencent.luggage.wxa.lg.d());
    a(new ax());
    a(new com.tencent.luggage.wxa.jx.ae());
    a(new com.tencent.luggage.wxa.kp.l());
    a(new com.tencent.luggage.wxa.ln.af());
    a(new com.tencent.luggage.wxa.mp.g());
    a(new com.tencent.luggage.wxa.mp.f());
    a(new com.tencent.luggage.wxa.jz.e());
    a(new com.tencent.luggage.wxa.jz.f());
    a(new com.tencent.luggage.wxa.jz.n());
    a(new com.tencent.luggage.wxa.jz.h());
    a(new com.tencent.luggage.wxa.jz.k());
    a(new com.tencent.luggage.wxa.jz.g());
    a(new com.tencent.luggage.wxa.kx.f());
    a(new com.tencent.luggage.wxa.kx.e());
    a(new com.tencent.luggage.wxa.kx.c());
    a(new com.tencent.luggage.wxa.mr.d());
    a(new com.tencent.luggage.wxa.mr.e());
    a(new com.tencent.luggage.wxa.mr.c());
    a(new com.tencent.luggage.wxa.mr.b());
    a(new com.tencent.luggage.wxa.mr.a());
    a(new com.tencent.luggage.wxa.lh.h(null));
    a(new com.tencent.luggage.wxa.lh.i());
    a(new com.tencent.luggage.wxa.lh.g());
    a(new com.tencent.luggage.wxa.lh.e());
    a(new com.tencent.luggage.wxa.lh.f());
    a(new com.tencent.luggage.wxa.lj.i());
    a(new com.tencent.luggage.wxa.lj.l());
    a(new com.tencent.luggage.wxa.lj.f());
    a(new com.tencent.luggage.wxa.lj.e());
    a(new com.tencent.luggage.wxa.lj.d());
    a(new com.tencent.luggage.wxa.lj.k());
    a(new com.tencent.luggage.wxa.lj.m());
    a(new com.tencent.luggage.wxa.lj.n());
    a(new com.tencent.luggage.wxa.lj.o());
    a(new com.tencent.luggage.wxa.lj.g());
    a(new com.tencent.luggage.wxa.lj.j());
    a(new com.tencent.luggage.wxa.lj.h());
    a(new com.tencent.luggage.wxa.ln.z());
    a(new com.tencent.luggage.wxa.ln.ab());
    a(new com.tencent.luggage.wxa.ln.aa());
    a(new com.tencent.luggage.wxa.ln.f());
    a(new com.tencent.luggage.wxa.ln.ae());
    a(new com.tencent.luggage.wxa.ly.c());
    a(new com.tencent.luggage.wxa.ly.a());
    a(new com.tencent.luggage.wxa.ly.d());
    a(new com.tencent.luggage.wxa.ly.b());
    a(new com.tencent.luggage.wxa.ld.e(com.tencent.luggage.wxa.ld.e.a, null));
    a(new com.tencent.luggage.wxa.ld.g(null));
    a(new com.tencent.luggage.wxa.ln.t());
    a(new com.tencent.luggage.wxa.ku.ah());
    a(new com.tencent.luggage.wxa.ku.ai());
    a(new com.tencent.luggage.wxa.ku.o());
    a(new com.tencent.luggage.wxa.ku.p());
    a(new com.tencent.luggage.wxa.ku.q());
    a(new com.tencent.luggage.wxa.ku.ac());
    a(new com.tencent.luggage.wxa.ku.ab());
    a(new com.tencent.luggage.wxa.ku.an());
    a(new com.tencent.luggage.wxa.ku.x());
    a(new com.tencent.luggage.wxa.ku.z());
    a(new com.tencent.luggage.wxa.ku.ag());
    a(new com.tencent.luggage.wxa.ku.h());
    a(new com.tencent.luggage.wxa.ku.ak());
    a(new com.tencent.luggage.wxa.ku.s());
    a(new com.tencent.luggage.wxa.ku.n());
    a(new com.tencent.luggage.wxa.ku.aa());
    a(new com.tencent.luggage.wxa.ku.am());
    a(new com.tencent.luggage.wxa.ku.w());
    a(new com.tencent.luggage.wxa.ku.y());
    a(new com.tencent.luggage.wxa.ku.af());
    a(new com.tencent.luggage.wxa.ku.g());
    a(new com.tencent.luggage.wxa.ku.aj());
    a(new com.tencent.luggage.wxa.ku.r());
    a(new com.tencent.luggage.wxa.ku.m());
    a(new com.tencent.luggage.wxa.ku.al());
    a(new com.tencent.luggage.wxa.ku.k());
    a(new com.tencent.luggage.wxa.ku.l());
    a(new com.tencent.luggage.wxa.ku.ad());
    a(new com.tencent.luggage.wxa.ku.ae());
    a(new com.tencent.luggage.wxa.ku.i());
    a(new com.tencent.luggage.wxa.ku.j());
    a(new com.tencent.luggage.wxa.kq.a());
    a(new com.tencent.luggage.wxa.kq.b());
    a(new com.tencent.luggage.wxa.lx.d());
    a(new com.tencent.luggage.wxa.jy.a());
    a(new ay());
    a(new com.tencent.luggage.wxa.jx.aj());
    a(new com.tencent.luggage.wxa.ln.r());
    a(new com.tencent.luggage.wxa.ln.s());
    a.a locala = a;
    if (locala != null) {
      locala.b(this);
    }
    a(new com.tencent.luggage.wxa.lb.a());
    a(new com.tencent.luggage.wxa.jx.ak());
    a(new com.tencent.luggage.wxa.jx.al());
    a(new com.tencent.luggage.wxa.lx.m());
    a(new com.tencent.luggage.wxa.lx.q());
    a(new com.tencent.luggage.wxa.ln.ai());
    a(new com.tencent.luggage.wxa.ld.f());
    a(new com.tencent.luggage.wxa.jz.p());
    a(new com.tencent.luggage.wxa.ln.ak());
    a(new com.tencent.luggage.wxa.ln.x());
    a(new com.tencent.luggage.wxa.kt.h());
    a(new com.tencent.luggage.wxa.kt.o());
    a(new com.tencent.luggage.wxa.kt.l());
    a(new com.tencent.luggage.wxa.kt.f());
    a(new com.tencent.luggage.wxa.kt.m());
    a(new com.tencent.luggage.wxa.kt.j());
    a(new com.tencent.luggage.wxa.kt.g());
    a(new com.tencent.luggage.wxa.kt.n());
    a(new com.tencent.luggage.wxa.kt.k());
    a(new com.tencent.luggage.wxa.kt.e());
    a(new com.tencent.luggage.wxa.mh.a());
    a(new com.tencent.luggage.wxa.mh.e());
    a(new com.tencent.luggage.wxa.mh.d());
    a(new com.tencent.luggage.wxa.mh.b());
    a(new com.tencent.luggage.wxa.nh.e());
    a(new com.tencent.luggage.wxa.nh.i());
    a(new com.tencent.luggage.wxa.nh.h());
    a(new com.tencent.luggage.wxa.nh.g());
    a(new com.tencent.luggage.wxa.nc.e());
    a(new com.tencent.luggage.wxa.nc.i());
    a(new com.tencent.luggage.wxa.nc.f());
    a(new com.tencent.luggage.wxa.nc.h());
    a(new com.tencent.luggage.wxa.nc.g());
    a(new com.tencent.luggage.wxa.ne.b());
    a(new com.tencent.luggage.wxa.ne.e());
    a(new com.tencent.luggage.wxa.ne.c());
    a(new com.tencent.luggage.wxa.ne.d());
    a(new com.tencent.luggage.wxa.ld.d());
    a(new com.tencent.luggage.wxa.ku.u());
    a(new com.tencent.luggage.wxa.ku.v());
  }
  
  @CallSuper
  protected void d()
  {
    b(new ap());
    b(new com.tencent.luggage.wxa.kw.h());
    b(new com.tencent.luggage.wxa.kw.c());
    b(new com.tencent.luggage.wxa.kw.b());
    b(new com.tencent.luggage.wxa.kw.i());
    b(new com.tencent.luggage.wxa.kw.d());
    b(new com.tencent.luggage.wxa.kw.j());
    b(new com.tencent.luggage.wxa.kw.e());
    b(new com.tencent.luggage.wxa.kw.f());
    b(new com.tencent.luggage.wxa.lx.k());
    b(new com.tencent.luggage.wxa.lx.l());
    b(new com.tencent.luggage.wxa.lx.j());
    b(new com.tencent.luggage.wxa.ln.g());
    b(new com.tencent.luggage.wxa.ln.m());
    b(new com.tencent.luggage.wxa.ln.l());
    b(new com.tencent.luggage.wxa.lt.c());
    b(new com.tencent.luggage.wxa.lt.d());
    b(new com.tencent.luggage.wxa.lt.f());
    b(new com.tencent.luggage.wxa.lt.e());
    b(new au());
    b(new com.tencent.luggage.wxa.lo.e());
    b(new com.tencent.luggage.wxa.lo.g());
    b(new com.tencent.luggage.wxa.ln.b());
    b(new com.tencent.luggage.wxa.jx.am());
    b(new com.tencent.luggage.wxa.mh.a());
    b(new com.tencent.luggage.wxa.mh.e());
    b(new com.tencent.luggage.wxa.mh.d());
    b(new com.tencent.luggage.wxa.mh.c());
    b(new com.tencent.luggage.wxa.mh.b());
    b(new com.tencent.luggage.wxa.kq.e());
    b(new com.tencent.luggage.wxa.kq.f());
    b(new com.tencent.luggage.wxa.kq.h());
    b(new com.tencent.luggage.wxa.kq.i());
    b(new com.tencent.luggage.wxa.ln.a());
    b(new com.tencent.luggage.wxa.kb.d());
    b(new com.tencent.luggage.wxa.kb.f());
    b(new com.tencent.luggage.wxa.kb.a());
    b(new com.tencent.luggage.wxa.kb.e());
    b(new aw());
    b(new com.tencent.luggage.wxa.lx.s());
    b(new com.tencent.luggage.wxa.ks.b());
    b(new com.tencent.luggage.wxa.ks.d());
    b(new com.tencent.luggage.wxa.ks.c());
    b(new com.tencent.luggage.wxa.kb.c());
    b(new com.tencent.luggage.wxa.lo.f());
    b(new com.tencent.luggage.wxa.lo.h());
    b(new av());
    b(new com.tencent.luggage.wxa.kt.h());
    b(new com.tencent.luggage.wxa.kt.o());
    b(new com.tencent.luggage.wxa.kt.l());
    b(new com.tencent.luggage.wxa.kt.f());
    b(new com.tencent.luggage.wxa.kt.m());
    b(new com.tencent.luggage.wxa.kt.j());
    b(new com.tencent.luggage.wxa.kp.j());
    b(new com.tencent.luggage.wxa.kp.n());
    b(new com.tencent.luggage.wxa.kp.m());
    b(new com.tencent.mm.plugin.appbrand.debugger.b());
    b(new com.tencent.luggage.wxa.kt.e());
    b(new com.tencent.luggage.wxa.ln.q());
    b(new com.tencent.luggage.wxa.kt.g());
    b(new com.tencent.luggage.wxa.kt.n());
    b(new com.tencent.luggage.wxa.kt.k());
    b(new com.tencent.luggage.wxa.ln.w());
    b(new com.tencent.luggage.wxa.ln.u());
    b(new com.tencent.luggage.wxa.ln.ad());
    b(new com.tencent.luggage.wxa.ln.e());
    b(new com.tencent.luggage.wxa.ln.s());
    b(new com.tencent.luggage.wxa.ln.r());
    a.a locala = a;
    if (locala != null) {
      locala.a(this);
    }
    b(new com.tencent.luggage.wxa.ly.c());
    b(new com.tencent.luggage.wxa.ly.a());
    b(new com.tencent.luggage.wxa.ln.ac());
    b(new com.tencent.luggage.wxa.ln.d());
    b(new com.tencent.luggage.wxa.ly.d());
    b(new com.tencent.luggage.wxa.ly.b());
    b(new com.tencent.luggage.wxa.la.g());
    b(new com.tencent.luggage.wxa.la.e());
    b(new com.tencent.luggage.wxa.ln.v());
    b(new com.tencent.luggage.wxa.lw.e());
    b(new com.tencent.luggage.wxa.lw.m());
    b(new com.tencent.luggage.wxa.lw.q());
    b(new com.tencent.luggage.wxa.lw.f());
    b(new com.tencent.luggage.wxa.lx.h());
    b(new com.tencent.luggage.wxa.lx.p());
    b(new com.tencent.luggage.wxa.lx.m());
    b(new com.tencent.luggage.wxa.lx.q());
    b(new com.tencent.luggage.wxa.ln.ai());
    b(new com.tencent.luggage.wxa.ls.b());
    b(new com.tencent.luggage.wxa.ku.t());
    b(new com.tencent.luggage.wxa.ln.ak());
    b(new com.tencent.luggage.wxa.ln.x());
    b(new com.tencent.luggage.wxa.ld.d());
    b(new com.tencent.luggage.wxa.kx.h());
    b(new com.tencent.luggage.wxa.ko.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dm.a
 * JD-Core Version:    0.7.0.1
 */
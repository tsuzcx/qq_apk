package com.tencent.luggage.wxa.oo;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.tencent.luggage.wxa.iu.c;
import com.tencent.luggage.wxa.on.m;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.ek;
import com.tencent.luggage.wxa.qw.el;
import com.tencent.luggage.wxa.qw.em;
import com.tencent.luggage.wxa.qw.en;
import com.tencent.luggage.wxa.qw.hn;
import com.tencent.luggage.wxa.qw.md;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public final class a
{
  private static b a;
  private static final LinkedList<Runnable> e = new LinkedList();
  private static final a.a f = new a.a(null);
  private static boolean g = false;
  private static final Set<String> h = new HashSet();
  @NonNull
  private final a.c b;
  @NonNull
  private final d c;
  private final int d;
  
  private a(@NonNull a.c paramc, @NonNull d paramd)
  {
    this.b = new a.1(this, paramc, paramd);
    this.c = paramd;
    this.d = paramd.a().q().ab();
  }
  
  public static void a()
  {
    f.a();
  }
  
  public static void a(b paramb)
  {
    a = paramb;
  }
  
  public static void a(d paramd, a.c paramc)
  {
    String str = paramd.a().getAppId();
    if (!af.c(str))
    {
      if (af.c(paramd.b())) {
        return;
      }
      b(str);
      paramc = new a.8(paramd, paramc);
      com.tencent.luggage.wxa.pc.l.a().c(new a.9(paramc, str, paramd));
    }
  }
  
  private void a(en paramen)
  {
    com.tencent.luggage.wxa.iu.b localb = this.c.a();
    String str1 = localb.getAppId();
    String str2 = this.c.b();
    com.tencent.luggage.wxa.iu.d locald = localb.q();
    o.d("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, appId %s, api %s, checkAuth Response.errcode %d", new Object[] { str1, str2, Integer.valueOf(paramen.a.a) });
    if (paramen.a.a == 0)
    {
      f.b(str1, str2);
      this.b.a();
      return;
    }
    if (paramen.a.a != -12000)
    {
      this.b.a(paramen.a.b);
      return;
    }
    hn localhn = (hn)paramen.b.get(0);
    if (localhn == null)
    {
      this.b.a(null);
      return;
    }
    String str3 = paramen.g;
    String str4 = paramen.f;
    String str5 = paramen.e;
    String str6 = localhn.a;
    boolean bool = m.a(str6, locald.A());
    String str7 = m.a(str6, locald);
    if ((bool) && (TextUtils.isEmpty(str7)))
    {
      this.b.a("fail:require permission desc");
      o.d("MicroMsg.AppBrandJsApiUserAuth", "requestUserAuth, user confirm, error = fail:require permission desc");
      return;
    }
    localb.a(new a.6(this, locald, localb, str6, str1, str2, str3, localhn, str5, str4, paramen, bool, str7));
  }
  
  public static void a(String paramString)
  {
    f.a(paramString);
  }
  
  private void a(String paramString, int paramInt)
  {
    ek localek = new ek();
    localek.a = this.c.a().getAppId();
    localek.b.add(paramString);
    localek.c = paramInt;
    String str1 = this.c.a().getAppId();
    String str2 = this.c.b();
    com.tencent.luggage.wxa.ba.b localb = this.c.a().a(com.tencent.luggage.wxa.ob.b.class);
    localb.getClass();
    ((com.tencent.luggage.wxa.ob.b)localb).b("/cgi-bin/mmbiz-bin/js-authorize-confirm", str1, localek, el.class).a(new a.2(this, paramInt, str1, str2, paramString));
  }
  
  public static boolean a(com.tencent.luggage.wxa.jx.h paramh, String paramString)
  {
    if (paramString.equals("getWifiList"))
    {
      paramh = paramh.q().A();
      o.d("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(paramh.P ^ true) });
      return paramh.P ^ true;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    return f.a(paramString1, paramString2);
  }
  
  private static void b(@NonNull String paramString)
  {
    synchronized (h)
    {
      if (h.contains(paramString)) {
        return;
      }
      c.a(paramString, new a.7(paramString));
      return;
    }
  }
  
  @WorkerThread
  private static void c(d paramd, @NonNull a.c paramc)
  {
    if (!paramd.a().d())
    {
      paramc.b();
      return;
    }
    String str1 = paramd.a().getAppId();
    String str2 = paramd.b();
    if (f.a(str1, str2))
    {
      o.d("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, before cgi, appId %s, api %s, found in AUTH_CACHE, return ok", new Object[] { str1, str2 });
      paramc.a();
      return;
    }
    o.d("MicroMsg.AppBrandJsApiUserAuth", "requestUSerAuth, before cgi, appId %s, api %s", new Object[] { str1, str2 });
    new a(paramc, paramd).g();
  }
  
  private void g()
  {
    Object localObject = this.c.a();
    String str1 = ((com.tencent.luggage.wxa.iu.b)localObject).getAppId();
    String str2 = this.c.b();
    com.tencent.luggage.wxa.iu.d locald = ((com.tencent.luggage.wxa.iu.b)localObject).q();
    o.d("MicroMsg.AppBrandJsApiUserAuth", "checkAuth appId = %s,mApi = %s", new Object[] { str1, str2 });
    em localem = new em();
    localem.a = str1;
    localem.e = str2;
    localem.c = this.d;
    localem.d = new md();
    if ((locald instanceof com.tencent.luggage.wxa.ed.d)) {
      localem.d.b = ((com.tencent.luggage.wxa.ed.d)locald).l().c;
    }
    if ((localObject instanceof com.tencent.luggage.wxa.iu.h)) {
      localem.d.c = 1;
    } else if ((localObject instanceof u)) {
      localem.d.c = 2;
    }
    localObject = ((com.tencent.luggage.wxa.iu.b)localObject).a(com.tencent.luggage.wxa.ob.b.class);
    localObject.getClass();
    ((com.tencent.luggage.wxa.ob.b)localObject).b("/cgi-bin/mmbiz-bin/js-authorize", str1, localem, en.class).a(new a.5(this, str1)).a(new a.4(this)).a(new a.3(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a
 * JD-Core Version:    0.7.0.1
 */
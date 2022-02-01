package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.m;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import com.tencent.mm.websocket.libwcwss.WcwssNative.IWcWssReportListener;
import java.lang.ref.WeakReference;
import javax.net.ssl.X509TrustManager;

public class d
{
  private String a = null;
  private int b = -1;
  private com.tencent.luggage.wxa.nz.a c = null;
  private X509TrustManager d = null;
  private boolean e = false;
  private boolean f = true;
  private String g = null;
  private WcwssNative h;
  private final d.a i = new d.a(this, new d.4(this));
  
  public static int a()
  {
    try
    {
      int j = x.d(r.a());
      o.d("Luggage.WcWssNativeInstallHelper", "getStatisticsNetType ret:%d", new Object[] { Integer.valueOf(j) });
      if (j == -1) {
        return -1;
      }
      if (x.f(r.a())) {
        return 3;
      }
      if (x.i(r.a())) {
        return 4;
      }
      if (x.g(r.a())) {
        return 5;
      }
      if (x.b(j)) {
        return 1;
      }
      boolean bool = x.a(j);
      if (bool) {
        return 2;
      }
      return 6;
    }
    catch (Exception localException)
    {
      o.a("Luggage.WcWssNativeInstallHelper", localException, "getStatisticsNetType_", new Object[0]);
    }
    return -1;
  }
  
  public static int a(String paramString, byte[][] paramArrayOfByte, X509TrustManager paramX509TrustManager)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("certifivate verify for ");
    ((StringBuilder)localObject).append(paramString);
    o.d("Luggage.WcWssNativeInstallHelper", ((StringBuilder)localObject).toString());
    int k = -1;
    try
    {
      com.tencent.mars.cdn.a locala = com.tencent.mars.cdn.b.a(paramArrayOfByte, "RSA", paramString, 1, paramX509TrustManager);
      o.d("Luggage.WcWssNativeInstallHelper", "host %s rsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(locala.a()), Boolean.valueOf(locala.b()), Boolean.valueOf(locala.c()) });
      localObject = locala;
      if (locala.a() != 0)
      {
        localObject = com.tencent.mars.cdn.b.a(paramArrayOfByte, "ECDSA", paramString, 1, paramX509TrustManager);
        o.d("Luggage.WcWssNativeInstallHelper", "host %s ecdsa verify result %d, isknownroots %b, ishostmatched %b", new Object[] { paramString, Integer.valueOf(((com.tencent.mars.cdn.a)localObject).a()), Boolean.valueOf(((com.tencent.mars.cdn.a)localObject).b()), Boolean.valueOf(((com.tencent.mars.cdn.a)localObject).c()) });
      }
      if (((com.tencent.mars.cdn.a)localObject).a() != 0) {
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 7L, 1L, false);
      }
      if ((((com.tencent.mars.cdn.a)localObject).a() == 0) && (!((com.tencent.mars.cdn.a)localObject).c())) {
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 8L, 1L, false);
      }
      if ((((com.tencent.mars.cdn.a)localObject).a() == 0) && (!((com.tencent.mars.cdn.a)localObject).b())) {
        ((com.tencent.luggage.wxa.ot.c)e.b(com.tencent.luggage.wxa.ot.c.class)).a(972L, 9L, 1L, false);
      }
      int j = k;
      if (((com.tencent.mars.cdn.a)localObject).a() == 0)
      {
        boolean bool = ((com.tencent.mars.cdn.a)localObject).b();
        j = k;
        if (bool) {
          j = 0;
        }
      }
      return j;
    }
    catch (Exception paramString)
    {
      o.a("Luggage.WcWssNativeInstallHelper", paramString, "doCertificateVerify Exception", new Object[0]);
    }
    return -1;
  }
  
  public void a(i parami)
  {
    o.d("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding mContextId:%s", new Object[] { this.a });
    if (!this.e)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding xSwitch false");
      return;
    }
    if (parami == null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "destroyWcWssBinding jsruntime is null");
      return;
    }
    ((m)parami.a(m.class)).a(this.i);
  }
  
  public void a(i parami, com.tencent.luggage.wxa.jx.c paramc, int paramInt)
  {
    o.d("Luggage.WcWssNativeInstallHelper", "createWcWssBinding");
    Object localObject1 = (d.b)paramc.a(d.b.class);
    if (localObject1 != null) {
      this.e = ((d.b)localObject1).a();
    }
    if (!this.e)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xSwitch false");
      return;
    }
    if (parami == null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsruntime is null");
      return;
    }
    this.g = String.valueOf(paramInt);
    f.a("owl", d.class.getClassLoader());
    f.a("wcwss", d.class.getClassLoader());
    com.tencent.mm.websocket.libwcwss.a.a();
    localObject1 = (q)parami.a(q.class);
    if (localObject1 == null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "createWcWssBinding jsThreadHandler is null");
      return;
    }
    WeakReference localWeakReference = new WeakReference(localObject1);
    Object localObject2 = (b)paramc.a(b.class);
    if (localObject2 != null)
    {
      this.f = ((b)localObject2).a();
      o.d("Luggage.WcWssNativeInstallHelper", "createWcWssBinding xLibUVSwitch:%b ", new Object[] { Boolean.valueOf(this.f) });
    }
    localObject2 = new d.1(this);
    ((q)localObject1).a(new d.3(this, parami, new d.2(this, localWeakReference, paramc), (WcwssNative.IWcWssReportListener)localObject2));
  }
  
  public void a(i parami, h paramh)
  {
    o.d("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mContextId:%s", new Object[] { this.a });
    if (!this.e)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss xSwitch false");
      return;
    }
    if (parami == null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsruntime is null");
      return;
    }
    parami = (q)parami.a(q.class);
    if (parami == null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss jsThreadHandler is null");
      return;
    }
    d.b localb = (d.b)paramh.a(d.b.class);
    boolean bool;
    if ((localb != null) && (localb.b())) {
      bool = true;
    } else {
      bool = false;
    }
    o.d("Luggage.WcWssNativeInstallHelper", "initConfigWcWss appId:%s, closeWcWssSocketsWhenSuspend:%b", new Object[] { paramh.getAppId(), Boolean.valueOf(bool) });
    if (bool) {
      paramh.q().al().a(new d.5(this, parami));
    }
    parami.a(new d.6(this, paramh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.bp;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.pd.l;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import com.tencent.mm.plugin.appbrand.jsruntime.u;

public class d
  extends com.tencent.luggage.wxa.du.a<com.tencent.luggage.wxa.du.c>
  implements com.tencent.luggage.wxa.bo.a
{
  private boolean d = false;
  
  public d(@NonNull com.tencent.luggage.wxa.du.c paramc, @NonNull s params)
  {
    super(paramc, params);
  }
  
  protected com.tencent.mm.plugin.appbrand.jsruntime.g a()
  {
    com.tencent.mm.plugin.appbrand.jsruntime.g localg = super.a();
    if (localg != null)
    {
      if (this.d) {
        try
        {
          u localu = (u)localg.a(u.class);
          b localb = (b)((com.tencent.luggage.wxa.du.c)e()).d(b.class);
          if (localb != null) {
            localb.r().a(localu.k(), localu.j(), localu.i());
          } else {
            com.tencent.luggage.wxa.qz.o.c("MicroMsg.WAGameJsContextInterfaceLU", "No extension found!");
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.WAGameJsContextInterfaceLU", "injectNativeGlobal failed [%s]", new Object[] { localNullPointerException });
          bool = false;
          break label114;
        }
      }
      boolean bool = true;
      label114:
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%b]", new Object[] { Boolean.valueOf(this.d), Boolean.valueOf(bool) });
    }
    return localg;
  }
  
  protected String a(@NonNull com.tencent.luggage.wxa.du.c paramc)
  {
    boolean bool = this.d;
    Object localObject = "";
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(com.tencent.luggage.wxa.pc.c.a("wxa_library/NativeGlobal-WAGame.js"));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramc = paramc.A().a("WAGameSubContext.js");
    if (!TextUtils.isEmpty(paramc))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(";");
      localStringBuilder.append(paramc);
      return localStringBuilder.toString();
    }
    throw new com.tencent.mm.plugin.appbrand.appcache.o("WAGameSubContext.js");
  }
  
  public void a(@NonNull i parami)
  {
    parami.addJavascriptInterface(this, "WeixinJSContext");
    l.a(parami, com.tencent.luggage.wxa.du.g.a, new d.1(this));
    l.a(parami, String.format(";(function(){let interface = %s;let alloc = interface.alloc;let allocNativeGlobal = interface.allocNativeGlobal;interface.alloc = function(injectNativeGlobal) {if(injectNativeGlobal){return allocNativeGlobal();}else{return alloc();}}})();", new Object[] { "WeixinJSContext" }), new d.2(this));
    b();
  }
  
  @JavascriptInterface
  @CallSuper
  public int allocNativeGlobal()
  {
    this.d = true;
    int i = super.alloc();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.WAGameJsContextInterfaceLU", "alloc injectNativeGlobal = [%b], ret = [%d]", new Object[] { Boolean.valueOf(this.d), Integer.valueOf(i) });
    this.d = false;
    return i;
  }
  
  protected int b(@NonNull com.tencent.luggage.wxa.du.c paramc)
  {
    return paramc.A().f().pkgVersion();
  }
  
  protected void b()
  {
    super.b();
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.WAGameJsContextInterfaceLU", "hy: injected WAGameJSContextInterface");
  }
  
  protected String c()
  {
    return "WAGameSubContext.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bp.d
 * JD-Core Version:    0.7.0.1
 */
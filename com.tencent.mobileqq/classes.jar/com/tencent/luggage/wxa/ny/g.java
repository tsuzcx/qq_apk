package com.tencent.luggage.wxa.ny;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class g
  implements a
{
  private final Set<String> a = new HashSet();
  private final com.tencent.luggage.wxa.pc.h<String, g.b> b = new com.tencent.luggage.wxa.pc.h();
  private final com.tencent.luggage.wxa.ed.d c;
  private final Map<String, Boolean> d = new HashMap();
  
  public g(com.tencent.luggage.wxa.ed.d paramd)
  {
    this.c = paramd;
  }
  
  private void a(ModulePkgInfo paramModulePkgInfo, a.b arg2, a.a parama)
  {
    String str = paramModulePkgInfo.name;
    boolean bool1;
    if ((!"__APP__".equals(str)) && (!paramModulePkgInfo.independent) && (!b())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1) {
      a(this.c.i().S, null, null);
    }
    o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, name %s, independent %b, should ensure __APP__ %b", new Object[] { paramModulePkgInfo.name, Boolean.valueOf(paramModulePkgInfo.independent), Boolean.valueOf(bool1) });
    a(str, ???, parama);
    synchronized (this.a)
    {
      boolean bool2 = this.a.contains(str);
      if (!bool2) {
        this.a.add(str);
      }
      if (!bool2)
      {
        ??? = new b(2);
        if (bool1) {
          a("__APP__", new g.4(this, ???), null);
        } else {
          ???.a(null);
        }
        parama = this.c.i().S.a(this.c.aa(), str);
        paramModulePkgInfo = e.c.a.a(this.c, parama, paramModulePkgInfo.md5);
        paramModulePkgInfo.a(new g.5(this, str, bool1, ???));
        paramModulePkgInfo.a();
      }
      return;
    }
  }
  
  private void a(@NonNull String paramString, @Nullable a.b paramb, @Nullable a.a parama)
  {
    if ((paramb == null) && (parama == null)) {
      return;
    }
    this.b.a(paramString, new g.b(paramb, parama));
  }
  
  private void a(String paramString, a.d paramd)
  {
    synchronized (this.a)
    {
      this.a.remove(paramString);
      ??? = this.b.b(paramString);
      if (??? == null)
      {
        o.b("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "markLoadingFinished %s, result %s, get null callbackSet, maybe canceled by user before", new Object[] { paramString, paramd.name() });
        return;
      }
      paramString = ((Set)???).iterator();
      while (paramString.hasNext())
      {
        ??? = (g.b)paramString.next();
        if (((g.b)???).a() != null) {
          ((g.b)???).a().a(paramd);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void a(String paramString, c paramc)
  {
    paramString = this.b.a(paramString);
    if (paramString == null) {
      return;
    }
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      g.b localb = (g.b)paramString.next();
      if (localb.b() != null) {
        localb.b().a(paramc);
      }
    }
  }
  
  private void a(String paramString, @Nullable g.a parama, @Nullable a.b paramb, @Nullable a.a parama1)
  {
    if (this.c.au())
    {
      o.b("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule with path(%s), but runtime(%s) finished", new Object[] { paramString, this.c.aa() });
      if (paramb != null) {
        paramb.a(a.d.b);
      }
      return;
    }
    i locali1 = new i();
    if (a(paramString, locali1))
    {
      o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule appId:%s path:%s, module:%s, options:%b, [loaded]", new Object[] { this.c.aa(), paramString, ((ModulePkgInfo)locali1.a).name, parama });
      if (paramb != null)
      {
        if ((parama != null) && (parama.b)) {
          a(((ModulePkgInfo)locali1.a).name, "options.injectModuleJS");
        }
        paramb.a(a.d.a);
        return;
      }
    }
    i locali2 = new i();
    com.tencent.luggage.wxa.qt.a locala = new com.tencent.luggage.wxa.qt.a();
    if ((parama != null) && (parama.a)) {
      this.c.d(new g.1(this, locala, locali1, locali2));
    }
    o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModule, appId:%s path:%s, module:%s, options:%b [do loadOrAddPendingCallback]", new Object[] { this.c.aa(), paramString, ((ModulePkgInfo)locali1.a).name, parama });
    a((ModulePkgInfo)locali1.a, new g.2(this, locala, parama, locali1, locali2, paramb), parama1);
  }
  
  private void a(String paramString1, String paramString2)
  {
    boolean bool = ((f)this.c.ae()).b(paramString1);
    o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "injectServiceScriptSafe appId:%s, module:%s, reason:%s ret:%b", new Object[] { this.c.aa(), paramString1, paramString2, Boolean.valueOf(bool) });
  }
  
  private boolean a(@NonNull ModulePkgInfo paramModulePkgInfo)
  {
    boolean bool;
    if ((!com.tencent.luggage.wxa.qz.af.c(paramModulePkgInfo.pkgPath)) && (k.h(paramModulePkgInfo.pkgPath))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (!paramModulePkgInfo.independent) {
        a("__APP__", "checkModuleLoaded");
      }
      a(paramModulePkgInfo.name, "checkModuleLoaded");
    }
    return bool;
  }
  
  private boolean a(String paramString, i<ModulePkgInfo> parami)
  {
    if (com.tencent.luggage.wxa.qz.af.c(paramString)) {
      paramString = this.c.i().S;
    } else {
      paramString = b(paramString);
    }
    if (parami != null) {
      parami.a = paramString;
    }
    return a(paramString);
  }
  
  private boolean b()
  {
    return a(this.c.i().S);
  }
  
  @NonNull
  public String a(String paramString)
  {
    return b(paramString).name;
  }
  
  public void a(String paramString, a.b paramb)
  {
    g.a locala = new g.a(null);
    locala.a = true;
    locala.b = true;
    a(paramString, locala, paramb, null);
  }
  
  public void a(@NonNull String paramString, @Nullable a.b paramb, @Nullable a.a parama, boolean paramBoolean)
  {
    ModulePkgInfo localModulePkgInfo = c(paramString);
    if (localModulePkgInfo == null)
    {
      o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [not found]", new Object[] { this.c.aa(), paramString, Boolean.valueOf(paramBoolean) });
      if (paramb != null) {
        paramb.a(a.d.d);
      }
    }
    else if (a(localModulePkgInfo))
    {
      o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [loaded]", new Object[] { this.c.aa(), paramString, Boolean.valueOf(paramBoolean) });
      if (paramBoolean) {
        a(localModulePkgInfo.name, "options.injectModuleJS");
      }
      if (paramb != null) {
        paramb.a(a.d.a);
      }
    }
    else
    {
      o.d("MicroMsg.AppBrand.RuntimeModularizingHelper[modularizing]", "loadModuleByName, appId:%s, name:%s, injectModuleJS:%b, [do loadOrAddPendingCallback]", new Object[] { this.c.aa(), paramString, Boolean.valueOf(paramBoolean) });
      a(localModulePkgInfo, new g.3(this, paramBoolean, localModulePkgInfo, paramb), parama);
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  @NonNull
  public ModulePkgInfo b(String paramString)
  {
    com.tencent.mm.plugin.appbrand.appcache.af localaf = this.c.i().S;
    if (!com.tencent.luggage.wxa.qz.af.c(paramString))
    {
      if ("__APP__".equals(paramString)) {
        return localaf;
      }
      ad.a(this.c);
      paramString = (ModulePkgInfo)h.a(localaf.e, paramString, "findModuleInfoByResourcePath");
      if (paramString != null) {
        return paramString;
      }
    }
    return localaf;
  }
  
  @Nullable
  public ModulePkgInfo c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.c.i().S;
    if (h.a(localObject, paramString, "findModuleInfoByModuleName")) {
      return localObject;
    }
    paramString = com.tencent.mm.plugin.appbrand.appcache.af.b(paramString);
    ad.a(this.c);
    localObject = ((com.tencent.mm.plugin.appbrand.appcache.af)localObject).e.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ModulePkgInfo localModulePkgInfo = (ModulePkgInfo)((Iterator)localObject).next();
      if (localModulePkgInfo.name.equals(paramString)) {
        return localModulePkgInfo;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ny.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.standalone_ext.service;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.du.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.s;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class g
  extends com.tencent.luggage.wxa.bp.d
{
  g(@NonNull c paramc, @NonNull s params)
  {
    super(paramc, params);
  }
  
  private int a(String paramString, com.tencent.mm.plugin.appbrand.jsruntime.g paramg)
  {
    o.d("Luggaeg.WAGameJsContextInterfaceStandalone", "injectPluginCodeNewLogic");
    if (paramString.equals("game.js"))
    {
      Object localObject1 = ((c)this.c).i().i().S.f;
      paramString = null;
      if (localObject1 != null) {
        paramString = ((ai)localObject1).a("__APP__");
      } else {
        o.b("Luggaeg.WAGameJsContextInterfaceStandalone", "pluginCodeList wxaRuntimeModulePluginListMap null");
      }
      if ((paramString != null) && (paramString.size() > 0))
      {
        o.d("Luggaeg.WAGameJsContextInterfaceStandalone", "client inject pluginCode size:%s", new Object[] { Integer.valueOf(paramString.size()) });
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          localObject1 = (WxaPluginPkgInfo)paramString.next();
          Object localObject2 = ((WxaPluginPkgInfo)localObject1).contexts;
          if (localObject2 != null) {
            o.e("Luggaeg.WAGameJsContextInterfaceStandalone", "multiPkg contexts size:%d,contexts:%s", new Object[] { Integer.valueOf(((List)localObject2).size()), Arrays.toString(((List)localObject2).toArray()) });
          }
          if ((localObject2 != null) && (((List)localObject2).contains(Integer.valueOf(0))))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((WxaPluginPkgInfo)localObject1).prefixPath);
            ((StringBuilder)localObject2).append("/plugin.js");
            localObject1 = ((StringBuilder)localObject2).toString();
            o.e("Luggaeg.WAGameJsContextInterfaceStandalone", "pluginCodefilePath:%s", new Object[] { localObject1 });
            super.a(paramg, (String)localObject1);
          }
        }
      }
    }
    return 1;
  }
  
  protected int a(@NonNull com.tencent.mm.plugin.appbrand.jsruntime.g paramg, @NonNull String paramString)
  {
    o.d("Luggaeg.WAGameJsContextInterfaceStandalone", "hy: injectWxaScript from js context interface: %s %d", new Object[] { paramString, Integer.valueOf(paramg.d()) });
    o.d("Luggaeg.WAGameJsContextInterfaceStandalone", "injectGameContextPlugin :%b, abtest:%b", new Object[] { Boolean.valueOf(Boolean.parseBoolean(((c)this.c).A().b("injectGameContextPlugin"))), Boolean.valueOf(false) });
    a(paramString, paramg);
    return super.a(paramg, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.service.g
 * JD-Core Version:    0.7.0.1
 */
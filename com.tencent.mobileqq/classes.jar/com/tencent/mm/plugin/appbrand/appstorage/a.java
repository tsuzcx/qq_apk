package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.luggage.wxa.jj.a.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import java.util.Set;

public class a
{
  public static void a(com.tencent.luggage.wxa.ed.d paramd)
  {
    if ((paramd != null) && (!af.c(paramd.aa())) && (paramd.aj() != null))
    {
      String str = paramd.aa();
      com.tencent.luggage.wxa.jj.a locala = paramd.aj();
      boolean bool2 = d.a.b(paramd.i().c());
      boolean bool3 = locala.g().contains("location");
      w.a("appbrand_background_config").a(String.format("%s_location_background_required", new Object[] { str }), bool3);
      paramd = locala.b("scope.userLocation");
      boolean bool1;
      if ((paramd != null) && (!af.c(paramd.b)))
      {
        w.a("appbrand_background_config").b(String.format("%s_permission_location_desc", new Object[] { str }), paramd.b);
        bool1 = true;
      }
      else
      {
        w.a("appbrand_background_config").remove(String.format("%s_permission_location_desc", new Object[] { str }));
        bool1 = false;
      }
      o.d("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, appId:%s, isDebug:%s, isLocationBackgroundRequired:%s, hasPermissionLocationDesc:%s", new Object[] { str, Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1) });
      return;
    }
    o.d("MicroMsg.AppBrandBackgroundConfigStorage", "updateBackgroundConfigs, runtime or appId or appConfig is null");
  }
  
  public static boolean a(String paramString)
  {
    if (af.c(paramString)) {
      return false;
    }
    return w.a("appbrand_background_config").b(String.format("%s_location_background_required", new Object[] { paramString }), false);
  }
  
  public static String b(String paramString)
  {
    if (af.c(paramString)) {
      return null;
    }
    return w.a("appbrand_background_config").c(String.format("%s_permission_location_desc", new Object[] { paramString }), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.a
 * JD-Core Version:    0.7.0.1
 */
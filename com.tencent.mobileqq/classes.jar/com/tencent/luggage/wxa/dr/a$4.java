package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.jj.l;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.game.liblockstep.LockStepNative;
import com.tencent.mm.plugin.appbrand.appcache.af;
import java.util.HashMap;

class a$4
  implements Runnable
{
  a$4(a parama, c paramc) {}
  
  public void run()
  {
    o.d("Luggage.LockStepNativeInstallHelper", "initConfigLockStep initConfig ");
    if (this.b.a == null)
    {
      o.d("Luggage.LockStepNativeInstallHelper", "initConfigLockStep lockStepNative is null");
      return;
    }
    l locall = (l)this.a.b(l.class);
    if (locall != null)
    {
      o.d("Luggage.LockStepNativeInstallHelper", "lockstep appId:%s,pkgDebugType:%d,pkgVersion:%d,mbzType:%s", new Object[] { locall.J, Integer.valueOf(locall.S.b + 1), Integer.valueOf(locall.S.pkgVersion), a.b(this.b) });
      HashMap localHashMap = new HashMap();
      localHashMap.put("appid", locall.J);
      localHashMap.put("appstate", String.valueOf(locall.S.b + 1));
      localHashMap.put("appversion", String.valueOf(locall.S.pkgVersion));
      localHashMap.put("apptype", a.b(this.b));
      this.b.a.initConfig(localHashMap);
      return;
    }
    o.b("Luggage.LockStepNativeInstallHelper", "initConfigLockStep sysConfig is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.a.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.dr;

import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.nz.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.websocket.libwcwss.WcwssNative;
import java.util.ArrayList;
import java.util.HashMap;

class d$6
  implements Runnable
{
  d$6(d paramd, h paramh) {}
  
  public void run()
  {
    o.d("Luggage.WcWssNativeInstallHelper", "initConfigWcWss initConfig mContextId:%s", new Object[] { d.d(this.b) });
    if (d.a(this.b) == null)
    {
      o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss mWcwssNative is null");
      return;
    }
    Object localObject = (a)this.a.b(a.class);
    if (localObject != null)
    {
      o.d("Luggage.WcWssNativeInstallHelper", "wcwss mbzType:%s,,websocketTimeoutMS:%d,userAgentString :%s,referer:%s,mode:%d", new Object[] { d.g(this.b), Integer.valueOf(((a)localObject).d), ((a)localObject).u, ((a)localObject).w, Integer.valueOf(((a)localObject).x) });
      HashMap localHashMap = new HashMap();
      localHashMap.put("referer", ((a)localObject).w);
      localHashMap.put("User-Agent", ((a)localObject).u);
      localHashMap.put("bzType", d.g(this.b));
      localHashMap.put("mode", String.valueOf(((a)localObject).x));
      localHashMap.put("timeout", String.valueOf(((a)localObject).d));
      d.a(this.b).initConfig(localHashMap);
      if (((a)localObject).x != 0)
      {
        if (((a)localObject).x == 1)
        {
          if ((((a)localObject).p != null) && (((a)localObject).p.size() != 0))
          {
            localObject = ((a)localObject).p;
          }
          else
          {
            o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss blacklistHeaders is null");
            localObject = null;
          }
          d.a(this.b).initConfigWhiteBlack(null, (ArrayList)localObject);
          return;
        }
        if (((a)localObject).x == 2)
        {
          if ((((a)localObject).q != null) && (((a)localObject).q.size() != 0))
          {
            localObject = ((a)localObject).q;
          }
          else
          {
            o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss whitelistHeaders is null");
            localObject = null;
          }
          d.a(this.b).initConfigWhiteBlack((ArrayList)localObject, null);
          return;
        }
        o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((a)localObject).x) });
        return;
      }
      o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss invalid mode:%d", new Object[] { Integer.valueOf(((a)localObject).x) });
      return;
    }
    o.b("Luggage.WcWssNativeInstallHelper", "initConfigWcWss networkConfig is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dr.d.6
 * JD-Core Version:    0.7.0.1
 */
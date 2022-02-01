package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.luggage.wxa.li.a;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pc.l.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;

class b$a
  implements a
{
  private b$a(b paramb) {}
  
  public void a(String paramString1, String paramString2)
  {
    o.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", new Object[] { paramString1, paramString2 });
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_apdu_command", paramString2);
      this.a.a(paramString1, 31, localBundle);
      b.a(this.a, true);
      if (!b.a(this.a))
      {
        b.b(this.a, true);
        b.c(this.a, false);
        b.a(System.currentTimeMillis());
        l.a().a(new b.a.1(this), b.b(this.a));
        return;
      }
      if (b.e(this.a))
      {
        o.c("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND TimeExceeded, just return default command");
        b.a(this.a, b.c(), true, b.d(this.a));
        b.c(this.a, false);
      }
      return;
    }
    o.b("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((b.f(this.a) != null) && (b.f(this.a).equals(paramString1)) && (!af.c(paramString2)))
    {
      byte[] arrayOfByte = Base64.decode(paramString2, 2);
      o.d("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", new Object[] { paramString1, paramString2, c.a(arrayOfByte), Boolean.valueOf(b.c(this.a)) });
      paramString1 = this.a;
      b.a(paramString1, arrayOfByte, false, b.d(paramString1));
      return;
    }
    o.b("MicroMsg.HCEServiceMgr", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", new Object[] { b.f(this.a), paramString1, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.b.a
 * JD-Core Version:    0.7.0.1
 */
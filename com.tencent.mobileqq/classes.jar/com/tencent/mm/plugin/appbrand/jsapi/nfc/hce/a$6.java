package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.qz.o;

class a$6
  implements Runnable
{
  a$6(a parama, ComponentName paramComponentName) {}
  
  public void run()
  {
    a.b(this.b, true);
    Object localObject = new Intent("android.nfc.cardemulation.action.ACTION_CHANGE_DEFAULT");
    ((Intent)localObject).putExtra("category", "payment");
    ((Intent)localObject).putExtra("component", this.a);
    if ((a.f(this.b) != null) && (((Intent)localObject).resolveActivity(a.f(this.b).getPackageManager()) != null))
    {
      LuggageActivityHelper.FOR(a.f(this.b)).startActivityForResult((Intent)localObject, new a.6.1(this));
      return;
    }
    o.b("MicroMsg.HCEActivityMgr", "alvinluo reuquestSetDefaultNFCApplication can not find activity");
    if (a.f(this.b) != null)
    {
      localObject = this.b;
      a.a((a)localObject, 13004, "not set default NFC application", a.f((a)localObject).getString(2131891469));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.6
 * JD-Core Version:    0.7.0.1
 */
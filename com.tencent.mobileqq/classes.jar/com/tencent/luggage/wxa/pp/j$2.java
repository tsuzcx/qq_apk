package com.tencent.luggage.wxa.pp;

import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.kw.h.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class j$2
  implements ac.b
{
  j$2(j paramj, WeakReference paramWeakReference, c paramc, String paramString) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67)
    {
      paramKeyEvent = (u)this.a.get();
      if (paramKeyEvent == null) {
        return true;
      }
      try
      {
        paramInt = this.b.a();
        h.a locala = new h.a();
        JSONObject localJSONObject = new JSONObject().put("value", this.b.b().getText().toString()).put("data", this.c).put("cursor", 0).put("inputId", paramInt).put("keyCode", 8);
        locala.a(paramKeyEvent.q().ae(), paramKeyEvent.getComponentId()).a(localJSONObject.toString()).a();
        return true;
      }
      catch (Exception paramKeyEvent)
      {
        o.b("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", new Object[] { paramKeyEvent });
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.j.2
 * JD-Core Version:    0.7.0.1
 */
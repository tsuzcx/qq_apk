package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.jx.n;
import com.tencent.luggage.wxa.pp.h;
import com.tencent.luggage.wxa.pp.y;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class d$2
  extends y
{
  d$2(d paramd, WeakReference paramWeakReference, int paramInt, String paramString) {}
  
  private void g()
  {
    u localu = (u)this.a.get();
    if (localu != null)
    {
      if (localu.aj() == null) {
        return;
      }
      h.a().c(localu.aj());
    }
  }
  
  public void a(String paramString)
  {
    u localu = (u)this.a.get();
    if (localu == null) {
      return;
    }
    try
    {
      int i = a();
      h.a locala = new h.a();
      paramString = new JSONObject().put("value", com.tencent.luggage.wxa.pd.d.a(paramString)).put("data", this.d.a(i)).put("cursor", 0).put("inputId", i).put("keyCode", 8);
      locala.a(localu.q().ae(), localu.getComponentId()).a(paramString.toString()).a();
      return;
    }
    catch (Exception paramString)
    {
      o.b("MicroMsg.JsApiInsertTextArea", "onBackspacePressedWhileValueNoChange, e = %s", new Object[] { paramString });
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.a.get() != null)
    {
      try
      {
        paramString = com.tencent.luggage.wxa.pd.d.a(paramString);
        paramString = new JSONObject().put("value", paramString).put("inputId", a()).put("cursor", paramInt).toString();
        if (paramBoolean1) {
          ((u)this.a.get()).a("onKeyboardConfirm", paramString);
        }
        if (!paramBoolean2) {
          ((u)this.a.get()).a("onKeyboardComplete", paramString);
        }
      }
      catch (JSONException paramString)
      {
        o.b("MicroMsg.JsApiInsertTextArea", "dispatch input done, exp = %s", new Object[] { af.a(paramString) });
      }
      if (!paramBoolean2) {
        g();
      }
    }
  }
  
  public void b()
  {
    if (this.a.get() != null)
    {
      ((u)this.a.get()).a(this.b, this.d.b("fail"));
      g();
    }
  }
  
  public void w_()
  {
    if (this.a.get() != null)
    {
      int i = a();
      HashMap localHashMap = new HashMap(1);
      localHashMap.put("inputId", Integer.valueOf(i));
      ((u)this.a.get()).a(this.b, this.d.a("ok", localHashMap));
      this.d.a(i, this.c);
      this.d.a(i, (u)this.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.d.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.hv.c;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.luggage.wxa.pp.j;
import com.tencent.luggage.wxa.pw.a.a;
import com.tencent.luggage.wxa.pw.a.b;
import com.tencent.luggage.wxa.pw.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class h
  extends a<e>
{
  public static final int CTRL_INDEX = 1;
  static final String NAME = "showKeyboard";
  
  private void a(int paramInt1, int paramInt2, u paramu)
  {
    try
    {
      paramInt2 = com.tencent.luggage.wxa.pc.g.a(paramInt2);
      paramu.a("onKeyboardShow", com.tencent.luggage.wxa.hv.h.b().a("inputId", paramInt1).a("height", paramInt2).toString());
      return;
    }
    catch (com.tencent.luggage.wxa.hv.g paramu)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiShowKeyboard", "", new Object[] { paramu.getMessage() });
    }
  }
  
  private void a(u paramu, int paramInt1, int paramInt2, String paramString, e parame, int paramInt3)
  {
    Object localObject = j.a().a(parame, paramString, paramInt1, paramInt2, paramu);
    if (localObject != null)
    {
      paramString = new HashMap(1);
      paramString.put("inputId", localObject);
      paramu.a(paramInt3, a("ok", paramString));
      return;
    }
    localObject = paramu.getAppId();
    paramu.getComponentId();
    WeakReference localWeakReference = new WeakReference(paramu);
    parame.h = localWeakReference;
    paramString = a(localWeakReference, paramString, paramInt3);
    paramString.a(new h.3(this, paramString, (String)localObject, paramu));
    paramString.a(new h.4(this, localWeakReference));
    a(paramString);
    l.a(new h.5(this, localWeakReference, paramString, parame, paramInt1, paramInt2));
  }
  
  protected com.tencent.luggage.wxa.pp.i a(WeakReference<u> paramWeakReference, String paramString, int paramInt)
  {
    return new h.6(this, paramWeakReference, paramInt, paramString);
  }
  
  protected void a(com.tencent.luggage.wxa.pp.i parami) {}
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    int j = paramJSONObject.optInt("cursor", -2);
    int i;
    if ((!paramJSONObject.has("selectionStart")) && (!paramJSONObject.has("selectionEnd")))
    {
      i = j;
    }
    else
    {
      j = paramJSONObject.optInt("selectionStart", -2);
      i = paramJSONObject.optInt("selectionEnd", -2);
    }
    try
    {
      int k = paramJSONObject.getInt("inputId");
      if (f())
      {
        t.a(new h.1(this, paramu, k, j, i, paramInt));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      label93:
      e locale;
      break label93;
    }
    locale = new e();
    if (!a(locale, paramJSONObject, paramu, paramInt)) {
      return;
    }
    if (!paramJSONObject.has("inputId"))
    {
      locale.b = com.tencent.luggage.wxa.kd.i.a(paramu, System.nanoTime());
      a(locale.b, 0, paramu);
    }
    l.a(new h.2(this, paramu, j, i, paramJSONObject.optString("data"), locale, paramInt));
  }
  
  protected boolean a(e parame, JSONObject paramJSONObject, u paramu, int paramInt)
  {
    boolean bool = super.a(parame, paramJSONObject, paramu, paramInt);
    int j = 0;
    if (!bool) {
      return false;
    }
    parame.a = paramJSONObject.optInt("parentId");
    parame.b = paramJSONObject.optInt("inputId");
    parame.j = Integer.valueOf(Math.max(0, parame.j.intValue()));
    int i;
    if (parame.k == null) {
      i = 0;
    } else {
      i = Math.max(0, parame.k.intValue());
    }
    parame.k = Integer.valueOf(i);
    parame.c = paramJSONObject.optString("type", "text");
    if (!com.tencent.luggage.wxa.pp.o.b.contains(parame.c))
    {
      paramu.a(paramInt, b("fail:unsupported input type"));
      return false;
    }
    if (parame.J == null) {
      parame.J = Boolean.valueOf(true);
    }
    parame.d = paramJSONObject.optBoolean("password");
    parame.M = Boolean.valueOf(paramJSONObject.optBoolean("password"));
    if (paramJSONObject.has("showCoverView")) {
      parame.N = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    }
    if (g())
    {
      paramu = paramJSONObject.optJSONObject("dropdown");
      if (paramu != null)
      {
        paramJSONObject = new a.a();
        paramJSONObject.a = paramu.optInt("marginLeft");
        paramJSONObject.b = paramu.optInt("marginRight");
        paramJSONObject.c = paramu.optString("width");
        paramu = paramu.optJSONArray("options");
        if ((paramu != null) && (paramu.length() > 0))
        {
          paramJSONObject.d = new ArrayList();
          paramInt = j;
          while (paramInt < paramu.length())
          {
            Object localObject = paramu.optJSONObject(paramInt);
            if (localObject != null)
            {
              String str1 = ((JSONObject)localObject).optString("id");
              String str2 = ((JSONObject)localObject).optString("title");
              localObject = ((JSONObject)localObject).optString("content");
              if ((!af.c(str1)) && (!af.c(str2)))
              {
                a.b localb = new a.b();
                localb.a = str1;
                localb.b = str2;
                localb.c = ((String)localObject);
                paramJSONObject.d.add(localb);
              }
            }
            paramInt += 1;
          }
          parame.g = paramJSONObject;
        }
      }
    }
    return true;
  }
  
  protected boolean f()
  {
    return true;
  }
  
  protected boolean g()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.h
 * JD-Core Version:    0.7.0.1
 */
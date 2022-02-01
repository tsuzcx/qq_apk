package com.tencent.luggage.wxa.kd;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.kt.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class c<CONTEXT extends com.tencent.luggage.wxa.jx.e>
  extends e<com.tencent.luggage.wxa.jx.c>
{
  private void b(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if ((!paramc.e()) && (!paramc.d()))
    {
      paramc.a(paramInt, "fail:interrupted");
      return;
    }
    com.tencent.luggage.wxa.jx.e locale = a(paramc, paramJSONObject);
    if (locale == null)
    {
      o.c("MicroMsg.BaseRemoveViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { d() });
      paramc.a(paramInt, b("fail:ComponentView is null."));
      return;
    }
    if (locale.getCustomViewContainer() == null)
    {
      o.c("MicroMsg.BaseRemoveViewJsApi", "fail, component custom view container is null");
      paramc.a(paramInt, b("fail:remove view failed"));
      return;
    }
    try
    {
      int i = a(paramJSONObject);
      boolean bool2 = h(paramJSONObject);
      View localView = locale.c(bool2).b(i);
      if (((localView instanceof b)) && (paramJSONObject.has("draggable")) && (i(paramJSONObject))) {
        ((b)localView).a(i);
      }
      boolean bool1;
      if (locale.c(bool2).c(i))
      {
        bool1 = locale.c(bool2).e(i);
        if (bool1) {
          bool1 = a(locale, i, localView, paramJSONObject);
        }
      }
      else
      {
        bool1 = false;
      }
      if (bool1) {
        locale.c(bool2).a(i);
      }
      o.d("MicroMsg.BaseRemoveViewJsApi", "remove view(parentId : %s, viewId : %s, r : %s)", new Object[] { Integer.valueOf(b(paramJSONObject)), Integer.valueOf(i), Boolean.valueOf(bool1) });
      if (bool1) {
        paramJSONObject = "ok";
      } else {
        paramJSONObject = "fail";
      }
      paramc.a(paramInt, b(paramJSONObject));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      o.b("MicroMsg.BaseRemoveViewJsApi", "get viewId error. exception : %s", new Object[] { paramJSONObject });
      paramc.a(paramInt, b("fail:view id do not exist"));
    }
  }
  
  @NonNull
  protected com.tencent.luggage.wxa.jx.e a(@NonNull com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject)
  {
    return ((g)paramc.a(g.class)).a(paramc, paramJSONObject);
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (t.a())
    {
      b(paramc, paramJSONObject, paramInt);
      return;
    }
    t.a(new c.1(this, paramc, paramJSONObject, paramInt));
  }
  
  protected boolean a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.c
 * JD-Core Version:    0.7.0.1
 */
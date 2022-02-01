package com.tencent.luggage.wxa.kd;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.e.a;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public abstract class b<CONTEXT extends com.tencent.luggage.wxa.jx.e>
  extends e<c>
{
  private void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (!f()) {
      return;
    }
    a.b localb = paramCONTEXT.c(paramBoolean).a(paramInt, true);
    localb.a("disableScroll", paramJSONObject.optBoolean("disableScroll", false));
    localb.a("enableLongClick", g());
    localb.a("data", paramJSONObject.optString("data"));
    if (paramJSONObject.optBoolean("gesture", false)) {
      com.tencent.luggage.wxa.mn.e.a(paramCONTEXT, paramView, localb);
    }
  }
  
  private void a(CONTEXT paramCONTEXT, int paramInt, boolean paramBoolean)
  {
    a.b localb = paramCONTEXT.c(paramBoolean).a(paramInt, true);
    if ((f.c)localb.b("baseViewDestroyListener", null) == null)
    {
      b.2 local2 = new b.2(this, paramCONTEXT, paramBoolean, paramInt, localb);
      localb.a("baseViewDestroyListener", local2);
      paramCONTEXT.a(local2);
    }
  }
  
  private void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, j paramj)
  {
    paramCONTEXT.a(new b.1(this, paramCONTEXT, paramj, paramJSONObject));
  }
  
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    paramCONTEXT = new StringBuilder();
    paramCONTEXT.append("inflateView must be inflated.");
    paramCONTEXT.append(this);
    throw new IllegalStateException(paramCONTEXT.toString());
  }
  
  protected View a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    return a(paramCONTEXT, paramJSONObject);
  }
  
  @NonNull
  protected com.tencent.luggage.wxa.jx.e a(@NonNull c paramc, JSONObject paramJSONObject)
  {
    return ((g)paramc.a(g.class)).a(paramc, paramJSONObject);
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.luggage.wxa.jx.e locale = a(paramc, paramJSONObject);
    if (locale == null)
    {
      o.c("MicroMsg.BaseInsertViewJsApi", "invoke JsApi(%s) failed, component view is null", new Object[] { d() });
      paramc.a(paramInt, b("fail:ComponentView is null."));
      return;
    }
    a(locale, paramJSONObject, new j(paramc, paramInt));
  }
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject) {}
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, j paramj) {}
  
  protected boolean c()
  {
    return false;
  }
  
  protected boolean f()
  {
    return false;
  }
  
  protected boolean g()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.b
 * JD-Core Version:    0.7.0.1
 */
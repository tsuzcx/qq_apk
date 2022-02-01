package com.tencent.luggage.wxa.kd;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.e.a;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends com.tencent.luggage.wxa.jx.e>
  extends e<c>
{
  private void a(com.tencent.luggage.wxa.jx.e parame, int paramInt, View paramView, JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (c()) {}
    try
    {
      parame = parame.c(paramBoolean);
      paramBoolean = false;
      parame = parame.a(paramInt, false);
      if (parame != null)
      {
        boolean bool = paramJSONObject.getBoolean("disableScroll");
        if (parame.b("isTouching"))
        {
          if (!bool) {
            paramBoolean = true;
          }
          if (parame.b("disableScroll", paramBoolean) != bool) {
            parame.a("disableScroll-nextState", bool);
          }
        }
        else
        {
          parame.a("disableScroll", bool);
        }
      }
      return;
    }
    catch (JSONException parame) {}
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
      paramc.a(paramInt, b("fail:ComponentView is null."));
      return;
    }
    paramc.a(new d.1(this, new WeakReference(locale), paramc, paramInt, paramJSONObject));
  }
  
  protected boolean a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    return true;
  }
  
  protected boolean a(CONTEXT paramCONTEXT, int paramInt, View paramView, JSONObject paramJSONObject, j paramj)
  {
    return true;
  }
  
  protected boolean c()
  {
    return false;
  }
  
  protected boolean f()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.d
 * JD-Core Version:    0.7.0.1
 */
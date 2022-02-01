package com.tencent.luggage.wxa.kx;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

abstract class a<CONTEXT extends c>
  extends com.tencent.luggage.wxa.jx.a<CONTEXT>
{
  private boolean a;
  
  private boolean c(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    Activity localActivity;
    if ((paramCONTEXT.getContext() instanceof Activity)) {
      localActivity = (Activity)paramCONTEXT.getContext();
    } else {
      localActivity = null;
    }
    if (localActivity == null)
    {
      o.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
      paramCONTEXT.a(paramInt, b("fail:internal error invalid android context"));
      return false;
    }
    if (a(paramCONTEXT)) {
      return true;
    }
    if (this.a)
    {
      paramCONTEXT.a(paramInt, b("fail:system permission denied"));
      return false;
    }
    return LuggageActivityHelper.FOR(localActivity).checkRequestPermission("android.permission.ACCESS_FINE_LOCATION", new a.1(this, paramCONTEXT, paramJSONObject, paramInt));
  }
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    if (!c(paramCONTEXT, paramJSONObject, paramInt))
    {
      o.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", new Object[] { d() });
      return;
    }
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", new Object[] { d() });
      paramCONTEXT.a(paramInt, b("fail:invalid data"));
      return;
    }
    b(paramCONTEXT, paramJSONObject, paramInt);
  }
  
  final boolean a(@NonNull CONTEXT paramCONTEXT)
  {
    return j.a(paramCONTEXT.getContext(), "android.permission.ACCESS_FINE_LOCATION");
  }
  
  protected abstract void b(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.a
 * JD-Core Version:    0.7.0.1
 */
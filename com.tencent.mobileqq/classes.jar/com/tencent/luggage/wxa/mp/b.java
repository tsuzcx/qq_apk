package com.tencent.luggage.wxa.mp;

import android.app.Activity;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public abstract class b
  extends a
{
  static String a(String paramString)
  {
    if (af.c(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if (i == -1) {
      return "";
    }
    return paramString.substring(i);
  }
  
  private boolean c(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    Activity localActivity;
    if ((paramc.getContext() instanceof Activity)) {
      localActivity = (Activity)paramc.getContext();
    } else {
      localActivity = null;
    }
    if (localActivity == null)
    {
      o.b("MicroMsg.BaseRecordJsApi", "operateRecorder, pageContext is null");
      paramc.a(paramInt, b("fail:internal error invalid android context"));
      return false;
    }
    return LuggageActivityHelper.FOR(localActivity).checkRequestPermission("android.permission.RECORD_AUDIO", new b.1(this, paramc, paramJSONObject, paramInt));
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!c(paramc, paramJSONObject, paramInt))
    {
      o.b("MicroMsg.BaseRecordJsApi", "%s requestPermission fail", new Object[] { d() });
      return;
    }
    if (paramJSONObject == null)
    {
      o.b("MicroMsg.BaseRecordJsApi", "%s invalid data", new Object[] { d() });
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    b(paramc, paramJSONObject, paramInt);
  }
  
  protected abstract void b(c paramc, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.b
 * JD-Core Version:    0.7.0.1
 */
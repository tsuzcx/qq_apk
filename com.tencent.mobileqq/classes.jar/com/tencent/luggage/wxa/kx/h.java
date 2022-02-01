package com.tencent.luggage.wxa.kx;

import android.os.Bundle;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.pg.a.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class h
  extends g<b>
{
  final i a = new i();
  
  protected Bundle a(b paramb, JSONObject paramJSONObject)
  {
    Bundle localBundle = super.a(paramb, paramJSONObject);
    String str = paramJSONObject.optString("subKey", "");
    paramb = paramb.getAppId();
    if (!af.c(str))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("#");
      localStringBuilder.append(paramb);
      localStringBuilder.append(";");
      localBundle.putString("smallAppKey", localStringBuilder.toString());
    }
    localBundle.putBoolean("enableIndoor", paramJSONObject.optBoolean("enableIndoor", false));
    o.f("MicroMsg.JsApiGetLocation", "getLocation %s", new Object[] { paramJSONObject });
    return localBundle;
  }
  
  protected void a(b paramb)
  {
    this.a.a(paramb.q());
  }
  
  protected void a(b paramb, int paramInt, String paramString, a.a parama)
  {
    this.a.b(paramb.q());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.h
 * JD-Core Version:    0.7.0.1
 */
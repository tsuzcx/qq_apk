package com.tencent.luggage.wxa.fy;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONObject;

public final class f
{
  public static boolean a(m paramm, c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (!paramm.d().contains("operate")) {
      return false;
    }
    Object localObject = paramJSONObject.optString("type");
    if (af.c((String)localObject)) {
      return false;
    }
    if (!((String)localObject).equalsIgnoreCase("exitPictureInPicture")) {
      return false;
    }
    localObject = null;
    if ((paramc instanceof h)) {
      localObject = ((h)paramc).q();
    }
    String str = "fail";
    if (localObject == null)
    {
      paramc.a(paramInt, paramm.b("fail"));
      return true;
    }
    com.tencent.luggage.wxa.op.f localf = ((d)localObject).aR();
    if (localf == null)
    {
      paramc.a(paramInt, paramm.b("fail"));
      return true;
    }
    localObject = str;
    if (localf.a(paramJSONObject.optInt("viewId"))) {
      localObject = "ok";
    }
    paramc.a(paramInt, paramm.b((String)localObject));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.f
 * JD-Core Version:    0.7.0.1
 */
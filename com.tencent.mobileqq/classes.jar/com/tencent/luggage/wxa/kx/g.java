package com.tencent.luggage.wxa.kx;

import android.os.Bundle;
import androidx.annotation.CallSuper;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pg.a.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class g<CONTEXT extends c>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 37;
  public static final String NAME = "getLocation";
  
  @CallSuper
  protected Bundle a(CONTEXT paramCONTEXT, JSONObject paramJSONObject)
  {
    paramCONTEXT = new Bundle();
    boolean bool = paramJSONObject.optBoolean("isHighAccuracy", false);
    int i = paramJSONObject.optInt("highAccuracyExpireTime", 3000);
    paramCONTEXT.putBoolean("isHighAccuracy", bool);
    paramCONTEXT.putInt("highAccuracyExpireTime", i);
    return paramCONTEXT;
  }
  
  protected void a(CONTEXT paramCONTEXT, int paramInt, String paramString, a.a parama) {}
  
  protected void b(CONTEXT paramCONTEXT) {}
  
  public void b(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    Object localObject2 = af.b(paramJSONObject.optString("type", "wgs84")).trim();
    Object localObject1 = localObject2;
    if (af.c((String)localObject2)) {
      localObject1 = "wgs84";
    }
    boolean bool = paramJSONObject.optBoolean("altitude", false);
    o.d("MicroMsg.JsApiGetLocation", "getLocation data:%s", new Object[] { paramJSONObject });
    if ((!"wgs84".equals(localObject1)) && (!"gcj02".equals(localObject1)))
    {
      o.b("MicroMsg.JsApiGetLocation", "doGeoLocation fail, unsupported type = %s", new Object[] { localObject1 });
      paramJSONObject = new HashMap(1);
      paramJSONObject.put("errCode", Integer.valueOf(-1));
      paramCONTEXT.a(paramInt, a("fail:invalid data", paramJSONObject));
      return;
    }
    if (!a(paramCONTEXT))
    {
      paramJSONObject = new HashMap(1);
      paramJSONObject.put("errCode", Integer.valueOf(-2));
      paramCONTEXT.a(paramInt, a("fail:system permission denied", paramJSONObject));
      return;
    }
    b(paramCONTEXT);
    paramJSONObject = a(paramCONTEXT, paramJSONObject);
    localObject2 = (com.tencent.luggage.wxa.pg.a)paramCONTEXT.a(com.tencent.luggage.wxa.pg.a.class);
    if (localObject2 != null) {
      ((com.tencent.luggage.wxa.pg.a)localObject2).getLocation((String)localObject1, new g.1(this, paramCONTEXT, (String)localObject1, bool, paramInt), paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kx.g
 * JD-Core Version:    0.7.0.1
 */
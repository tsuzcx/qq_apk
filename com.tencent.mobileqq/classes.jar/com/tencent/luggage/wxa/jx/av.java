package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.ed.d;
import com.tencent.luggage.wxa.om.c;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONArray;
import org.json.JSONObject;

public class av
  extends a<com.tencent.luggage.wxa.iu.b>
{
  public static final int CTRL_INDEX = 283;
  public static final String NAME = "traceEvent";
  
  public void a(com.tencent.luggage.wxa.iu.b paramb, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("events");
    if ((com.tencent.luggage.wxa.om.b.b((d)paramb.q())) && (paramJSONObject != null))
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        Object localObject = paramJSONObject.optJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("category");
          String str2 = ((JSONObject)localObject).optString("name");
          long l1 = ((JSONObject)localObject).optLong("start");
          long l2 = ((JSONObject)localObject).optLong("end");
          String str3 = ((JSONObject)localObject).optString("phase");
          localObject = ((JSONObject)localObject).optString("args");
          if (!af.c(str2)) {
            c.a(paramb.getAppId(), str1, str2, str3, l1, l2, (String)localObject);
          }
        }
        i += 1;
      }
      paramb.a(paramInt, b("ok"));
      return;
    }
    paramb.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.av
 * JD-Core Version:    0.7.0.1
 */
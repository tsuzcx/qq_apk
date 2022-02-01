package com.tencent.luggage.wxa.mp;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends a
{
  public static final int CTRL_INDEX = 469;
  public static final String NAME = "getAvailableAudioSources";
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = "";
    }
    o.d("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources data:%s", new Object[] { paramJSONObject });
    Object localObject = new ArrayList();
    ((List)localObject).add(e.a.a.h);
    ((List)localObject).add(e.a.b.h);
    ((List)localObject).add(e.a.c.h);
    ((List)localObject).add(e.a.d.h);
    ((List)localObject).add(e.a.e.h);
    if (com.tencent.luggage.wxa.hg.c.a(24)) {
      ((List)localObject).add(e.a.f.h);
    }
    paramJSONObject = new JSONArray();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramJSONObject.put((String)((Iterator)localObject).next());
    }
    localObject = new HashMap(1);
    ((HashMap)localObject).put("audioSources", paramJSONObject);
    o.d("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", new Object[] { ((HashMap)localObject).toString() });
    paramc.a(paramInt, a("ok", (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.f
 * JD-Core Version:    0.7.0.1
 */
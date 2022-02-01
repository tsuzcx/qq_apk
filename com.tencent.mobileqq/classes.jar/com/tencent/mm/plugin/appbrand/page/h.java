package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.util.g;
import com.tencent.luggage.util.m;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.n;
import java.util.HashMap;
import org.json.JSONObject;

public class h
  extends n
{
  private static final int CTRL_INDEX = 50;
  private static final String NAME = "onAppEnterForeground";
  
  public final void a(d paramd, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    Object localObject = paramd.B().l();
    if (localObject != null) {
      localHashMap.put("referrerInfo", localObject);
    }
    localHashMap.put("relaunch", Boolean.valueOf(paramBoolean));
    localHashMap.put("reLaunch", Boolean.valueOf(paramBoolean));
    if (paramBoolean) {
      localObject = paramd.as();
    } else {
      localObject = paramd.C().getCurrentUrl();
    }
    localHashMap.put("rawPath", localObject);
    localHashMap.put("path", m.b((String)localObject));
    localHashMap.put("query", m.c((String)localObject));
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandOnAppEnterForegroundEvent", "path: %s, query: %s, relaunch: %s, url: %s", new Object[] { localHashMap.get("path"), localHashMap.get("query"), localHashMap.get("relaunch"), localObject });
    g.a(localHashMap);
    localObject = new JSONObject(localHashMap);
    a(paramd, paramBoolean, (JSONObject)localObject);
    a(((JSONObject)localObject).toString()).a(paramd.ae()).a();
  }
  
  public void a(d paramd, boolean paramBoolean, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.h
 * JD-Core Version:    0.7.0.1
 */
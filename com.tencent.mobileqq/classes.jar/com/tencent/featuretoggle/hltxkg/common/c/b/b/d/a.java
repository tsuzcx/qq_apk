package com.tencent.featuretoggle.hltxkg.common.c.b.b.d;

import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.e;
import com.tencent.featuretoggle.hltxkg.common.c.j;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  extends com.tencent.featuretoggle.hltxkg.common.c.b.b.b
{
  private static boolean a = false;
  
  public final void a(com.tencent.featuretoggle.hltxkg.common.c.b.b.a parama)
  {
    Object localObject3 = new com.tencent.featuretoggle.hltxkg.common.c.b.b.a.c();
    Object localObject2 = new com.tencent.featuretoggle.hltxkg.common.c.b.b.a.b();
    Object localObject1 = new com.tencent.featuretoggle.hltxkg.common.c.b.b.a.a();
    try
    {
      boolean bool = com.tencent.featuretoggle.hltxkg.common.e.c.a(((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.b)localObject2).b);
      if ((!bool) && (a))
      {
        parama.a.put("needUpdateState", Integer.valueOf(0));
      }
      else
      {
        parama.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
      if (com.tencent.featuretoggle.hltxkg.common.e.c.a(((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.b)localObject2).b))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("model", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.c)localObject3).a);
        localJSONObject.put("osVersion", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.c)localObject3).b);
        localJSONObject.put("imei", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.c)localObject3).c);
        localJSONObject.put("imsi", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.c)localObject3).d);
        localJSONObject.put("pseudoId", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.c)localObject3).e);
        parama.a.put("RegistDeviceInfo", localJSONObject);
      }
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("platform", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.b)localObject2).a);
      ((JSONObject)localObject3).put("deviceId", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.b)localObject2).b);
      ((JSONObject)localObject3).put("sdkVersion", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.b)localObject2).c);
      parama.a.put("BindDeviceInfo", localObject3);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("bundle", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.a)localObject1).a);
      ((JSONObject)localObject2).put("verCode", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.a)localObject1).b);
      ((JSONObject)localObject2).put("verName", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.a)localObject1).c);
      ((JSONObject)localObject2).put("appId", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.a)localObject1).e);
      ((JSONObject)localObject2).put("uuid", ((com.tencent.featuretoggle.hltxkg.common.c.b.b.a.a)localObject1).d);
      localObject1 = new JSONArray();
      ((JSONArray)localObject1).put(localObject2);
      parama.a.put("AppState", localObject1);
      localObject1 = j.a(e.e());
      parama.a.put("netType", localObject1);
      localObject1 = com.tencent.featuretoggle.hltxkg.common.c.b.a.b.a(e.i().intValue());
      parama.a.put("oper", localObject1);
      return;
    }
    catch (Exception parama) {}
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      str1 = paramJSONObject.optString("result");
      boolean bool = TextUtils.isEmpty(str1);
      if (bool) {}
    }
    catch (Throwable paramJSONObject)
    {
      String str1;
      label32:
      String str2;
      return;
    }
    try
    {
      if (Integer.parseInt(str1) == 1002)
      {
        j.a("");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      break label32;
    }
    str1 = paramJSONObject.optString("deviceId");
    if (!TextUtils.isEmpty(str1))
    {
      str2 = j.a();
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals(str2))) {
        j.a(str1);
      }
    }
    else
    {
      j.a("");
    }
    paramJSONObject = paramJSONObject.optString("oper");
    if (!TextUtils.isEmpty(paramJSONObject)) {
      com.tencent.featuretoggle.hltxkg.common.c.b.a.b.a().a(e.b(), paramJSONObject);
    }
  }
  
  public final String c()
  {
    return "state";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.b.d.a
 * JD-Core Version:    0.7.0.1
 */
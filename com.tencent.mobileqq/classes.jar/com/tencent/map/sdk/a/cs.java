package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cs
  extends cj
{
  private static boolean a = false;
  private static volatile boolean b = false;
  private static volatile boolean c = false;
  
  public final void a(cf paramcf)
  {
    Object localObject3 = new ci();
    Object localObject2 = new ch();
    Object localObject1 = new cg();
    try
    {
      if ((dg.a(((ch)localObject2).b)) || (!a))
      {
        paramcf.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
      for (;;)
      {
        if (dg.a(((ch)localObject2).b))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("model", ((ci)localObject3).a);
          localJSONObject.put("osVersion", ((ci)localObject3).b);
          localJSONObject.put("imei", ((ci)localObject3).c);
          localJSONObject.put("imsi", ((ci)localObject3).d);
          localJSONObject.put("pseudoId", ((ci)localObject3).e);
          paramcf.a.put("RegistDeviceInfo", localJSONObject);
        }
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("platform", ((ch)localObject2).a);
        ((JSONObject)localObject3).put("deviceId", ((ch)localObject2).b);
        ((JSONObject)localObject3).put("sdkVersion", ((ch)localObject2).c);
        paramcf.a.put("BindDeviceInfo", localObject3);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("bundle", ((cg)localObject1).a);
        ((JSONObject)localObject2).put("verCode", ((cg)localObject1).b);
        ((JSONObject)localObject2).put("verName", ((cg)localObject1).c);
        ((JSONObject)localObject2).put("appId", ((cg)localObject1).e);
        ((JSONObject)localObject2).put("uuid", ((cg)localObject1).d);
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localObject2);
        paramcf.a.put("AppState", localObject1);
        localObject1 = dc.a(ao.g());
        paramcf.a.put("netType", localObject1);
        localObject1 = cd.a(ao.k().intValue());
        paramcf.a.put("oper", localObject1);
        if (!de.c) {
          break label456;
        }
        if (b) {
          break;
        }
        b = true;
        return;
        paramcf.a.put("needUpdateState", Integer.valueOf(0));
      }
      if (!c)
      {
        c = true;
        if ((!TextUtils.isEmpty(de.a)) && (!TextUtils.isEmpty(de.b)))
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("longitude", de.a);
          ((JSONObject)localObject1).put("latitude", de.b);
          paramcf.a.put("location", localObject1);
        }
      }
      label456:
      return;
    }
    catch (Exception paramcf) {}
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.optString("result");
      boolean bool = TextUtils.isEmpty(str1);
      if (!bool) {
        try
        {
          if (Integer.parseInt(str1) == 1002)
          {
            dc.a("");
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
      String str2 = paramJSONObject.optString("deviceId");
      if (!TextUtils.isEmpty(str2))
      {
        String str3 = dc.a();
        if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str3))) {
          dc.a(str2);
        }
      }
      for (;;)
      {
        paramJSONObject = paramJSONObject.optString("oper");
        if (TextUtils.isEmpty(paramJSONObject)) {
          break;
        }
        cd.a().a(ao.b(), paramJSONObject);
        return;
        dc.a("");
      }
      return;
    }
    catch (Throwable paramJSONObject) {}
  }
  
  public final String c()
  {
    return "state";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.cs
 * JD-Core Version:    0.7.0.1
 */
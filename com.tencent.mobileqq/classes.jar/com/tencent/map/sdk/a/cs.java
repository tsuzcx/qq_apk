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
      boolean bool = dg.a(((ch)localObject2).b);
      if ((!bool) && (a))
      {
        paramcf.a.put("needUpdateState", Integer.valueOf(0));
      }
      else
      {
        paramcf.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
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
      if (de.c)
      {
        if (!b)
        {
          b = true;
          return;
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
      }
      return;
    }
    catch (Exception paramcf) {}
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
        dc.a("");
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
      str2 = dc.a();
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals(str2))) {
        dc.a(str1);
      }
    }
    else
    {
      dc.a("");
    }
    paramJSONObject = paramJSONObject.optString("oper");
    if (!TextUtils.isEmpty(paramJSONObject)) {
      cd.a().a(ao.b(), paramJSONObject);
    }
  }
  
  public final String c()
  {
    return "state";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.cs
 * JD-Core Version:    0.7.0.1
 */
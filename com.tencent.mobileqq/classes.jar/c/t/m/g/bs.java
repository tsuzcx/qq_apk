package c.t.m.g;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bs
  extends bk
{
  private static boolean a = false;
  
  public final void a(bg parambg)
  {
    Object localObject3 = new bj();
    Object localObject2 = new bi();
    Object localObject1 = new bh();
    try
    {
      if ((ch.a(((bi)localObject2).b)) || (!a))
      {
        parambg.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
      for (;;)
      {
        if (ch.a(((bi)localObject2).b))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("model", ((bj)localObject3).a);
          localJSONObject.put("osVersion", ((bj)localObject3).b);
          localJSONObject.put("imei", ((bj)localObject3).c);
          localJSONObject.put("imsi", ((bj)localObject3).d);
          localJSONObject.put("pseudoId", ((bj)localObject3).e);
          parambg.a.put("RegistDeviceInfo", localJSONObject);
        }
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("platform", ((bi)localObject2).a);
        ((JSONObject)localObject3).put("deviceId", ((bi)localObject2).b);
        ((JSONObject)localObject3).put("sdkVersion", ((bi)localObject2).c);
        parambg.a.put("BindDeviceInfo", localObject3);
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("bundle", ((bh)localObject1).a);
        ((JSONObject)localObject2).put("verCode", ((bh)localObject1).b);
        ((JSONObject)localObject2).put("verName", ((bh)localObject1).c);
        ((JSONObject)localObject2).put("appId", ((bh)localObject1).e);
        ((JSONObject)localObject2).put("uuid", ((bh)localObject1).d);
        localObject1 = new JSONArray();
        ((JSONArray)localObject1).put(localObject2);
        parambg.a.put("AppState", localObject1);
        localObject1 = cc.a(o.g());
        parambg.a.put("netType", localObject1);
        localObject1 = be.a(o.j().intValue());
        parambg.a.put("oper", localObject1);
        return;
        parambg.a.put("needUpdateState", Integer.valueOf(0));
      }
      return;
    }
    catch (Exception parambg) {}
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
            cc.a("");
            return;
          }
        }
        catch (Throwable localThrowable) {}
      }
      String str2 = paramJSONObject.optString("deviceId");
      if (!TextUtils.isEmpty(str2))
      {
        String str3 = cc.a();
        if ((!TextUtils.isEmpty(str2)) && (!str2.equals(str3))) {
          cc.a(str2);
        }
      }
      for (;;)
      {
        paramJSONObject = paramJSONObject.optString("oper");
        if (TextUtils.isEmpty(paramJSONObject)) {
          break;
        }
        be.a().a(o.b(), paramJSONObject);
        return;
        cc.a("");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.bs
 * JD-Core Version:    0.7.0.1
 */
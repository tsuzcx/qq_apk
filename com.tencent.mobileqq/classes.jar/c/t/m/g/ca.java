package c.t.m.g;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ca
  extends br
{
  private static boolean a = false;
  
  public final void a(bn parambn)
  {
    Object localObject3 = new bq();
    Object localObject2 = new bp();
    Object localObject1 = new bo();
    try
    {
      boolean bool = cn.a(((bp)localObject2).b);
      if ((!bool) && (a))
      {
        parambn.a.put("needUpdateState", Integer.valueOf(0));
      }
      else
      {
        parambn.a.put("needUpdateState", Integer.valueOf(1));
        a = true;
      }
      if (cn.a(((bp)localObject2).b))
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("model", ((bq)localObject3).a);
        localJSONObject.put("osVersion", ((bq)localObject3).b);
        localJSONObject.put("imei", ((bq)localObject3).c);
        localJSONObject.put("imsi", ((bq)localObject3).d);
        localJSONObject.put("pseudoId", ((bq)localObject3).e);
        parambn.a.put("RegistDeviceInfo", localJSONObject);
      }
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("platform", ((bp)localObject2).a);
      ((JSONObject)localObject3).put("deviceId", ((bp)localObject2).b);
      ((JSONObject)localObject3).put("sdkVersion", ((bp)localObject2).c);
      parambn.a.put("BindDeviceInfo", localObject3);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("bundle", ((bo)localObject1).a);
      ((JSONObject)localObject2).put("verCode", ((bo)localObject1).b);
      ((JSONObject)localObject2).put("verName", ((bo)localObject1).c);
      ((JSONObject)localObject2).put("appId", ((bo)localObject1).e);
      ((JSONObject)localObject2).put("uuid", ((bo)localObject1).d);
      localObject1 = new JSONArray();
      ((JSONArray)localObject1).put(localObject2);
      parambn.a.put("AppState", localObject1);
      localObject1 = ck.a(x.g());
      parambn.a.put("netType", localObject1);
      localObject1 = bl.a(x.j().intValue());
      parambn.a.put("oper", localObject1);
      return;
    }
    catch (Exception parambn) {}
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
        ck.a("");
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
      str2 = ck.a();
      if ((!TextUtils.isEmpty(str1)) && (!str1.equals(str2))) {
        ck.a(str1);
      }
    }
    else
    {
      ck.a("");
    }
    paramJSONObject = paramJSONObject.optString("oper");
    if (!TextUtils.isEmpty(paramJSONObject)) {
      bl.a().a(x.b(), paramJSONObject);
    }
  }
  
  public final String c()
  {
    return "state";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ca
 * JD-Core Version:    0.7.0.1
 */
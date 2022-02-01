package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j0
  implements m0
{
  public Context a = b.f();
  public String b;
  public JSONObject c;
  public String d;
  public String e;
  public String f;
  public String g;
  public Boolean h;
  
  public j0(String paramString1, JSONObject paramJSONObject, String paramString2, String paramString3, long paramLong)
  {
    this.b = paramString1;
    this.c = paramJSONObject;
    this.d = paramString2;
    this.e = paramString3;
    this.f = String.valueOf(paramLong);
    if (a.i(paramString2, "oper"))
    {
      paramString1 = e0.a().a(paramString2, paramLong);
      this.g = paramString1.a();
      this.h = Boolean.valueOf(paramString1.b());
    }
  }
  
  public void run()
  {
    y.c("hmsSdk", "Begin to run EventRecordTask...");
    int i = b.e();
    int j = c.k(this.d, this.e);
    if (p0.a(this.a, "stat_v2_1", i * 1048576))
    {
      y.c("hmsSdk", "stat sp file reach max limited size, discard new event");
      h0.a().a("", "alltype");
      return;
    }
    Object localObject2 = new q();
    ((q)localObject2).b(this.b);
    ((q)localObject2).a(this.c.toString());
    ((q)localObject2).d(this.e);
    ((q)localObject2).c(this.f);
    ((q)localObject2).f(this.g);
    Object localObject1 = this.h;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = String.valueOf(localObject1);
    }
    ((q)localObject2).e((String)localObject1);
    try
    {
      localObject2 = ((q)localObject2).d();
      str = s0.a(this.d, this.e);
      localObject1 = g0.a(this.a, "stat_v2_1", str, "");
    }
    catch (JSONException localJSONException1)
    {
      String str;
      label203:
      break label270;
    }
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject1 = new JSONArray((String)localObject1);
      } else {
        localObject1 = new JSONArray();
      }
    }
    catch (JSONException localJSONException2)
    {
      break label203;
    }
    y.d("hmsSdk", "Cached data corrupted: stat_v2_1");
    localObject1 = new JSONArray();
    ((JSONArray)localObject1).put(localObject2);
    g0.b(this.a, "stat_v2_1", str, ((JSONArray)localObject1).toString());
    if (((JSONArray)localObject1).toString().length() > j * 1024) {
      h0.a().a(this.d, this.e);
    }
    return;
    label270:
    y.e("hmsSdk", "eventRecord toJson error! The record failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.j0
 * JD-Core Version:    0.7.0.1
 */
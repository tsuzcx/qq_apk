package com.tencent.map.sdk.a;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class jg
{
  public long a = 0L;
  public long b = 0L;
  public jg.d c = new jg.d();
  public jg.f d;
  
  protected static jg a(JSONObject paramJSONObject)
  {
    Object localObject2 = null;
    if (paramJSONObject == null) {
      return null;
    }
    jg localjg = new jg();
    localjg.a = paramJSONObject.optLong("create");
    localjg.b = paramJSONObject.optLong("destroy");
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("mapLoad");
    if (localJSONObject1 == null)
    {
      localObject1 = null;
    }
    else
    {
      jg.d locald = new jg.d();
      locald.a = localJSONObject1.optBoolean("loadSuccess");
      locald.b = localJSONObject1.optLong("loadSuccessTime");
      locald.c = localJSONObject1.optLong("firstLoadTime");
      Object localObject3 = localJSONObject1.optJSONObject("configUpdate");
      if (localObject3 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = new jg.b();
        ((jg.b)localObject1).a = ((JSONObject)localObject3).optBoolean("success");
        ((jg.b)localObject1).b = ((JSONObject)localObject3).optLong("loadBeginTime");
      }
      locald.d = ((jg.b)localObject1);
      localObject3 = localJSONObject1.optJSONArray("tileErrors");
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0))
      {
        locald.e = new CopyOnWriteArraySet();
        int i = 0;
        while (i < ((JSONArray)localObject3).length())
        {
          JSONObject localJSONObject2 = ((JSONArray)localObject3).optJSONObject(i);
          if (localJSONObject2 == null)
          {
            localObject1 = null;
          }
          else
          {
            localObject1 = new jg.g();
            ((jg.g)localObject1).a = localJSONObject2.optLong("time");
            ((jg.g)localObject1).b = localJSONObject2.optString("tid");
            ((jg.g)localObject1).c = localJSONObject2.optInt("netError");
          }
          if (localObject1 != null) {
            locald.e.add(localObject1);
          }
          i += 1;
        }
      }
      locald.f = jg.a.a(localJSONObject1.optJSONObject("configError"));
      localObject1 = locald;
    }
    localjg.c = ((jg.d)localObject1);
    Object localObject1 = paramJSONObject.optJSONObject("oversea");
    if (localObject1 == null)
    {
      paramJSONObject = localObject2;
    }
    else
    {
      paramJSONObject = new jg.f();
      paramJSONObject.a = ((JSONObject)localObject1).optInt("wtc");
    }
    localjg.d = paramJSONObject;
    return localjg;
  }
  
  protected final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("create", this.a);
      localJSONObject.put("destroy", this.b);
      if (this.c != null) {
        localJSONObject.put("mapLoad", this.c.a());
      }
      if (this.d != null) {
        localJSONObject.put("oversea", this.d.a());
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public final void a(long paramLong, String paramString)
  {
    if (this.c.f == null) {
      this.c.f = new jg.a();
    }
    if (this.c.f.b == null) {
      this.c.f.b = new CopyOnWriteArraySet();
    }
    if (this.c.f.b.size() > 9) {
      return;
    }
    jg.e locale = new jg.e();
    locale.b = (paramLong - this.a);
    locale.a = paramString;
    this.c.f.b.add(locale);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.a = paramBoolean;
  }
  
  public final void a(boolean paramBoolean, long paramLong)
  {
    jg.b localb = new jg.b((byte)0);
    localb.a = paramBoolean;
    long l = this.a;
    if (paramLong - l > 0L) {
      localb.b = (paramLong - l);
    }
    this.c.d = localb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg
 * JD-Core Version:    0.7.0.1
 */
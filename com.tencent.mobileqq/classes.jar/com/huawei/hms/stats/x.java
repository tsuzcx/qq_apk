package com.huawei.hms.stats;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class x
  implements y
{
  private List<w> a;
  private u b;
  private v c;
  private y d;
  private String e = "";
  private String f;
  
  public x(String paramString)
  {
    this.f = paramString;
  }
  
  public void a(bl parambl)
  {
    this.d = parambl;
  }
  
  public void a(u paramu)
  {
    this.b = paramu;
  }
  
  public void a(v paramv)
  {
    this.c = paramv;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.e = paramString;
    }
  }
  
  public void a(List<w> paramList)
  {
    this.a = paramList;
  }
  
  public JSONObject c()
  {
    if ((this.a == null) || (this.a.size() == 0))
    {
      af.c("EventUploadModel", "Not have actionEvent to send");
      return null;
    }
    if ((this.b == null) || (this.c == null) || (this.d == null))
    {
      af.c("EventUploadModel", "model in wrong format");
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("header", this.b.c());
    Object localObject1 = new JSONObject();
    Object localObject2 = this.d.c();
    ((JSONObject)localObject2).put("properties", this.c.c());
    try
    {
      ((JSONObject)localObject2).put("events_global_properties", new JSONObject(this.e));
      ((JSONObject)localObject1).put("events_common", localObject2);
      localObject2 = new JSONArray();
      Iterator localIterator = this.a.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label223;
        }
        JSONObject localJSONObject2 = ((w)localIterator.next()).c();
        if (localJSONObject2 == null) {
          break;
        }
        ((JSONArray)localObject2).put(localJSONObject2);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ((JSONObject)localObject2).put("events_global_properties", this.e);
        continue;
        af.c("EventUploadModel", "custom event is empty,delete this event");
      }
      label223:
      ((JSONObject)localObject1).put("events", localObject2);
      localObject1 = ((JSONObject)localObject1).toString();
      try
      {
        localObject1 = ba.a(((String)localObject1).getBytes("UTF-8"));
        localObject1 = e.a().a(e.a.a).a(this.f, (byte[])localObject1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          af.c("EventUploadModel", "eventInfo encrypt failed,report over!");
          return null;
        }
        localJSONObject1.put("event", localObject1);
        return localJSONObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        af.c("EventUploadModel", "getBitZip(): Unsupported coding : utf-8");
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.x
 * JD-Core Version:    0.7.0.1
 */
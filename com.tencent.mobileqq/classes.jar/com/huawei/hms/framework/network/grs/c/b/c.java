package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
{
  private GrsBaseInfo a;
  private Context b;
  private Set<String> c = new HashSet();
  
  public c(GrsBaseInfo paramGrsBaseInfo, Context paramContext)
  {
    this.a = paramGrsBaseInfo;
    this.b = paramContext;
  }
  
  private String e()
  {
    Object localObject = b.a(this.b.getPackageName(), this.a).b();
    if (((Set)localObject).isEmpty()) {
      return "";
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localJSONArray.put((String)((Iterator)localObject).next());
    }
    try
    {
      localJSONObject.put("services", localJSONArray);
      Logger.i("GrsRequestInfo", "post service list is:%s", new Object[] { localJSONObject.toString() });
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException) {}
    return "";
  }
  
  private String f()
  {
    Logger.v("GrsRequestInfo", "getGeoipService enter");
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((String)localIterator.next());
    }
    try
    {
      localJSONObject.put("services", localJSONArray);
      Logger.v("GrsRequestInfo", "post query service list is:%s", new Object[] { localJSONObject.toString() });
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      label90:
      break label90;
    }
    return "";
  }
  
  public Context a()
  {
    return this.b;
  }
  
  public void a(String paramString)
  {
    this.c.add(paramString);
  }
  
  public GrsBaseInfo b()
  {
    return this.a;
  }
  
  public String c()
  {
    if (this.c.size() == 0) {
      return e();
    }
    return f();
  }
  
  public Set<String> d()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b.c
 * JD-Core Version:    0.7.0.1
 */
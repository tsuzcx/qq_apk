package com.tencent.luggage.wxa.jg;

import android.graphics.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class e
{
  private Map<String, a> a = new HashMap();
  
  public e()
  {
    a(new h());
    a(new f());
    a(new g());
    a(new i());
    a(new d());
    a(new b());
    a(new c());
    a(new j());
  }
  
  public static e a()
  {
    return e.a.a;
  }
  
  private void a(a parama)
  {
    if (parama == null) {
      return;
    }
    this.a.put(parama.a(), parama);
  }
  
  private boolean a(Path paramPath, com.tencent.luggage.wxa.jd.a parama)
  {
    Object localObject = parama.a;
    localObject = (a)this.a.get(localObject);
    if (localObject == null) {
      return false;
    }
    return ((a)localObject).a(paramPath, parama);
  }
  
  private boolean a(Path paramPath, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("method");
    paramJSONObject = paramJSONObject.optJSONArray("data");
    localObject = (a)this.a.get(localObject);
    if (localObject == null) {
      return false;
    }
    return ((a)localObject).a(paramPath, paramJSONObject);
  }
  
  public Path a(com.tencent.luggage.wxa.jd.c paramc)
  {
    Path localPath = new Path();
    paramc = paramc.b;
    if (paramc != null)
    {
      if (paramc.size() == 0) {
        return localPath;
      }
      paramc = paramc.iterator();
      while (paramc.hasNext())
      {
        com.tencent.luggage.wxa.jd.a locala = (com.tencent.luggage.wxa.jd.a)paramc.next();
        if (locala != null) {
          a(localPath, locala);
        }
      }
    }
    return localPath;
  }
  
  public Path a(JSONArray paramJSONArray)
  {
    Path localPath = new Path();
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return localPath;
      }
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          a(localPath, localJSONObject);
        }
        i += 1;
      }
    }
    return localPath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jg.e
 * JD-Core Version:    0.7.0.1
 */
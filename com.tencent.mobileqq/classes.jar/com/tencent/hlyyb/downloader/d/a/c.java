package com.tencent.hlyyb.downloader.d.a;

import com.tencent.hlyyb.common.b.b;
import com.tencent.hlyyb.downloader.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  public boolean a;
  public long b;
  public String c;
  public String d;
  public String e;
  public List<a> f;
  public List<String> g;
  private String h;
  private List<d> i;
  
  public c(JSONObject paramJSONObject, String paramString)
  {
    a(paramJSONObject, paramString);
  }
  
  private void a(JSONObject paramJSONObject, String paramString)
  {
    this.a = false;
    for (;;)
    {
      Object localObject2;
      try
      {
        paramJSONObject.optString("ipinfo");
        paramJSONObject = new JSONObject(paramJSONObject.optString("resultmap"));
        Iterator localIterator = paramJSONObject.keys();
        continue;
        if (!localIterator.hasNext()) {
          break;
        }
        this.h = ((String)localIterator.next());
        if (!this.h.equals(paramString)) {
          continue;
        }
        Object localObject1 = paramJSONObject.optJSONObject(this.h);
        ((JSONObject)localObject1).optInt("code");
        this.b = ((JSONObject)localObject1).optLong("size");
        this.c = ((JSONObject)localObject1).optString("md5");
        this.d = ((JSONObject)localObject1).optString("schedulecode");
        this.e = ((JSONObject)localObject1).optString("featuresmd5");
        localObject2 = ((JSONObject)localObject1).optJSONArray("reselements");
        this.i = new ArrayList();
        int j;
        Object localObject4;
        Object localObject3;
        if (localObject2 != null)
        {
          int m = ((JSONArray)localObject2).length();
          j = 0;
          if (j < m)
          {
            localObject4 = ((JSONArray)localObject2).getJSONObject(j);
            localObject3 = new d(this);
            d.a((d)localObject3, ((JSONObject)localObject4).optInt("type"));
            d.a((d)localObject3, ((JSONObject)localObject4).optString("realurl"));
            localObject4 = ((JSONObject)localObject4).optJSONArray("iplist");
            d.a((d)localObject3, new ArrayList());
            if (localObject4 != null)
            {
              int k = 0;
              if (k < ((JSONArray)localObject4).length())
              {
                String str = (String)((JSONArray)localObject4).get(k);
                d.a((d)localObject3).add(str);
                k += 1;
                continue;
              }
            }
            this.i.add(localObject3);
            j += 1;
            continue;
          }
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("features");
        if (localObject1 != null)
        {
          this.f = new ArrayList();
          j = 0;
          if (j < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(j);
            localObject2 = new a(((JSONObject)localObject2).optLong("offset"), ((JSONObject)localObject2).optInt("length"));
            this.f.add(localObject2);
            j += 1;
            continue;
          }
        }
        this.g = new ArrayList();
        localObject1 = this.i.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (d)((Iterator)localObject1).next();
        if (d.b((d)localObject2) == 0)
        {
          this.g.add(d.c((d)localObject2));
          localObject3 = d.a((d)localObject2).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (String)((Iterator)localObject3).next();
            this.g.add(b.a(d.c((d)localObject2), (String)localObject4));
            continue;
          }
          continue;
        }
        if (d.b((d)localObject2) != 1) {
          continue;
        }
      }
      catch (Exception paramJSONObject)
      {
        this.a = false;
        paramJSONObject.printStackTrace();
        return;
      }
      this.g.add(d.c((d)localObject2));
    }
    this.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.d.a.c
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.hms.hatool;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class l0
  implements m0
{
  public String a;
  public String b;
  public String c;
  public List<q> d;
  
  public l0(List<q> paramList, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramList;
  }
  
  public final void a()
  {
    String str = s0.a(this.a, this.c, this.b);
    g0.a(b.f(), "backup_event", new String[] { str });
  }
  
  public void run()
  {
    Object localObject1 = this.d;
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      int i = b.h();
      if (p0.a(b.f(), "cached_v2_1", i * 1048576))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("The cacheFile is full,Can not writing data! reqID:");
        ((StringBuilder)localObject1).append(this.b);
        y.e("hmsSdk", ((StringBuilder)localObject1).toString());
        return;
      }
      localObject1 = s0.a(this.a, this.c);
      Object localObject2 = (List)w.b(b.f(), "cached_v2_1", (String)localObject1).get(localObject1);
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        this.d.addAll((Collection)localObject2);
      }
      localObject2 = new JSONArray();
      Object localObject3 = this.d.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        q localq = (q)((Iterator)localObject3).next();
        try
        {
          ((JSONArray)localObject2).put(localq.d());
        }
        catch (JSONException localJSONException)
        {
          label183:
          break label183;
        }
        y.e("hmsSdk", "event to json error");
      }
      localObject2 = ((JSONArray)localObject2).toString();
      i = b.e();
      if (((String)localObject2).length() > i * 1048576)
      {
        y.e("hmsSdk", "this failed data is too long,can not writing it");
        this.d = null;
        return;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("data send failed, write to cache file...reqID:");
      ((StringBuilder)localObject3).append(this.b);
      y.d("hmsSdk", ((StringBuilder)localObject3).toString());
      g0.b(b.f(), "cached_v2_1", (String)localObject1, (String)localObject2);
      a();
      return;
    }
    y.d("hmsSdk", "failed events is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.l0
 * JD-Core Version:    0.7.0.1
 */
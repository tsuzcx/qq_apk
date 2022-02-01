package com.huawei.hms.stats;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class au
  implements av
{
  private String a;
  private String b;
  private String c;
  private List<w> d;
  
  public au(List<w> paramList, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramList;
  }
  
  private void a()
  {
    String str = bb.a(this.a, this.c, this.b);
    ap.a(b.j(), "backup_event", new String[] { str });
  }
  
  public void run()
  {
    if ((this.d == null) || (this.d.size() == 0))
    {
      af.b("FailedEventHandlerTask", "failed events is empty");
      return;
    }
    int i = b.i();
    if (ay.a(b.j(), "cached_v2_1", i * 1048576))
    {
      af.c("FailedEventHandlerTask", "The cacheFile is full,Can not writing data! reqID:" + this.b);
      return;
    }
    String str = bb.a(this.a, this.c);
    Object localObject = (List)ad.b(b.j(), "cached_v2_1", str).get(str);
    if ((localObject != null) && (((List)localObject).size() != 0)) {
      this.d.addAll((Collection)localObject);
    }
    localObject = new JSONArray();
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext())
    {
      w localw = (w)localIterator.next();
      try
      {
        ((JSONArray)localObject).put(localw.d());
      }
      catch (JSONException localJSONException)
      {
        af.c("FailedEventHandlerTask", "event to json error");
      }
    }
    localObject = ((JSONArray)localObject).toString();
    i = b.h();
    if (((String)localObject).length() > i * 1048576)
    {
      af.c("FailedEventHandlerTask", "this failed data is too long,can not writing it");
      this.d = null;
      return;
    }
    af.b("FailedEventHandlerTask", "data send failed, write to cache file...reqID:" + this.b);
    ap.a(b.j(), "cached_v2_1", str, (String)localObject);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.au
 * JD-Core Version:    0.7.0.1
 */
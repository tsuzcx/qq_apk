package com.huawei.hms.stats;

import android.content.Context;
import android.util.Pair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class at
  implements av
{
  private Context a = b.j();
  private String b;
  private String c;
  private String d;
  
  public at(String paramString1, String paramString2, String paramString3)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  private void a(String paramString, List<w> paramList)
  {
    paramString = bb.a(paramString);
    new aa(paramList, (String)paramString.first, (String)paramString.second, this.d).a();
  }
  
  public void run()
  {
    af.b("EventReportTask", "eventReportTask is running");
    boolean bool = ay.a(this.a);
    if (bool)
    {
      af.b("EventReportTask", "workKey is refresh,begin report all data");
      this.c = "alltype";
    }
    Object localObject = ad.a(this.a, this.b, this.c);
    if (((Map)localObject).size() == 0) {
      af.a("EventReportTask", "no have events to report: tag:%s : type:%s", new Object[] { this.b, this.c });
    }
    for (;;)
    {
      return;
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        a((String)localEntry.getKey(), (List)localEntry.getValue());
      }
      if ("alltype".equals(this.c))
      {
        ap.a(this.a, "stat_v2_1", new String[0]);
        ap.a(this.a, "cached_v2_1", new String[0]);
      }
      while (bool)
      {
        af.b("EventReportTask", "refresh local key");
        am.a().b();
        localObject = z.a().b();
        z.a().a((String)localObject);
        return;
        localObject = bb.a(this.b, this.c);
        ap.a(this.a, "stat_v2_1", new String[] { localObject });
        ap.a(this.a, "cached_v2_1", new String[] { localObject });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.at
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.hms.stats;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class aa
{
  private List<w> a;
  private String b;
  private String c;
  private String d;
  
  public aa(List<w> paramList, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramList;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
  }
  
  private void a(List<w> paramList, String paramString1, String paramString2)
  {
    if (paramList.isEmpty()) {
      return;
    }
    int j = paramList.size() / 500;
    int i = 0;
    label25:
    if (i < j + 1)
    {
      int k = i * 500;
      Object localObject = paramList.subList(k, Math.min(paramList.size(), k + 500));
      String str = UUID.randomUUID().toString().replace("-", "");
      long l1 = System.currentTimeMillis();
      long l2 = c.g(paramString2, paramString1);
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        w localw = (w)((Iterator)localObject).next();
        if (!ay.a(localw.b(), l1, l2 * 86400000L)) {
          localArrayList.add(localw);
        }
      }
      if (localArrayList.size() <= 0) {
        break label206;
      }
      new ab(paramString2, paramString1, this.d, localArrayList, str).a();
    }
    for (;;)
    {
      i += 1;
      break label25;
      break;
      label206:
      af.c("DataOrganizeHandler", "No data to report handler");
    }
  }
  
  public void a()
  {
    if ("_default_config_tag".equals(this.c))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        w localw = (w)localIterator.next();
        String str = localw.a();
        if ((TextUtils.isEmpty(str)) || ("oper".equals(str))) {
          localArrayList4.add(localw);
        } else if ("maint".equals(str)) {
          localArrayList1.add(localw);
        } else if ("preins".equals(str)) {
          localArrayList2.add(localw);
        } else if ("diffprivacy".equals(str)) {
          localArrayList3.add(localw);
        }
      }
      a(localArrayList4, "oper", "_default_config_tag");
      a(localArrayList1, "maint", "_default_config_tag");
      a(localArrayList2, "preins", "_default_config_tag");
      a(localArrayList3, "diffprivacy", "_default_config_tag");
      return;
    }
    a(this.a, this.c, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.aa
 * JD-Core Version:    0.7.0.1
 */
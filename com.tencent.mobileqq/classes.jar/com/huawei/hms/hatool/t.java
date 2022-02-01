package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class t
{
  public List<q> a;
  public String b;
  public String c;
  public String d;
  
  public t(List<q> paramList, String paramString1, String paramString2, String paramString3)
  {
    this.a = paramList;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramString3;
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
        q localq = (q)localIterator.next();
        String str = localq.c();
        if ((!TextUtils.isEmpty(str)) && (!"oper".equals(str)))
        {
          if ("maint".equals(str)) {
            localArrayList1.add(localq);
          } else if ("preins".equals(str)) {
            localArrayList2.add(localq);
          } else if ("diffprivacy".equals(str)) {
            localArrayList3.add(localq);
          }
        }
        else {
          localArrayList4.add(localq);
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
  
  public final void a(List<q> paramList, String paramString1, String paramString2)
  {
    if (paramList.isEmpty()) {
      return;
    }
    int j = paramList.size() / 500;
    int i = 0;
    while (i < j + 1)
    {
      int k = i * 500;
      Object localObject = paramList.subList(k, Math.min(paramList.size(), k + 500));
      String str = UUID.randomUUID().toString().replace("-", "");
      long l1 = System.currentTimeMillis();
      long l2 = c.b(paramString2, paramString1);
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        q localq = (q)((Iterator)localObject).next();
        if (!p0.a(localq.b(), l1, l2 * 86400000L)) {
          localArrayList.add(localq);
        }
      }
      if (localArrayList.size() > 0) {
        new u(paramString2, paramString1, this.d, localArrayList, str).a();
      } else {
        y.e("hmsSdk", "No data to report handler");
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.t
 * JD-Core Version:    0.7.0.1
 */
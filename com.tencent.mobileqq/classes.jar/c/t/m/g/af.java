package c.t.m.g;

import android.text.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class af
{
  private static v i = new v("direct_ip_black_list");
  public String a;
  private boolean b;
  private boolean c;
  private int d;
  private URL e;
  private String f;
  private int g;
  private r h;
  
  public af(URL paramURL, String paramString, r paramr)
  {
    if (v.a("direct_access_use_schedule", 0, 1, 1) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.b = bool1;
      bool1 = bool2;
      if (v.a("direct_https_use_sche", 0, 1, 1) == 1) {
        bool1 = true;
      }
      this.c = bool1;
      this.d = v.a("direct_access_domain_try_times", 1, 8, 2);
      this.a = "";
      this.e = paramURL;
      this.f = paramString;
      this.h = paramr;
      return;
    }
  }
  
  private List<m> a()
  {
    int k = 0;
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = null;
    if (this.h != null) {
      localObject1 = this.h.a(this.e.getHost());
    }
    if (localObject1 != null)
    {
      localObject2 = ((q)localObject1).c;
      this.a = ((q)localObject1).b;
      this.g = ((q)localObject1).d;
      if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
        localArrayList.addAll((Collection)localObject2);
      }
    }
    Object localObject2 = new m(this.f, -1);
    localObject1 = new ArrayList();
    if (localArrayList.size() == 0)
    {
      while (j < this.d)
      {
        ((List)localObject1).add(localObject2);
        j += 1;
      }
      ((m)localObject2).c = 5;
      return localObject1;
    }
    if ((this.a != null) && (this.a.contains("bott")))
    {
      ((List)localObject1).add(localObject2);
      ((m)localObject2).c = 7;
      a(localArrayList, (List)localObject1);
    }
    while (((List)localObject1).size() <= 1)
    {
      localObject1 = new ArrayList();
      j = k;
      for (;;)
      {
        if (j < this.d)
        {
          ((List)localObject1).add(localObject2);
          j += 1;
          continue;
          a(localArrayList, (List)localObject1);
          ((List)localObject1).add(localObject2);
          ((m)localObject2).c = 6;
          break;
        }
      }
      ((m)localObject2).c = 9;
    }
    for (;;)
    {
      return localObject1;
    }
  }
  
  private static void a(List<m> paramList1, List<m> paramList2)
  {
    for (;;)
    {
      try
      {
        List localList = i.b();
        paramList1 = paramList1.iterator();
        if (paramList1.hasNext())
        {
          m localm = (m)paramList1.next();
          Iterator localIterator = localList.iterator();
          if (localIterator.hasNext())
          {
            if (!localm.a((m)localIterator.next())) {
              continue;
            }
            j = 1;
            if (j != 0) {
              continue;
            }
            paramList2.add(localm);
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      int j = 0;
    }
  }
  
  public static void b(m paramm)
  {
    i.a(paramm);
  }
  
  public static void c(m paramm)
  {
    i.b(paramm);
  }
  
  public final String a(m paramm)
  {
    Object localObject;
    if (paramm.b == -1)
    {
      localObject = paramm.a;
      return localObject;
    }
    label62:
    String str;
    if (!this.e.getProtocol().startsWith("https"))
    {
      localObject = "http://" + paramm.a + ":" + paramm.b;
      str = this.e.getFile();
      paramm = (m)localObject;
      if (!TextUtils.isEmpty(str)) {
        if (!str.startsWith("/")) {
          break label218;
        }
      }
    }
    label218:
    for (paramm = (String)localObject + str;; paramm = (String)localObject + "/" + str)
    {
      str = this.e.getRef();
      localObject = paramm;
      if (TextUtils.isEmpty(str)) {
        break;
      }
      return paramm + "#" + str;
      if (this.g != 0)
      {
        localObject = "https://" + paramm.a + ":" + this.g;
        break label62;
      }
      localObject = "https://" + paramm.a + ":443";
      break label62;
    }
  }
  
  public final List<m> a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    m localm = new m(this.f, -1);
    for (;;)
    {
      try
      {
        Object localObject = new ArrayList();
        if (!paramBoolean1)
        {
          ((List)localObject).add(localm);
          localm.c = 1;
          return localObject;
        }
        if ((!o.i()) && (this.b)) {
          if ((paramBoolean2) && (!this.c))
          {
            break label188;
            if (j < this.d)
            {
              ((List)localObject).add(localm);
              j += 1;
              continue;
            }
            if (o.i())
            {
              j = 2;
              localm.c = j;
              return localObject;
            }
            if (this.b) {
              break label193;
            }
            j = 3;
            continue;
          }
          else
          {
            localObject = a();
            return localObject;
          }
        }
      }
      catch (Exception localException)
      {
        ArrayList localArrayList = new ArrayList();
        j = k;
        if (j < this.d)
        {
          localArrayList.add(localm);
          j += 1;
          continue;
        }
        localm.c = 8;
        return localArrayList;
      }
      label188:
      int j = 0;
      continue;
      label193:
      j = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.af
 * JD-Core Version:    0.7.0.1
 */
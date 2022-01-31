package c.t.m.g;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class p
{
  public static String a;
  private static String b = "AccessIpMgr";
  private static Map<String, a> c = new ConcurrentHashMap();
  private static x.a d = new x.a();
  
  static
  {
    new ConcurrentHashMap();
  }
  
  public static v a(String paramString)
  {
    Object localObject = (a)c.get(paramString);
    if (localObject != null)
    {
      paramString = new v(((a)localObject).a, ((a)localObject).b);
      paramString.c = ((a)localObject).a();
      return paramString;
    }
    localObject = new n(paramString);
    ((n)localObject).e = 3;
    paramString = new v(paramString, "");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localObject);
    paramString.c = localArrayList;
    return paramString;
  }
  
  public static void a()
  {
    m.j().post(new t());
  }
  
  public static void a(String paramString, n paramn, int paramInt)
  {
    paramString = (a)c.get(paramString);
    if ((paramString != null) && (paramInt != 0)) {
      paramString.b(paramn);
    }
  }
  
  public static void b()
  {
    cg.d().f();
  }
  
  public static void c()
  {
    Object localObject1 = cg.d().f().a();
    if (localObject1 != null)
    {
      c.clear();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        v localv = (v)((Iterator)localObject1).next();
        a locala = new a(a);
        locala.a = localv.a;
        locala.b = localv.b;
        Object localObject2 = localv.c.iterator();
        while (((Iterator)localObject2).hasNext()) {
          locala.a((n)((Iterator)localObject2).next());
        }
        localObject2 = new n(localv.a);
        ((n)localObject2).e = 3;
        locala.a((n)localObject2);
        c.put(localv.a, locala);
      }
    }
  }
  
  static final class a
  {
    String a;
    String b;
    private String c;
    private List<n> d;
    private List<n> e;
    private List<n> f;
    private List<n> g;
    
    public a(String paramString)
    {
      this.c = paramString;
    }
    
    public final List<n> a()
    {
      ArrayList localArrayList = new ArrayList();
      List localList = this.d;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.e;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.f;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      localList = this.g;
      if ((localList != null) && (localList.size() > 0)) {
        localArrayList.addAll(localList);
      }
      return localArrayList;
    }
    
    public final void a(n paramn)
    {
      if (paramn == null) {
        return;
      }
      if (paramn.e == 1)
      {
        if (this.d == null) {
          this.d = new ArrayList();
        }
        this.d.add(paramn);
        return;
      }
      if (paramn.e == 2)
      {
        if (this.e == null) {
          this.e = new ArrayList();
        }
        this.e.add(paramn);
        return;
      }
      if (paramn.e == 3)
      {
        if (this.f == null) {
          this.f = new ArrayList();
        }
        this.f.add(paramn);
        return;
      }
      if (paramn.e == 4)
      {
        if (this.g == null) {
          this.g = new ArrayList();
        }
        this.g.add(paramn);
        return;
      }
      if (this.d == null) {
        this.d = new ArrayList();
      }
      this.d.add(paramn);
    }
    
    public final void b(n paramn)
    {
      if (paramn == null) {}
      for (;;)
      {
        return;
        try
        {
          if (paramn.e == 1)
          {
            if ((this.d == null) || (this.d.isEmpty()) || (!paramn.a((n)this.d.get(0)))) {
              continue;
            }
            this.d.remove(0);
            continue;
          }
        }
        finally {}
        if ((paramn.e == 2) && (this.e != null) && (!this.e.isEmpty()) && (paramn.a((n)this.e.get(0)))) {
          this.e.remove(0);
        }
      }
    }
    
    public final String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Appid：" + null + " domain：" + this.a + "\r\n");
      localStringBuilder.append("apn：" + this.c + " ckIP：" + null + "\r\n");
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        n localn = (n)localIterator.next();
        localStringBuilder.append("accessIP：" + localn.toString() + "\r\n");
      }
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.p
 * JD-Core Version:    0.7.0.1
 */
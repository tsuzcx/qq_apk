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
  private static Map<String, p.a> c = new ConcurrentHashMap();
  private static x.a d = new x.a();
  
  static
  {
    new ConcurrentHashMap();
  }
  
  public static v a(String paramString)
  {
    Object localObject = (p.a)c.get(paramString);
    if (localObject != null)
    {
      paramString = new v(((p.a)localObject).a, ((p.a)localObject).b);
      paramString.c = ((p.a)localObject).a();
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
    paramString = (p.a)c.get(paramString);
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
        p.a locala = new p.a(a);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.p
 * JD-Core Version:    0.7.0.1
 */
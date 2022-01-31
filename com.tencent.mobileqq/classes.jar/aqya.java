import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aqya
{
  public static ConcurrentHashMap<String, ArrayList<aqyd>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, aqyc> b = new ConcurrentHashMap();
  
  public static void a()
  {
    synchronized (a)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator2 = a.values().iterator();
      while (localIterator2.hasNext())
      {
        Iterator localIterator3 = ((ArrayList)localIterator2.next()).iterator();
        if (localIterator3.hasNext())
        {
          aqyd localaqyd = (aqyd)localIterator3.next();
          localaqyd.d();
          localHashSet.add(localaqyd.d);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((String)localIterator1.next());
    }
  }
  
  public static void a(aqyd paramaqyd)
  {
    synchronized (a)
    {
      String str = paramaqyd.a();
      ArrayList localArrayList = (ArrayList)a.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramaqyd);
        a.put(str, localArrayList);
      }
      while (localArrayList.contains(paramaqyd)) {
        return;
      }
      localArrayList.add(paramaqyd);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      aqyd localaqyd;
      do
      {
        Iterator localIterator = a.keySet().iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (String)localIterator.next();
          } while (!((String)localObject).endsWith("plugin"));
          localObject = ((ArrayList)a.get(localObject)).iterator();
        }
        localaqyd = (aqyd)((Iterator)localObject).next();
      } while (!((aqyb)localaqyd).a.equals(paramString));
      localaqyd.b();
      localaqyd.d();
    }
  }
  
  public static void b(String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (((String)localObject).startsWith(paramString))
        {
          localObject = ((ArrayList)a.get(localObject)).iterator();
          if (((Iterator)localObject).hasNext()) {
            ((aqyd)((Iterator)localObject).next()).d();
          }
        }
      }
    }
    c(paramString);
  }
  
  public static void c(String paramString)
  {
    synchronized (a)
    {
      aqyc localaqyc = (aqyc)b.get(paramString);
      if (localaqyc != null)
      {
        localaqyc.d();
        b.remove(paramString);
      }
      return;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (a)
    {
      paramString = (aqyc)b.get(paramString);
      if (paramString != null) {
        paramString.b();
      }
      return;
    }
  }
  
  public static void e(String paramString)
  {
    synchronized (a)
    {
      if ((aqyc)b.get(paramString) == null)
      {
        aqyc localaqyc = new aqyc(paramString);
        b.put(paramString, localaqyc);
        localaqyc.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqya
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aqdy
{
  public static ConcurrentHashMap<String, ArrayList<aqeb>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, aqea> b = new ConcurrentHashMap();
  
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
          aqeb localaqeb = (aqeb)localIterator3.next();
          localaqeb.d();
          localHashSet.add(localaqeb.d);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((String)localIterator1.next());
    }
  }
  
  public static void a(aqeb paramaqeb)
  {
    synchronized (a)
    {
      String str = paramaqeb.a();
      ArrayList localArrayList = (ArrayList)a.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramaqeb);
        a.put(str, localArrayList);
      }
      while (localArrayList.contains(paramaqeb)) {
        return;
      }
      localArrayList.add(paramaqeb);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      aqeb localaqeb;
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
        localaqeb = (aqeb)((Iterator)localObject).next();
      } while (!((aqdz)localaqeb).a.equals(paramString));
      localaqeb.b();
      localaqeb.d();
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
            ((aqeb)((Iterator)localObject).next()).d();
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
      aqea localaqea = (aqea)b.get(paramString);
      if (localaqea != null)
      {
        localaqea.d();
        b.remove(paramString);
      }
      return;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (a)
    {
      paramString = (aqea)b.get(paramString);
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
      if ((aqea)b.get(paramString) == null)
      {
        aqea localaqea = new aqea(paramString);
        b.put(paramString, localaqea);
        localaqea.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqdy
 * JD-Core Version:    0.7.0.1
 */
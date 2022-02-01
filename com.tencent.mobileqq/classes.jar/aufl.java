import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class aufl
{
  public static ConcurrentHashMap<String, ArrayList<aufo>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, aufn> b = new ConcurrentHashMap();
  
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
          aufo localaufo = (aufo)localIterator3.next();
          localaufo.d();
          localHashSet.add(localaufo.d);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((String)localIterator1.next());
    }
  }
  
  public static void a(aufo paramaufo)
  {
    synchronized (a)
    {
      String str = paramaufo.a();
      ArrayList localArrayList = (ArrayList)a.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramaufo);
        a.put(str, localArrayList);
      }
      while (localArrayList.contains(paramaufo)) {
        return;
      }
      localArrayList.add(paramaufo);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      aufo localaufo;
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
        localaufo = (aufo)((Iterator)localObject).next();
      } while (!((aufm)localaufo).a.equals(paramString));
      localaufo.b();
      localaufo.d();
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
            ((aufo)((Iterator)localObject).next()).d();
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
      aufn localaufn = (aufn)b.get(paramString);
      if (localaufn != null)
      {
        localaufn.d();
        b.remove(paramString);
      }
      return;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (a)
    {
      paramString = (aufn)b.get(paramString);
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
      if ((aufn)b.get(paramString) == null)
      {
        aufn localaufn = new aufn(paramString);
        b.put(paramString, localaufn);
        localaufn.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aufl
 * JD-Core Version:    0.7.0.1
 */
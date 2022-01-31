import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class asoq
{
  public static ConcurrentHashMap<String, ArrayList<asot>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, asos> b = new ConcurrentHashMap();
  
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
          asot localasot = (asot)localIterator3.next();
          localasot.d();
          localHashSet.add(localasot.d);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((String)localIterator1.next());
    }
  }
  
  public static void a(asot paramasot)
  {
    synchronized (a)
    {
      String str = paramasot.a();
      ArrayList localArrayList = (ArrayList)a.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramasot);
        a.put(str, localArrayList);
      }
      while (localArrayList.contains(paramasot)) {
        return;
      }
      localArrayList.add(paramasot);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      asot localasot;
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
        localasot = (asot)((Iterator)localObject).next();
      } while (!((asor)localasot).a.equals(paramString));
      localasot.b();
      localasot.d();
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
            ((asot)((Iterator)localObject).next()).d();
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
      asos localasos = (asos)b.get(paramString);
      if (localasos != null)
      {
        localasos.d();
        b.remove(paramString);
      }
      return;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (a)
    {
      paramString = (asos)b.get(paramString);
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
      if ((asos)b.get(paramString) == null)
      {
        asos localasos = new asos(paramString);
        b.put(paramString, localasos);
        localasos.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     asoq
 * JD-Core Version:    0.7.0.1
 */
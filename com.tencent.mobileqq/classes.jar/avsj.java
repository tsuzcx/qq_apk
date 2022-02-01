import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class avsj
{
  public static ConcurrentHashMap<String, ArrayList<avsm>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, avsl> b = new ConcurrentHashMap();
  
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
          avsm localavsm = (avsm)localIterator3.next();
          localavsm.d();
          localHashSet.add(localavsm.d);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((String)localIterator1.next());
    }
  }
  
  public static void a(avsm paramavsm)
  {
    synchronized (a)
    {
      String str = paramavsm.a();
      ArrayList localArrayList = (ArrayList)a.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramavsm);
        a.put(str, localArrayList);
      }
      while (localArrayList.contains(paramavsm)) {
        return;
      }
      localArrayList.add(paramavsm);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      avsm localavsm;
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
        localavsm = (avsm)((Iterator)localObject).next();
      } while (!((avsk)localavsm).a.equals(paramString));
      localavsm.b();
      localavsm.d();
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
            ((avsm)((Iterator)localObject).next()).d();
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
      avsl localavsl = (avsl)b.get(paramString);
      if (localavsl != null)
      {
        localavsl.d();
        b.remove(paramString);
      }
      return;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (a)
    {
      paramString = (avsl)b.get(paramString);
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
      if ((avsl)b.get(paramString) == null)
      {
        avsl localavsl = new avsl(paramString);
        b.put(paramString, localavsl);
        localavsl.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     avsj
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class avlf
{
  public static ConcurrentHashMap<String, ArrayList<avli>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, avlh> b = new ConcurrentHashMap();
  
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
          avli localavli = (avli)localIterator3.next();
          localavli.d();
          localHashSet.add(localavli.d);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((String)localIterator1.next());
    }
  }
  
  public static void a(avli paramavli)
  {
    synchronized (a)
    {
      String str = paramavli.a();
      ArrayList localArrayList = (ArrayList)a.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramavli);
        a.put(str, localArrayList);
      }
      while (localArrayList.contains(paramavli)) {
        return;
      }
      localArrayList.add(paramavli);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      avli localavli;
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
        localavli = (avli)((Iterator)localObject).next();
      } while (!((avlg)localavli).a.equals(paramString));
      localavli.b();
      localavli.d();
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
            ((avli)((Iterator)localObject).next()).d();
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
      avlh localavlh = (avlh)b.get(paramString);
      if (localavlh != null)
      {
        localavlh.d();
        b.remove(paramString);
      }
      return;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (a)
    {
      paramString = (avlh)b.get(paramString);
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
      if ((avlh)b.get(paramString) == null)
      {
        avlh localavlh = new avlh(paramString);
        b.put(paramString, localavlh);
        localavlh.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     avlf
 * JD-Core Version:    0.7.0.1
 */
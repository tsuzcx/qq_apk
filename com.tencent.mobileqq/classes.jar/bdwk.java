import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class bdwk<E>
{
  private HashMap<String, CopyOnWriteArrayList<E>> a = new HashMap();
  
  public List<E> a(String paramString)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.a.get(paramString);
      paramString = localCopyOnWriteArrayList;
      if (localCopyOnWriteArrayList == null) {
        paramString = Collections.emptyList();
      }
      return paramString;
    }
    finally {}
  }
  
  public void a(String paramString, E paramE)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList2 = (CopyOnWriteArrayList)this.a.get(paramString);
      CopyOnWriteArrayList localCopyOnWriteArrayList1 = localCopyOnWriteArrayList2;
      if (localCopyOnWriteArrayList2 == null)
      {
        localCopyOnWriteArrayList1 = new CopyOnWriteArrayList();
        this.a.put(paramString, localCopyOnWriteArrayList1);
      }
      localCopyOnWriteArrayList1.add(paramE);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    try
    {
      paramString = (CopyOnWriteArrayList)this.a.get(paramString);
      if (paramString != null)
      {
        if (paramBoolean)
        {
          Iterator localIterator = paramString.iterator();
          while (localIterator.hasNext())
          {
            Object localObject1 = localIterator.next();
            Object localObject2 = ((WeakReference)localObject1).get();
            if ((localObject2 == null) || (localObject2 == paramObject)) {
              paramString.remove(localObject1);
            }
          }
        }
        paramString.remove(paramObject);
      }
    }
    finally {}
  }
  
  public List<E> b(String paramString)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = (CopyOnWriteArrayList)this.a.remove(paramString);
      paramString = localCopyOnWriteArrayList;
      if (localCopyOnWriteArrayList == null) {
        paramString = Collections.emptyList();
      }
      return paramString;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwk
 * JD-Core Version:    0.7.0.1
 */
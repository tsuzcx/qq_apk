import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bmbp
{
  private final HashSet<WeakReference<bmbq>> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final ConcurrentHashMap<Integer, HashSet<WeakReference<bmbq>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public void a(int paramInt, Object paramObject, Object... paramVarArgs)
  {
    Object localObject1 = new ArrayList();
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
    {
      HashSet localHashSet = (HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localHashSet != null) {
        ((ArrayList)localObject1).addAll(localHashSet);
      }
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      ((ArrayList)localObject1).addAll(this.jdField_a_of_type_JavaUtilHashSet);
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ??? = (bmbq)((WeakReference)((Iterator)localObject1).next()).get();
        if (??? != null)
        {
          ((bmbq)???).a(paramInt, paramObject, paramVarArgs);
          continue;
          paramObject = finally;
          throw paramObject;
        }
      }
    }
  }
  
  public void a(bmbq parambmbq)
  {
    if (parambmbq == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator;
    Object localObject2;
    Object localObject3;
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (WeakReference)localIterator.next();
        localObject3 = (bmbq)((WeakReference)localObject2).get();
        if ((localObject3 == null) || (parambmbq == localObject3)) {
          localArrayList.add(localObject2);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashSet.removeAll(localArrayList);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        int i = ((Integer)localIterator.next()).intValue();
        localObject2 = (HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
        localArrayList.clear();
        localObject3 = ((HashSet)localObject2).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          WeakReference localWeakReference = (WeakReference)((Iterator)localObject3).next();
          bmbq localbmbq = (bmbq)localWeakReference.get();
          if ((localbmbq != null) && (parambmbq != localbmbq)) {
            continue;
          }
          localArrayList.add(localWeakReference);
        }
      }
      ((HashSet)localObject2).removeAll(localArrayList);
    }
  }
  
  public void a(bmbq parambmbq, int... arg2)
  {
    if (parambmbq == null) {
      return;
    }
    a(parambmbq);
    parambmbq = new WeakReference(parambmbq);
    if ((??? == null) || (???.length == 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(parambmbq);
        return;
      }
    }
    for (;;)
    {
      int i;
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap)
      {
        int j = ???.length;
        i = 0;
        if (i < j)
        {
          int k = ???[i];
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(k)))
          {
            ((HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(k))).add(parambmbq);
          }
          else
          {
            HashSet localHashSet = new HashSet();
            localHashSet.add(parambmbq);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(k), localHashSet);
          }
        }
      }
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbp
 * JD-Core Version:    0.7.0.1
 */
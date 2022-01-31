import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bgqo
{
  private final HashSet<WeakReference<bgqp>> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final ConcurrentHashMap<Integer, HashSet<WeakReference<bgqp>>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
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
        ??? = (bgqp)((WeakReference)((Iterator)localObject1).next()).get();
        if (??? != null)
        {
          ((bgqp)???).a(paramInt, paramObject, paramVarArgs);
          continue;
          paramObject = finally;
          throw paramObject;
        }
      }
    }
  }
  
  public void a(bgqp parambgqp)
  {
    if (parambgqp == null) {
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
        localObject3 = (bgqp)((WeakReference)localObject2).get();
        if ((localObject3 == null) || (parambgqp == localObject3)) {
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
          bgqp localbgqp = (bgqp)localWeakReference.get();
          if ((localbgqp != null) && (parambgqp != localbgqp)) {
            continue;
          }
          localArrayList.add(localWeakReference);
        }
      }
      ((HashSet)localObject2).removeAll(localArrayList);
    }
  }
  
  public void a(bgqp parambgqp, int... arg2)
  {
    if (parambgqp == null) {
      return;
    }
    a(parambgqp);
    parambgqp = new WeakReference(parambgqp);
    if ((??? == null) || (???.length == 0)) {
      synchronized (this.jdField_a_of_type_JavaUtilHashSet)
      {
        this.jdField_a_of_type_JavaUtilHashSet.add(parambgqp);
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
            ((HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(k))).add(parambgqp);
          }
          else
          {
            HashSet localHashSet = new HashSet();
            localHashSet.add(parambgqp);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(k), localHashSet);
          }
        }
      }
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqo
 * JD-Core Version:    0.7.0.1
 */
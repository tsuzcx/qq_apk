import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bfbp<T, E>
{
  private bfbp<T, E>.bfbq<T> jdField_a_of_type_Bfbq;
  private List<E> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<bfbq, List<bfbr>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private void a()
  {
    Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    if (((List)localObject1).size() <= 0) {
      label21:
      return;
    } else {
      localObject1 = ((List)localObject1).iterator();
    }
    label182:
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label21;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (localObject2 == null) {
        break;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label182;
        }
        Object localObject3 = (Map.Entry)localIterator.next();
        Object localObject4 = (bfbq)((Map.Entry)localObject3).getKey();
        if (this.jdField_a_of_type_Bfbq == localObject4)
        {
          localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bfbr)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!localObject2.equals(bfbr.a((bfbr)localObject4)))) {
              break;
            }
            a(bfbr.b((bfbr)localObject4));
            this.jdField_a_of_type_JavaUtilList.remove(localObject2);
          }
        }
      }
    }
  }
  
  public bfbq a()
  {
    return this.jdField_a_of_type_Bfbq;
  }
  
  public void a(bfbq parambfbq)
  {
    if ((parambfbq == null) || (parambfbq == this.jdField_a_of_type_Bfbq)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(" change state from ");
    if (this.jdField_a_of_type_Bfbq != null) {}
    for (Object localObject = this.jdField_a_of_type_Bfbq.a;; localObject = "N/A")
    {
      betc.b("StateMachine", localObject + " to " + parambfbq.a);
      this.jdField_a_of_type_Bfbq = parambfbq;
      this.jdField_a_of_type_Bfbq.a();
      a();
      return;
    }
  }
  
  public void a(bfbp<T, E>.bfbr<E> parambfbp)
  {
    if ((parambfbp == null) || (bfbr.a(parambfbp) == null)) {
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(parambfbp.a());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(bfbr.a(parambfbp), localObject);
    }
    ((List)localObject).add(parambfbp);
  }
  
  public void a(E paramE)
  {
    if ((paramE == null) || (this.jdField_a_of_type_Bfbq == null)) {}
    label128:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label128;
        }
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (bfbq)((Map.Entry)localObject1).getKey();
        if (this.jdField_a_of_type_Bfbq == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bfbr)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(bfbr.a((bfbr)localObject2)))) {
              break;
            }
            a(bfbr.b((bfbr)localObject2));
          }
        }
      }
    }
  }
  
  public void b(E paramE)
  {
    if ((paramE == null) || (this.jdField_a_of_type_Bfbq == null)) {}
    label156:
    label157:
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (bfbq)((Map.Entry)localObject1).getKey();
        if (this.jdField_a_of_type_Bfbq != localObject2) {
          break label156;
        }
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bfbr)((Iterator)localObject1).next();
          if ((localObject2 != null) && (paramE.equals(bfbr.a((bfbr)localObject2))))
          {
            a(bfbr.b((bfbr)localObject2));
            i = 1;
          }
        }
      }
      for (;;)
      {
        break;
        if (i != 0) {
          break label157;
        }
        this.jdField_a_of_type_JavaUtilList.add(paramE);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfbp
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bduq<T, E>
{
  private bduq<T, E>.bdur<T> jdField_a_of_type_Bdur;
  private List<E> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<bdur, List<bdus>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
        Object localObject4 = (bdur)((Map.Entry)localObject3).getKey();
        if (this.jdField_a_of_type_Bdur == localObject4)
        {
          localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bdus)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!localObject2.equals(bdus.a((bdus)localObject4)))) {
              break;
            }
            a(bdus.b((bdus)localObject4));
            this.jdField_a_of_type_JavaUtilList.remove(localObject2);
          }
        }
      }
    }
  }
  
  public bdur a()
  {
    return this.jdField_a_of_type_Bdur;
  }
  
  public void a(bdur parambdur)
  {
    if ((parambdur == null) || (parambdur == this.jdField_a_of_type_Bdur)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(" change state from ");
    if (this.jdField_a_of_type_Bdur != null) {}
    for (Object localObject = this.jdField_a_of_type_Bdur.a;; localObject = "N/A")
    {
      bdnw.b("StateMachine", localObject + " to " + parambdur.a);
      this.jdField_a_of_type_Bdur = parambdur;
      this.jdField_a_of_type_Bdur.a();
      a();
      return;
    }
  }
  
  public void a(bduq<T, E>.bdus<E> parambduq)
  {
    if ((parambduq == null) || (bdus.a(parambduq) == null)) {
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(parambduq.a());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(bdus.a(parambduq), localObject);
    }
    ((List)localObject).add(parambduq);
  }
  
  public void a(E paramE)
  {
    if ((paramE == null) || (this.jdField_a_of_type_Bdur == null)) {}
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
        Object localObject2 = (bdur)((Map.Entry)localObject1).getKey();
        if (this.jdField_a_of_type_Bdur == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bdus)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(bdus.a((bdus)localObject2)))) {
              break;
            }
            a(bdus.b((bdus)localObject2));
          }
        }
      }
    }
  }
  
  public void b(E paramE)
  {
    if ((paramE == null) || (this.jdField_a_of_type_Bdur == null)) {}
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
        Object localObject2 = (bdur)((Map.Entry)localObject1).getKey();
        if (this.jdField_a_of_type_Bdur != localObject2) {
          break label156;
        }
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bdus)((Iterator)localObject1).next();
          if ((localObject2 != null) && (paramE.equals(bdus.a((bdus)localObject2))))
          {
            a(bdus.b((bdus)localObject2));
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
 * Qualified Name:     bduq
 * JD-Core Version:    0.7.0.1
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bfay<T, E>
{
  private bfay<T, E>.bfaz<T> jdField_a_of_type_Bfaz;
  private List<E> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<bfaz, List<bfba>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
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
        Object localObject4 = (bfaz)((Map.Entry)localObject3).getKey();
        if (this.jdField_a_of_type_Bfaz == localObject4)
        {
          localObject3 = ((List)((Map.Entry)localObject3).getValue()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (bfba)((Iterator)localObject3).next();
            if ((localObject4 == null) || (!localObject2.equals(bfba.a((bfba)localObject4)))) {
              break;
            }
            a(bfba.b((bfba)localObject4));
            this.jdField_a_of_type_JavaUtilList.remove(localObject2);
          }
        }
      }
    }
  }
  
  public bfaz a()
  {
    return this.jdField_a_of_type_Bfaz;
  }
  
  public void a(bfaz parambfaz)
  {
    if ((parambfaz == null) || (parambfaz == this.jdField_a_of_type_Bfaz)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(getClass().getSimpleName()).append(" change state from ");
    if (this.jdField_a_of_type_Bfaz != null) {}
    for (Object localObject = this.jdField_a_of_type_Bfaz.a;; localObject = "N/A")
    {
      besl.b("StateMachine", localObject + " to " + parambfaz.a);
      this.jdField_a_of_type_Bfaz = parambfaz;
      this.jdField_a_of_type_Bfaz.a();
      a();
      return;
    }
  }
  
  public void a(bfay<T, E>.bfba<E> parambfay)
  {
    if ((parambfay == null) || (bfba.a(parambfay) == null)) {
      return;
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(parambfay.a());
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilMap.put(bfba.a(parambfay), localObject);
    }
    ((List)localObject).add(parambfay);
  }
  
  public void a(E paramE)
  {
    if ((paramE == null) || (this.jdField_a_of_type_Bfaz == null)) {}
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
        Object localObject2 = (bfaz)((Map.Entry)localObject1).getKey();
        if (this.jdField_a_of_type_Bfaz == localObject2)
        {
          localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bfba)((Iterator)localObject1).next();
            if ((localObject2 == null) || (!paramE.equals(bfba.a((bfba)localObject2)))) {
              break;
            }
            a(bfba.b((bfba)localObject2));
          }
        }
      }
    }
  }
  
  public void b(E paramE)
  {
    if ((paramE == null) || (this.jdField_a_of_type_Bfaz == null)) {}
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
        Object localObject2 = (bfaz)((Map.Entry)localObject1).getKey();
        if (this.jdField_a_of_type_Bfaz != localObject2) {
          break label156;
        }
        localObject1 = ((List)((Map.Entry)localObject1).getValue()).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bfba)((Iterator)localObject1).next();
          if ((localObject2 != null) && (paramE.equals(bfba.a((bfba)localObject2))))
          {
            a(bfba.b((bfba)localObject2));
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
 * Qualified Name:     bfay
 * JD-Core Version:    0.7.0.1
 */
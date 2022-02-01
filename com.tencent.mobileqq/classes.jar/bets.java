import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.ArrayList;
import java.util.ArrayList<Lbetu;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bets
  extends betp
{
  private afsn jdField_a_of_type_Afsn;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ArrayList<betr> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Integer, ArrayList<betu>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  
  public bets(BaseChatPie paramBaseChatPie, afrc paramafrc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Afsn = ((afsn)paramafrc);
    d();
  }
  
  private betv a(betu parambetu)
  {
    if (!(parambetu instanceof betv)) {
      return null;
    }
    return (betv)parambetu;
  }
  
  private ArrayList<betu> a(int paramInt, ArrayList<betu> paramArrayList)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 2;
    }
    ArrayList localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
    Object localObject;
    if ((localArrayList == null) && (paramArrayList == null)) {
      localObject = null;
    }
    for (;;)
    {
      if ((localObject != null) && (((ArrayList)localObject).size() > 0)) {
        Collections.sort((List)localObject, new bett(this));
      }
      return localObject;
      if ((localArrayList == null) && (paramArrayList != null))
      {
        localObject = paramArrayList;
      }
      else
      {
        localObject = localArrayList;
        if (localArrayList != null)
        {
          localObject = localArrayList;
          if (paramArrayList != null)
          {
            localObject = new ArrayList();
            ((ArrayList)localObject).addAll(localArrayList);
            ((ArrayList)localObject).addAll(paramArrayList);
          }
        }
      }
    }
  }
  
  private void b(int paramInt, ArrayList<betu> paramArrayList)
  {
    Object localObject2;
    if (paramInt == 0)
    {
      localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<betu>)localObject2;
    }
    while ((localObject1 == null) || (paramArrayList == null))
    {
      return;
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (betu)((Iterator)localObject1).next();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (betu)localIterator.next();
        if (((betu)localObject2).c() == ((betu)localObject3).c())
        {
          localObject3 = a((betu)localObject2);
          if (localObject3 != null)
          {
            ((betv)localObject3).a(false);
            ((betv)localObject3).b(0);
          }
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new bevl(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
    this.jdField_a_of_type_JavaUtilArrayList.add(new bevf(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((betr)localIterator.next()).a();
    }
    e();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_Afsn = null;
  }
  
  public void a(int paramInt, ArrayList<betu> paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_Afsn == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramArrayList);
    b(paramInt, paramArrayList);
    if ((paramInt == 2) || (paramInt == 1))
    {
      paramArrayList = a(paramInt, paramArrayList);
      this.jdField_a_of_type_Afsn.a(paramInt, paramArrayList, paramBoolean);
      this.jdField_a_of_type_Afsn.a(0, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)), this.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Afsn.a(paramInt, paramArrayList, paramBoolean);
    this.jdField_a_of_type_Afsn.a(1, a(1, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))), false);
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      betr localbetr = (betr)localIterator.next();
      if (localbetr != null) {
        localbetr.a(paramObject);
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((betr)localIterator.next()).b();
    }
  }
  
  public void b(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      betr localbetr = (betr)localIterator.next();
      if (localbetr != null) {
        localbetr.b(paramObject);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((betr)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bets
 * JD-Core Version:    0.7.0.1
 */
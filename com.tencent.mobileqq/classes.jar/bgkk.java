import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.ArrayList;
import java.util.ArrayList<Lbgkm;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bgkk
  extends bgkh
{
  private agwg jdField_a_of_type_Agwg;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArrayList<bgkj> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Integer, ArrayList<bgkm>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  
  public bgkk(BaseChatPie paramBaseChatPie, agvc paramagvc)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Agwg = ((agwg)paramagvc);
    d();
  }
  
  private bgkn a(bgkm parambgkm)
  {
    if (!(parambgkm instanceof bgkn)) {
      return null;
    }
    return (bgkn)parambgkm;
  }
  
  private ArrayList<bgkm> a(int paramInt, ArrayList<bgkm> paramArrayList)
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
        Collections.sort((List)localObject, new bgkl(this));
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
  
  private void b(int paramInt, ArrayList<bgkm> paramArrayList)
  {
    Object localObject2;
    if (paramInt == 0)
    {
      localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<bgkm>)localObject2;
    }
    while ((localObject1 == null) || (paramArrayList == null))
    {
      return;
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bgkm)((Iterator)localObject1).next();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (bgkm)localIterator.next();
        if (((bgkm)localObject2).c() == ((bgkm)localObject3).c())
        {
          localObject3 = a((bgkm)localObject2);
          if (localObject3 != null)
          {
            ((bgkn)localObject3).a(false);
            ((bgkn)localObject3).b(0);
          }
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new bglz(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this));
    this.jdField_a_of_type_JavaUtilArrayList.add(new bglt(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bgkj)localIterator.next()).a();
    }
    e();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Agwg = null;
  }
  
  public void a(int paramInt, ArrayList<bgkm> paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agwg == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramArrayList);
    b(paramInt, paramArrayList);
    if ((paramInt == 2) || (paramInt == 1))
    {
      paramArrayList = a(paramInt, paramArrayList);
      this.jdField_a_of_type_Agwg.a(paramInt, paramArrayList, paramBoolean);
      this.jdField_a_of_type_Agwg.a(0, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)), this.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Agwg.a(paramInt, paramArrayList, paramBoolean);
    this.jdField_a_of_type_Agwg.a(1, a(1, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))), false);
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bgkj localbgkj = (bgkj)localIterator.next();
      if (localbgkj != null) {
        localbgkj.a(paramObject);
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bgkj)localIterator.next()).b();
    }
  }
  
  public void b(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bgkj localbgkj = (bgkj)localIterator.next();
      if (localbgkj != null) {
        localbgkj.b(paramObject);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bgkj)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkk
 * JD-Core Version:    0.7.0.1
 */
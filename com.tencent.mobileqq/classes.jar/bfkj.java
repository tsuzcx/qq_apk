import com.tencent.mobileqq.activity.BaseChatPie;
import java.util.ArrayList;
import java.util.ArrayList<Lbfkl;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bfkj
  extends bfkg
{
  private agne jdField_a_of_type_Agne;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private ArrayList<bfki> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  HashMap<Integer, ArrayList<bfkl>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  
  public bfkj(BaseChatPie paramBaseChatPie, agma paramagma)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Agne = ((agne)paramagma);
    d();
  }
  
  private bfkm a(bfkl parambfkl)
  {
    if (!(parambfkl instanceof bfkm)) {
      return null;
    }
    return (bfkm)parambfkl;
  }
  
  private ArrayList<bfkl> a(int paramInt, ArrayList<bfkl> paramArrayList)
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
        Collections.sort((List)localObject, new bfkk(this));
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
  
  private void b(int paramInt, ArrayList<bfkl> paramArrayList)
  {
    Object localObject2;
    if (paramInt == 0)
    {
      localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1));
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<bfkl>)localObject2;
    }
    while ((localObject1 == null) || (paramArrayList == null))
    {
      return;
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bfkl)((Iterator)localObject1).next();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (bfkl)localIterator.next();
        if (((bfkl)localObject2).c() == ((bfkl)localObject3).c())
        {
          localObject3 = a((bfkl)localObject2);
          if (localObject3 != null)
          {
            ((bfkm)localObject3).a(false);
            ((bfkm)localObject3).b(0);
          }
        }
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new bfly(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this));
    this.jdField_a_of_type_JavaUtilArrayList.add(new bfls(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie, this));
  }
  
  private void e()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bfki)localIterator.next()).a();
    }
    e();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = null;
    this.jdField_a_of_type_Agne = null;
  }
  
  public void a(int paramInt, ArrayList<bfkl> paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (this.jdField_a_of_type_Agne == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramArrayList);
    b(paramInt, paramArrayList);
    if ((paramInt == 2) || (paramInt == 1))
    {
      paramArrayList = a(paramInt, paramArrayList);
      this.jdField_a_of_type_Agne.a(paramInt, paramArrayList, paramBoolean);
      this.jdField_a_of_type_Agne.a(0, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)), this.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Agne.a(paramInt, paramArrayList, paramBoolean);
    this.jdField_a_of_type_Agne.a(1, a(1, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(1))), false);
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bfki localbfki = (bfki)localIterator.next();
      if (localbfki != null) {
        localbfki.a(paramObject);
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bfki)localIterator.next()).b();
    }
  }
  
  public void b(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bfki localbfki = (bfki)localIterator.next();
      if (localbfki != null) {
        localbfki.b(paramObject);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bfki)localIterator.next()).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkj
 * JD-Core Version:    0.7.0.1
 */
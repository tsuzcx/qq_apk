import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.ArrayList;
import java.util.ArrayList<Lbgba;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class bgay
  extends bgav
{
  private agkb jdField_a_of_type_Agkb;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ArrayList<bgax> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, ArrayList<bgba>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public boolean a;
  private ArrayList<Integer> b = new ArrayList();
  
  public bgay(BaseChatPie paramBaseChatPie, agin paramagin)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_Agkb = ((agkb)paramagin);
    i();
    e();
  }
  
  private bgbb a(bgba parambgba)
  {
    if (!(parambgba instanceof bgbb)) {
      return null;
    }
    return (bgbb)parambgba;
  }
  
  private ArrayList<bgba> a()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.b.iterator();
    ArrayList localArrayList;
    while (((Iterator)localObject2).hasNext())
    {
      int i = ((Integer)((Iterator)localObject2).next()).intValue();
      localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(i));
      if ((localArrayList != null) && (localArrayList.size() > 0)) {
        ((ArrayList)localObject1).add(localArrayList);
      }
    }
    Collections.sort((List)localObject1, new bgaz(this));
    localObject2 = new ArrayList();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localArrayList = (ArrayList)((Iterator)localObject1).next();
      if (localArrayList != null) {
        ((ArrayList)localObject2).addAll(localArrayList);
      }
    }
    return localObject2;
  }
  
  private void b(int paramInt, ArrayList<bgba> paramArrayList)
  {
    Object localObject2;
    if (paramInt == 0)
    {
      localObject2 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(2));
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<bgba>)localObject2;
    }
    while ((localObject1 == null) || (paramArrayList == null))
    {
      return;
      localObject1 = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0));
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bgba)((Iterator)localObject1).next();
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (bgba)localIterator.next();
        if (((bgba)localObject2).b() == ((bgba)localObject3).b())
        {
          localObject3 = a((bgba)localObject2);
          if (localObject3 != null)
          {
            ((bgbb)localObject3).b(false);
            ((bgbb)localObject3).b(0);
          }
        }
      }
    }
  }
  
  private void i()
  {
    f();
    g();
    h();
  }
  
  private void j()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bgax)localIterator.next()).a();
    }
    this.b.clear();
    j();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = null;
    this.jdField_a_of_type_Agkb = null;
  }
  
  public void a(int paramInt, ArrayList<bgba> paramArrayList, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_Agkb == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramArrayList);
    b(paramInt, paramArrayList);
    if (this.b.contains(Integer.valueOf(paramInt)))
    {
      this.jdField_a_of_type_Agkb.a(1, a(), paramBoolean);
      this.jdField_a_of_type_Agkb.a(0, (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(0)), this.jdField_a_of_type_Boolean);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Agkb.a(0, paramArrayList, paramBoolean);
    this.jdField_a_of_type_Agkb.a(1, a(), false);
  }
  
  public void a(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bgax localbgax = (bgax)localIterator.next();
      if (localbgax != null) {
        localbgax.a(paramObject);
      }
    }
  }
  
  public void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bgax)localIterator.next()).b();
    }
  }
  
  public void b(Object paramObject)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      bgax localbgax = (bgax)localIterator.next();
      if (localbgax != null) {
        localbgax.b(paramObject);
      }
    }
  }
  
  public void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bgax)localIterator.next()).c();
    }
  }
  
  public void d()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bgax)localIterator.next()).d();
    }
  }
  
  public void e()
  {
    this.b.add(Integer.valueOf(2));
    this.b.add(Integer.valueOf(3));
    this.b.add(Integer.valueOf(4));
  }
  
  protected void f()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new bgcu(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
  }
  
  protected void g()
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new bgco(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
  }
  
  protected void h()
  {
    bacq localbacq = (bacq)aqxe.a().a(701);
    if ((localbacq == null) || (!localbacq.b())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(new bgbn(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie, this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgay
 * JD-Core Version:    0.7.0.1
 */
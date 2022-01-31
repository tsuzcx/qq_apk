import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class avug
  implements avuz<avoj>
{
  int jdField_a_of_type_Int;
  avtz jdField_a_of_type_Avtz;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  
  public avug(QQAppInterface paramQQAppInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Avtz = new avtz(paramQQAppInterface, 10002, 5, null);
  }
  
  public List<avoj> a(avvn paramavvn)
  {
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = false;
    if ((paramavvn == null) || (TextUtils.isEmpty(paramavvn.a))) {
      return null;
    }
    Object localObject2 = paramavvn.a.split("\\s+");
    if (localObject2.length < 2) {
      return null;
    }
    if (!this.c)
    {
      this.jdField_a_of_type_Avtz.a();
      this.c = true;
    }
    Object localObject1 = new ArrayList();
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      localObject3 = localObject2[i];
      if (this.jdField_a_of_type_Boolean) {
        return null;
      }
      localObject3 = new avvn((String)localObject3);
      localObject3 = this.jdField_a_of_type_Avtz.a((avvn)localObject3);
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
    }
    if (((List)localObject1).size() < 2) {
      return null;
    }
    int m = ((List)localObject1).size();
    Object localObject3 = new ArrayList();
    Object localObject4 = ((List)localObject1).iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject2 = (List)((Iterator)localObject4).next();
      localObject1 = localObject2;
      if (((List)localObject2).size() > m) {
        localObject1 = ((List)localObject2).subList(0, m);
      }
      ((List)localObject3).add(localObject1);
    }
    localObject2 = new HashMap();
    localObject1 = new HashMap();
    localObject4 = ((List)localObject3).iterator();
    i = 0;
    Object localObject5;
    Object localObject6;
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((List)((Iterator)localObject4).next()).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = (avoj)((Iterator)localObject5).next();
        if (!((Map)localObject2).containsKey(((avoj)localObject6).b()))
        {
          ((Map)localObject2).put(((avoj)localObject6).b(), Integer.valueOf(i));
          ((Map)localObject1).put(Integer.valueOf(i), ((avoj)localObject6).b());
          i += 1;
        }
      }
    }
    localObject4 = (long[][])Array.newInstance(Long.TYPE, new int[] { m, i });
    j = 0;
    while (j < ((List)localObject3).size())
    {
      int k = 0;
      while (k < ((List)((List)localObject3).get(j)).size())
      {
        localObject5 = (Integer)((Map)localObject2).get(((avoj)((List)((List)localObject3).get(j)).get(k)).b());
        if (localObject5 != null) {
          localObject4[j][localObject5.intValue()] = ((avoj)((List)((List)localObject3).get(j)).get(k)).b();
        }
        k += 1;
      }
      j += 1;
    }
    localObject2 = avvw.a((long[][])localObject4, m, i);
    localObject4 = new ArrayList();
    i = localObject2.length - 1;
    while (i >= 0)
    {
      if (localObject2[i] != -1)
      {
        localObject6 = (List)((List)localObject3).get(i);
        localObject5 = (String)((Map)localObject1).get(Integer.valueOf(localObject2[i]));
        localObject6 = ((List)localObject6).iterator();
        while (((Iterator)localObject6).hasNext())
        {
          avoj localavoj = (avoj)((Iterator)localObject6).next();
          if ((localObject5 != null) && (((String)localObject5).equals(localavoj.b()))) {
            ((List)localObject4).add(localavoj);
          }
        }
      }
      i -= 1;
    }
    if (((List)localObject4).size() < 2) {
      return null;
    }
    paramavvn = new avmu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, paramavvn.a, (List)localObject4);
    localObject1 = new ArrayList();
    ((List)localObject1).add(paramavvn);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CreateDiscussionSearchEngine", 2, "Create discussion search cost time = " + (l2 - l1));
    }
    if (!this.b)
    {
      this.b = true;
      awqx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800635E", "0X800635E", 0, 0, "", "", "", "");
    }
    return localObject1;
  }
  
  public void a() {}
  
  public void a(avvn paramavvn, avva<avoj> paramavva) {}
  
  public void b()
  {
    this.jdField_a_of_type_Avtz.b();
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avug
 * JD-Core Version:    0.7.0.1
 */
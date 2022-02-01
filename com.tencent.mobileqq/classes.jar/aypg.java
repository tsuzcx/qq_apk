import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class aypg
{
  private ayoo jdField_a_of_type_Ayoo;
  private HashMap<Long, ayoo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private ayoo b(long paramLong, ayop paramayop, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    Object localObject = null;
    if (paramLong == 1030L) {
      localObject = new ayub(paramLong, paramayop, paramQQAppInterface, paramBaseActivity);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((ayoo)localObject).a();
        ((ayoo)localObject).a(true);
      }
      return localObject;
      if (paramLong == 1040L) {
        localObject = new aytt(paramLong, paramayop, paramQQAppInterface, paramBaseActivity);
      } else if (paramLong > 40000L) {
        localObject = new ayqj(paramLong, paramayop, paramQQAppInterface, paramBaseActivity);
      }
    }
  }
  
  public ayoo a(long paramLong, ayop paramayop, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if ((this.jdField_a_of_type_Ayoo != null) && (this.jdField_a_of_type_Ayoo.a != paramLong)) {
      this.jdField_a_of_type_Ayoo.a(false, paramLong);
    }
    ayoo localayoo = (ayoo)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localayoo != null)
    {
      localayoo.a(true, paramLong);
      localayoo.a();
      localayoo.a(false);
      return localayoo;
    }
    paramayop = b(paramLong, paramayop, paramQQAppInterface, paramBaseActivity);
    if (paramayop != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramayop);
    }
    this.jdField_a_of_type_Ayoo = paramayop;
    return paramayop;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      ayoo localayoo = (ayoo)((Map.Entry)localIterator.next()).getValue();
      if (localayoo != null) {
        localayoo.d();
      }
    }
    this.jdField_a_of_type_Ayoo = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypg
 * JD-Core Version:    0.7.0.1
 */
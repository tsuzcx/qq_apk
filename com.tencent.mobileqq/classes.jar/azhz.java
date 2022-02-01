import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class azhz
{
  private azhh jdField_a_of_type_Azhh;
  private HashMap<Long, azhh> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private azhh b(long paramLong, azhi paramazhi, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    Object localObject = null;
    if (paramLong == 1030L) {
      localObject = new azmm(paramLong, paramazhi, paramQQAppInterface, paramBaseActivity);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((azhh)localObject).a();
        ((azhh)localObject).a(true);
      }
      return localObject;
      if (paramLong == 1040L) {
        localObject = new azme(paramLong, paramazhi, paramQQAppInterface, paramBaseActivity);
      } else if (paramLong > 40000L) {
        localObject = new azjc(paramLong, paramazhi, paramQQAppInterface, paramBaseActivity);
      }
    }
  }
  
  public azhh a(long paramLong, azhi paramazhi, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if ((this.jdField_a_of_type_Azhh != null) && (this.jdField_a_of_type_Azhh.a != paramLong)) {
      this.jdField_a_of_type_Azhh.a(false, paramLong);
    }
    azhh localazhh = (azhh)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localazhh != null)
    {
      localazhh.a(true, paramLong);
      localazhh.a();
      localazhh.a(false);
      return localazhh;
    }
    paramazhi = b(paramLong, paramazhi, paramQQAppInterface, paramBaseActivity);
    if (paramazhi != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramazhi);
    }
    this.jdField_a_of_type_Azhh = paramazhi;
    return paramazhi;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      azhh localazhh = (azhh)((Map.Entry)localIterator.next()).getValue();
      if (localazhh != null) {
        localazhh.e();
      }
    }
    this.jdField_a_of_type_Azhh = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhz
 * JD-Core Version:    0.7.0.1
 */
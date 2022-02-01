import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class axvh
{
  private axup jdField_a_of_type_Axup;
  private HashMap<Long, axup> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private axup b(long paramLong, axuq paramaxuq, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    Object localObject = null;
    if (paramLong == 1030L) {
      localObject = new axzu(paramLong, paramaxuq, paramQQAppInterface, paramBaseActivity);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((axup)localObject).a();
        ((axup)localObject).a(true);
      }
      return localObject;
      if (paramLong == 1040L) {
        localObject = new axzm(paramLong, paramaxuq, paramQQAppInterface, paramBaseActivity);
      } else if (paramLong > 40000L) {
        localObject = new axwk(paramLong, paramaxuq, paramQQAppInterface, paramBaseActivity);
      }
    }
  }
  
  public axup a(long paramLong, axuq paramaxuq, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if ((this.jdField_a_of_type_Axup != null) && (this.jdField_a_of_type_Axup.a != paramLong)) {
      this.jdField_a_of_type_Axup.a(false, paramLong);
    }
    axup localaxup = (axup)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localaxup != null)
    {
      localaxup.a(true, paramLong);
      localaxup.a();
      localaxup.a(false);
      return localaxup;
    }
    paramaxuq = b(paramLong, paramaxuq, paramQQAppInterface, paramBaseActivity);
    if (paramaxuq != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramaxuq);
    }
    this.jdField_a_of_type_Axup = paramaxuq;
    return paramaxuq;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      axup localaxup = (axup)((Map.Entry)localIterator.next()).getValue();
      if (localaxup != null) {
        localaxup.e();
      }
    }
    this.jdField_a_of_type_Axup = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvh
 * JD-Core Version:    0.7.0.1
 */
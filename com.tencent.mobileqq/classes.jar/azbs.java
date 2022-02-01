import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class azbs
{
  private azba jdField_a_of_type_Azba;
  private HashMap<Long, azba> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private azba b(long paramLong, azbb paramazbb, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    Object localObject = null;
    if (paramLong == 1030L) {
      localObject = new azgg(paramLong, paramazbb, paramQQAppInterface, paramBaseActivity);
    }
    for (;;)
    {
      if (localObject != null)
      {
        ((azba)localObject).a();
        ((azba)localObject).a(true);
      }
      return localObject;
      if (paramLong == 1040L) {
        localObject = new azfy(paramLong, paramazbb, paramQQAppInterface, paramBaseActivity);
      } else if (paramLong > 40000L) {
        localObject = new azcw(paramLong, paramazbb, paramQQAppInterface, paramBaseActivity);
      }
    }
  }
  
  public azba a(long paramLong, azbb paramazbb, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if ((this.jdField_a_of_type_Azba != null) && (this.jdField_a_of_type_Azba.a != paramLong)) {
      this.jdField_a_of_type_Azba.a(false, paramLong);
    }
    azba localazba = (azba)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localazba != null)
    {
      localazba.a(true, paramLong);
      localazba.a();
      localazba.a(false);
      return localazba;
    }
    paramazbb = b(paramLong, paramazbb, paramQQAppInterface, paramBaseActivity);
    if (paramazbb != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), paramazbb);
    }
    this.jdField_a_of_type_Azba = paramazbb;
    return paramazbb;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      azba localazba = (azba)((Map.Entry)localIterator.next()).getValue();
      if (localazba != null) {
        localazba.e();
      }
    }
    this.jdField_a_of_type_Azba = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbs
 * JD-Core Version:    0.7.0.1
 */
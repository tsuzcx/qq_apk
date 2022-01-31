import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class axxk
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, axxp> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public axxk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static axxk a(QQAppInterface paramQQAppInterface)
  {
    return (axxk)paramQQAppInterface.getManager(294);
  }
  
  public axxp a(long paramLong, int paramInt)
  {
    try
    {
      axxp localaxxp2 = (axxp)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      axxp localaxxp1 = localaxxp2;
      if (localaxxp2 == null)
      {
        localaxxp1 = new axxp(paramLong);
        localaxxp1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localaxxp1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localaxxp1);
      }
      return localaxxp1;
    }
    finally {}
  }
  
  public void a(axxp paramaxxp)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramaxxp.jdField_a_of_type_Long));
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((axxp)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axxk
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class bavl
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, bavq> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bavl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static bavl a(QQAppInterface paramQQAppInterface)
  {
    return (bavl)paramQQAppInterface.getManager(294);
  }
  
  public bavq a(long paramLong, int paramInt)
  {
    try
    {
      bavq localbavq2 = (bavq)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      bavq localbavq1 = localbavq2;
      if (localbavq2 == null)
      {
        localbavq1 = new bavq(paramLong);
        localbavq1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localbavq1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localbavq1);
      }
      return localbavq1;
    }
    finally {}
  }
  
  public void a(bavq parambavq)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambavq.jdField_a_of_type_Long));
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
        ((bavq)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavl
 * JD-Core Version:    0.7.0.1
 */
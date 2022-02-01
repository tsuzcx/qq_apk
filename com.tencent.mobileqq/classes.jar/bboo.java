import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class bboo
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, bbot> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bboo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static bboo a(QQAppInterface paramQQAppInterface)
  {
    return (bboo)paramQQAppInterface.getManager(QQManagerFactory.LIGHT_VIDEO_MANAGER);
  }
  
  public bbot a(long paramLong, int paramInt)
  {
    try
    {
      bbot localbbot2 = (bbot)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      bbot localbbot1 = localbbot2;
      if (localbbot2 == null)
      {
        localbbot1 = new bbot(paramLong);
        localbbot1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localbbot1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localbbot1);
      }
      return localbbot1;
    }
    finally {}
  }
  
  public void a(bbot parambbot)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambbot.jdField_a_of_type_Long));
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
        ((bbot)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboo
 * JD-Core Version:    0.7.0.1
 */
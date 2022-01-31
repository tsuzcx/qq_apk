import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class avbh
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, avbm> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public avbh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static avbh a(QQAppInterface paramQQAppInterface)
  {
    return (avbh)paramQQAppInterface.getManager(294);
  }
  
  public avbm a(long paramLong, int paramInt)
  {
    try
    {
      avbm localavbm2 = (avbm)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      avbm localavbm1 = localavbm2;
      if (localavbm2 == null)
      {
        localavbm1 = new avbm(paramLong);
        localavbm1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localavbm1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localavbm1);
      }
      return localavbm1;
    }
    finally {}
  }
  
  public void a(avbm paramavbm)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramavbm.jdField_a_of_type_Long));
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
        ((avbm)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avbh
 * JD-Core Version:    0.7.0.1
 */
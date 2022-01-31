import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class awbc
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, awbh> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public awbc(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static awbc a(QQAppInterface paramQQAppInterface)
  {
    return (awbc)paramQQAppInterface.getManager(294);
  }
  
  public awbh a(long paramLong, int paramInt)
  {
    try
    {
      awbh localawbh2 = (awbh)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      awbh localawbh1 = localawbh2;
      if (localawbh2 == null)
      {
        localawbh1 = new awbh(paramLong);
        localawbh1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localawbh1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localawbh1);
      }
      return localawbh1;
    }
    finally {}
  }
  
  public void a(awbh paramawbh)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramawbh.jdField_a_of_type_Long));
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
        ((awbh)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awbc
 * JD-Core Version:    0.7.0.1
 */
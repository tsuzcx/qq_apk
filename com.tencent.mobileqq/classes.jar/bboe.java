import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class bboe
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, bboj> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bboe(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static bboe a(QQAppInterface paramQQAppInterface)
  {
    return (bboe)paramQQAppInterface.getManager(294);
  }
  
  public bboj a(long paramLong, int paramInt)
  {
    try
    {
      bboj localbboj2 = (bboj)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      bboj localbboj1 = localbboj2;
      if (localbboj2 == null)
      {
        localbboj1 = new bboj(paramLong);
        localbboj1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localbboj1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localbboj1);
      }
      return localbboj1;
    }
    finally {}
  }
  
  public void a(bboj parambboj)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambboj.jdField_a_of_type_Long));
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
        ((bboj)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboe
 * JD-Core Version:    0.7.0.1
 */
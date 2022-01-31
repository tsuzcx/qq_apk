import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class awba
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, awbf> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public awba(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static awba a(QQAppInterface paramQQAppInterface)
  {
    return (awba)paramQQAppInterface.getManager(294);
  }
  
  public awbf a(long paramLong, int paramInt)
  {
    try
    {
      awbf localawbf2 = (awbf)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      awbf localawbf1 = localawbf2;
      if (localawbf2 == null)
      {
        localawbf1 = new awbf(paramLong);
        localawbf1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localawbf1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localawbf1);
      }
      return localawbf1;
    }
    finally {}
  }
  
  public void a(awbf paramawbf)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramawbf.jdField_a_of_type_Long));
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
        ((awbf)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awba
 * JD-Core Version:    0.7.0.1
 */
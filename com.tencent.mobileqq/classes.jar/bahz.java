import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class bahz
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, baie> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public bahz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static bahz a(QQAppInterface paramQQAppInterface)
  {
    return (bahz)paramQQAppInterface.getManager(294);
  }
  
  public baie a(long paramLong, int paramInt)
  {
    try
    {
      baie localbaie2 = (baie)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      baie localbaie1 = localbaie2;
      if (localbaie2 == null)
      {
        localbaie1 = new baie(paramLong);
        localbaie1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localbaie1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localbaie1);
      }
      return localbaie1;
    }
    finally {}
  }
  
  public void a(baie parambaie)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(parambaie.jdField_a_of_type_Long));
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
        ((baie)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahz
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class axtb
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<Long, axtg> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public axtb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static axtb a(QQAppInterface paramQQAppInterface)
  {
    return (axtb)paramQQAppInterface.getManager(294);
  }
  
  public axtg a(long paramLong, int paramInt)
  {
    try
    {
      axtg localaxtg2 = (axtg)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      axtg localaxtg1 = localaxtg2;
      if (localaxtg2 == null)
      {
        localaxtg1 = new axtg(paramLong);
        localaxtg1.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localaxtg1.jdField_a_of_type_Int = paramInt;
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localaxtg1);
      }
      return localaxtg1;
    }
    finally {}
  }
  
  public void a(axtg paramaxtg)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramaxtg.jdField_a_of_type_Long));
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
        ((axtg)localIterator.next()).b();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    finally {}
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axtb
 * JD-Core Version:    0.7.0.1
 */
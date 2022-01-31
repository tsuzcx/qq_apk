import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class baix
  extends Observable
  implements Manager
{
  protected aukp a;
  protected QQAppInterface a;
  protected ConcurrentHashMap<String, TroopAioTopADInfo> a;
  
  public baix(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aukp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        return;
      }
      finally {}
    }
  }
  
  public TroopAioTopADInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (TroopAioTopADInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
      paramString = (TroopAioTopADInfo)this.jdField_a_of_type_Aukp.a(TroopAioTopADInfo.class, paramString);
    } while (paramString == null);
    this.jdField_a_of_type_Aukp.b(paramString);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Aukp != null) && (this.jdField_a_of_type_Aukp.a())) {
      this.jdField_a_of_type_Aukp.a();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baix
 * JD-Core Version:    0.7.0.1
 */
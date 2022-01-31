import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class bchj
  extends Observable
  implements Manager
{
  protected awbw a;
  protected QQAppInterface a;
  protected ConcurrentHashMap<String, TroopAioTopADInfo> a;
  
  public bchj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awbw = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
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
      paramString = (TroopAioTopADInfo)this.jdField_a_of_type_Awbw.a(TroopAioTopADInfo.class, paramString);
    } while (paramString == null);
    this.jdField_a_of_type_Awbw.b(paramString);
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_Awbw != null) && (this.jdField_a_of_type_Awbw.a())) {
      this.jdField_a_of_type_Awbw.a();
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchj
 * JD-Core Version:    0.7.0.1
 */
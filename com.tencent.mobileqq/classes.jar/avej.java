import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class avej
  implements Manager
{
  private aukp jdField_a_of_type_Aukp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProxyManager jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ConcurrentHashMap<String, QCallCardInfo> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public avej(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager = paramQQAppInterface.a();
  }
  
  private aukp a()
  {
    if ((this.jdField_a_of_type_Aukp == null) || (!this.jdField_a_of_type_Aukp.a())) {}
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_a_of_type_Aukp == null) || (!this.jdField_a_of_type_Aukp.a())) {
        this.jdField_a_of_type_Aukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      }
      return this.jdField_a_of_type_Aukp;
    }
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_Aukp != null) && (this.jdField_a_of_type_Aukp.a())) {
      this.jdField_a_of_type_Aukp.a();
    }
  }
  
  public QCallCardInfo a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return (QCallCardInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    paramString = a().a(QCallCardInfo.class, false, "uin = ?", new String[] { paramString }, null, null, null, null);
    if (paramString != null) {
      return (QCallCardInfo)paramString.get(0);
    }
    return null;
  }
  
  public void a(QCallCardInfo paramQCallCardInfo)
  {
    if (paramQCallCardInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QCallCardManager", 2, "saveQcallCard null ");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCallCardManager", 2, "CardManager saveQcallCard");
    }
    b(paramQCallCardInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppProxyProxyManager.b(paramQCallCardInfo.uin, 0, paramQCallCardInfo.getTableName(), paramQCallCardInfo, 3, null);
  }
  
  public void b(QCallCardInfo paramQCallCardInfo)
  {
    if (paramQCallCardInfo == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramQCallCardInfo.uin))
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.replace(paramQCallCardInfo.uin, paramQCallCardInfo);
          continue;
        }
      }
      finally {}
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQCallCardInfo.uin, paramQCallCardInfo);
    }
  }
  
  public void onDestroy()
  {
    a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avej
 * JD-Core Version:    0.7.0.1
 */
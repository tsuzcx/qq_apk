import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EqqConfig;
import com.tencent.mobileqq.data.EqqDetail;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class anty
  implements Manager
{
  private EqqConfig jdField_a_of_type_ComTencentMobileqqDataEqqConfig;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private ConcurrentHashMap<String, EqqDetail> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public anty(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  public EqqDetail a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return null;
    }
    return (EqqDetail)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
  }
  
  public String a()
  {
    String str2 = "";
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig == null)
    {
      List localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(EqqConfig.class);
      String str1 = str2;
      if (localList != null)
      {
        str1 = str2;
        if (localList.size() >= 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig = ((EqqConfig)localList.get(0));
          str1 = this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig.getData();
        }
      }
      return str1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig.getData();
  }
  
  public void a()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.eqq", 2, "initEqqDetailCache() begin");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(EqqDetail.class, false, "followType=?", new String[] { "0" }, null, null, null, null);
    if (localObject != null) {
      i = ((List)localObject).size();
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(i);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EqqDetail localEqqDetail = (EqqDetail)((Iterator)localObject).next();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localEqqDetail.uin, localEqqDetail);
      }
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.eqq", 2, "initEqqDetailCache() end: " + this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size());
    }
  }
  
  public void a(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {}
    do
    {
      return;
      a(paramEqqDetail);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
    } while (paramEqqDetail.followType != 0);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramEqqDetail.uin, paramEqqDetail);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig = new EqqConfig(paramString);
    }
    a(this.jdField_a_of_type_ComTencentMobileqqDataEqqConfig);
  }
  
  protected boolean a(Entity paramEntity)
  {
    boolean bool = false;
    if (paramEntity.getStatus() == 1000)
    {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  public void b(EqqDetail paramEqqDetail)
  {
    if (paramEqqDetail == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove(paramEqqDetail);
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    } while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramEqqDetail.uin);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anty
 * JD-Core Version:    0.7.0.1
 */
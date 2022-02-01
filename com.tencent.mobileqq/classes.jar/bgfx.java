import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.1;
import com.tencent.mobileqq.troop.troopgame.TroopGameCardManager.2;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import mqq.manager.Manager;

public class bgfx
  implements Manager
{
  protected LruCache<String, MemberGradeLevelInfo> a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  
  public bgfx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(1000);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
  }
  
  @Nullable
  private MemberGradeLevelInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardManager", 2, "getMemberGradeLevelInfo arg is invalid");
      }
      paramString = null;
    }
    Object localObject1;
    do
    {
      return paramString;
      localObject2 = (MemberGradeLevelInfo)this.jdField_a_of_type_AndroidSupportV4UtilLruCache.get(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (MemberGradeLevelInfo)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(MemberGradeLevelInfo.class, paramString);
      }
      paramString = (String)localObject1;
    } while (!QLog.isColorLevel());
    Object localObject2 = new StringBuilder().append("getMemberGradeLevelInfo info = ");
    if (localObject1 == null) {}
    for (paramString = "null";; paramString = ((MemberGradeLevelInfo)localObject1).toString())
    {
      QLog.d("TroopGameCardManager", 2, paramString);
      return localObject1;
    }
  }
  
  private boolean a(Entity paramEntity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.isOpen())
    {
      if (paramEntity.getStatus() != 1000) {
        break label48;
      }
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.persistOrReplace(paramEntity);
      bool1 = bool2;
      if (paramEntity.getStatus() == 1001) {
        bool1 = true;
      }
    }
    label48:
    do
    {
      return bool1;
      if (paramEntity.getStatus() == 1001) {
        break;
      }
      bool1 = bool2;
    } while (paramEntity.getStatus() != 1002);
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.update(paramEntity);
  }
  
  protected void a(Entity paramEntity)
  {
    ThreadManager.excute(new TroopGameCardManager.2(this, paramEntity), 32, null, true);
  }
  
  public void a(MemberGradeLevelInfo paramMemberGradeLevelInfo)
  {
    if ((paramMemberGradeLevelInfo == null) || (TextUtils.isEmpty(paramMemberGradeLevelInfo.memberuin)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameCardManager", 2, "saveMemberGradeLevelInfo arg is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopGameCardManager", 2, "saveMemberGradeLevelInfo memberuin = " + paramMemberGradeLevelInfo.memberuin + ", level = " + paramMemberGradeLevelInfo.gradeLevel);
    }
    if (this.jdField_a_of_type_AndroidSupportV4UtilLruCache == null) {
      this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(1000);
    }
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache.put(paramMemberGradeLevelInfo.memberuin, paramMemberGradeLevelInfo);
    a(paramMemberGradeLevelInfo);
  }
  
  public void a(String paramString, bgfy parambgfy)
  {
    if ((TextUtils.isEmpty(paramString)) || (parambgfy == null)) {
      return;
    }
    ThreadManager.excute(new TroopGameCardManager.1(this, paramString, parambgfy), 32, null, true);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgfx
 * JD-Core Version:    0.7.0.1
 */
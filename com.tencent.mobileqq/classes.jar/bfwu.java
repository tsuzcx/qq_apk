import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.honor.TroopHonorManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorList;
import tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor.UserHonor;

public class bfwu
  implements Manager
{
  private bfxd jdField_a_of_type_Bfxd;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private boolean jdField_a_of_type_Boolean;
  
  public bfwu(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Bfxd = new bfxd();
    ThreadManager.getSubThreadHandler().post(new TroopHonorManager.1(this));
  }
  
  public List<bfxc> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = bfwx.a(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (Integer)paramString.next();
        localObject = this.jdField_a_of_type_Bfxd.a(((Integer)localObject).intValue());
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List<bfxc> a(String paramString1, String paramString2)
  {
    if (!b(paramString1)) {
      return null;
    }
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1, paramString2);
    if (localObject != null) {}
    for (localObject = a(((TroopMemberInfo)localObject).honorList);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { paramString1, paramString2, localObject }));
      }
      return localObject;
    }
  }
  
  public void a(bfxd parambfxd, boolean paramBoolean)
  {
    if (parambfxd == null) {}
    for (;;)
    {
      try
      {
        QLog.d("TroopHonor.manager", 1, "updateConfig, config == null");
        return;
      }
      finally {}
      if ((paramBoolean) && (this.jdField_a_of_type_Boolean))
      {
        QLog.d("TroopHonor.manager", 1, "had init config");
      }
      else
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Bfxd = parambfxd;
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("updateConfig, isInit: %s, config: %s", new Object[] { Boolean.valueOf(paramBoolean), parambfxd }));
        }
        if (!paramBoolean) {
          ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(80, true, null);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, bfww parambfww)
  {
    ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString1, paramString2, new bfwv(this, paramString1, paramString2, parambfww));
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    TroopManager localTroopManager;
    Object localObject;
    do
    {
      return;
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      TroopMemberInfo localTroopMemberInfo = localTroopManager.b(paramString1, paramString2);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2))
      {
        localObject = localTroopManager.c(paramString1);
        if ((localObject != null) && (paramString3 != null) && (!paramString3.equals(((TroopInfo)localObject).myHonorList)))
        {
          ((TroopInfo)localObject).myHonorList = paramString3;
          localTroopManager.b((TroopInfo)localObject);
        }
      }
      localObject = localTroopMemberInfo;
      if (localTroopMemberInfo == null)
      {
        localObject = localTroopMemberInfo;
        if (!TextUtils.isEmpty(paramString3))
        {
          localObject = new TroopMemberInfo();
          ((TroopMemberInfo)localObject).memberuin = paramString2;
          ((TroopMemberInfo)localObject).troopuin = paramString1;
        }
      }
    } while ((localObject == null) || (TextUtils.equals(paramString3, ((TroopMemberInfo)localObject).honorList)));
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("updateTroopMemberHonor troopUin: %s, memberUin: %s, newHonorList: %s, oldHonorList: %s", new Object[] { paramString1, paramString2, paramString3, ((TroopMemberInfo)localObject).honorList }));
    }
    ((TroopMemberInfo)localObject).honorList = paramString3;
    if (((TroopMemberInfo)localObject).getStatus() == 1000) {
      localTroopManager.a(paramString1, paramString2, (TroopMemberInfo)localObject);
    }
    localTroopManager.b(paramString1, paramString2, (TroopMemberInfo)localObject);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = localTroopManager.c(paramString);
    if (localTroopInfo == null) {
      QLog.d("TroopHonor.manager", 1, "updateTroopHonorAIOSwitch troopInfo is null");
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("updateTroopHonorAIOSwitch, troopUin: %s, isOpen: %s, old: %s", new Object[] { paramString, Boolean.valueOf(paramBoolean), Boolean.valueOf(localTroopInfo.isTroopHonorOpen()) }));
      }
    } while (!(localTroopInfo.isTroopHonorOpen() ^ paramBoolean));
    if (paramBoolean) {}
    for (localTroopInfo.dwGroupFlagExt3 &= 0xFDFFFFFF;; localTroopInfo.dwGroupFlagExt3 |= 0x2000000)
    {
      localTroopManager.b(localTroopInfo);
      ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(80, true, null);
      return;
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    for (;;)
    {
      try
      {
        Object localObject = new troop_honor.HonorChangeGrayTipsReserved();
        ((troop_honor.HonorChangeGrayTipsReserved)localObject).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = ((troop_honor.HonorChangeGrayTipsReserved)localObject).user_honor.get();
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
        {
          localObject = paramArrayOfByte.iterator();
          if (((Iterator)localObject).hasNext())
          {
            paramArrayOfByte = (troop_honor.UserHonor)((Iterator)localObject).next();
            String str = String.valueOf(paramArrayOfByte.uin.get());
            if (!paramArrayOfByte.id.has()) {
              break label225;
            }
            paramArrayOfByte = paramArrayOfByte.id.get();
            a(paramString, str, bfwx.a(paramArrayOfByte));
            if ((!TextUtils.isEmpty(str)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              ((aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(80, true, new Object[] { paramString, str });
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("TroopHonor.push", 2, String.format("updatePushTroopHonor, pushType: %s, troopUin: %s, memberUin: %s, ids: %s", new Object[] { Integer.valueOf(paramInt), paramString, str, paramArrayOfByte }));
            continue;
          }
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramString)
      {
        paramString.printStackTrace();
        QLog.d("TroopHonor.manager", 1, "updatePushTroopHonor", paramString);
      }
      label225:
      paramArrayOfByte = null;
    }
  }
  
  public void a(List<oidb_0xdc9.HonorList> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.d("TroopHonor.manager", 1, "updateHostHonorList| honorList is empty!");
    }
    StringBuilder localStringBuilder;
    label383:
    do
    {
      return;
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localStringBuilder = new StringBuilder();
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(str1))
      {
        QLog.d("TroopHonor.manager", 1, "updateHostHonorList memberUin is empty");
        return;
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (oidb_0xdc9.HonorList)localIterator.next();
        String str2 = String.valueOf(paramList.group_id.get());
        if (paramList.is_gray.has()) {}
        for (int i = paramList.is_gray.get();; i = 0)
        {
          List localList = paramList.id.get();
          String str3 = bfwx.a(localList);
          localStringBuilder.append(str2).append(": ").append(str3).append("\n");
          if (TextUtils.isEmpty(str2)) {
            break label383;
          }
          paramList = localTroopManager.c(str2);
          if (paramList != null)
          {
            paramList.troopHonorGrayFlag = i;
            paramList.myHonorList = str3;
            a(paramList);
            if (QLog.isColorLevel()) {
              QLog.d("TroopHonor.manager", 2, String.format("updateHostHonorList| update troopUin: %s, troopHonorGrayFlag: %s", new Object[] { str2, Integer.valueOf(i) }));
            }
          }
          TroopMemberInfo localTroopMemberInfo = localTroopManager.b(str2, str1);
          paramList = localTroopMemberInfo;
          if (localTroopMemberInfo == null)
          {
            paramList = localTroopMemberInfo;
            if (!TextUtils.isEmpty(str3))
            {
              paramList = new TroopMemberInfo();
              paramList.memberuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              paramList.troopuin = str2;
            }
          }
          if (paramList == null) {
            break;
          }
          paramList.honorList = str3;
          if (paramList.getStatus() == 1000) {
            localTroopManager.a(str2, str1, paramList);
          }
          boolean bool = a(paramList);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopHonor.manager", 2, String.format("updateHostHonorList| update host memberInfo, troopUin: %s, honorList: %s, result: %s", new Object[] { str2, localList, Boolean.valueOf(bool) }));
          break;
        }
        QLog.d("TroopHonor.manager", 1, String.format("updateHostHonorList| troopUin is empty", new Object[0]));
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHonor.manager", 2, "updateHostHonorList, " + localStringBuilder.toString());
  }
  
  public boolean a(Entity paramEntity)
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
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Bfxd != null) && (this.jdField_a_of_type_Bfxd.jdField_a_of_type_Boolean)) {}
    for (int i = 1;; i = 0)
    {
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (i == 0)
      {
        paramString = localTroopManager.c(paramString);
        if ((paramString == null) || (paramString.troopHonorGrayFlag != 1)) {
          break;
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    boolean bool5 = false;
    boolean bool2;
    TroopManager localTroopManager;
    boolean bool1;
    if ((this.jdField_a_of_type_Bfxd != null) && (this.jdField_a_of_type_Bfxd.jdField_a_of_type_Boolean))
    {
      bool2 = true;
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (bool2) {
        break label242;
      }
      TroopInfo localTroopInfo = localTroopManager.c(paramString);
      if ((localTroopInfo == null) || (localTroopInfo.troopHonorGrayFlag != 1)) {
        break label225;
      }
      bool1 = true;
    }
    for (;;)
    {
      label65:
      paramString = localTroopManager.c(paramString);
      boolean bool3;
      label92:
      boolean bool6;
      if ((paramString != null) && ((paramString.dwGroupFlagExt3 & 0x2000000) == 0L))
      {
        bool3 = true;
        bool6 = bdfk.b();
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("isSupportTroopHonor, isGlobalOpen: %s, isGrayTroop: %s, isAIOOpen: %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool3) }));
        }
        paramString = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (paramString == null) {
          break label236;
        }
        paramString = paramString.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        if (paramString == null) {
          break label236;
        }
      }
      label225:
      label236:
      for (boolean bool4 = paramString.troopHonorSwitch;; bool4 = false)
      {
        if (!bool2)
        {
          bool2 = bool5;
          if (!bool1) {}
        }
        else
        {
          bool2 = bool5;
          if (bool3)
          {
            bool2 = bool5;
            if (!bool6)
            {
              bool2 = bool5;
              if (bool4) {
                bool2 = true;
              }
            }
          }
        }
        return bool2;
        bool2 = false;
        break;
        bool1 = false;
        break label65;
        bool3 = false;
        break label92;
      }
      label242:
      bool1 = false;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwu
 * JD-Core Version:    0.7.0.1
 */
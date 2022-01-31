import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.honor.TroopHonorManager.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.oidb_0xdc9.oidb_0xdc9.HonorList;
import tencent.im.troop.honor.troop_honor.HonorChangeGrayTipsReserved;
import tencent.im.troop.honor.troop_honor.UserHonor;

public class azcd
  implements Manager
{
  private atmp jdField_a_of_type_Atmp;
  private azci jdField_a_of_type_Azci;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean;
  
  public azcd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atmp = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    this.jdField_a_of_type_Azci = new azci();
    ThreadManager.getSubThreadHandler().post(new TroopHonorManager.1(this));
  }
  
  public String a(String paramString1, String paramString2)
  {
    if (!a(paramString1, false)) {
      return null;
    }
    paramString1 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString1, paramString2);
    if (paramString1 != null) {}
    for (paramString1 = paramString1.honorList;; paramString1 = null) {
      return paramString1;
    }
  }
  
  public List<azch> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = azce.a(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (Integer)paramString.next();
        localObject = this.jdField_a_of_type_Azci.a(((Integer)localObject).intValue());
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
    }
    return localArrayList;
  }
  
  public List<azch> a(String paramString1, String paramString2)
  {
    if (!a(paramString1, false)) {
      return null;
    }
    Object localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString1, paramString2);
    if (localObject != null) {}
    for (localObject = a(((TroopMemberInfo)localObject).honorList);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { paramString1, paramString2, localObject }));
      }
      return localObject;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putBoolean("SP_HAD_OPEN_TROOP_HONOR", true).apply();
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, "setHadOpenTroopHonor");
    }
  }
  
  public void a(azci paramazci, boolean paramBoolean)
  {
    if (paramazci == null) {}
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
        this.jdField_a_of_type_Azci = paramazci;
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("updateConfig, isInit: %s, config: %s", new Object[] { Boolean.valueOf(paramBoolean), paramazci }));
        }
        if (!paramBoolean) {
          ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).notifyUI(80, true, null);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    TroopManager localTroopManager;
    TroopMemberInfo localTroopMemberInfo1;
    do
    {
      return;
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      TroopMemberInfo localTroopMemberInfo2 = localTroopManager.b(paramString1, paramString2);
      localTroopMemberInfo1 = localTroopMemberInfo2;
      if (localTroopMemberInfo2 == null)
      {
        localTroopMemberInfo1 = localTroopMemberInfo2;
        if (!TextUtils.isEmpty(paramString3))
        {
          localTroopMemberInfo1 = new TroopMemberInfo();
          localTroopMemberInfo1.memberuin = paramString2;
          localTroopMemberInfo1.troopuin = paramString1;
        }
      }
    } while ((localTroopMemberInfo1 == null) || (paramString3.equals(localTroopMemberInfo1.honorList)));
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("updateTroopMemberHonor troopUin: %s, memberUin: %s, newHonorList: %s, oldHonorList: %s", new Object[] { paramString1, paramString2, paramString3, localTroopMemberInfo1.honorList }));
    }
    localTroopMemberInfo1.honorList = paramString3;
    if (localTroopMemberInfo1.getStatus() == 1000) {
      localTroopManager.a(paramString1, paramString2, localTroopMemberInfo1);
    }
    localTroopManager.b(paramString1, paramString2, localTroopMemberInfo1);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
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
              break label224;
            }
            paramArrayOfByte = paramArrayOfByte.id.get();
            a(paramString, str, azce.a(paramArrayOfByte));
            if ((!TextUtils.isEmpty(str)) && (str.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              ((ajtg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).notifyUI(80, true, new Object[] { paramString, str });
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
      label224:
      paramArrayOfByte = null;
    }
  }
  
  public void a(List<oidb_0xdc9.HonorList> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      QLog.d("TroopHonor.manager", 1, "updateHostHonorList| honorList is empty!");
    }
    StringBuilder localStringBuilder;
    label390:
    do
    {
      return;
      TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      localStringBuilder = new StringBuilder();
      String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (TextUtils.isEmpty(str1))
      {
        QLog.d("TroopHonor.manager", 1, "updateHostHonorList memberUin is empty");
        return;
      }
      atmr localatmr = this.jdField_a_of_type_Atmp.a();
      localatmr.a();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (oidb_0xdc9.HonorList)localIterator.next();
        String str2 = String.valueOf(paramList.group_id.get());
        if (paramList.is_gray.has()) {}
        for (int i = paramList.is_gray.get();; i = 0)
        {
          List localList = paramList.id.get();
          String str3 = azce.a(localList);
          localStringBuilder.append(str2).append(": ").append(str3).append("\n");
          if (TextUtils.isEmpty(str2)) {
            break label390;
          }
          paramList = localTroopManager.c(str2);
          if (paramList != null)
          {
            paramList.troopHonorGrayFlag = i;
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
      localatmr.c();
      localatmr.b();
    } while (!QLog.isColorLevel());
    QLog.d("TroopHonor.manager", 2, "updateHostHonorList, " + localStringBuilder.toString());
  }
  
  public boolean a()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("SP_HAD_OPEN_TROOP_HONOR", false);
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("hadOpenTroopHonor, open flag = %s", new Object[] { Boolean.valueOf(bool) }));
    }
    return bool;
  }
  
  public boolean a(atmo paramatmo)
  {
    boolean bool = false;
    if (paramatmo.getStatus() == 1000)
    {
      this.jdField_a_of_type_Atmp.b(paramatmo);
      if (paramatmo.getStatus() == 1001) {
        bool = true;
      }
    }
    while ((paramatmo.getStatus() != 1001) && (paramatmo.getStatus() != 1002)) {
      return bool;
    }
    return this.jdField_a_of_type_Atmp.a(paramatmo);
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    boolean bool4 = false;
    boolean bool3;
    TroopManager localTroopManager;
    boolean bool1;
    if ((this.jdField_a_of_type_Azci != null) && (this.jdField_a_of_type_Azci.jdField_a_of_type_Boolean))
    {
      bool3 = true;
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
      if (bool3) {
        break label204;
      }
      TroopInfo localTroopInfo = localTroopManager.c(paramString);
      if ((localTroopInfo == null) || (localTroopInfo.troopHonorGrayFlag != 1)) {
        break label187;
      }
      bool1 = true;
    }
    for (;;)
    {
      label66:
      boolean bool2;
      if (paramBoolean)
      {
        paramString = localTroopManager.c(paramString);
        if ((paramString != null) && ((paramString.dwGroupFlagExt3 & 0x2000000) == 0L)) {
          bool2 = true;
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopHonor.manager", 2, String.format("isSupportTroopHonor, isInAIO: %s, isGlobalOpen: %s, isGrayTroop: %s, isAIOOpen: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        if (!bool3)
        {
          bool3 = bool4;
          if (!bool1) {}
        }
        else if (paramBoolean)
        {
          bool3 = bool4;
          if (!bool2) {}
        }
        else
        {
          bool3 = true;
        }
        return bool3;
        bool3 = false;
        break;
        label187:
        bool1 = false;
        break label66;
        bool2 = false;
        continue;
        bool2 = false;
      }
      label204:
      bool1 = false;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Atmp.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azcd
 * JD-Core Version:    0.7.0.1
 */
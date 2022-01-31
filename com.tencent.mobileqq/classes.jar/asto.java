import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.multicard.RecommendPerson;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager.1;
import com.tencent.mobileqq.multicard.manager.TroopMemberRecommendManager.2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class asto
  implements Manager
{
  public amwl a;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<String, List<RecommendPerson>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public asto(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("TroopMemberRecom" + paramQQAppInterface.getCurrentAccountUin(), 0);
    ThreadManager.getSubThreadHandler().post(new TroopMemberRecommendManager.1(this));
  }
  
  private astn a()
  {
    return (astn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(167);
  }
  
  public static asto a(QQAppInterface paramQQAppInterface)
  {
    return (asto)paramQQAppInterface.getManager(347);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Amwl == null) {
      this.jdField_a_of_type_Amwl = amwm.a();
    }
  }
  
  public int a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.c(paramString);
      if (paramString != null) {
        return paramString.wMemberNum;
      }
    }
    return 0;
  }
  
  public SharedPreferences a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  List<RecommendPerson> a(List<RecommendPerson> paramList, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramList.size();
    if (j > 0)
    {
      k = ((RecommendPerson)paramList.get(0)).cardMaxDisplayPersonNum;
      if (j <= k) {
        localArrayList.addAll(paramList);
      }
    }
    else
    {
      return localArrayList;
    }
    int i = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt(paramString, 0);
    if (i + k <= j)
    {
      j = k + i;
      localArrayList.addAll(paramList.subList(i, j));
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, j).commit();
      return localArrayList;
    }
    int k = (k + i) % j;
    localArrayList.addAll(paramList.subList(i, j));
    localArrayList.addAll(paramList.subList(0, k));
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt(paramString, k).commit();
    return localArrayList;
  }
  
  public Map<Integer, List<RecommendPerson>> a(List<RecommendPerson> paramList, String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.Manager", 2, "filterAndReorderRecommenList start ,troopUin = " + paramString);
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      Iterator localIterator = paramList.iterator();
      Object localObject;
      if (localIterator.hasNext())
      {
        localObject = (RecommendPerson)localIterator.next();
        if (localLinkedHashMap.containsKey(Integer.valueOf(((RecommendPerson)localObject).cardTypeID))) {}
        for (paramList = (List)localLinkedHashMap.get(Integer.valueOf(((RecommendPerson)localObject).cardTypeID));; paramList = new ArrayList())
        {
          paramList.add(localObject);
          localLinkedHashMap.put(Integer.valueOf(((RecommendPerson)localObject).cardTypeID), paramList);
          break;
        }
      }
      localIterator = localLinkedHashMap.entrySet().iterator();
      if (localIterator.hasNext())
      {
        paramList = (Map.Entry)localIterator.next();
        localObject = (Integer)paramList.getKey();
        List localList = (List)paramList.getValue();
        paramList = "";
        switch (((Integer)localObject).intValue())
        {
        }
        for (;;)
        {
          localLinkedHashMap.put(localObject, a(localList, paramList));
          break;
          paramList = "key_ActiveMember_ri" + paramString;
          continue;
          paramList = "key_SameUserInfo_ri" + paramString;
          continue;
          paramList = "key_CommonBehavior_ri" + paramString;
          continue;
          paramList = "key_Interactive_ri" + paramString;
          continue;
          paramList = "key_GroupKOL_ri" + paramString;
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public void a(String paramString, int paramInt, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.Manager", 2, "getTroopMemRecommendCardsData troopUin = " + paramString + ",entryId = " + paramInt);
    }
    Object localObject = (List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      a(paramString, false);
      localObject = a((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString), paramString);
      a().notifyUI(1, true, new Object[] { localObject, paramString, Integer.valueOf(1) });
    }
    for (;;)
    {
      if (a(paramInt, paramString)) {
        a().a(paramString, paramInt, paramList);
      }
      return;
      ThreadManager.excute(new TroopMemberRecommendManager.2(this, paramString), 32, null, true);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return;
      Object localObject = new ArrayList();
      ((List)localObject).addAll((Collection)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1));
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecommendPerson localRecommendPerson = (RecommendPerson)((Iterator)localObject).next();
          if (paramString2.equals(localRecommendPerson.uin)) {
            ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).remove(localRecommendPerson);
          }
        }
      }
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    } while (paramString1 == null);
    paramString1.a(RecommendPerson.class.getSimpleName(), "uin=?", new String[] { String.valueOf(paramString2) });
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      ajxl localajxl = (ajxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      Object localObject = new ArrayList();
      ((List)localObject).addAll((Collection)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString));
      aukp localaukp = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecommendPerson localRecommendPerson = (RecommendPerson)((Iterator)localObject).next();
          if ((localajxl != null) && (localajxl.b(localRecommendPerson.uin)))
          {
            ((List)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).remove(localRecommendPerson);
            if ((paramBoolean) && (localaukp != null)) {
              localaukp.a(RecommendPerson.class.getSimpleName(), "uin=?", new String[] { String.valueOf(localRecommendPerson.uin) });
            }
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, List<RecommendPerson> paramList, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberRecommend.Manager", 2, "onGetTroopMemRecommendList, success = " + paramBoolean + ",troopUin = " + paramString);
    }
    Object localObject = new LinkedHashMap();
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_ActiveMember_ri" + paramString, 0).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_SameUserInfo_ri" + paramString, 0).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_CommonBehavior_ri" + paramString, 0).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_Interactive_ri" + paramString, 0).commit();
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_GroupKOL_ri" + paramString, 0).commit();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramList);
      localObject = a(paramList, paramString);
    }
    a().notifyUI(1, paramBoolean, new Object[] { localObject, paramString, Integer.valueOf(3) });
  }
  
  boolean a(int paramInt, String paramString)
  {
    long l1 = 0L;
    boolean bool = false;
    SharedPreferences localSharedPreferences = a();
    if (paramInt == 11) {
      l1 = localSharedPreferences.getLong("key_LeftSlide_fetch_ts" + paramString, 0L);
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis() / 1000L;
      if (l2 > l1) {
        bool = true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.Manager", 2, "isTimeToObtainRemote result = " + bool + ",entryId = " + paramInt + ",troopUin = " + paramString + ",curTimeStamp = " + l2 + ",fetchTimeStamp = " + l1);
      }
      return bool;
      if (paramInt == 12) {
        l1 = localSharedPreferences.getLong("key_AIO_fetch_ts" + paramString, 0L);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    a();
    int i = a(paramString);
    if ((this.jdField_a_of_type_Amwl == null) || (i <= 0)) {
      bool = false;
    }
    do
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberRecommend.Manager", 2, "needShowTroopRecommend() troopUin =" + paramString + " troopMemRecommendConfBean = " + this.jdField_a_of_type_Amwl.toString() + " troopMemCount = " + i);
      }
    } while ((this.jdField_a_of_type_Amwl.a == 1) && (i > this.jdField_a_of_type_Amwl.b));
    return false;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asto
 * JD-Core Version:    0.7.0.1
 */
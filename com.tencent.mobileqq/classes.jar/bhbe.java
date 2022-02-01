import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.trooponline.data.TroopAllOnlineData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class bhbe
  implements Manager
{
  protected long a;
  protected QQAppInterface a;
  private Map<String, bhbc> a;
  private Map<String, TroopAllOnlineData> b = new ConcurrentHashMap();
  
  public bhbe(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(String paramString)
  {
    paramString = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (paramString.jdField_a_of_type_Int > 0)) {
      return paramString.jdField_a_of_type_Int;
    }
    return 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(String paramString)
  {
    paramString = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.jdField_b_of_type_Long;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = "";
      return paramString;
    }
    TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString);
    if (localTroopInfo != null) {}
    for (boolean bool = localTroopInfo.isKicked();; bool = true)
    {
      if (bool) {
        return "";
      }
      paramString = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
      String str;
      if (paramString != null) {
        str = paramString.jdField_a_of_type_JavaLangString;
      }
      for (int i = paramString.jdField_b_of_type_Int;; i = 0)
      {
        if (str == null) {
          return "";
        }
        paramString = str;
        if (localTroopInfo == null) {
          break;
        }
        paramString = str;
        if (localTroopInfo.wMemberNumClient <= 0) {
          break;
        }
        paramString = str;
        if (i <= localTroopInfo.wMemberNumClient) {
          break;
        }
        paramString = str;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        str = str.replace(String.valueOf(i), String.valueOf(localTroopInfo.wMemberNumClient));
        paramString = str;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopOnlineMemberManage", 2, String.format("getOnlineTip onlineCount: %s, memberNum: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localTroopInfo.wMemberNumClient) }));
        return str;
        str = null;
      }
    }
  }
  
  public List<bhbd> a(String paramString)
  {
    paramString = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("TroopOnlineMemberManage", 1, "removeDetailOnlineData: e = " + paramString.toString());
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    bhbc localbhbc2 = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    bhbc localbhbc1 = localbhbc2;
    if (localbhbc2 == null)
    {
      localbhbc1 = new bhbc();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, localbhbc1);
    }
    if ((i != 4) || (!TextUtils.isEmpty(paramString2)))
    {
      localbhbc1.jdField_a_of_type_JavaLangString = paramString2;
      localbhbc1.jdField_b_of_type_Int = paramInt3;
    }
    localbhbc1.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + i);
    if (paramInt2 != -1) {
      localbhbc1.jdField_a_of_type_Int = paramInt2;
    }
  }
  
  public void a(String paramString, List<String> paramList, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopAllOnlineData localTroopAllOnlineData = new TroopAllOnlineData();
    localTroopAllOnlineData.troopUin = paramString;
    localTroopAllOnlineData.memberUinList = paramList;
    localTroopAllOnlineData.nextReqTime = i;
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString.persistOrReplace(localTroopAllOnlineData);
    paramString.close();
  }
  
  public void a(String paramString1, List<bhbd> paramList, int paramInt1, String paramString2, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    bhbc localbhbc2 = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    bhbc localbhbc1 = localbhbc2;
    if (localbhbc2 == null)
    {
      localbhbc1 = new bhbc();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, localbhbc1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localbhbc1.jdField_a_of_type_JavaLangString = paramString2;
      localbhbc1.jdField_b_of_type_Int = paramInt2;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      localbhbc1.jdField_a_of_type_JavaUtilList = paramList;
    }
    localbhbc1.jdField_b_of_type_Long = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {}
    for (int i = paramString.jdField_b_of_type_Int;; i = 0) {
      return i;
    }
  }
  
  public long b(String paramString)
  {
    paramString = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.jdField_a_of_type_Long;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public List<String> b(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.find(TroopAllOnlineData.class, paramString);
    localEntityManager.close();
    if (paramString == null) {
      return null;
    }
    return paramString.memberUinList;
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = (bhbc)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    } while (paramString == null);
    paramString.jdField_a_of_type_JavaUtilList = null;
    paramString.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
  }
  
  public void b(String paramString, List<String> paramList, int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = 10;
    }
    TroopAllOnlineData localTroopAllOnlineData2 = (TroopAllOnlineData)this.b.get(paramString);
    TroopAllOnlineData localTroopAllOnlineData1 = localTroopAllOnlineData2;
    if (localTroopAllOnlineData2 == null)
    {
      localTroopAllOnlineData1 = new TroopAllOnlineData();
      this.b.put(paramString, localTroopAllOnlineData1);
    }
    localTroopAllOnlineData1.troopUin = paramString;
    localTroopAllOnlineData1.memberUinList = paramList;
    localTroopAllOnlineData1.nextReqTime = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public long c(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    paramString = (TroopAllOnlineData)localEntityManager.find(TroopAllOnlineData.class, paramString);
    localEntityManager.close();
    if (paramString != null) {}
    for (long l1 = paramString.nextReqTime;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public List<String> c(String paramString)
  {
    paramString = (TroopAllOnlineData)this.b.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.memberUinList;
  }
  
  public long d(String paramString)
  {
    paramString = (TroopAllOnlineData)this.b.get(paramString);
    if (paramString != null) {}
    for (long l1 = paramString.nextReqTime;; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L) {
        l2 = NetConnInfoCenter.getServerTime();
      }
      return l2;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbe
 * JD-Core Version:    0.7.0.1
 */
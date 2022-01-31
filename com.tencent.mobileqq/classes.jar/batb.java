import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.trooponline.data.TroopAllOnlineData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;

public class batb
  implements Manager
{
  protected long a;
  protected QQAppInterface a;
  private Map<String, basz> a;
  private Map<String, TroopAllOnlineData> b = new ConcurrentHashMap();
  
  public batb(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a(String paramString)
  {
    paramString = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    paramString = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    String str = null;
    Object localObject = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (localObject != null) {
      str = ((basz)localObject).jdField_a_of_type_JavaLangString;
    }
    for (int i = ((basz)localObject).jdField_b_of_type_Int;; i = 0)
    {
      if (str == null) {
        return "";
      }
      localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).c(paramString);
      if ((localObject != null) && (((TroopInfo)localObject).wMemberNumClient > 0) && (i > ((TroopInfo)localObject).wMemberNumClient) && (!TextUtils.isEmpty(str)))
      {
        str = str.replace(String.valueOf(i), String.valueOf(((TroopInfo)localObject).wMemberNumClient));
        paramString = str;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopOnlineMemberManage", 2, String.format("getOnlineTip onlineCount: %s, memberNum: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(((TroopInfo)localObject).wMemberNumClient) }));
        return str;
      }
      return str;
    }
  }
  
  public List<bata> a(String paramString)
  {
    paramString = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    basz localbasz2 = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    basz localbasz1 = localbasz2;
    if (localbasz2 == null)
    {
      localbasz1 = new basz();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, localbasz1);
    }
    if ((i != 4) || (!TextUtils.isEmpty(paramString2)))
    {
      localbasz1.jdField_a_of_type_JavaLangString = paramString2;
      localbasz1.jdField_b_of_type_Int = paramInt3;
    }
    localbasz1.jdField_a_of_type_Long = (NetConnInfoCenter.getServerTime() + i);
    if (paramInt2 != -1) {
      localbasz1.jdField_a_of_type_Int = paramInt2;
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
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString.b(localTroopAllOnlineData);
    paramString.a();
  }
  
  public void a(String paramString1, List<bata> paramList, int paramInt1, String paramString2, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 <= 0) {
      i = 10;
    }
    basz localbasz2 = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
    basz localbasz1 = localbasz2;
    if (localbasz2 == null)
    {
      localbasz1 = new basz();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, localbasz1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      localbasz1.jdField_a_of_type_JavaLangString = paramString2;
      localbasz1.jdField_b_of_type_Int = paramInt2;
    }
    if ((paramList != null) && (paramList.size() > 0)) {
      localbasz1.jdField_a_of_type_JavaUtilList = paramList;
    }
    localbasz1.jdField_b_of_type_Long = (NetConnInfoCenter.getServerTime() + i);
  }
  
  public int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    paramString = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {}
    for (int i = paramString.jdField_b_of_type_Int;; i = 0) {
      return i;
    }
  }
  
  public long b(String paramString)
  {
    paramString = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TroopAllOnlineData)localaukn.a(TroopAllOnlineData.class, paramString);
    localaukn.a();
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
      paramString = (basz)this.jdField_a_of_type_JavaUtilMap.get(paramString);
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
    aukn localaukn = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramString = (TroopAllOnlineData)localaukn.a(TroopAllOnlineData.class, paramString);
    localaukn.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     batb
 * JD-Core Version:    0.7.0.1
 */
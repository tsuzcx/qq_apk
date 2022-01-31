import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.1;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager.2;
import com.tencent.mobileqq.troop.aioapp.data.FullListGroupAppEntity;
import com.tencent.mobileqq.troop.aioapp.data.GrayGroupAppEntity;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import mqq.manager.Manager;

public class bbmk
  implements babe, Manager
{
  private final amdu jdField_a_of_type_Amdu;
  private final bbml jdField_a_of_type_Bbml;
  private final bbmm jdField_a_of_type_Bbmm;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString = "";
  public List<TroopAIOAppInfo> a;
  final ConcurrentHashMap<Long, GrayGroupAppEntity> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  public bbmk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bbmm = new bbmm(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Bbml = new bbml(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_a_of_type_Amdu = ((amdu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20));
    this.jdField_a_of_type_JavaUtilList = new ArrayList(20);
    babd.a(this);
  }
  
  public static bbmk a(QQAppInterface paramQQAppInterface)
  {
    return (bbmk)paramQQAppInterface.getManager(196);
  }
  
  private List<TroopAIOAppInfo> a()
  {
    ArrayList localArrayList = new ArrayList(20);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  private List<TroopAIOAppInfo> a(GrayGroupAppEntity paramGrayGroupAppEntity)
  {
    ArrayList localArrayList = new ArrayList(20);
    Object localObject = paramGrayGroupAppEntity.troopAIOAppInfos;
    paramGrayGroupAppEntity = new HashSet(20);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramGrayGroupAppEntity.add(Integer.valueOf(((TroopAIOAppInfo)((Iterator)localObject).next()).appid));
    }
    localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!localTroopAIOAppInfo.isGray) {
        localArrayList.add(localTroopAIOAppInfo);
      } else if (paramGrayGroupAppEntity.contains(Integer.valueOf(localTroopAIOAppInfo.appid))) {
        localArrayList.add(localTroopAIOAppInfo);
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaLangString = "";
    b();
    a().c();
    a().b();
  }
  
  public long a(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    paramLong = TimeUnit.DAYS.toSeconds(1L);
    if (localGrayGroupAppEntity == null) {
      return paramLong;
    }
    if (localGrayGroupAppEntity.requestIntervalSecond <= 0) {
      return paramLong;
    }
    return localGrayGroupAppEntity.requestIntervalSecond;
  }
  
  public bbml a()
  {
    return this.jdField_a_of_type_Bbml;
  }
  
  public bbmm a()
  {
    return this.jdField_a_of_type_Bbmm;
  }
  
  public String a(long paramLong)
  {
    Object localObject = a(paramLong);
    if (bbmp.a((Collection)localObject)) {
      return "";
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localTroopAIOAppInfo.hashVal)) {
        return localTroopAIOAppInfo.hashVal;
      }
    }
    return "";
  }
  
  public List<TroopAIOAppInfo> a(long paramLong)
  {
    GrayGroupAppEntity localGrayGroupAppEntity = (GrayGroupAppEntity)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localGrayGroupAppEntity == null) {
      return a();
    }
    return a(localGrayGroupAppEntity);
  }
  
  public void a()
  {
    bbmp.a(new AioGroupAppsManager.1(this), 1000L);
  }
  
  public void a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(Integer.valueOf(paramInt));
    this.jdField_a_of_type_Amdu.a(localArrayList, 0);
  }
  
  public void a(long paramLong)
  {
    boolean bool = bbmo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
    if (QLog.isColorLevel()) {
      QLog.i("AioGroupAppsManager", 2, "getAppsInObserver: invoked.  needRequest: " + bool);
    }
    if (bool)
    {
      TroopInfo localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(String.valueOf(paramLong));
      if (localTroopInfo == null) {}
      for (int i = 0;; i = (int)localTroopInfo.dwGroupClassExt)
      {
        bbmo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, i);
        return;
      }
    }
    if (!bbmp.a(a(paramLong)))
    {
      bbmo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong);
      return;
    }
    bbmp.a(new AioGroupAppsManager.2(this, paramLong));
  }
  
  public void a(boolean paramBoolean)
  {
    d();
  }
  
  public void b()
  {
    String str = "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
    localEditor.putString("SP_KEY_FULL_APP_LIST_HASH" + str, this.jdField_a_of_type_JavaLangString);
    localEditor.apply();
  }
  
  public void b(int paramInt)
  {
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)localIterator.next();
      if (paramInt == localTroopAIOAppInfo.appid) {
        localTroopAIOAppInfo.redPoint = false;
      }
    }
    this.jdField_a_of_type_JavaUtilList = ((List)localObject);
    localObject = new FullListGroupAppEntity();
    ((FullListGroupAppEntity)localObject).troopAIOAppInfos = this.jdField_a_of_type_JavaUtilList;
    a().a((FullListGroupAppEntity)localObject);
  }
  
  public void c()
  {
    String str = "_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    this.jdField_a_of_type_JavaLangString = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getString("SP_KEY_FULL_APP_LIST_HASH" + str, "");
  }
  
  public void onDestroy()
  {
    babd.b(this);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmk
 * JD-Core Version:    0.7.0.1
 */
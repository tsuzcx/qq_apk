import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.2;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0xece.oidb_0xece.RspBody;

public class beua
  implements Manager
{
  protected andd a;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<Long, betz> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Integer> c = new ConcurrentHashMap();
  
  public beua(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    a();
    this.jdField_a_of_type_Andd = new beub(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Andd);
  }
  
  private static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "troop_shortcut_bar", 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new beuc(this);
    b();
  }
  
  private void a(betv parambetv, Object paramObject)
  {
    if ((parambetv == null) || (paramObject == null) || (!(paramObject instanceof Long))) {}
    long l;
    do
    {
      return;
      l = ((Long)paramObject).longValue();
    } while (parambetv.c() != l);
    parambetv.b(true);
  }
  
  private void a(boolean paramBoolean, long paramLong, Object paramObject, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopShortcutBarManager", 2, "handleGetAddTroopAppRemindInfo isSuccess:" + paramBoolean + " troopUin:" + paramLong + " errCode:" + paramInt);
    }
    if ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof oidb_0xece.RspBody))) {}
    do
    {
      do
      {
        return;
        paramObject = (oidb_0xece.RspBody)paramObject;
      } while (paramObject.busi_id.get() != 1053);
      paramObject = beue.a(paramObject);
    } while (paramObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShortcutBarManager", 2, "addRemindGrayTip tipItem" + paramObject.toString());
    }
    beue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), paramObject);
  }
  
  private void b()
  {
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.addgroupapplication");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TroopShortcutBarManager", 1, "registerMiniAppAdd exception.");
    }
  }
  
  private void c()
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TroopShortcutBarManager", 1, "unregisterMiniAppAdd exception.");
    }
  }
  
  public int a(long paramLong)
  {
    if (this.c.containsKey(Long.valueOf(paramLong))) {
      return ((Integer)this.c.get(Long.valueOf(paramLong))).intValue();
    }
    return 0;
  }
  
  public long a(long paramLong)
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(String.valueOf(paramLong), 0L);
    }
    return l;
  }
  
  public long a(String paramString)
  {
    SharedPreferences localSharedPreferences = a();
    if ((TextUtils.isEmpty(paramString)) || (localSharedPreferences == null)) {
      return 0L;
    }
    return localSharedPreferences.getLong(paramString + "_last_remind_graytip_uniseq", 0L);
  }
  
  public betz a(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return (betz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    betz localbetz = (betz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localbetz != null)
    {
      localbetz.c(0);
      localbetz.d(0);
      localbetz.a(0L);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.c.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    betz localbetz = (betz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localbetz == null) {
      return;
    }
    localbetz.a(paramInt);
    if (paramBoolean) {
      localbetz.b(paramInt);
    }
    a(true);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b.put(String.valueOf(paramLong1), Long.valueOf(paramLong2));
    ThreadManager.postImmediately(new TroopShortcutBarManager.2(this, paramLong1, paramLong2), null, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {}
    betv localbetv;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((betz)localObject).a();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localbetv = (betv)((Iterator)localObject).next();
    } while (localbetv.c() != paramLong2);
    localbetv.b(paramInt);
  }
  
  public void a(Long paramLong, betz parambetz, boolean paramBoolean, Object paramObject)
  {
    if ((parambetz == null) || (paramLong == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + String.valueOf(paramLong) + "is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + String.valueOf(paramLong));
    }
    Object localObject = (betz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    Iterator localIterator1;
    if ((localObject != null) && (!paramBoolean))
    {
      parambetz.a(((betz)localObject).b());
      localObject = ((betz)localObject).a();
      localIterator1 = parambetz.a().iterator();
    }
    while (localIterator1.hasNext())
    {
      betv localbetv1 = (betv)localIterator1.next();
      Iterator localIterator2 = ((ArrayList)localObject).iterator();
      while (localIterator2.hasNext())
      {
        betv localbetv2 = (betv)localIterator2.next();
        if (localbetv1.c() == localbetv2.c()) {
          localbetv1.b(localbetv2.b());
        }
      }
      a(localbetv1, paramObject);
      continue;
      parambetz.a(System.currentTimeMillis() + parambetz.c());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, parambetz);
    b(paramLong.longValue());
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        long l = Long.parseLong(paramString);
        if (a(l) != 0)
        {
          anca localanca = (anca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(20);
          if ((localanca != null) && ((TroopUtils.isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) || (TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))))
          {
            localanca.i(l);
            if (QLog.isColorLevel()) {
              QLog.d("TroopShortcutBarManager", 2, "reqGetAddTroopAppRemindInfo troopUin：" + l);
            }
          }
          bfdg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 101896870);
          a(l, 0);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("TroopShortcutBarManager", 1, "getAddTroopAppRemindInfo parseLong troopUin exception");
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if ((paramString.isEmpty()) || (localSharedPreferences == null)) {
      return;
    }
    localSharedPreferences.edit().putLong(paramString, paramLong).apply();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b(long paramLong)
  {
    String str = String.valueOf(paramLong);
    if (this.b.containsKey(str)) {
      return ((Long)this.b.get(str)).longValue();
    }
    paramLong = a(paramLong);
    this.b.put(str, Long.valueOf(paramLong));
    return paramLong;
  }
  
  public void b(long paramLong)
  {
    Object localObject1 = (betz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      break label21;
    }
    for (;;)
    {
      label21:
      return;
      if ((((betz)localObject1).a() != 1) && (((betz)localObject1).b() != 1))
      {
        Object localObject2 = ((betz)localObject1).a();
        if (localObject2 == null) {
          break;
        }
        if (b(paramLong) == 0L)
        {
          long l = c(paramLong);
          if (l <= b(paramLong)) {
            break;
          }
          a(paramLong, l);
          return;
        }
        paramLong = Math.max(b(paramLong), ((betz)localObject1).c());
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (betv)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (((betv)localObject2).d() > paramLong) {
              ((betv)localObject2).a(true);
            } else {
              ((betv)localObject2).a(false);
            }
          }
        }
      }
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    SharedPreferences localSharedPreferences = a();
    if ((TextUtils.isEmpty(paramString)) || (localSharedPreferences == null)) {
      return;
    }
    localSharedPreferences.edit().putLong(paramString + "_last_remind_graytip_uniseq", paramLong).apply();
  }
  
  public long c(long paramLong)
  {
    long l2 = 0L;
    Object localObject = (betz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject == null) {
      l1 = l2;
    }
    do
    {
      do
      {
        do
        {
          return l1;
          l1 = l2;
        } while (((betz)localObject).a() == 1);
        l1 = l2;
      } while (((betz)localObject).b() == 1);
      localObject = ((betz)localObject).a();
      l1 = l2;
    } while (localObject == null);
    paramLong = b(paramLong);
    localObject = ((ArrayList)localObject).iterator();
    betv localbetv;
    do
    {
      l1 = paramLong;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbetv = (betv)((Iterator)localObject).next();
    } while (localbetv == null);
    long l1 = localbetv.d();
    if (l1 > paramLong) {
      paramLong = l1;
    }
    for (;;)
    {
      break;
    }
  }
  
  public void onDestroy()
  {
    c();
    if (this.jdField_a_of_type_Andd != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Andd);
    }
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beua
 * JD-Core Version:    0.7.0.1
 */
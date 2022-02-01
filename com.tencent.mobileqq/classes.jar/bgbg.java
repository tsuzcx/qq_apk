import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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

public class bgbg
  implements Manager
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  protected aofu a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<Long, bgbf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  private ConcurrentHashMap<Long, Integer> c = new ConcurrentHashMap();
  
  public bgbg(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    a();
    this.jdField_a_of_type_Aofu = new bgbh(this);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  private static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "troop_shortcut_bar", 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bgbi(this);
    b();
  }
  
  private void a(bgbb parambgbb, Object paramObject)
  {
    if ((parambgbb == null) || (paramObject == null) || (!(paramObject instanceof Long))) {}
    long l;
    do
    {
      return;
      l = ((Long)paramObject).longValue();
    } while (parambgbb.b() != l);
    parambgbb.c(true);
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
      paramObject = bgbk.a(paramObject);
    } while (paramObject == null);
    if (QLog.isColorLevel()) {
      QLog.d("TroopShortcutBarManager", 2, "addRemindGrayTip tipItem" + paramObject.toString());
    }
    bgbk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramLong), paramObject);
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
  
  public bgbf a(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return (bgbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    bgbf localbgbf = (bgbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localbgbf != null)
    {
      localbgbf.c(0);
      localbgbf.d(0);
      localbgbf.a(0L);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.c.put(Long.valueOf(paramLong), Integer.valueOf(paramInt));
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    bgbf localbgbf = (bgbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localbgbf == null) {
      return;
    }
    localbgbf.a(paramInt);
    if (paramBoolean) {
      localbgbf.b(paramInt);
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
    bgbb localbgbb;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((bgbf)localObject).a();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localbgbb = (bgbb)((Iterator)localObject).next();
    } while (localbgbb.b() != paramLong2);
    localbgbb.b(paramInt);
  }
  
  public void a(Long paramLong, bgbf parambgbf, boolean paramBoolean, Object paramObject)
  {
    if ((parambgbf == null) || (paramLong == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + String.valueOf(paramLong) + "is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + String.valueOf(paramLong));
    }
    Object localObject = (bgbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    Iterator localIterator1;
    if ((localObject != null) && (!paramBoolean))
    {
      parambgbf.a(((bgbf)localObject).b());
      localObject = ((bgbf)localObject).a();
      localIterator1 = parambgbf.a().iterator();
    }
    while (localIterator1.hasNext())
    {
      bgbb localbgbb1 = (bgbb)localIterator1.next();
      Iterator localIterator2 = ((ArrayList)localObject).iterator();
      while (localIterator2.hasNext())
      {
        bgbb localbgbb2 = (bgbb)localIterator2.next();
        if (localbgbb1.b() == localbgbb2.b()) {
          localbgbb1.b(localbgbb2.c());
        }
      }
      a(localbgbb1, paramObject);
      continue;
      parambgbf.a(System.currentTimeMillis() + parambgbf.c());
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, parambgbf);
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
          aoep localaoep = (aoep)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
          if ((localaoep != null) && ((TroopUtils.isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) || (TroopUtils.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))))
          {
            localaoep.i(l);
            if (QLog.isColorLevel()) {
              QLog.d("TroopShortcutBarManager", 2, "reqGetAddTroopAppRemindInfo troopUin：" + l);
            }
          }
          bglm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 101896870);
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
    Object localObject1 = (bgbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      break label21;
    }
    for (;;)
    {
      label21:
      return;
      if ((((bgbf)localObject1).a() != 1) && (((bgbf)localObject1).b() != 1))
      {
        Object localObject2 = ((bgbf)localObject1).a();
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
        paramLong = Math.max(b(paramLong), ((bgbf)localObject1).c());
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bgbb)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (((bgbb)localObject2).c() > paramLong) {
              ((bgbb)localObject2).b(true);
            } else {
              ((bgbb)localObject2).b(false);
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
    Object localObject = (bgbf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
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
        } while (((bgbf)localObject).a() == 1);
        l1 = l2;
      } while (((bgbf)localObject).b() == 1);
      localObject = ((bgbf)localObject).a();
      l1 = l2;
    } while (localObject == null);
    paramLong = b(paramLong);
    localObject = ((ArrayList)localObject).iterator();
    bgbb localbgbb;
    do
    {
      l1 = paramLong;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbgbb = (bgbb)((Iterator)localObject).next();
    } while (localbgbb == null);
    long l1 = localbgbb.c();
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
    if (this.jdField_a_of_type_Aofu != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
    }
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbg
 * JD-Core Version:    0.7.0.1
 */
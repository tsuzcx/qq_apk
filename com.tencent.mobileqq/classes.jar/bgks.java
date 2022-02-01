import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class bgks
  implements Manager
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ConcurrentHashMap<Long, bgkr> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  
  public bgks(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b.clear();
    a();
  }
  
  private static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "troop_shortcut_bar", 0);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new bgkt(this);
    b();
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
  
  public long a(long paramLong)
  {
    long l = 0L;
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(String.valueOf(paramLong), 0L);
    }
    return l;
  }
  
  public bgkr a(Long paramLong)
  {
    if (paramLong == null) {
      return null;
    }
    return (bgkr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
  }
  
  public void a(long paramLong)
  {
    bgkr localbgkr = (bgkr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localbgkr != null)
    {
      localbgkr.c(0);
      localbgkr.d(0);
      localbgkr.a(0L);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    bgkr localbgkr = (bgkr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localbgkr == null) {
      return;
    }
    localbgkr.a(paramInt);
    if (paramBoolean) {
      localbgkr.b(paramInt);
    }
    a(true);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.b.put(String.valueOf(paramLong1), Long.valueOf(paramLong2));
    ThreadManager.postImmediately(new TroopShortcutBarManager.1(this, paramLong1, paramLong2), null, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {}
    bgkn localbgkn;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((bgkr)localObject).a();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localbgkn = (bgkn)((Iterator)localObject).next();
    } while (localbgkn.c() != paramLong2);
    localbgkn.b(paramInt);
  }
  
  public void a(Long paramLong, bgkr parambgkr, boolean paramBoolean)
  {
    if ((parambgkr == null) || (paramLong == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + String.valueOf(paramLong) + "is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopShortcutBarManager", 2, "addTroopInfoToAIOCache. troopCode:" + String.valueOf(paramLong));
    }
    Object localObject = (bgkr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramLong);
    Iterator localIterator1;
    if ((localObject != null) && (!paramBoolean))
    {
      parambgkr.a(((bgkr)localObject).b());
      localObject = ((bgkr)localObject).a();
      localIterator1 = parambgkr.a().iterator();
    }
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        bgkn localbgkn1 = (bgkn)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        if (localIterator2.hasNext())
        {
          bgkn localbgkn2 = (bgkn)localIterator2.next();
          if (localbgkn1.c() != localbgkn2.c()) {
            break;
          }
          localbgkn1.b(localbgkn2.b());
          continue;
          parambgkr.a(System.currentTimeMillis() + parambgkr.c());
        }
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramLong, parambgkr);
    b(paramLong.longValue());
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
    Object localObject1 = (bgkr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject1 == null) {
      break label21;
    }
    for (;;)
    {
      label21:
      return;
      if ((((bgkr)localObject1).a() != 1) && (((bgkr)localObject1).b() != 1))
      {
        Object localObject2 = ((bgkr)localObject1).a();
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
        paramLong = Math.max(b(paramLong), ((bgkr)localObject1).c());
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (bgkn)((Iterator)localObject1).next();
          if (localObject2 != null) {
            if (((bgkn)localObject2).d() > paramLong) {
              ((bgkn)localObject2).a(true);
            } else {
              ((bgkn)localObject2).a(false);
            }
          }
        }
      }
    }
  }
  
  public long c(long paramLong)
  {
    long l2 = 0L;
    Object localObject = (bgkr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
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
        } while (((bgkr)localObject).a() == 1);
        l1 = l2;
      } while (((bgkr)localObject).b() == 1);
      localObject = ((bgkr)localObject).a();
      l1 = l2;
    } while (localObject == null);
    paramLong = b(paramLong);
    localObject = ((ArrayList)localObject).iterator();
    bgkn localbgkn;
    do
    {
      l1 = paramLong;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbgkn = (bgkn)((Iterator)localObject).next();
    } while (localbgkn == null);
    long l1 = localbgkn.d();
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgks
 * JD-Core Version:    0.7.0.1
 */
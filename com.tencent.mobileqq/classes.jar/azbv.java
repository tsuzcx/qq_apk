import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager.2;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager.4;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;

public class azbv
  implements Handler.Callback, anug, azdn, Manager
{
  private long jdField_a_of_type_Long;
  private azbc jdField_a_of_type_Azbc;
  private azco jdField_a_of_type_Azco;
  private azfc jdField_a_of_type_Azfc;
  bdvp jdField_a_of_type_Bdvp = new azbx(this);
  private final BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new OnlineStatusManager.2(this);
  private ConcurrentHashMap<String, azfd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  private boolean jdField_a_of_type_Boolean;
  Runnable b = new OnlineStatusManager.4(this);
  
  public azbv(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Azco = new azco(paramQQAppInterface);
    this.jdField_a_of_type_Azbc = new azbc();
    anue.a().a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = new azbw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    bdvn.a(this.jdField_a_of_type_Bdvp);
  }
  
  private long a(long paramLong)
  {
    long l = 1800L;
    if (paramLong == 1000L)
    {
      paramLong = this.jdField_a_of_type_Azbc.a(1000);
      l = paramLong;
      if (paramLong == 0L) {
        l = 300L;
      }
    }
    return l;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning()))
    {
      if (QLog.isColorLevel()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label54;
        }
      }
      label54:
      for (Object localObject = "null";; localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning()))
      {
        QLog.d("OnlineStatusManager", 2, new Object[] { "checkAppValid app.isRunning=", localObject });
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(paramQQAppInterface.getCurrentUin());
    if (paramQQAppInterface == null) {
      return true;
    }
    if (paramLong - paramQQAppInterface.weatherUpdateTime > 3600L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public azbc a()
  {
    return this.jdField_a_of_type_Azbc;
  }
  
  public azco a()
  {
    return this.jdField_a_of_type_Azco;
  }
  
  public void a()
  {
    if (!a()) {
      return;
    }
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.b);
      this.jdField_a_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "onRunningForground");
      }
    }
    this.jdField_a_of_type_Azco.c("ForeBackgroundSwitch");
  }
  
  public void a(int paramInt)
  {
    a(paramInt, new Intent());
  }
  
  public void a(int paramInt1, double paramDouble1, double paramDouble2, String paramString1, String paramString2, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 0) {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "retCode：", Integer.valueOf(paramInt1) });
      }
    }
    boolean bool;
    do
    {
      return;
      bool = false;
      if (azfc.a(this.jdField_a_of_type_Azfc, paramDouble1, paramDouble2, paramString1))
      {
        this.jdField_a_of_type_Azfc = new azfc(paramDouble1, paramDouble2, paramString2, paramString1);
        bool = true;
      }
    } while (this.jdField_a_of_type_Azfc == null);
    a(paramInt2, this.jdField_a_of_type_Azfc, paramIntent, bool);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendLocationInfo type:", Integer.valueOf(paramInt) });
    }
    if (a(paramInt)) {
      azdk.a(paramInt, paramIntent, this);
    }
  }
  
  void a(int paramInt, azfc paramazfc, Intent paramIntent, boolean paramBoolean)
  {
    int j = 0;
    ArrayList localArrayList;
    if ((paramBoolean) || (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, NetConnInfoCenter.getServerTime())) || (paramInt == 9))
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "gotoNextStep type：", Integer.valueOf(paramInt), " isLocationChange:", Boolean.valueOf(paramBoolean) });
      }
      localArrayList = new ArrayList(2);
      localArrayList.add(Integer.valueOf(1));
      localArrayList.add(Integer.valueOf(10));
    }
    try
    {
      i = Integer.valueOf(paramazfc.c).intValue();
      azgl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, i, paramInt, paramIntent.getExtras());
      return;
    }
    catch (NumberFormatException paramazfc)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("OnlineStatusManager", 4, "handleFetchWeatherInfo numberFormat", paramazfc);
          i = j;
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 40000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "[status][autoMgr] handleExtStatusChanged startDetector: " + paramLong);
      }
      if (((azcb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a()) {
        this.jdField_a_of_type_Azco.a("onlinePush", true);
      }
    }
    for (;;)
    {
      a(bdvn.a());
      return;
      azcf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 40001L, false, true);
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "[status][autoMgr] handleExtStatusChanged stopDetector: " + paramLong);
      }
      this.jdField_a_of_type_Azco.b("onlinePush");
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Azbc.b((int)paramLong1, paramLong2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Bdvp.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush succ:", Boolean.valueOf(paramBoolean), " mSyncPause:", Boolean.valueOf(this.jdField_a_of_type_Boolean) });
    }
    long l;
    if ((paramBoolean) && (paramStatus == AppRuntime.Status.online))
    {
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
      paramStatus = (azff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ONLINE_STATUS_HANDLER);
      if (l != 1000L) {
        break label139;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setPowerConnect(azbj.c());
        paramStatus.a(1, azbj.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true), null);
        a(l);
        c();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("OnlineStatusManager", 1, "registerPush t:", localThrowable);
        continue;
      }
      label139:
      if ((l == 1030L) && (!this.jdField_a_of_type_Boolean))
      {
        a(6);
      }
      else if (l == 1040L)
      {
        paramStatus = azeu.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (TextUtils.isEmpty(paramStatus))
        {
          ((anri)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          this.jdField_a_of_type_Long = bhaa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).lBirthday;
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (星座不存在，那么执行一次资料拉取，在资料回调中拉取运势)", " mSelfCurrentBirthday: ", Long.valueOf(this.jdField_a_of_type_Long) });
          }
        }
        else
        {
          String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          paramBoolean = TextUtils.isEmpty(azeu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
          if (paramBoolean) {
            azbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStatus);
          }
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. (注册上线时，星座资料不空，但运势为空，那么执行一次运势拉取逻辑)", " emptyTrend: ", Boolean.valueOf(paramBoolean) });
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 6) || (paramInt == 7) || (paramInt == 8) || (paramInt == 9);
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackgroundStop))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.b);
      ThreadManager.getSubThreadHandler().post(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "onRunningBackground");
      }
    }
    this.jdField_a_of_type_Azco.d("ForeBackgroundSwitch");
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    azff localazff = (azff)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ONLINE_STATUS_HANDLER);
    Object localObject = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    Bundle localBundle = azbj.a().a((Friends)localObject);
    localBundle.putBoolean("from_need_update_delay_time", true);
    if ((7 == paramInt) && (this.jdField_a_of_type_Azbc.a(1030))) {
      localazff.a(3, localBundle);
    }
    do
    {
      return;
      if (6 == paramInt)
      {
        localBundle.putBoolean("from_register", true);
        localazff.a(3, localBundle, null);
        return;
      }
    } while (8 != paramInt);
    if (paramIntent.hasExtra("online_status_permission_item")) {}
    for (localObject = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");; localObject = null)
    {
      localBundle.putBoolean("from_modify", paramIntent.getBooleanExtra("from_modify", false));
      localBundle.putBoolean("from_register", false);
      localazff.a(3, localBundle, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong > 40001L)
    {
      localarci = (arci)aqxe.a().a(652);
      localArrayList = new ArrayList();
      if (localarci.a.jdField_a_of_type_JavaUtilList != null)
      {
        localIterator = localarci.a.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Long.valueOf(((azeo)localIterator.next()).jdField_a_of_type_Long));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked.  [status][reset-default]", " configIds: ", localArrayList, " extStatus: ", Long.valueOf(paramLong) });
      }
      if ((!localArrayList.isEmpty()) && (localarci.a()) && (!localArrayList.contains(Long.valueOf(paramLong))))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, 0L, true);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusManager", 2, "resetWhenAutoStatusItemRemoved: invoked. [status][reset-default] finish. ");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      arci localarci;
      ArrayList localArrayList;
      Iterator localIterator;
      return;
    }
    QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked. [status][reset-default] no need reset", " extStatus: ", Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label56;
        }
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask app.isRunning=", localObject });
      }
    }
    label56:
    long l1;
    label201:
    do
    {
      long l2;
      do
      {
        return;
        localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
        break;
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatusNonSync();
        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
        if ((localObject != AppRuntime.Status.online) || ((l1 != 1000L) && (l1 != 1030L) && (l1 != 1040L))) {
          break label201;
        }
        ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
        l2 = a(l1);
        ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L * l2);
      } while (!QLog.isColorLevel());
      QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask schedule msgTimer after ", Long.valueOf(l2), " seconds", " extStatus: ", Long.valueOf(l1) });
      return;
      d();
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, new Object[] { "launchTimedMsgTask cancel status", localObject, " extStatus:", Long.valueOf(l1) });
  }
  
  public void c(long paramLong)
  {
    arci localarci = (arci)aqxe.a().a(652);
    azbu localazbu = localarci.a.jdField_a_of_type_Azbu;
    if ((localazbu != null) && (localazbu.jdField_a_of_type_Long == 0L) && (localarci.a()) && (paramLong > 40000L))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, 0L, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusEntranceRemoved: invoked. [status][reset-default] finish. ", " item: ", localazbu });
      }
    }
  }
  
  public void d()
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break label44;
        }
        localObject = "null";
        QLog.d("OnlineStatusManager", 2, new Object[] { "cancelTimedMsgTask app.isRunning=", localObject });
      }
    }
    label44:
    do
    {
      return;
      localObject = Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning());
      break;
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    } while (!QLog.isColorLevel());
    QLog.d("OnlineStatusManager", 2, "cancelTimedMsgTask");
  }
  
  public void d(long paramLong)
  {
    Object localObject2 = null;
    ArrayList localArrayList = null;
    Object localObject1;
    if ((paramLong > 0L) && (paramLong < 40000L))
    {
      localObject1 = azbj.a().a();
      if (localObject1 != null)
      {
        localArrayList = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Long.valueOf(((azbu)((Iterator)localObject1).next()).jdField_a_of_type_Long));
        }
      }
      localObject1 = localArrayList;
      if (localArrayList != null)
      {
        localObject1 = localArrayList;
        if (!localArrayList.isEmpty())
        {
          localObject1 = localArrayList;
          if (!localArrayList.contains(Long.valueOf(paramLong)))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, 0L, true);
            localObject1 = localArrayList;
            if (QLog.isColorLevel())
            {
              QLog.d("OnlineStatusManager", 2, "resetWhenStatusConfigRemoved: invoked. [status][reset-default] finish. ");
              localObject1 = localArrayList;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenStatusConfigRemoved: invoked. [status][reset-default] ", " configIds: ", localObject1, " extStatus: ", Long.valueOf(paramLong) });
      }
      return;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenStatusConfigRemoved: invoked. [status][reset-default] no need reset", " extStatus: ", Long.valueOf(paramLong) });
        localObject1 = localObject2;
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onDestroy()
  {
    d();
    anue.a().b(this);
    this.jdField_a_of_type_Azco.a();
    this.jdField_a_of_type_Azbc.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    bdvn.b(this.jdField_a_of_type_Bdvp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azbv
 * JD-Core Version:    0.7.0.1
 */
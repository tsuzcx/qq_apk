import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager.2;
import com.tencent.mobileqq.onlinestatus.OnlineStatusManager.3;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class aypj
  implements Handler.Callback, anlo, ayra, aysy, Manager
{
  private long jdField_a_of_type_Long;
  private final anil jdField_a_of_type_Anil;
  private ayoq jdField_a_of_type_Ayoq;
  private ayqb jdField_a_of_type_Ayqb;
  private aysp jdField_a_of_type_Aysp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new OnlineStatusManager.2(this);
  private ConcurrentHashMap<String, aysq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(10);
  private boolean jdField_a_of_type_Boolean;
  Runnable b = new OnlineStatusManager.3(this);
  
  public aypj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Ayqb = new ayqb(paramQQAppInterface);
    this.jdField_a_of_type_Ayoq = new ayoq();
    anlm.a().a(this);
    this.jdField_a_of_type_Anil = new aypk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anil);
  }
  
  private long a(long paramLong)
  {
    long l = 1800L;
    if (paramLong == 1000L)
    {
      paramLong = this.jdField_a_of_type_Ayoq.a(1000);
      l = paramLong;
      if (paramLong == 0L) {
        l = 300L;
      }
    }
    return l;
  }
  
  private void a(int paramInt, aysp paramaysp, Intent paramIntent)
  {
    OnlineStatusPermissionChecker.OnlineStatusPermissionItem localOnlineStatusPermissionItem = null;
    Bundle localBundle = ayox.a().a(paramaysp);
    localBundle.getByteArray("LocationInfo");
    ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    ayta localayta = (ayta)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(174);
    if (3 == paramInt) {
      localayta.a(2, localBundle);
    }
    do
    {
      return;
      if (2 == paramInt)
      {
        localayta.a(2, ayox.a().a(paramaysp, true), null);
        return;
      }
      if (4 == paramInt)
      {
        if (paramIntent.hasExtra("online_status_permission_item")) {
          localOnlineStatusPermissionItem = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");
        }
        localayta.a(2, ayox.a().a(paramaysp, false), localOnlineStatusPermissionItem);
        return;
      }
    } while (5 != paramInt);
    localayta.notifyUI(6, true, null);
  }
  
  private void a(int paramInt, aysp paramaysp, Intent paramIntent, boolean paramBoolean)
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
      i = Integer.valueOf(paramaysp.c).intValue();
      ayue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, i, paramInt, paramIntent.getExtras());
      return;
    }
    catch (NumberFormatException paramaysp)
    {
      for (;;)
      {
        int i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("OnlineStatusManager", 4, "handleFetchWeatherInfo numberFormat", paramaysp);
          i = j;
        }
      }
    }
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
    paramQQAppInterface = ((anmw)paramQQAppInterface.getManager(51)).d(paramQQAppInterface.c());
    if (paramQQAppInterface == null) {
      return true;
    }
    if (paramLong - paramQQAppInterface.weatherUpdateTime > 3600L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public ayoq a()
  {
    return this.jdField_a_of_type_Ayoq;
  }
  
  public ayqb a()
  {
    return this.jdField_a_of_type_Ayqb;
  }
  
  public aysq a(String paramString)
  {
    aysq localaysq2 = (aysq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    aysq localaysq1 = localaysq2;
    if (localaysq2 == null)
    {
      localaysq1 = new aysq(paramString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localaysq1);
    }
    return localaysq1;
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
    this.jdField_a_of_type_Ayqb.c("ForeBackgroundSwitch");
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
      if (aysp.a(this.jdField_a_of_type_Aysp, paramDouble1, paramDouble2, paramString1))
      {
        this.jdField_a_of_type_Aysp = new aysp(paramDouble1, paramDouble2, paramString2, paramString1);
        bool = true;
      }
    } while (this.jdField_a_of_type_Aysp == null);
    a(paramInt2, this.jdField_a_of_type_Aysp, paramIntent, bool);
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendLocationInfo type:", Integer.valueOf(paramInt) });
    }
    if (a(paramInt))
    {
      ayqx.a(paramInt, paramIntent, this);
      return;
    }
    SosoInterface.a(new aysw(paramInt, paramIntent, this));
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 40000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "[status][autoMgr] handleExtStatusChanged startDetector: " + paramLong);
      }
      if (((aypo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370)).a())
      {
        this.jdField_a_of_type_Ayqb.a("onlinePush", true);
        return;
      }
      ayps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 40001L, false, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, "[status][autoMgr] handleExtStatusChanged stopDetector: " + paramLong);
    }
    this.jdField_a_of_type_Ayqb.b("onlinePush");
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Ayoq.b((int)paramLong1, paramLong2);
  }
  
  public void a(JSONObject paramJSONObject, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      if (paramJSONObject == null)
      {
        localObject1 = "";
        QLog.d("OnlineStatusManager", 2, new Object[] { "retCode：", Integer.valueOf(paramInt1), " result:", localObject1 });
      }
    }
    else {
      if (paramJSONObject != null) {
        break label63;
      }
    }
    for (;;)
    {
      return;
      localObject1 = paramJSONObject.toString();
      break;
      label63:
      localObject1 = "";
      try
      {
        if (paramJSONObject.getInt("status") == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder(10);
          JSONObject localJSONObject = paramJSONObject.optJSONObject("result");
          Object localObject2 = localObject1;
          if (localJSONObject != null)
          {
            paramJSONObject = localJSONObject.optJSONObject("address_component");
            if (paramJSONObject != null) {
              localStringBuilder.append(paramJSONObject.optString("district"));
            }
            localObject2 = localJSONObject.optJSONObject("ad_info");
            paramJSONObject = (JSONObject)localObject1;
            if (localObject2 != null) {
              paramJSONObject = ((JSONObject)localObject2).optString("adcode");
            }
            localObject1 = localJSONObject.optJSONObject("address_reference");
            localObject2 = paramJSONObject;
            if (localObject1 != null)
            {
              localObject1 = ((JSONObject)localObject1).optJSONObject("landmark_l2");
              localObject2 = paramJSONObject;
              if (localObject1 != null)
              {
                localStringBuilder.append(((JSONObject)localObject1).optString("title"));
                localObject2 = paramJSONObject;
              }
            }
          }
          if (aysp.a(this.jdField_a_of_type_Aysp, paramDouble1, paramDouble2, (String)localObject2)) {
            this.jdField_a_of_type_Aysp = new aysp(paramDouble1, paramDouble2, localStringBuilder.toString(), (String)localObject2);
          }
          if (this.jdField_a_of_type_Aysp != null)
          {
            a(paramInt2, this.jdField_a_of_type_Aysp, paramIntent);
            return;
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("OnlineStatusManager", 2, paramJSONObject.toString());
      }
    }
  }
  
  public void a(boolean paramBoolean, AppRuntime.Status paramStatus)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush succ:", Boolean.valueOf(paramBoolean) });
    }
    long l;
    if ((paramBoolean) && (paramStatus == AppRuntime.Status.online))
    {
      l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
      paramStatus = (ayta)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(174);
      if (l != 1000L) {
        break label123;
      }
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setPowerConnect(ayox.c());
        paramStatus.a(1, ayox.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true), null);
        a(l);
        c();
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("OnlineStatusManager", 1, "registerPush t:", localThrowable);
        continue;
      }
      label123:
      if (l == 1030L)
      {
        a(6);
      }
      else if (l == 1040L)
      {
        paramStatus = aysh.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (TextUtils.isEmpty(paramStatus))
        {
          ((anip)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0, 0L, (byte)1, 0L, 0L, null, "", 0L, 10004, null, (byte)0);
          this.jdField_a_of_type_Long = bghy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).lBirthday;
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusManager", 2, new Object[] { "sendBussinessInfoRegisterPush: invoked. [constellation] (星座不存在，那么执行一次资料拉取，在资料回调中拉取运势)", " mSelfCurrentBirthday: ", Long.valueOf(this.jdField_a_of_type_Long) });
          }
        }
        else
        {
          String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          paramBoolean = TextUtils.isEmpty(aysh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
          if (paramBoolean) {
            ayph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramStatus);
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
    if ((localStatus == AppRuntime.Status.online) && (l == 1030L) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop))
    {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.b);
      ThreadManager.getSubThreadHandler().postDelayed(this.b, 60000L);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, "onRunningBackground");
      }
    }
    this.jdField_a_of_type_Ayqb.d("ForeBackgroundSwitch");
  }
  
  public void b(int paramInt, Intent paramIntent)
  {
    ayta localayta = (ayta)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(174);
    Object localObject = ((anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    Bundle localBundle = ayox.a().a((Friends)localObject);
    localBundle.putBoolean("from_need_update_delay_time", true);
    if ((7 == paramInt) && (this.jdField_a_of_type_Ayoq.a(1030))) {
      localayta.a(3, localBundle);
    }
    do
    {
      return;
      if (6 == paramInt)
      {
        localBundle.putBoolean("from_register", true);
        localayta.a(3, localBundle, null);
        return;
      }
    } while (8 != paramInt);
    if (paramIntent.hasExtra("online_status_permission_item")) {}
    for (localObject = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramIntent.getSerializableExtra("online_status_permission_item");; localObject = null)
    {
      localBundle.putBoolean("from_modify", paramIntent.getBooleanExtra("from_modify", false));
      localBundle.putBoolean("from_register", false);
      localayta.a(3, localBundle, (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)localObject);
      return;
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong > 40001L)
    {
      localaqqh = (aqqh)aqlk.a().a(652);
      localArrayList = new ArrayList();
      if (localaqqh.a.jdField_a_of_type_JavaUtilList != null)
      {
        localIterator = localaqqh.a.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext()) {
          localArrayList.add(Long.valueOf(((aysb)localIterator.next()).jdField_a_of_type_Long));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusItemRemoved: invoked.  [status][reset-default]", " configIds: ", localArrayList, " extStatus: ", Long.valueOf(paramLong) });
      }
      if ((!localArrayList.isEmpty()) && (localaqqh.a()) && (!localArrayList.contains(Long.valueOf(paramLong))))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(AppRuntime.Status.online, 0L, true);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusManager", 2, "resetWhenAutoStatusItemRemoved: invoked. [status][reset-default] finish. ");
        }
      }
    }
    while (!QLog.isColorLevel())
    {
      aqqh localaqqh;
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
    aqqh localaqqh = (aqqh)aqlk.a().a(652);
    aypi localaypi = localaqqh.a.jdField_a_of_type_Aypi;
    if ((localaypi != null) && (localaypi.jdField_a_of_type_Long == 0L) && (localaqqh.a()) && (paramLong > 40000L))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(AppRuntime.Status.online, 0L, true);
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusManager", 2, new Object[] { "resetWhenAutoStatusEntranceRemoved: invoked. [status][reset-default] finish. ", " item: ", localaypi });
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
      localObject1 = ayox.a().a();
      if (localObject1 != null)
      {
        localArrayList = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localArrayList.add(Long.valueOf(((aypi)((Iterator)localObject1).next()).jdField_a_of_type_Long));
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
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(AppRuntime.Status.online, 0L, true);
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
    anlm.a().b(this);
    this.jdField_a_of_type_Ayqb.a();
    this.jdField_a_of_type_Ayoq.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anil);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aypj
 * JD-Core Version:    0.7.0.1
 */
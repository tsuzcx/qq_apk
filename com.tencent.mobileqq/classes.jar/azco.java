import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.1;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.3;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.4;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusConfirmFragment;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class azco
{
  private volatile long jdField_a_of_type_Long = azcv.c;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
  private azby jdField_a_of_type_Azby = new azcq(this);
  private azce jdField_a_of_type_Azce = new azcr(this);
  private azcn jdField_a_of_type_Azcn = new azcn(40001);
  private azcs jdField_a_of_type_Azcs;
  private azcu jdField_a_of_type_Azcu = new azcu(null);
  private azcy jdField_a_of_type_Azcy;
  private azdg jdField_a_of_type_Azdg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new AutoStatusManager.3(this);
  private volatile boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private Runnable jdField_b_of_type_JavaLangRunnable = new AutoStatusManager.1(this);
  
  public azco(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] AutoStatusManager() called");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    e();
    this.jdField_a_of_type_Azcy = new azcy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Azdg = new azdg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new azcp(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Azce);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Azby);
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("android.intent.action.SCREEN_OFF");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Azcu, paramQQAppInterface);
  }
  
  @NotNull
  public static Intent a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int i = 1;
    Intent localIntent = new Intent();
    localIntent.putExtra("ext_status", paramLong);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (ayof.a(paramQQAppInterface)) {}
    for (;;)
    {
      localIntent.putExtra("is_background", i);
      localIntent.setClass(paramQQAppInterface.getApp(), PublicTransFragmentActivity.class);
      localIntent.putExtra("public_fragment_class", AutoStatusConfirmFragment.class.getName());
      return localIntent;
      i = 0;
    }
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 != paramInt1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus status changed cur: " + azcv.a(paramInt2) + " last: " + azcv.a(paramInt1));
      }
      if (this.jdField_a_of_type_Azcs != null) {
        this.jdField_a_of_type_Azcs.a(paramInt2);
      }
      if (paramInt2 == 40001) {
        if (paramLong > 40001L) {
          if (a(true)) {
            this.jdField_a_of_type_Azcn.a(paramInt2);
          }
        }
      }
    }
    do
    {
      azeo localazeo;
      do
      {
        return;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        c();
        this.jdField_a_of_type_Azcn.a(paramInt2);
        return;
        this.jdField_a_of_type_Azcn.a(paramInt2);
        localazeo = azcv.a(paramInt2);
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus getAutoStringById : " + localazeo);
        }
      } while (localazeo == null);
      a(localazeo);
      return;
      if (paramLong != 40001L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoStatusManager", 2, new Object[] { "updateAutoStatus: invoked. [status-time] (真实在线状态命中了40001，不允许上报时间信息，如果后续超时自动重置，也不用上报)", " actionStatus: ", Integer.valueOf(paramInt3) });
    return;
    azev.a.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, azev.a.a(), paramInt2);
  }
  
  private void a(azeo paramazeo)
  {
    int i = (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if (i == paramazeo.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips fail status : " + paramazeo + " real: " + i);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips success status : " + paramazeo + " real: " + i);
    }
    if (i > 40001)
    {
      boolean bool = a(i);
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips real statusChanged: " + bool + " real: " + azcv.a(i));
      }
      if (bool) {
        a(false);
      }
    }
    if ((BaseActivity.mAppForground) && (a()))
    {
      b(paramazeo);
      c();
      return;
    }
    b(paramazeo);
    c(paramazeo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr][banner] hideBanner");
    }
    paramQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1074);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, boolean paramBoolean, @NonNull String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] submitStatus " + paramString + " status: " + azcv.a((int)paramLong) + " auto: " + paramBoolean);
    }
    a(paramQQAppInterface);
    c();
    if (paramLong != 40001L) {
      azev.a.a(paramQQAppInterface, azev.a.a(), (int)paramLong);
    }
    paramQQAppInterface.updateOnlineStatus(AppRuntime.Status.online, paramLong, paramBoolean);
    if (azcv.a(paramLong)) {
      ((azbv)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.ONLINE_STATUS_MANAGER)).a().jdField_a_of_type_Azdg.a(paramLong);
    }
  }
  
  private boolean a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof SplashActivity))
    {
      localObject = (SplashActivity)localObject;
      return (SplashActivity.a == 1) && (((SplashActivity)localObject).a() == MainFragment.b);
    }
    return false;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Azcy.a()) {}
    for (;;)
    {
      return false;
      if (paramInt != this.jdField_a_of_type_Azdg.d())
      {
        if (azcv.b) {}
        for (int i = this.jdField_a_of_type_Azdg.b(); paramInt != i; i = this.jdField_a_of_type_Azdg.c()) {
          return true;
        }
      }
    }
  }
  
  private void b(azeo paramazeo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr][banner] showBanner status : " + paramazeo);
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    Message localMessage = new Message();
    localMessage.what = 1075;
    localMessage.obj = paramazeo;
    localMqqHandler.sendMessage(localMessage);
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] hidePush");
    }
    ThreadManagerV2.getUIHandlerV2().post(new AutoStatusManager.4());
  }
  
  private void c(azeo paramazeo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] showPush status : " + paramazeo + " at " + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
    }
    Intent localIntent = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazeo.jdField_a_of_type_Long);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    localBuilder.setContentText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690272), new Object[] { paramazeo.b })).setWhen(System.currentTimeMillis()).setSmallIcon(2130841445).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, localIntent, 134217728));
    paramazeo = localBuilder.build();
    QQNotificationManager.addChannelIfNeed(paramazeo, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("AutoStatusManager", 3000530, paramazeo);
    if (ayof.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      azcl.a("0X800AFA2", 1);
      return;
    }
    azcl.a("0X800AFA1", 1);
  }
  
  private void d()
  {
    int m = 40001;
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    int n = a();
    if (QLog.isColorLevel()) {
      QLog.w("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus last status: " + azcv.a(n) + " real status: " + azcv.a((int)l));
    }
    if (l < 40000L)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus [user submit no auto status] stopDetector. last status: " + azcv.a(n) + " real status: " + azcv.a((int)l));
      }
      b("updateStatus");
      return;
    }
    int k = this.jdField_a_of_type_Azcy.a();
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus actionStatus: " + azcv.a(k) + " enable: " + azcv.a.contains(Integer.valueOf(k)));
    }
    int i;
    if ((k > 40001) && (azcv.a.contains(Integer.valueOf(k))))
    {
      i = k;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus result: " + azcv.a(i) + " enable: " + azcv.a.contains(Integer.valueOf(i)));
      }
      if ((i <= 40001) || (azcv.a.contains(Integer.valueOf(i)))) {
        break label676;
      }
      j = m;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus detected disabled cur status: " + azcv.a(i));
      }
    }
    label676:
    for (int j = m;; j = i)
    {
      a(l, n, j, k);
      return;
      if (azcv.b)
      {
        j = this.jdField_a_of_type_Azdg.b();
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus getNewMovementStatus: " + azcv.a(j) + " enable: " + azcv.a.contains(Integer.valueOf(j)));
        }
        if (j > 40001)
        {
          i = j;
          if (azcv.a.contains(Integer.valueOf(j))) {
            break;
          }
        }
        j = this.jdField_a_of_type_Azdg.d();
        i = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus categoryStatus: " + azcv.a(j) + " enable: " + azcv.a.contains(Integer.valueOf(j)));
        i = j;
        break;
      }
      j = this.jdField_a_of_type_Azdg.c();
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus movementStatus: " + azcv.a(j) + " enable: " + azcv.a.contains(Integer.valueOf(j)));
      }
      if (j > 40001)
      {
        i = j;
        if (azcv.a.contains(Integer.valueOf(j))) {
          break;
        }
      }
      j = this.jdField_a_of_type_Azdg.d();
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus categoryStatus: " + azcv.a(j) + " enable: " + azcv.a.contains(Integer.valueOf(j)));
      i = j;
      break;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadConfig");
    }
    if (!azch.a())
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadConfig auto_config not valid stopDetector. detector started: " + this.jdField_a_of_type_Boolean);
      }
      if (this.jdField_a_of_type_Boolean) {
        b("configDrop");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (arci)aqxe.a().a(652);
        if ((localObject != null) && (((arci)localObject).a != null)) {
          break;
        }
      } while (!QLog.isColorLevel());
      StringBuilder localStringBuilder = new StringBuilder().append("[status][autoMgr] loadConfig fail by bean: ").append(localObject);
      if (localObject == null) {}
      for (localObject = "";; localObject = " bean.autoStatusElement null")
      {
        QLog.e("AutoStatusManager", 2, (String)localObject);
        return;
      }
      localObject = ((arci)localObject).a.a(false);
      if (!((List)localObject).isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadConfig fail by element.autoStatus: element.autoStatus empty");
    return;
    try
    {
      azcv.a((List)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AutoStatusManager", 1, "initWithConfig", localThrowable);
    }
  }
  
  private void f()
  {
    Object localObject = ((azcb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER)).a();
    if (localObject != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList size: " + ((List)localObject).size());
      }
    }
    for (azcv.a = (List)localObject;; azcv.a = new ArrayList())
    {
      localObject = azcv.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus status: " + azcv.a(localInteger.intValue()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList is null");
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Azcn.a;
  }
  
  public String a(Integer paramInteger)
  {
    Integer localInteger = paramInteger;
    if (paramInteger == null) {
      localInteger = Integer.valueOf(a());
    }
    paramInteger = azcv.a(localInteger.intValue());
    if (paramInteger != null) {
      return paramInteger.b;
    }
    paramInteger = azbj.a().a(AppRuntime.Status.online, 40001L);
    if (paramInteger.d == null) {
      return "";
    }
    return paramInteger.d;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] destroy");
      }
      if (this.jdField_a_of_type_Boolean) {
        b("destroy");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Azce);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Azby);
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Azcu);
      return;
    }
    finally {}
  }
  
  void a(azcs paramazcs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector listener: " + paramazcs);
    }
    this.jdField_a_of_type_Azcs = paramazcs;
  }
  
  public void a(@NonNull String paramString)
  {
    a(paramString, false);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!azbu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " fail and stopDetector status: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() + " extStatus: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus() + " started: " + this.jdField_a_of_type_Boolean);
          }
          if (this.jdField_a_of_type_Boolean) {
            b("startFail-" + paramString);
          }
          return;
        }
        if (paramBoolean) {
          this.jdField_a_of_type_Azcn.a((int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
        }
        if (!AppInterface.isAppOnForeground(BaseApplicationImpl.getApplication()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " fail onAppBackground status: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus() + " extStatus: " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus() + " started: " + this.jdField_a_of_type_Boolean);
          }
          d("startDetector");
          continue;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label301;
        }
      }
      finally {}
      if (QLog.isColorLevel())
      {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " already started");
        continue;
        label301:
        if (azch.a()) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " fail by auto_config not valid.");
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " success");
    }
    this.jdField_a_of_type_Boolean = true;
    e();
    f();
    long l2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if (this.jdField_a_of_type_Azcn.a != l2) {
      this.jdField_a_of_type_Azcn.a("autoMgr");
    }
    this.jdField_a_of_type_Azdg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    long l1 = 30000L;
    if ((l2 != 41031L) && (l2 != 41014L)) {}
    for (;;)
    {
      if (l2 == 41042L) {
        l1 = this.jdField_a_of_type_Azdg.a();
      }
      String str = SharePreferenceUtils.get(BaseApplication.getContext(), "KEY_LAST_AUTO_RESET_TIME_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if (!TextUtils.isEmpty(str)) {
        this.jdField_b_of_type_Long = Long.parseLong(str);
      }
      long l3 = System.currentTimeMillis() - this.jdField_b_of_type_Long;
      if (l3 < this.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.i("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " realStatus: " + l2 + " firstDelay: " + l1 + " lastAutoInternal: " + l3 + " delay max: " + Math.max(l1, l3));
        }
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, Math.max(l1, l3));
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("AutoStatusManager", 2, "[status][autoMgr] startDetector from: " + paramString + " realStatus: " + l2 + " firstDelay: " + l1 + " lastAutoInternal: " + l3 + " delay first");
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, l1);
      break;
      l1 = 390000L;
    }
  }
  
  boolean a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    if (l > this.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] resetStatusAuto success. internal: " + l + " limit: " + this.jdField_b_of_type_Long);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 40001L, true, "auto_reset");
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("AutoStatusManager", 2, "[status][autoMgr] resetStatusAuto fail by Frequency. internal: " + l + " limit: " + this.jdField_b_of_type_Long);
    }
    if (paramBoolean)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c();
    }
    return false;
  }
  
  public void b()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if ((l == 40001L) || (l == 41042L))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public void b(@NonNull String paramString)
  {
    b(paramString, false);
  }
  
  public void b(@NonNull String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!this.jdField_a_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AutoStatusManager", 2, "[status][autoMgr] stopDetector from: " + paramString + " already stopped");
          }
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] stopDetector from: " + paramString + " success");
        }
        if (paramBoolean)
        {
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_b_of_type_JavaLangRunnable, 600000L);
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Azdg.a(paramBoolean);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          SharePreferenceUtils.set(BaseApplication.getContext(), "KEY_LAST_AUTO_RESET_TIME_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), String.valueOf(this.jdField_b_of_type_Long));
          continue;
        }
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      finally {}
      c();
    }
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoStatusManager", 2, "[status][autoMgr] onAppForeground from: " + paramString);
    }
    a("Foreground");
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AutoStatusManager", 2, "[status][autoMgr] onAppBackground from: " + paramString);
    }
    paramString = (azbv)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.ONLINE_STATUS_MANAGER);
    if (paramString != null) {
      paramString.a().b("Background", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azco
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.1;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.3;
import com.tencent.mobileqq.onlinestatus.auto.AutoStatusManager.4;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusConfirmFragment;
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

public class ayqb
{
  private volatile long jdField_a_of_type_Long = ayqi.c;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManagerV2.getSubThreadLooper());
  private aypl jdField_a_of_type_Aypl = new ayqd(this);
  private aypr jdField_a_of_type_Aypr = new ayqe(this);
  private ayqa jdField_a_of_type_Ayqa = new ayqa(40001);
  private ayqf jdField_a_of_type_Ayqf;
  private ayqh jdField_a_of_type_Ayqh = new ayqh(null);
  private ayql jdField_a_of_type_Ayql;
  private ayqt jdField_a_of_type_Ayqt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  Runnable jdField_a_of_type_JavaLangRunnable = new AutoStatusManager.3(this);
  private volatile boolean jdField_a_of_type_Boolean;
  private long jdField_b_of_type_Long;
  private Runnable jdField_b_of_type_JavaLangRunnable = new AutoStatusManager.1(this);
  
  public ayqb(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] AutoStatusManager() called");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    e();
    this.jdField_a_of_type_Ayql = new ayql(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Ayqt = new ayqt(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, new ayqc(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Aypr);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aypl);
    paramQQAppInterface = new IntentFilter();
    paramQQAppInterface.addAction("android.intent.action.SCREEN_OFF");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_Ayqh, paramQQAppInterface);
  }
  
  @NotNull
  public static Intent a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int i = 1;
    Intent localIntent = new Intent();
    localIntent.putExtra("ext_status", paramLong);
    localIntent.putExtra("public_fragment_window_feature", 1);
    if (aybz.a(paramQQAppInterface)) {}
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
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus status changed cur: " + ayqi.a(paramInt2) + " last: " + ayqi.a(paramInt1));
      }
      if (this.jdField_a_of_type_Ayqf != null) {
        this.jdField_a_of_type_Ayqf.a(paramInt2);
      }
      if (paramInt2 == 40001) {
        if (paramLong > 40001L) {
          if (a(true)) {
            this.jdField_a_of_type_Ayqa.a(paramInt2);
          }
        }
      }
    }
    do
    {
      aysb localaysb;
      do
      {
        return;
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        c();
        this.jdField_a_of_type_Ayqa.a(paramInt2);
        return;
        this.jdField_a_of_type_Ayqa.a(paramInt2);
        localaysb = ayqi.a(paramInt2);
        if (QLog.isColorLevel()) {
          QLog.e("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus getAutoStringById : " + localaysb);
        }
      } while (localaysb == null);
      a(localaysb);
      return;
      if (paramLong != 40001L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("AutoStatusManager", 2, new Object[] { "updateAutoStatus: invoked. [status-time] (真实在线状态命中了40001，不允许上报时间信息，如果后续超时自动重置，也不用上报)", " actionStatus: ", Integer.valueOf(paramInt3) });
    return;
    aysi.a.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aysi.a.a(), paramInt2);
  }
  
  private void a(aysb paramaysb)
  {
    int i = (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    if (i == paramaysb.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips fail status : " + paramaysb + " real: " + i);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      c();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips success status : " + paramaysb + " real: " + i);
    }
    if (i > 40001)
    {
      boolean bool = a(i);
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] showTips real statusChanged: " + bool + " real: " + ayqi.a(i));
      }
      if (bool) {
        a(false);
      }
    }
    if ((BaseActivity.mAppForground) && (a()))
    {
      b(paramaysb);
      c();
      return;
    }
    b(paramaysb);
    c(paramaysb);
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
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] submitStatus " + paramString + " status: " + ayqi.a((int)paramLong) + " auto: " + paramBoolean);
    }
    a(paramQQAppInterface);
    c();
    if (paramLong != 40001L) {
      aysi.a.a(paramQQAppInterface, aysi.a.a(), (int)paramLong);
    }
    paramQQAppInterface.a(AppRuntime.Status.online, paramLong, paramBoolean);
    if (ayqi.a(paramLong)) {
      ((aypj)BaseApplicationImpl.getApplication().getRuntime().getManager(369)).a().jdField_a_of_type_Ayqt.a(paramLong);
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
    if (paramInt == this.jdField_a_of_type_Ayql.a()) {}
    for (;;)
    {
      return false;
      if (paramInt != this.jdField_a_of_type_Ayqt.d())
      {
        if (ayqi.b) {}
        for (int i = this.jdField_a_of_type_Ayqt.b(); paramInt != i; i = this.jdField_a_of_type_Ayqt.c()) {
          return true;
        }
      }
    }
  }
  
  private void b(aysb paramaysb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr][banner] showBanner status : " + paramaysb);
    }
    MqqHandler localMqqHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    Message localMessage = new Message();
    localMessage.what = 1075;
    localMessage.obj = paramaysb;
    localMqqHandler.sendMessage(localMessage);
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] hidePush");
    }
    ThreadManagerV2.getUIHandlerV2().post(new AutoStatusManager.4());
  }
  
  private void c(aysb paramaysb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] showPush status : " + paramaysb + " at " + new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(System.currentTimeMillis())));
    }
    Intent localIntent = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaysb.jdField_a_of_type_Long);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    localBuilder.setContentText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690197), new Object[] { paramaysb.jdField_a_of_type_JavaLangString })).setWhen(System.currentTimeMillis()).setSmallIcon(2130841393).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0, localIntent, 134217728));
    paramaysb = localBuilder.build();
    QQNotificationManager.addChannelIfNeed(paramaysb, "CHANNEL_ID_OTHER");
    QQNotificationManager.getInstance().notify("AutoStatusManager", 3000530, paramaysb);
    if (aybz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      aypy.a("0X800AFA2", 1);
      return;
    }
    aypy.a("0X800AFA1", 1);
  }
  
  private void d()
  {
    int m = 40001;
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus();
    int n = a();
    if (QLog.isColorLevel()) {
      QLog.w("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus last status: " + ayqi.a(n) + " real status: " + ayqi.a((int)l));
    }
    if (l < 40000L)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus [user submit no auto status] stopDetector. last status: " + ayqi.a(n) + " real status: " + ayqi.a((int)l));
      }
      b("updateStatus");
      return;
    }
    int k = this.jdField_a_of_type_Ayql.a();
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus actionStatus: " + ayqi.a(k) + " enable: " + ayqi.a.contains(Integer.valueOf(k)));
    }
    int i;
    if ((k > 40001) && (ayqi.a.contains(Integer.valueOf(k))))
    {
      i = k;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus result: " + ayqi.a(i) + " enable: " + ayqi.a.contains(Integer.valueOf(i)));
      }
      if ((i <= 40001) || (ayqi.a.contains(Integer.valueOf(i)))) {
        break label676;
      }
      j = m;
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus detected disabled cur status: " + ayqi.a(i));
      }
    }
    label676:
    for (int j = m;; j = i)
    {
      a(l, n, j, k);
      return;
      if (ayqi.b)
      {
        j = this.jdField_a_of_type_Ayqt.b();
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus getNewMovementStatus: " + ayqi.a(j) + " enable: " + ayqi.a.contains(Integer.valueOf(j)));
        }
        if (j > 40001)
        {
          i = j;
          if (ayqi.a.contains(Integer.valueOf(j))) {
            break;
          }
        }
        j = this.jdField_a_of_type_Ayqt.d();
        i = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus categoryStatus: " + ayqi.a(j) + " enable: " + ayqi.a.contains(Integer.valueOf(j)));
        i = j;
        break;
      }
      j = this.jdField_a_of_type_Ayqt.c();
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus movementStatus: " + ayqi.a(j) + " enable: " + ayqi.a.contains(Integer.valueOf(j)));
      }
      if (j > 40001)
      {
        i = j;
        if (ayqi.a.contains(Integer.valueOf(j))) {
          break;
        }
      }
      j = this.jdField_a_of_type_Ayqt.d();
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] updateAutoStatus categoryStatus: " + ayqi.a(j) + " enable: " + ayqi.a.contains(Integer.valueOf(j)));
      i = j;
      break;
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadConfig");
    }
    if (!aypu.a())
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
        localObject = (aqqh)aqlk.a().a(652);
        if ((localObject != null) && (((aqqh)localObject).a != null)) {
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
      localObject = ((aqqh)localObject).a.a(false);
      if (!((List)localObject).isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadConfig fail by element.autoStatus: element.autoStatus empty");
    return;
    try
    {
      ayqi.a((List)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("AutoStatusManager", 1, "initWithConfig", localThrowable);
    }
  }
  
  private void f()
  {
    Object localObject = ((aypo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(370)).a();
    if (localObject != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList size: " + ((List)localObject).size());
      }
    }
    for (ayqi.a = (List)localObject;; ayqi.a = new ArrayList())
    {
      localObject = ayqi.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Integer localInteger = (Integer)((Iterator)localObject).next();
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus status: " + ayqi.a(localInteger.intValue()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("AutoStatusManager", 2, "[status][autoMgr] loadEnabledStatus smartSelectedList is null");
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ayqa.a;
  }
  
  public String a(Integer paramInteger)
  {
    Integer localInteger = paramInteger;
    if (paramInteger == null) {
      localInteger = Integer.valueOf(a());
    }
    paramInteger = ayqi.a(localInteger.intValue());
    if (paramInteger != null) {
      return paramInteger.jdField_a_of_type_JavaLangString;
    }
    paramInteger = ayox.a().a(AppRuntime.Status.online, 40001L);
    if (paramInteger.c == null) {
      return "";
    }
    return paramInteger.c;
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_Aypr);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aypl);
      BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_Ayqh);
      return;
    }
    finally {}
  }
  
  void a(ayqf paramayqf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusManager", 2, "[status][autoMgr] startDetector listener: " + paramayqf);
    }
    this.jdField_a_of_type_Ayqf = paramayqf;
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
        if (!aypi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus()))
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
          this.jdField_a_of_type_Ayqa.a((int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtOnlineStatus());
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
        if (aypu.a()) {
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
    if (this.jdField_a_of_type_Ayqa.a != l2) {
      this.jdField_a_of_type_Ayqa.a("autoMgr");
    }
    this.jdField_a_of_type_Ayqt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    long l1 = 30000L;
    if ((l2 != 41031L) && (l2 != 41014L)) {}
    for (;;)
    {
      if (l2 == 41042L) {
        l1 = this.jdField_a_of_type_Ayqt.a();
      }
      String str = bgjb.a(BaseApplication.getContext(), "KEY_LAST_AUTO_RESET_TIME_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
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
          this.jdField_a_of_type_Ayqt.a(paramBoolean);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          bgjb.a(BaseApplication.getContext(), "KEY_LAST_AUTO_RESET_TIME_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), String.valueOf(this.jdField_b_of_type_Long));
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
    paramString = (aypj)BaseApplicationImpl.getApplication().getRuntime().getManager(369);
    if (paramString != null) {
      paramString.a().b("Background", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqb
 * JD-Core Version:    0.7.0.1
 */
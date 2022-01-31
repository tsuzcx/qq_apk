package com.tencent.av.app;

import ajfb;
import ajfe;
import android.app.Notification;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import atmq;
import auqk;
import awdm;
import awqx;
import awru;
import axrr;
import axso;
import com.tencent.av.VideoController;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedDisplayInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Vector;
import krx;
import ktm;
import ktn;
import ktp;
import ktr;
import kts;
import kul;
import kun;
import kup;
import kus;
import kuu;
import kuw;
import kuy;
import kva;
import kvd;
import kvh;
import kvi;
import kvl;
import kvq;
import kvu;
import kvv;
import kvy;
import kvz;
import kwn;
import kwt;
import kwu;
import kwv;
import kyh;
import kyj;
import kyl;
import lad;
import lfa;
import lls;
import lor;
import mht;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class VideoAppInterface
  extends AppInterface
  implements awru
{
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  protected Handler a;
  private atmq jdField_a_of_type_Atmq;
  private axso jdField_a_of_type_Axso;
  public VideoController a;
  protected DeviceCapabilityExamination a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<ajfe> a;
  private ktm jdField_a_of_type_Ktm;
  private ktn jdField_a_of_type_Ktn;
  kts jdField_a_of_type_Kts;
  kul jdField_a_of_type_Kul;
  kun jdField_a_of_type_Kun;
  kup jdField_a_of_type_Kup;
  kus jdField_a_of_type_Kus;
  kuu jdField_a_of_type_Kuu;
  kuw jdField_a_of_type_Kuw;
  kuy jdField_a_of_type_Kuy;
  kva jdField_a_of_type_Kva;
  kvd jdField_a_of_type_Kvd;
  kvh jdField_a_of_type_Kvh;
  private kvi jdField_a_of_type_Kvi;
  kvl jdField_a_of_type_Kvl;
  kvv jdField_a_of_type_Kvv = null;
  private kvy jdField_a_of_type_Kvy;
  private kwn jdField_a_of_type_Kwn;
  public kwu a;
  protected kwv a;
  lad jdField_a_of_type_Lad;
  private final lfa jdField_a_of_type_Lfa = new lfa();
  protected boolean a;
  private Runnable b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  private boolean h;
  
  public VideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangRunnable = new VideoAppInterface.1(this);
  }
  
  public static boolean a(BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    if (paramAppInfo == null) {}
    while ((paramAppInfo.iNewFlag.get() == 0) || (paramAppInfo.exposure_max.get() < 0) || (paramAppInfo.red_display_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get() == null) || (paramAppInfo.red_display_info.red_type_info.get().size() == 0)) {
      return false;
    }
    return true;
  }
  
  private void d(String paramString)
  {
    this.jdField_a_of_type_Kvl.b(paramString);
  }
  
  private void e()
  {
    AudioManager localAudioManager = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
    {
      this.jdField_a_of_type_Boolean = localAudioManager.isSpeakerphoneOn();
      this.jdField_a_of_type_Int = localAudioManager.getMode();
    }
  }
  
  private void e(String paramString)
  {
    this.jdField_a_of_type_Kvl.c(paramString);
  }
  
  private void f()
  {
    this.jdField_a_of_type_Kul.b();
    this.jdField_a_of_type_Kup.b();
    this.jdField_a_of_type_Kuw.a();
    this.jdField_a_of_type_Kvd.a();
    this.jdField_a_of_type_Kun.a();
    this.jdField_a_of_type_Kus.a();
    this.jdField_a_of_type_Kva.a();
    this.jdField_a_of_type_Kuy.b();
    this.jdField_a_of_type_Kuu.a();
    this.jdField_a_of_type_Kvi.a();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      a();
    }
    for (;;)
    {
      AudioHelper.b("VideoAppInterface.onCreate.end");
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
    }
  }
  
  private void h()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)getApp().getSystemService("power");
      if (!localPowerManager.isScreenOn()) {
        localPowerManager.newWakeLock(1, "mobileqq:videoapp").acquire(10000L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void i()
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 10, null, true);
  }
  
  private void j()
  {
    if ((AudioHelper.d()) && (AudioHelper.a(13) == 1))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onCreate, 音视频进程在等待调试器连接(界面会无响应)");
      Debug.waitForDebugger();
    }
  }
  
  private void k()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "registerExitProcessReceiver");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.exit_process");
    getApp().registerReceiver(new kvu(this), localIntentFilter);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new VideoAppInterface.4(this);
    }
    for (;;)
    {
      a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      return;
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public int a()
  {
    return a().countObservers();
  }
  
  public int a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_Kvl.a(paramInt, paramString);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Kvl.a(paramString);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_Kvl.a(paramString);
  }
  
  public ajfb a(int paramInt)
  {
    return this.jdField_a_of_type_Kwn.a(this, paramInt);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_a_of_type_Kvl.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_a_of_type_Kvl.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public VideoController a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
    }
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public RedTouch a(View paramView, int paramInt)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      int i = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int;
      str = ktr.a(paramInt, i);
      if (!ktr.a(this, paramInt, i))
      {
        QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot falied. can not show redtouch. appId = " + str);
        return null;
      }
    }
    else
    {
      QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot failed. videoController == null or videoController.getSessionInfo() == null");
      return null;
    }
    if ((paramView == null) || (TextUtils.isEmpty(str)))
    {
      QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot falied. appId[" + str + "], view[" + paramView + "]");
      return null;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(str);
    if ((localAppInfo != null) && (a(localAppInfo)))
    {
      RedTouch localRedTouch = new RedTouch(getApplication(), paramView).a(53).a();
      localRedTouch.a(localAppInfo);
      e(str);
      QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot successfully. appId[" + str + "], view[" + paramView + "], redTouch[" + localRedTouch + "]");
      return localRedTouch;
    }
    QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot falied. appId[" + str + "], view[" + paramView + "], appInfo[" + localAppInfo + "], hasRedDot[" + a(localAppInfo) + "]");
    return null;
  }
  
  public RedTouch a(View paramView, String paramString)
  {
    if ((paramView == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot falied. appId[" + paramString + "], view[" + paramView + "]");
      return null;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramString);
    if ((localAppInfo != null) && (a(localAppInfo)))
    {
      RedTouch localRedTouch = new RedTouch(getApplication(), paramView).a(53).a();
      localRedTouch.a(localAppInfo);
      e(paramString);
      QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot successfully. appId[" + paramString + "], view[" + paramView + "], redTouch[" + localRedTouch + "]");
      return localRedTouch;
    }
    QLog.d("AVRedDot", 1, "tryGetRedTouchAndShowRedDot falied. appId[" + paramString + "], view[" + paramView + "], appInfo[" + localAppInfo + "], hasRedDot[" + a(localAppInfo) + "]");
    return null;
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("red_touch_app_id", paramString);
    paramString = a(7, 0, 0, localBundle, null);
    if (paramString == null) {
      return null;
    }
    paramString.setClassLoader(RedAppInfo.class.getClassLoader());
    return auqk.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String a()
  {
    String str2 = getApp().getString(2131654887);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().jdField_d_of_type_JavaLangString;
      int i = ((VideoController)localObject).a().i;
      localObject = ((VideoController)localObject).a().f;
      str1 = str2;
      if (i == 9500) {
        str1 = getDisplayName(i, str3, (String)localObject) + getApp().getString(2131654889);
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_Kvl.b(paramString);
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_Kuu.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ktm a()
  {
    return this.jdField_a_of_type_Ktm;
  }
  
  public ktn a()
  {
    return this.jdField_a_of_type_Ktn;
  }
  
  public kvv a()
  {
    if (this.jdField_a_of_type_Kvv == null) {
      this.jdField_a_of_type_Kvv = new kvv(this);
    }
    return this.jdField_a_of_type_Kvv;
  }
  
  public kwt a(int paramInt)
  {
    return this.jdField_a_of_type_Kwu.a(paramInt);
  }
  
  public lad a()
  {
    return this.jdField_a_of_type_Lad;
  }
  
  public lfa a()
  {
    if (this.h) {
      return this.jdField_a_of_type_Lfa;
    }
    synchronized (this.jdField_a_of_type_Lfa)
    {
      String str;
      if (!this.h)
      {
        str = AVNotifyCenter.d(getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        int j = AVNotifyCenter.b(getCurrentAccountUin());
        i = j;
        if (j != -1)
        {
          this.jdField_a_of_type_Lfa.a("BEAUTY_SKIN", j);
          i = j;
        }
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_Lfa;
      label133:
      this.jdField_a_of_type_Lfa.a(str);
      int i = -1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, awdm.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public void a(int paramInt)
  {
    long l = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess, reason[" + paramInt + "], videoController[" + this.jdField_a_of_type_ComTencentAvVideoController + "], reason[" + paramInt + "], seq[" + l + "]");
    int i;
    switch (paramInt)
    {
    default: 
      i = 260;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          int j = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
          if ((j > 0) && (j <= 4))
          {
            String str = this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_JavaLangString;
            this.jdField_a_of_type_ComTencentAvVideoController.a(str, i);
            this.jdField_a_of_type_ComTencentAvVideoController.b(i);
            this.jdField_a_of_type_ComTencentAvVideoController.b(str, 0);
            this.jdField_a_of_type_ComTencentAvVideoController.o = false;
            a(l, paramInt);
            return;
          }
          if (!this.jdField_a_of_type_ComTencentAvVideoController.e) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.c, this.jdField_a_of_type_ComTencentAvVideoController.a, 72);
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess System.exit ");
      }
      catch (Exception localException)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess Exception System.exit ");
        QLog.flushLog();
        return;
      }
      QLog.flushLog();
      return;
      i = 254;
      continue;
      i = 255;
      continue;
      i = 256;
      continue;
      i = 257;
      continue;
      i = 258;
      continue;
      i = 259;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Kwu.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Kvl.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Kvl.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt < 200) {}
    for (int i = paramInt + 200;; i = paramInt)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "video exit, mIsExit[" + this.e + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_Kwu + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
      this.e = true;
      if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
      {
        if (!this.jdField_a_of_type_ComTencentAvVideoController.a().G) {
          break label356;
        }
        awqx.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
          this.jdField_a_of_type_ComTencentAvVideoController.C();
        }
        this.jdField_b_of_type_Boolean = false;
        lor.a(paramLong, getApplication());
        krx.d(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
        QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
        Object localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
        if (localObject != null) {}
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
          ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
          localObject = mht.a(this);
          if (localObject != null) {
            ((mht)localObject).a();
          }
          krx.d(jdField_a_of_type_JavaLangString, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_Ktm != null)
          {
            if (this.jdField_a_of_type_Ktm.a()) {
              this.jdField_a_of_type_Ktm.b();
            }
            if (this.jdField_a_of_type_Ktm.c()) {
              this.jdField_a_of_type_ComTencentAvVideoController.q(false);
            }
            if (this.jdField_a_of_type_Ktm.b()) {
              this.jdField_a_of_type_ComTencentAvVideoController.o(false);
            }
          }
          return;
          label356:
          awqx.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            krx.d(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Kvl.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(RedTouch paramRedTouch, int paramInt)
  {
    String str;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      str = ktr.a(paramInt, this.jdField_a_of_type_ComTencentAvVideoController.a().jdField_d_of_type_Int);
      if ((paramRedTouch == null) || (TextUtils.isEmpty(str))) {
        QLog.d("AVRedDot", 1, "clearRedDot falied. appId[" + str + "], redTouch[" + paramRedTouch + "]");
      }
    }
    else
    {
      QLog.d("AVRedDot", 1, "clearRedDot failed. videoController == null or videoController.getSessionInfo() == null");
      return;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(str);
    if ((localAppInfo != null) && (a(localAppInfo)))
    {
      d(str);
      paramRedTouch.b();
      QLog.d("AVRedDot", 1, "clearRedDot successfully. appId[" + str + "], redTouch[" + paramRedTouch + "]");
      return;
    }
    QLog.d("AVRedDot", 1, "clearRedDot falied. appId[" + str + "], redTouch[" + paramRedTouch + "], appInfo[" + localAppInfo + "], hasRedDot[" + a(localAppInfo) + "]");
  }
  
  public void a(RedTouch paramRedTouch, String paramString)
  {
    if ((paramRedTouch == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("AVRedDot", 1, "clearRedDot falied. appId[" + paramString + "], redTouch[" + paramRedTouch + "]");
      return;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(paramString);
    if ((localAppInfo != null) && (a(localAppInfo)))
    {
      d(paramString);
      paramRedTouch.b();
      QLog.d("AVRedDot", 1, "clearRedDot successfully. appId[" + paramString + "], redTouch[" + paramRedTouch + "]");
      return;
    }
    QLog.d("AVRedDot", 1, "clearRedDot falied. appId[" + paramString + "], redTouch[" + paramRedTouch + "], appInfo[" + localAppInfo + "], hasRedDot[" + a(localAppInfo) + "]");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_Kvy.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    kyl localkyl = (kyl)a(4);
    if (localkyl != null)
    {
      localkyl.a(paramString);
      localkyl.a(36, 1L);
      localkyl.a(29, 1L);
      localkyl.b();
      kyj.a(16, 1L);
      kyj.c();
    }
    onDestroy();
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Kuu.a(paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    a().a(paramString, paramInt);
    if (paramBoolean)
    {
      l();
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "setBeautyValue name[" + paramString + "], value[" + paramInt + "]");
      }
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      a().addObserver(paramObserver);
      if ((this.jdField_a_of_type_Kvl != null) && (this.jdField_a_of_type_Kvl.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Kvl != null) {
      this.jdField_a_of_type_Kvl.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_a_of_type_Kts.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Kts.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Kwu.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    String str = ktr.a(paramInt1, paramInt2);
    if (TextUtils.isEmpty(str))
    {
      QLog.d("AVRedDot", 1, "hasRedDot falied. appId = " + str);
      return false;
    }
    BusinessInfoCheckUpdate.AppInfo localAppInfo = a(str);
    if ((localAppInfo != null) && (a(localAppInfo))) {
      return true;
    }
    QLog.d("AVRedDot", 1, "hasRedDot falied. appId = " + str + ", appInfo = " + localAppInfo + ", hasRedDot = false");
    return false;
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.jdField_a_of_type_Kvl.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Kvl.a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Kvl.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_Kvl.a(paramString, paramInt);
  }
  
  public boolean a(lls paramlls)
  {
    return this.jdField_a_of_type_Kvl.a(paramlls);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_Kvl.a(paramString);
  }
  
  public void addObserver(ajfe paramajfe)
  {
    addObserver(paramajfe, false);
  }
  
  public void addObserver(ajfe paramajfe, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramajfe)) {
      this.jdField_a_of_type_JavaUtilList.add(paramajfe);
    }
  }
  
  public int b(String paramString)
  {
    return a().a(paramString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Kvl.a();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_Kvl.c(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Kvl.c();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Kwu.a(paramInt);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Kvl.a(paramInt, paramString);
  }
  
  public void b(String paramString)
  {
    Object localObject = getApplication().refreAccountList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if (paramString.equals(localSimpleAccount.getUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Switch Account: " + paramString);
          }
          switchAccount(localSimpleAccount, null);
          if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
            this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
          }
          this.jdField_a_of_type_ComTencentAvVideoController = null;
        }
      }
    }
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportQuaProcessWakeUp() isBroadcastCreated = " + paramBoolean);
    if (paramBoolean) {
      this.f = true;
    }
    for (;;)
    {
      if (this.f)
      {
        if (!this.g) {
          break;
        }
        kyh.a(this.f, this.g);
      }
      return;
      this.g = true;
    }
    a().postDelayed(new VideoAppInterface.2(this), 3000L);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Kvl.b();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Kvl.b(paramString);
  }
  
  public boolean b(lls paramlls)
  {
    return this.jdField_a_of_type_Kvl.b(paramlls);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Kvl.d();
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Kvl.b(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Kvl.a(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Kvl.c();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_Kvl.c(paramString);
  }
  
  public void d()
  {
    a().b();
    l();
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Kvl.d();
  }
  
  public boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = a(paramString);
    } while ((paramString == null) || (!a(paramString)));
    return true;
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Kvl.e();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Kvl.f();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Kvl.g();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<ajfe> getBusinessObserver(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getDisplayName(int paramInt, String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_Kvl.b(paramInt, paramString1, paramString2);
  }
  
  public atmq getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Atmq == null) {
      this.jdField_a_of_type_Atmq = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Atmq;
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { ktp.class };
  }
  
  public axrr getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Axso == null) {
      this.jdField_a_of_type_Axso = new axso();
    }
    return this.jdField_a_of_type_Axso.a(this, paramInt);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Kvl.h();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Kvl.a();
  }
  
  public boolean j()
  {
    lfa locallfa = a();
    if (locallfa.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    if (AEFilterSupport.a()) {
      return locallfa.b();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.d()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    UpdateAvSo.a(-1045L);
    this.c = true;
    kyj.a(this);
    kyj.a();
    kyj.a(27);
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    j();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    h();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Kvh = new kvh(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Kvh);
    this.jdField_a_of_type_Kvy = new kvy(this);
    this.jdField_a_of_type_Kwn = new kwn();
    this.jdField_a_of_type_Kwn.a(this.jdField_a_of_type_Kvy);
    this.jdField_a_of_type_Kwu = new kwu(this);
    this.jdField_a_of_type_Kwv = new kwv(this);
    g();
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Kup = new kup(this);
    this.jdField_a_of_type_Kul = new kul(this);
    this.jdField_a_of_type_Kuw = new kuw(this);
    this.jdField_a_of_type_Kvd = new kvd(this);
    this.jdField_a_of_type_Kun = new kun(this);
    this.jdField_a_of_type_Kus = new kus(this);
    this.jdField_a_of_type_Kva = new kva(this);
    this.jdField_a_of_type_Kuy = new kuy(this);
    this.jdField_a_of_type_Kuu = new kuu(this);
    this.jdField_a_of_type_Ktm = new ktm(this);
    this.jdField_a_of_type_Ktn = new ktn(this);
    this.jdField_a_of_type_Kvi = new kvi(this);
    this.jdField_a_of_type_Kvl = new kvl(this);
    this.jdField_a_of_type_Kvl.a();
    this.jdField_a_of_type_Kvl.c();
    this.jdField_a_of_type_Kts = new kts(this);
    this.jdField_a_of_type_Kts.a();
    this.jdField_a_of_type_Lad = new lad(this);
    AVReport.a().a();
    e();
    ThreadManager.post(new VideoAppInterface.CameraUsageRunnable(this), 5, null, true);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    i();
    f();
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
    }
    catch (Exception paramBundle)
    {
      try
      {
        for (;;)
        {
          ReporterMachine.a();
          if (QLog.isDevelopLevel())
          {
            long l2 = System.currentTimeMillis();
            QLog.d("IVR_TS_" + jdField_a_of_type_JavaLangString, 4, String.format("VideoAppInterface onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
          }
          AudioHelper.b("VideoAppInterface.onCreate.end");
          k();
          ClientLogReport.instance().checkLocalReportRecord();
          if (AudioHelper.a(25) == 1)
          {
            AudioHelper.a("使用了index_disable_immersive");
            com.tencent.widget.immersive.ImmersiveUtils.jdField_a_of_type_Int = 0;
          }
          return;
          paramBundle = paramBundle;
          QLog.e(jdField_a_of_type_JavaLangString, 4, paramBundle.toString());
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[Magnifier startMachine error]" + paramBundle);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    l();
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Kts.b();
    this.jdField_a_of_type_Kvl.b();
    this.jdField_a_of_type_Kvl.d();
    if (this.jdField_a_of_type_Axso != null) {}
    try
    {
      this.jdField_a_of_type_Axso.onDestroy();
      this.jdField_a_of_type_Axso = null;
      PtvTemplateManager.a();
      AVRedPacketManager.b();
      this.jdField_a_of_type_Kva.b();
      this.jdField_a_of_type_Kuy.a();
      this.jdField_a_of_type_Kup.a();
      this.jdField_a_of_type_Kul.a();
      this.jdField_a_of_type_Kuw.b();
      this.jdField_a_of_type_Kvd.b();
      this.jdField_a_of_type_Kun.b();
      this.jdField_a_of_type_Kus.b();
      this.jdField_a_of_type_Kuu.b();
      this.jdField_a_of_type_Kvi.b();
      kvz.a(getApp());
      kyj.b();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Axso.onDestroy();
      }
    }
  }
  
  public void removeObserver(ajfe paramajfe)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramajfe);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    krx.c(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_Kvy.a(paramToServiceMsg, null, ktp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.av.app;

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
import anii;
import anil;
import baij;
import bcdi;
import bcst;
import bctr;
import bdvu;
import bdwr;
import com.tencent.av.VideoController;
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
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
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
import lbc;
import lct;
import lcu;
import lcw;
import lcz;
import lds;
import ldu;
import ldw;
import ldz;
import leb;
import led;
import lef;
import leh;
import lek;
import leo;
import lep;
import leq;
import let;
import ley;
import lfc;
import lfd;
import lfg;
import lfh;
import lfv;
import lgb;
import lgc;
import lgd;
import lhs;
import lhu;
import lhw;
import ljo;
import lon;
import lvs;
import lyu;
import mbm;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msp;

public class VideoAppInterface
  extends AppInterface
  implements bctr, lep
{
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  protected Handler a;
  private bdwr jdField_a_of_type_Bdwr;
  public VideoController a;
  protected DeviceCapabilityExamination a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<anil> a;
  private lct jdField_a_of_type_Lct;
  private lcu jdField_a_of_type_Lcu;
  lcz jdField_a_of_type_Lcz;
  lds jdField_a_of_type_Lds;
  ldu jdField_a_of_type_Ldu;
  ldw jdField_a_of_type_Ldw;
  ldz jdField_a_of_type_Ldz;
  leb jdField_a_of_type_Leb;
  led jdField_a_of_type_Led;
  lef jdField_a_of_type_Lef;
  leh jdField_a_of_type_Leh;
  lek jdField_a_of_type_Lek;
  leo jdField_a_of_type_Leo;
  private leq jdField_a_of_type_Leq;
  let jdField_a_of_type_Let;
  lfd jdField_a_of_type_Lfd = null;
  private lfg jdField_a_of_type_Lfg;
  private lfv jdField_a_of_type_Lfv;
  public lgc a;
  protected lgd a;
  ljo jdField_a_of_type_Ljo;
  private final lon jdField_a_of_type_Lon = new lon();
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
  
  private void e()
  {
    AudioManager localAudioManager = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
    {
      this.jdField_a_of_type_Boolean = localAudioManager.isSpeakerphoneOn();
      this.jdField_a_of_type_Int = localAudioManager.getMode();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_Lds.b();
    this.jdField_a_of_type_Ldw.b();
    this.jdField_a_of_type_Led.a();
    this.jdField_a_of_type_Lek.a();
    this.jdField_a_of_type_Ldu.a();
    this.jdField_a_of_type_Ldz.a();
    this.jdField_a_of_type_Leh.a();
    this.jdField_a_of_type_Lef.b();
    this.jdField_a_of_type_Leb.a();
    this.jdField_a_of_type_Leq.a();
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
    if ((AudioHelper.e()) && (AudioHelper.a(13) == 1))
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
    getApp().registerReceiver(new lfc(this), localIntentFilter);
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
    return this.jdField_a_of_type_Let.a(paramInt, paramString);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Let.a(paramString);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_Let.a(paramString);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_a_of_type_Let.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_a_of_type_Let.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public anii a(int paramInt)
  {
    return this.jdField_a_of_type_Lfv.a(this, paramInt);
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
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("red_touch_app_id", paramString);
    paramString = a(7, 0, 0, localBundle, null);
    if (paramString == null) {
      return null;
    }
    paramString.setClassLoader(RedAppInfo.class.getClassLoader());
    return baij.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String a()
  {
    String str2 = getApp().getString(2131719068);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().d;
      int i = ((VideoController)localObject).a().j;
      localObject = ((VideoController)localObject).a().f;
      str1 = str2;
      if (i == 9500) {
        str1 = getDisplayName(i, str3, (String)localObject) + getApp().getString(2131719070);
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_Let.b(paramString);
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_Leb.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public lct a()
  {
    return this.jdField_a_of_type_Lct;
  }
  
  public lcu a()
  {
    return this.jdField_a_of_type_Lcu;
  }
  
  public lfd a()
  {
    if (this.jdField_a_of_type_Lfd == null) {
      this.jdField_a_of_type_Lfd = new lfd(this);
    }
    return this.jdField_a_of_type_Lfd;
  }
  
  public lgb a(int paramInt)
  {
    return this.jdField_a_of_type_Lgc.a(paramInt);
  }
  
  public ljo a()
  {
    return this.jdField_a_of_type_Ljo;
  }
  
  public lon a()
  {
    if (this.h) {
      return this.jdField_a_of_type_Lon;
    }
    synchronized (this.jdField_a_of_type_Lon)
    {
      String str;
      if (!this.h)
      {
        str = mbm.a(getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        int j = mbm.a(getCurrentAccountUin());
        i = j;
        if (j != -1)
        {
          this.jdField_a_of_type_Lon.a("BEAUTY_SKIN", j);
          i = j;
        }
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_Lon;
      label133:
      this.jdField_a_of_type_Lon.a(str);
      int i = -1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, bcdi.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public void a(int paramInt)
  {
    VideoController localVideoController = a();
    if (localVideoController != null) {
      localVideoController.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Lgc.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Let.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Let.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt < 200) {}
    for (int i = paramInt + 200;; i = paramInt)
    {
      boolean bool;
      if (i == 261) {
        bool = true;
      }
      for (;;)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video exit, mIsExit[" + this.e + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_Lgc + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        this.e = true;
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
            bcst.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
            this.jdField_a_of_type_ComTencentAvVideoController.C();
          }
          this.jdField_b_of_type_Boolean = false;
          lyu.a(paramLong, 1, getApplication());
          lbc.d(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
          QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
          localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
          if (localObject == null) {}
        }
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
          ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
          localObject = msp.a(this);
          if (localObject != null) {
            ((msp)localObject).a();
          }
          lbc.d(jdField_a_of_type_JavaLangString, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_Lct != null)
          {
            if (this.jdField_a_of_type_Lct.a()) {
              this.jdField_a_of_type_Lct.a(bool);
            }
            if (this.jdField_a_of_type_Lct.c()) {
              this.jdField_a_of_type_ComTencentAvVideoController.p(false);
            }
            if (this.jdField_a_of_type_Lct.b()) {
              this.jdField_a_of_type_ComTencentAvVideoController.n(false);
            }
          }
          return;
          bool = false;
          continue;
          bcst.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            lbc.d(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Let.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_Lfg.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    lhw locallhw = (lhw)a(4);
    if (locallhw != null)
    {
      locallhw.a(paramString);
      locallhw.a(36, 1L);
      locallhw.a(29, 1L);
      locallhw.b();
      lhu.a(16, 1L);
      lhu.c();
    }
    onDestroy();
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Leb.a(paramString, paramInt);
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
      if ((this.jdField_a_of_type_Let != null) && (this.jdField_a_of_type_Let.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Let != null) {
      this.jdField_a_of_type_Let.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_a_of_type_Lcz.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lcz.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Lgc.a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.jdField_a_of_type_Let.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Let.a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Let.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_Let.a(paramString, paramInt);
  }
  
  public boolean a(lvs paramlvs)
  {
    return this.jdField_a_of_type_Let.a(paramlvs);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_Let.a(paramString);
  }
  
  public void addObserver(anil paramanil)
  {
    addObserver(paramanil, false);
  }
  
  public void addObserver(anil paramanil, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramanil)) {
      this.jdField_a_of_type_JavaUtilList.add(paramanil);
    }
  }
  
  public int b(String paramString)
  {
    return a().a(paramString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Let.a();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_Let.c(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Let.c();
  }
  
  public void b(int paramInt)
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
            String str = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
            this.jdField_a_of_type_ComTencentAvVideoController.a(str, i);
            this.jdField_a_of_type_ComTencentAvVideoController.b(i);
            this.jdField_a_of_type_ComTencentAvVideoController.b(str, 0);
            this.jdField_a_of_type_ComTencentAvVideoController.n = false;
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
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Let.a(paramInt, paramString);
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
        lhs.a(this.f, this.g);
      }
      return;
      this.g = true;
    }
    a().postDelayed(new VideoAppInterface.2(this), 3000L);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Let.b();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Let.b(paramString);
  }
  
  public boolean b(lvs paramlvs)
  {
    return this.jdField_a_of_type_Let.b(paramlvs);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Let.d();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Lgc.a(paramInt);
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Let.b(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Let.a(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Let.c();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_Let.c(paramString);
  }
  
  public void d()
  {
    a().b();
    l();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Let.b(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Let.d();
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_Let.c(paramString);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Let.e();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Let.f();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Let.g();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<anil> getBusinessObserver(int paramInt)
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
    return this.jdField_a_of_type_Let.b(paramInt, paramString1, paramString2);
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { lcw.class };
  }
  
  public bdvu getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bdwr == null) {
      this.jdField_a_of_type_Bdwr = new bdwr();
    }
    return this.jdField_a_of_type_Bdwr.a(this, paramInt);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Let.h();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Let.i();
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_Let.a();
  }
  
  public boolean k()
  {
    lon locallon = a();
    if (locallon.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    if (AEFilterSupport.a()) {
      return locallon.b();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.e()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    AVSoUtils.a(-1045L);
    this.c = true;
    lhu.a(this);
    lhu.a();
    lhu.a(27);
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    j();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    h();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Leo = new leo(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Leo);
    this.jdField_a_of_type_Lfg = new lfg(this);
    this.jdField_a_of_type_Lfv = new lfv();
    this.jdField_a_of_type_Lfv.a(this.jdField_a_of_type_Lfg);
    this.jdField_a_of_type_Lgc = new lgc(this);
    this.jdField_a_of_type_Lgd = new lgd(this);
    g();
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Ldw = new ldw(this);
    this.jdField_a_of_type_Lds = new lds(this);
    this.jdField_a_of_type_Led = new led(this);
    this.jdField_a_of_type_Lek = new lek(this);
    this.jdField_a_of_type_Ldu = new ldu(this);
    this.jdField_a_of_type_Ldz = new ldz(this);
    this.jdField_a_of_type_Leh = new leh(this);
    this.jdField_a_of_type_Lef = new lef(this);
    this.jdField_a_of_type_Leb = new leb(this);
    this.jdField_a_of_type_Lct = new lct(this);
    this.jdField_a_of_type_Lcu = new lcu(this);
    this.jdField_a_of_type_Leq = new leq(this);
    this.jdField_a_of_type_Let = new let(this);
    this.jdField_a_of_type_Let.a();
    this.jdField_a_of_type_Let.c();
    this.jdField_a_of_type_Lcz = new lcz(this);
    this.jdField_a_of_type_Lcz.a();
    this.jdField_a_of_type_Ljo = new ljo(this);
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
    this.jdField_a_of_type_Lcz.b();
    this.jdField_a_of_type_Let.b();
    this.jdField_a_of_type_Let.d();
    if (this.jdField_a_of_type_Bdwr != null) {}
    try
    {
      this.jdField_a_of_type_Bdwr.onDestroy();
      this.jdField_a_of_type_Bdwr = null;
      PtvTemplateManager.a();
      AVRedPacketManager.b();
      this.jdField_a_of_type_Leh.b();
      this.jdField_a_of_type_Lef.a();
      this.jdField_a_of_type_Ldw.a();
      this.jdField_a_of_type_Lds.a();
      this.jdField_a_of_type_Led.b();
      this.jdField_a_of_type_Lek.b();
      this.jdField_a_of_type_Ldu.b();
      this.jdField_a_of_type_Ldz.b();
      this.jdField_a_of_type_Leb.b();
      this.jdField_a_of_type_Leq.b();
      lfh.a(getApp());
      lhu.b();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Bdwr.onDestroy();
      }
    }
  }
  
  public void removeObserver(anil paramanil)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramanil);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    lbc.c(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_Lfg.a(paramToServiceMsg, null, lcw.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
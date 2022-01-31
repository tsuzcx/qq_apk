package com.tencent.av.app;

import alpd;
import alpg;
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
import awgg;
import axmc;
import azcj;
import azqs;
import azrp;
import baue;
import bavd;
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
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
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
import lek;
import lfz;
import lga;
import lgc;
import lgf;
import lgy;
import lha;
import lhc;
import lhf;
import lhh;
import lhj;
import lhl;
import lhn;
import lhq;
import lhu;
import lhv;
import lhy;
import lid;
import lih;
import lii;
import lil;
import lim;
import lja;
import ljg;
import ljh;
import lji;
import lkv;
import lkx;
import lkz;
import lmr;
import lrq;
import lyo;
import lyu;
import mbt;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mvj;

public class VideoAppInterface
  extends AppInterface
  implements azrp
{
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  protected Handler a;
  private awgg jdField_a_of_type_Awgg;
  private bavd jdField_a_of_type_Bavd;
  public VideoController a;
  protected DeviceCapabilityExamination a;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<alpg> a;
  private lfz jdField_a_of_type_Lfz;
  private lga jdField_a_of_type_Lga;
  lgf jdField_a_of_type_Lgf;
  lgy jdField_a_of_type_Lgy;
  lha jdField_a_of_type_Lha;
  lhc jdField_a_of_type_Lhc;
  lhf jdField_a_of_type_Lhf;
  lhh jdField_a_of_type_Lhh;
  lhj jdField_a_of_type_Lhj;
  lhl jdField_a_of_type_Lhl;
  lhn jdField_a_of_type_Lhn;
  lhq jdField_a_of_type_Lhq;
  lhu jdField_a_of_type_Lhu;
  private lhv jdField_a_of_type_Lhv;
  lhy jdField_a_of_type_Lhy;
  lii jdField_a_of_type_Lii = null;
  private lil jdField_a_of_type_Lil;
  private lja jdField_a_of_type_Lja;
  public ljh a;
  protected lji a;
  lmr jdField_a_of_type_Lmr;
  private final lrq jdField_a_of_type_Lrq = new lrq();
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
    this.jdField_a_of_type_Lgy.b();
    this.jdField_a_of_type_Lhc.b();
    this.jdField_a_of_type_Lhj.a();
    this.jdField_a_of_type_Lhq.a();
    this.jdField_a_of_type_Lha.a();
    this.jdField_a_of_type_Lhf.a();
    this.jdField_a_of_type_Lhn.a();
    this.jdField_a_of_type_Lhl.b();
    this.jdField_a_of_type_Lhh.a();
    this.jdField_a_of_type_Lhv.a();
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
    getApp().registerReceiver(new lih(this), localIntentFilter);
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
    return this.jdField_a_of_type_Lhy.a(paramInt, paramString);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Lhy.a(paramString);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_Lhy.a(paramString);
  }
  
  public alpd a(int paramInt)
  {
    return this.jdField_a_of_type_Lja.a(this, paramInt);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_a_of_type_Lhy.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_a_of_type_Lhy.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
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
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("red_touch_app_id", paramString);
    paramString = a(7, 0, 0, localBundle, null);
    if (paramString == null) {
      return null;
    }
    paramString.setClassLoader(RedAppInfo.class.getClassLoader());
    return axmc.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String a()
  {
    String str2 = getApp().getString(2131721349);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().d;
      int i = ((VideoController)localObject).a().i;
      localObject = ((VideoController)localObject).a().f;
      str1 = str2;
      if (i == 9500) {
        str1 = getDisplayName(i, str3, (String)localObject) + getApp().getString(2131721351);
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_Lhy.b(paramString);
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_Lhh.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public lfz a()
  {
    return this.jdField_a_of_type_Lfz;
  }
  
  public lga a()
  {
    return this.jdField_a_of_type_Lga;
  }
  
  public lii a()
  {
    if (this.jdField_a_of_type_Lii == null) {
      this.jdField_a_of_type_Lii = new lii(this);
    }
    return this.jdField_a_of_type_Lii;
  }
  
  public ljg a(int paramInt)
  {
    return this.jdField_a_of_type_Ljh.a(paramInt);
  }
  
  public lmr a()
  {
    return this.jdField_a_of_type_Lmr;
  }
  
  public lrq a()
  {
    if (this.h) {
      return this.jdField_a_of_type_Lrq;
    }
    synchronized (this.jdField_a_of_type_Lrq)
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
          this.jdField_a_of_type_Lrq.a("BEAUTY_SKIN", j);
          i = j;
        }
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_Lrq;
      label133:
      this.jdField_a_of_type_Lrq.a(str);
      int i = -1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, azcj.class);
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
            String str = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
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
    this.jdField_a_of_type_Ljh.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Lhy.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Lhy.a(paramLong);
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video exit, mIsExit[" + this.e + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_Ljh + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        this.e = true;
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
            azqs.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
            this.jdField_a_of_type_ComTencentAvVideoController.C();
          }
          this.jdField_b_of_type_Boolean = false;
          mbt.a(paramLong, getApplication());
          lyo.b(getApplication());
          lek.d(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
          QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
          localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
          if (localObject == null) {}
        }
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
          ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
          localObject = mvj.a(this);
          if (localObject != null) {
            ((mvj)localObject).a();
          }
          lek.d(jdField_a_of_type_JavaLangString, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_Lfz != null)
          {
            if (this.jdField_a_of_type_Lfz.a()) {
              this.jdField_a_of_type_Lfz.a(bool);
            }
            if (this.jdField_a_of_type_Lfz.c()) {
              this.jdField_a_of_type_ComTencentAvVideoController.q(false);
            }
            if (this.jdField_a_of_type_Lfz.b()) {
              this.jdField_a_of_type_ComTencentAvVideoController.o(false);
            }
          }
          return;
          bool = false;
          continue;
          azqs.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            lek.d(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Lhy.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_Lil.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    lkz locallkz = (lkz)a(4);
    if (locallkz != null)
    {
      locallkz.a(paramString);
      locallkz.a(36, 1L);
      locallkz.a(29, 1L);
      locallkz.b();
      lkx.a(16, 1L);
      lkx.c();
    }
    onDestroy();
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Lhh.a(paramString, paramInt);
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
      if ((this.jdField_a_of_type_Lhy != null) && (this.jdField_a_of_type_Lhy.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lhy != null) {
      this.jdField_a_of_type_Lhy.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_a_of_type_Lgf.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lgf.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Ljh.a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.jdField_a_of_type_Lhy.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Lhy.a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Lhy.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_Lhy.a(paramString, paramInt);
  }
  
  public boolean a(lyu paramlyu)
  {
    return this.jdField_a_of_type_Lhy.a(paramlyu);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_Lhy.a(paramString);
  }
  
  public void addObserver(alpg paramalpg)
  {
    addObserver(paramalpg, false);
  }
  
  public void addObserver(alpg paramalpg, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramalpg)) {
      this.jdField_a_of_type_JavaUtilList.add(paramalpg);
    }
  }
  
  public int b(String paramString)
  {
    return a().a(paramString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Lhy.a();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_Lhy.c(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Lhy.c();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Ljh.a(paramInt);
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Lhy.a(paramInt, paramString);
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
        lkv.a(this.f, this.g);
      }
      return;
      this.g = true;
    }
    a().postDelayed(new VideoAppInterface.2(this), 3000L);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lhy.b();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Lhy.b(paramString);
  }
  
  public boolean b(lyu paramlyu)
  {
    return this.jdField_a_of_type_Lhy.b(paramlyu);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Lhy.d();
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Lhy.b(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Lhy.a(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lhy.c();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_Lhy.c(paramString);
  }
  
  public void d()
  {
    a().b();
    l();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Lhy.b(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Lhy.d();
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_Lhy.c(paramString);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Lhy.e();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Lhy.f();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Lhy.g();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<alpg> getBusinessObserver(int paramInt)
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
    return this.jdField_a_of_type_Lhy.b(paramInt, paramString1, paramString2);
  }
  
  public awgg getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_Awgg == null) {
      this.jdField_a_of_type_Awgg = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_Awgg;
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { lgc.class };
  }
  
  public baue getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bavd == null) {
      this.jdField_a_of_type_Bavd = new bavd();
    }
    return this.jdField_a_of_type_Bavd.a(this, paramInt);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Lhy.h();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Lhy.a();
  }
  
  public boolean j()
  {
    lrq locallrq = a();
    if (locallrq.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    if (AEFilterSupport.a()) {
      return locallrq.b();
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
    lkx.a(this);
    lkx.a();
    lkx.a(27);
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    j();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    h();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Lhu = new lhu(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Lhu);
    this.jdField_a_of_type_Lil = new lil(this);
    this.jdField_a_of_type_Lja = new lja();
    this.jdField_a_of_type_Lja.a(this.jdField_a_of_type_Lil);
    this.jdField_a_of_type_Ljh = new ljh(this);
    this.jdField_a_of_type_Lji = new lji(this);
    g();
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Lhc = new lhc(this);
    this.jdField_a_of_type_Lgy = new lgy(this);
    this.jdField_a_of_type_Lhj = new lhj(this);
    this.jdField_a_of_type_Lhq = new lhq(this);
    this.jdField_a_of_type_Lha = new lha(this);
    this.jdField_a_of_type_Lhf = new lhf(this);
    this.jdField_a_of_type_Lhn = new lhn(this);
    this.jdField_a_of_type_Lhl = new lhl(this);
    this.jdField_a_of_type_Lhh = new lhh(this);
    this.jdField_a_of_type_Lfz = new lfz(this);
    this.jdField_a_of_type_Lga = new lga(this);
    this.jdField_a_of_type_Lhv = new lhv(this);
    this.jdField_a_of_type_Lhy = new lhy(this);
    this.jdField_a_of_type_Lhy.a();
    this.jdField_a_of_type_Lhy.c();
    this.jdField_a_of_type_Lgf = new lgf(this);
    this.jdField_a_of_type_Lgf.a();
    this.jdField_a_of_type_Lmr = new lmr(this);
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
    this.jdField_a_of_type_Lgf.b();
    this.jdField_a_of_type_Lhy.b();
    this.jdField_a_of_type_Lhy.d();
    if (this.jdField_a_of_type_Bavd != null) {}
    try
    {
      this.jdField_a_of_type_Bavd.onDestroy();
      this.jdField_a_of_type_Bavd = null;
      PtvTemplateManager.a();
      AVRedPacketManager.b();
      this.jdField_a_of_type_Lhn.b();
      this.jdField_a_of_type_Lhl.a();
      this.jdField_a_of_type_Lhc.a();
      this.jdField_a_of_type_Lgy.a();
      this.jdField_a_of_type_Lhj.b();
      this.jdField_a_of_type_Lhq.b();
      this.jdField_a_of_type_Lha.b();
      this.jdField_a_of_type_Lhf.b();
      this.jdField_a_of_type_Lhh.b();
      this.jdField_a_of_type_Lhv.b();
      lim.a(getApp());
      lkx.b();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Bavd.onDestroy();
      }
    }
  }
  
  public void removeObserver(alpg paramalpg)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramalpg);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    lek.c(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_Lil.a(paramToServiceMsg, null, lgc.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
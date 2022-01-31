package com.tencent.mobileqq.app.automator.step;

import acin;
import acip;
import ajmm;
import ajtd;
import ajxz;
import ajya;
import ajyb;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import awao;
import awrn;
import badq;
import befa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.app.MainService;
import obz;
import ogy;
import ohd;
import zrr;

public class RegisterProxy
  extends AsyncStep
{
  public static int d;
  public long a;
  ajmm jdField_a_of_type_Ajmm;
  private ajxz jdField_a_of_type_Ajxz;
  Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k;
  
  public RegisterProxy()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + "[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = " + paramBoolean);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler = new ajyb(this, ThreadManager.getSubThreadLooper());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_a_of_type_JavaLangString + "[ReSendProxy] RESULT_NET_CONNECT resend request!");
    }
    super.a(4);
  }
  
  private void b()
  {
    long l1 = SystemClock.uptimeMillis();
    long l2;
    long l3;
    HashMap localHashMap;
    String str;
    if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
    {
      befa.a().k();
      l2 = l1 + BaseApplicationImpl.sLaunchTime;
      l3 = l1 + BaseApplicationImpl.sShowTime;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        QLog.i("AutoMonitor", 2, "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b <= 9) {
          break label534;
        }
        str = ">9";
        label151:
        localHashMap.put("param_FailCount", str);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b <= 0) {
          break label549;
        }
        str = "CLIENT_TIMEOUT";
        label175:
        localHashMap.put("param_FailCode", str);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.jdField_a_of_type_Long));
        localHashMap.put("param_threadOpId", String.valueOf(ajtd.a().a()));
        localHashMap.put("param_cacheConfig", String.valueOf(MsgLruCache.cacheConfig));
        localHashMap.put("param_hc_state", String.valueOf(zrr.a().a()));
        localHashMap.put("param_model", Build.MODEL);
        if (d != 0) {
          break label557;
        }
        awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginB", true, l2, 0L, localHashMap, null);
        awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginR", true, l3, 0L, localHashMap, null);
      }
    }
    else
    {
      label316:
      BaseApplicationImpl.sShowTime = 0L;
      BaseApplicationImpl.sLaunchTime = 0L;
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l1 -= BaseApplicationImpl.appStartTime;
        if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!BaseApplicationImpl.isFirstLogin)) {
          break label693;
        }
        str = "1";
        label354:
        Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + str);
        localHashMap = new HashMap();
        localHashMap.put("actLoginType", str);
        if (d != 0) {
          break label741;
        }
        awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginT", true, l1, 0L, localHashMap, null);
      }
    }
    for (;;)
    {
      BaseApplicationImpl.appStartTime = 0L;
      d = 0;
      return;
      Log.i("AutoMonitor", "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
      Log.i("AutoMonitor", "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
      break;
      label534:
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b);
      break label151;
      label549:
      str = "";
      break label175;
      label557:
      localHashMap.put("param_exceptionReason", String.valueOf(d));
      awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginB_prxyError", true, l2, 0L, localHashMap, null);
      awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginR_prxyError", true, l3, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationB:" + l2 + ", durationR:" + l3 + ",totalFailCount:" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b + ",actBExcetpionReason=" + d);
      break label316;
      label693:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin))
      {
        str = "2";
        break label354;
      }
      if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin))
      {
        str = "3";
        break label354;
      }
      str = "4";
      break label354;
      label741:
      awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, "actLoginT_prxyError", true, l1, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationT:" + l1 + ",actLoginType:" + str + ",actBExcetpionReason=" + d);
    }
  }
  
  private boolean b()
  {
    return (this.f == 2) && (this.g == 2) && (this.h == 2) && (this.i == 2);
  }
  
  public int a()
  {
    this.k = zrr.a().a(0, 1, 1, MainService.sNativeTidOfReceiver, 5000, 201, 131072L, Process.myTid(), "pullMsg");
    long l1 = System.currentTimeMillis();
    Object localObject;
    int m;
    long l2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
      if (this.b == 18)
      {
        m = 2;
        ((MessageHandler)localObject).a(m);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      l2 = (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
      if (this.b != 18) {
        break label284;
      }
      MessageHandler.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(2, true, l2, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doStep , mStepId = ").append(this.b).append(" , isGetPassword = ");
        if (this.b != 17) {
          break label376;
        }
      }
    }
    label284:
    label376:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("RegisterProxy", 2, bool + " ,isUseNewRegisterProxy = " + MessageHandler.b);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      if (QLog.isColorLevel()) {
        QLog.i("AutoMonitor", 2, "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      }
      return 2;
      m = 1;
      break;
      if (MessageHandler.b)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
        if (this.b == 17) {}
        for (bool = true;; bool = false)
        {
          ((MessageHandler)localObject).a(l2, bool);
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a();
      if (this.b == 17) {}
      for (bool = true;; bool = false)
      {
        ((MessageHandler)localObject).a(1, true, l2, bool);
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajmm == null)
    {
      this.jdField_a_of_type_Ajmm = new ajya(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_Ajxz = new ajxz(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.addObserver(this.jdField_a_of_type_Ajxz);
    }
    if ((this.b == 17) || (this.b == 19)) {
      befa.a().a(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.c = 3;
    this.jdField_a_of_type_Boolean = false;
    MessageHandler.b = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(true);
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.d())
    {
      if (paramInt != 4) {
        break label26;
      }
      a(true);
    }
    for (;;)
    {
      super.a(paramInt);
      return;
      label26:
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      }
    }
  }
  
  public boolean a()
  {
    return ((this.e == 2) || (this.e == 1)) && ((this.f == 2) || (this.f == 1)) && ((this.i == 2) || (this.i == 1)) && ((this.g == 2) || (this.g == 1)) && ((this.h == 2) || (this.h == 1));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Ajmm != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_Ajmm = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.removeObserver(this.jdField_a_of_type_Ajxz);
      this.jdField_a_of_type_Ajxz = null;
    }
    if ((this.jdField_a_of_type_Int != 7) || (!b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "RegisterProxy result:" + this.jdField_a_of_type_Int + " ,syncSucc:" + b());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().c(true);
    }
    befa.a().b(Thread.currentThread().getThreadGroup().activeCount());
    b();
    if (this.b == 17)
    {
      acin.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app);
      acip.a().a(BaseActivity.sTopActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().a(b());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().f();
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
      Log.i("AutoMonitor", "SyncData, cost=" + l);
      if (badq.g(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true)) {
          break label464;
        }
        localObject = "actSyncMsgFirst";
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFirstQQInit", false).commit();
        awrn.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getApp()).a(null, (String)localObject, b(), l, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.a().b()) {}
    for (int m = 2;; m = 1)
    {
      ((Automator)localObject).jdField_a_of_type_Int = m;
      if (obz.d(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app))
      {
        localObject = (ohd)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getManager(163);
        if (localObject != null) {
          ((ohd)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.app.getLongAccountUin());
        }
      }
      MsfServiceSdk.get().registerProxyDone();
      if (this.k != 0)
      {
        zrr.a().a(this.k);
        this.k = 0;
      }
      return;
      label464:
      localObject = "actSyncMsgSecond";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */
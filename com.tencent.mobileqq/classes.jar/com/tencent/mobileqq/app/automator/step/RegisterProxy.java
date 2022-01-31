package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.Random;
import zoe;
import zof;
import zog;

public class RegisterProxy
  extends AsyncStep
{
  public static int d;
  public long a;
  Handler jdField_a_of_type_AndroidOsHandler;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private zoe jdField_a_of_type_Zoe;
  private boolean jdField_a_of_type_Boolean;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  
  public RegisterProxy()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + "[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = " + paramBoolean);
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler = new zog(this, ThreadManager.getSubThreadLooper());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.jdField_b_of_type_JavaLangString + "[ReSendProxy] RESULT_NET_CONNECT resend request!");
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
      MsgAutoMonitorUtil.a().k();
      l2 = l1 + BaseApplicationImpl.sLaunchTime;
      l3 = l1 + BaseApplicationImpl.sShowTime;
      if (QLog.isColorLevel())
      {
        QLog.i("AutoMonitor", 2, "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int);
        QLog.i("AutoMonitor", 2, "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int);
        localHashMap = new HashMap();
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int <= 9) {
          break label504;
        }
        str = ">9";
        label151:
        localHashMap.put("param_FailCount", str);
        if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int <= 0) {
          break label519;
        }
        str = "CLIENT_TIMEOUT";
        label175:
        localHashMap.put("param_FailCode", str);
        localHashMap.put("param_TimeoutCode", String.valueOf(this.jdField_a_of_type_Long));
        localHashMap.put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
        localHashMap.put("param_cacheConfig", String.valueOf(MsgLruCache.cacheConfig));
        if (d != 0) {
          break label526;
        }
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actLoginB", true, l2, 0L, localHashMap, null);
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actLoginR", true, l3, 0L, localHashMap, null);
      }
    }
    else
    {
      label288:
      BaseApplicationImpl.sShowTime = 0L;
      BaseApplicationImpl.sLaunchTime = 0L;
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l1 -= BaseApplicationImpl.appStartTime;
        if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!BaseApplicationImpl.isFirstLogin)) {
          break label661;
        }
        str = "1";
        label326:
        Log.i("AutoMonitor", "ActionLoginT, cost=" + l1 + ", actLoginType=" + str);
        localHashMap = new HashMap();
        localHashMap.put("actLoginType", str);
        if (d != 0) {
          break label709;
        }
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actLoginT", true, l1, 0L, localHashMap, null);
      }
    }
    for (;;)
    {
      BaseApplicationImpl.appStartTime = 0L;
      d = 0;
      return;
      Log.i("AutoMonitor", "ActionLoginB, cost=" + l2 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int);
      Log.i("AutoMonitor", "ActionLoginR, cost=" + l3 + ", totalFailCount=" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int);
      break;
      label504:
      str = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int);
      break label151;
      label519:
      str = "";
      break label175;
      label526:
      localHashMap.put("param_exceptionReason", String.valueOf(d));
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actLoginB_prxyError", true, l2, 0L, localHashMap, null);
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actLoginR_prxyError", true, l3, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationB:" + l2 + ", durationR:" + l3 + ",totalFailCount:" + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int + ",actBExcetpionReason=" + d);
      break label288;
      label661:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin))
      {
        str = "2";
        break label326;
      }
      if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin))
      {
        str = "3";
        break label326;
      }
      str = "4";
      break label326;
      label709:
      StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "actLoginT_prxyError", true, l1, 0L, localHashMap, null);
      QLog.i("QQInitHandler", 1, "prxyError durationT:" + l1 + ",actLoginType:" + str + ",actBExcetpionReason=" + d);
    }
  }
  
  private boolean b()
  {
    return (this.f == 2) && (this.g == 2) && (this.h == 2) && (this.i == 2);
  }
  
  protected int a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject;
    int k;
    long l2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (this.jdField_b_of_type_Int == 18)
      {
        k = 2;
        ((MessageHandler)localObject).a(k);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    else
    {
      l2 = (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
      if (this.jdField_b_of_type_Int != 18) {
        break label253;
      }
      MessageHandler.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2, true, l2, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doStep , mStepId = ").append(this.jdField_b_of_type_Int).append(" , isGetPassword = ");
        if (this.jdField_b_of_type_Int != 17) {
          break label346;
        }
      }
    }
    label346:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("RegisterProxy", 2, bool + " ,isUseNewRegisterProxy = " + MessageHandler.b);
      Log.i("AutoMonitor", "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      if (QLog.isColorLevel()) {
        QLog.i("AutoMonitor", 2, "STEP_SEND_REGISTER_PACKAGE, cost=" + (System.currentTimeMillis() - l1));
      }
      return 2;
      k = 1;
      break;
      label253:
      if (MessageHandler.b)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
        if (this.jdField_b_of_type_Int == 17) {}
        for (bool = true;; bool = false)
        {
          ((MessageHandler)localObject).a(1, l2, bool);
          break;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (this.jdField_b_of_type_Int == 17) {}
      for (bool = true;; bool = false)
      {
        ((MessageHandler)localObject).a(1, true, l2, bool);
        break;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new zof(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_Zoe = new zoe(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Zoe);
    }
    if ((this.jdField_b_of_type_Int == 17) || (this.jdField_b_of_type_Int == 19)) {
      MsgAutoMonitorUtil.a().a(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.c = 3;
    this.jdField_a_of_type_Boolean = false;
    MessageHandler.b = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
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
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Zoe);
      this.jdField_a_of_type_Zoe = null;
    }
    if ((this.jdField_a_of_type_Int != 7) || (!b()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "RegisterProxy result:" + this.jdField_a_of_type_Int + " ,syncSucc:" + b());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(true);
    }
    MsgAutoMonitorUtil.a().b(Thread.currentThread().getThreadGroup().activeCount());
    b();
    if (this.jdField_b_of_type_Int == 17)
    {
      AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      AIOPreLoadEngine.a().a(BaseActivity.sTopActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(b());
    this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().g();
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
      Log.i("AutoMonitor", "SyncData, cost=" + l);
      if (NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true)) {
          break label442;
        }
        localObject = "actSyncMsgFirst";
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFirstQQInit", false).commit();
        StatisticCollector.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, (String)localObject, b(), l, this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_Int, null, null);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b()) {}
    for (int k = 2;; k = 1)
    {
      ((Automator)localObject).jdField_a_of_type_Int = k;
      if (ReadInJoyUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        localObject = (ReadInJoyLogicManager)this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162);
        if (localObject != null) {
          ((ReadInJoyLogicManager)localObject).a().a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        }
      }
      MsfServiceSdk.get().registerProxyDone();
      return;
      label442:
      localObject = "actSyncMsgSecond";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */
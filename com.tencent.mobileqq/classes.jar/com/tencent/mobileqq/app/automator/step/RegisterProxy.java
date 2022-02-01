package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOPreLoadEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.LoginSetting;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.threadpriority.ThreadOptimizer;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MainService;

public class RegisterProxy
  extends AsyncStep
{
  public static int a;
  long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler;
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  private RegisterProxy.MyAutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$MyAutomatorObserver;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  
  private void a()
  {
    long l1 = SystemClock.uptimeMillis();
    Object localObject1;
    Object localObject2;
    if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
    {
      MsgAutoMonitorUtil.getInstance().printMsgInfo();
      long l2 = BaseApplicationImpl.sLaunchTime + l1;
      long l3 = l1 + BaseApplicationImpl.sShowTime;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginB, cost=");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(", totalFailCount=");
        ((StringBuilder)localObject1).append(this.mAutomator.jdField_b_of_type_Int);
        QLog.i("AutoMonitor", 2, ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginR, cost=");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(", totalFailCount=");
        ((StringBuilder)localObject1).append(this.mAutomator.jdField_b_of_type_Int);
        QLog.i("AutoMonitor", 2, ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginB, cost=");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(", totalFailCount=");
        ((StringBuilder)localObject1).append(this.mAutomator.jdField_b_of_type_Int);
        Log.i("AutoMonitor", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginR, cost=");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(", totalFailCount=");
        ((StringBuilder)localObject1).append(this.mAutomator.jdField_b_of_type_Int);
        Log.i("AutoMonitor", ((StringBuilder)localObject1).toString());
      }
      localObject2 = new HashMap();
      if (this.mAutomator.jdField_b_of_type_Int > 9) {
        localObject1 = ">9";
      } else {
        localObject1 = String.valueOf(this.mAutomator.jdField_b_of_type_Int);
      }
      ((HashMap)localObject2).put("param_FailCount", localObject1);
      if (this.mAutomator.jdField_b_of_type_Int > 0) {
        localObject1 = "CLIENT_TIMEOUT";
      } else {
        localObject1 = "";
      }
      ((HashMap)localObject2).put("param_FailCode", localObject1);
      ((HashMap)localObject2).put("param_TimeoutCode", String.valueOf(this.jdField_a_of_type_Long));
      ((HashMap)localObject2).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
      ((HashMap)localObject2).put("param_hc_state", String.valueOf(HardCoderManager.a().a()));
      ((HashMap)localObject2).put("param_model", Build.MODEL);
      ((HashMap)localObject2).put("param_PluginDelayTime", String.valueOf(this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getLong("PREF_PLUGIN_DELAY_TIME", -1L)));
      localObject1 = this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str1 = (String)((Iterator)localObject1).next();
        if (this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str1))
        {
          try
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("param_");
            localStringBuilder.append(str1);
            ((HashMap)localObject2).put(localStringBuilder.toString(), String.valueOf(this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str1)));
          }
          catch (Throwable localThrowable) {}
          if (QLog.isColorLevel()) {
            QLog.d("QQInitHandler", 2, "add param exception ", localThrowable);
          }
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("param_");
      ((StringBuilder)localObject1).append(this.mName);
      ((HashMap)localObject2).put(((StringBuilder)localObject1).toString(), String.valueOf(l1 - this.jdField_b_of_type_Long));
      if (QLog.isColorLevel())
      {
        localObject1 = ((HashMap)localObject2).keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str2 = (String)((Iterator)localObject1).next();
          QLog.d("QQInitHandler", 2, new Object[] { str2, "=", ((HashMap)localObject2).get(str2) });
        }
      }
      int i = jdField_a_of_type_Int;
      if (i == 0)
      {
        StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actLoginB", true, l2, 0L, (HashMap)localObject2, null);
        StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actLoginR", true, l3, 0L, (HashMap)localObject2, null);
      }
      else
      {
        ((HashMap)localObject2).put("param_exceptionReason", String.valueOf(i));
        StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actLoginB_prxyError", true, l2, 0L, (HashMap)localObject2, null);
        StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actLoginR_prxyError", true, l3, 0L, (HashMap)localObject2, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("prxyError durationB:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(", durationR:");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(",totalFailCount:");
        ((StringBuilder)localObject1).append(this.mAutomator.jdField_b_of_type_Int);
        ((StringBuilder)localObject1).append(",actBExcetpionReason=");
        ((StringBuilder)localObject1).append(jdField_a_of_type_Int);
        QLog.i("QQInitHandler", 1, ((StringBuilder)localObject1).toString());
      }
    }
    BaseApplicationImpl.sShowTime = 0L;
    BaseApplicationImpl.sLaunchTime = 0L;
    if (BaseApplicationImpl.appStartTime > 0L)
    {
      l1 -= BaseApplicationImpl.appStartTime;
      if ((AutomatorHelper.b) && (LoginSetting.jdField_a_of_type_Boolean)) {
        localObject1 = "1";
      } else if ((AutomatorHelper.b) && (!LoginSetting.jdField_a_of_type_Boolean)) {
        localObject1 = "2";
      } else if ((!AutomatorHelper.b) && (LoginSetting.jdField_a_of_type_Boolean)) {
        localObject1 = "3";
      } else {
        localObject1 = "4";
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ActionLoginT, cost=");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(", actLoginType=");
      ((StringBuilder)localObject2).append((String)localObject1);
      Log.i("AutoMonitor", ((StringBuilder)localObject2).toString());
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("actLoginType", localObject1);
      if (jdField_a_of_type_Int == 0)
      {
        StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actLoginT", true, l1, 0L, (HashMap)localObject2, null);
      }
      else
      {
        StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "actLoginT_prxyError", true, l1, 0L, (HashMap)localObject2, null);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("prxyError durationT:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(",actLoginType:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",actBExcetpionReason=");
        ((StringBuilder)localObject2).append(jdField_a_of_type_Int);
        QLog.i("QQInitHandler", 1, ((StringBuilder)localObject2).toString());
      }
    }
    BaseApplicationImpl.appStartTime = 0L;
    jdField_a_of_type_Int = 0;
  }
  
  private void a(Object paramObject)
  {
    k = 0;
    i = k;
    try
    {
      if ((paramObject instanceof Bundle))
      {
        j = 1;
        localObject1 = ((Bundle)paramObject).get("ToServiceMsg");
        localObject2 = ((Bundle)paramObject).get("FromServiceMsg");
        paramObject = new HashMap(4);
        bool = localObject1 instanceof ToServiceMsg;
        i = j;
        if (!bool) {}
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        int j;
        Object localObject1;
        Object localObject2;
        boolean bool;
        label86:
        i = k;
      }
    }
    try
    {
      a(((ToServiceMsg)localObject1).getAttribute("to_SendTime"), paramObject, "app2msf");
      i = j;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      break label86;
    }
    i = 0;
    j = i;
    if (i != 0)
    {
      bool = localObject2 instanceof FromServiceMsg;
      j = i;
      if (!bool) {}
    }
    try
    {
      a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2net"), paramObject, "msf2net");
      a(((FromServiceMsg)localObject2).getAttribute("__timestamp_net2msf"), paramObject, "net2msf");
      a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2app"), paramObject, "msf2app");
      a(((FromServiceMsg)localObject2).getAttribute("msf_receive"), paramObject, "msfReceive");
      j = i;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label189:
      break label189;
    }
    j = 0;
    i = k;
    if (j != 0)
    {
      i = k;
      if (!paramObject.isEmpty())
      {
        this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putAll(paramObject);
        this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("netCost", Long.valueOf(1L));
        i = j;
      }
    }
    if (i == 0) {
      this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("netCost", Long.valueOf(0L));
    }
  }
  
  private void a(Object paramObject, HashMap<String, Long> paramHashMap, String paramString)
  {
    if (paramObject != null)
    {
      long l = Long.parseLong(paramObject.toString());
      paramHashMap.put(paramString, Long.valueOf(l - this.jdField_c_of_type_Long));
      this.jdField_c_of_type_Long = l;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (!this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mName);
        localStringBuilder.append("[ReSendProxy] needSetReconnnect isAllRegisterProxyTroopResponseDone = false,waitingThreadDone = ");
        localStringBuilder.append(paramBoolean);
        QLog.d("QQInitHandler", 2, localStringBuilder.toString());
      }
      if (paramBoolean)
      {
        this.jdField_a_of_type_AndroidOsHandler = new RegisterProxy.ReconnectHandler(this, ThreadManager.getSubThreadLooper());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mName);
      localStringBuilder.append("[ReSendProxy] RESULT_NET_CONNECT resend request!");
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    super.setResult(4);
  }
  
  private boolean b()
  {
    return (this.jdField_c_of_type_Int == 2) && (this.d == 2) && (this.e == 2) && (this.f == 2);
  }
  
  boolean a()
  {
    int i = this.jdField_b_of_type_Int;
    if ((i == 2) || (i == 1))
    {
      i = this.jdField_c_of_type_Int;
      if ((i == 2) || (i == 1))
      {
        i = this.f;
        if ((i == 2) || (i == 1))
        {
          i = this.d;
          if ((i == 2) || (i == 1))
          {
            i = this.e;
            if (i == 2) {
              break label79;
            }
            if (i == 1) {
              return true;
            }
          }
        }
      }
    }
    return false;
    label79:
    return true;
  }
  
  protected int doStep()
  {
    Object localObject = HardCoderManager.a();
    int i = MainService.sNativeTidOfReceiver;
    int j = Process.myTid();
    boolean bool2 = true;
    this.h = ((HardCoderManager)localObject).a(0, 1, 1, i, 5000, 201, 131072L, j, "pullMsg");
    this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
      if (this.mStepId == 18) {
        i = 2;
      } else {
        i = 1;
      }
      ((MessageHandler)localObject).c(i);
      this.jdField_a_of_type_Boolean = false;
    }
    long l = (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    boolean bool1;
    if (this.mStepId == 18)
    {
      RegisterProxyHandler.c = false;
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(2, true, l, false);
    }
    else if (RegisterProxyHandler.jdField_a_of_type_Boolean)
    {
      localObject = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
      if (this.mStepId == 17) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((MessageHandler)localObject).a(l, bool1, false);
    }
    else
    {
      localObject = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
      if (this.mStepId == 17) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((MessageHandler)localObject).a(1, true, l, bool1);
    }
    this.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("SERP", Long.valueOf(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doStep , mStepId = ");
      ((StringBuilder)localObject).append(this.mStepId);
      ((StringBuilder)localObject).append(" , isGetPassword = ");
      if (this.mStepId == 17) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" ,isUseNewRegisterProxy = ");
      ((StringBuilder)localObject).append(RegisterProxyHandler.jdField_a_of_type_Boolean);
      QLog.d("RegisterProxy", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("STEP_SEND_REGISTER_PACKAGE, cost=");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - this.jdField_b_of_type_Long);
    Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
    return 2;
  }
  
  public void onCreate()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new RegisterProxy.MyMessageObserver(this, null);
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addDefaultObservers(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$MyAutomatorObserver = new RegisterProxy.MyAutomatorObserver(this, null);
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$MyAutomatorObserver);
    }
    if ((this.mStepId == 17) || (this.mStepId == 19)) {
      MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumBegin(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.mCountRetry = 3;
    this.jdField_a_of_type_Boolean = false;
    RegisterProxyHandler.jdField_a_of_type_Boolean = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().a(true);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver != null)
    {
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = null;
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$MyAutomatorObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepRegisterProxy$MyAutomatorObserver = null;
    }
    int j = this.mResult;
    int i = 2;
    if ((j != 7) || (!b()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("RegisterProxy result:");
        ((StringBuilder)localObject).append(this.mResult);
        ((StringBuilder)localObject).append(" ,syncSucc:");
        ((StringBuilder)localObject).append(b());
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
      }
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c(true);
    }
    MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumEnd(Thread.currentThread().getThreadGroup().activeCount());
    a();
    if (this.mStepId == 17)
    {
      AIOInputTypeHelper.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      AIOPreLoadEngine.a().a(BaseActivity.sTopActivity);
    }
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c(b());
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().n();
    if (this.mAutomator.jdField_a_of_type_Long > 0L)
    {
      long l = System.currentTimeMillis() - this.mAutomator.jdField_a_of_type_Long;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SyncData, cost=");
      ((StringBuilder)localObject).append(l);
      Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
      if (NetworkUtil.isNetworkAvailable(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
      {
        if (this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true))
        {
          this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isFirstQQInit", false).commit();
          localObject = "actSyncMsgFirst";
        }
        else
        {
          localObject = "actSyncMsgSecond";
        }
        StatisticCollector.getInstance(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, (String)localObject, b(), l, this.mAutomator.jdField_b_of_type_Int, null, null);
      }
    }
    Object localObject = this.mAutomator;
    if (!this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().b()) {
      i = 1;
    }
    ((Automator)localObject).jdField_a_of_type_Int = i;
    if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).shouldGetIndividualTimePush())
    {
      localObject = ((IReadInJoyLogicManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IReadInJoyLogicManager.class)).getReadInJoyLogicEngine();
      if (localObject != null) {
        ((IReadInJoyLogicEngine)localObject).a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      }
    }
    MsfServiceSdk.get().registerProxyDone();
    if (this.h != 0)
    {
      HardCoderManager.a().a(this.h);
      this.h = 0;
    }
  }
  
  public void setResult(int paramInt)
  {
    if (!this.mAutomator.d()) {
      if (paramInt == 4)
      {
        a(true);
      }
      else
      {
        Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null) {
          localHandler.removeMessages(100);
        }
      }
    }
    super.setResult(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */
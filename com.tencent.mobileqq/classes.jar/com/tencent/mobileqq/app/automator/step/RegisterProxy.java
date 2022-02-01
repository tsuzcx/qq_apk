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
import com.tencent.mobileqq.perf.report.FeatureFlag;
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
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MainService;

public class RegisterProxy
  extends AsyncStep
{
  public static int c = 0;
  public static double d = -1.0D;
  long a = 0L;
  Handler b;
  MessageObserver e;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  private int k = 0;
  private RegisterProxy.MyAutomatorObserver l;
  private boolean m = false;
  private int n = 0;
  private long o;
  private long p = 0L;
  
  private void a(Object paramObject)
  {
    i3 = 0;
    i1 = i3;
    try
    {
      if ((paramObject instanceof Bundle))
      {
        i2 = 1;
        localObject1 = ((Bundle)paramObject).get("ToServiceMsg");
        localObject2 = ((Bundle)paramObject).get("FromServiceMsg");
        paramObject = new HashMap(4);
        bool = localObject1 instanceof ToServiceMsg;
        i1 = i2;
        if (!bool) {}
      }
    }
    catch (Throwable paramObject)
    {
      for (;;)
      {
        int i2;
        Object localObject1;
        Object localObject2;
        boolean bool;
        label82:
        i1 = i3;
      }
    }
    try
    {
      a(((ToServiceMsg)localObject1).getAttribute("to_SendTime"), paramObject, "app2msf");
      i1 = i2;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      break label82;
    }
    i1 = 0;
    i2 = i1;
    if (i1 != 0)
    {
      bool = localObject2 instanceof FromServiceMsg;
      i2 = i1;
      if (!bool) {}
    }
    try
    {
      a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2net"), paramObject, "msf2net");
      a(((FromServiceMsg)localObject2).getAttribute("__timestamp_net2msf"), paramObject, "net2msf");
      a(((FromServiceMsg)localObject2).getAttribute("__timestamp_msf2app"), paramObject, "msf2app");
      a(((FromServiceMsg)localObject2).getAttribute("msf_receive"), paramObject, "msfReceive");
      i2 = i1;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label177:
      break label177;
    }
    i2 = 0;
    i1 = i3;
    if (i2 != 0)
    {
      i1 = i3;
      if (!paramObject.isEmpty())
      {
        this.mAutomator.j.putAll(paramObject);
        this.mAutomator.j.put("netCost", Long.valueOf(1L));
        i1 = i2;
      }
    }
    if (i1 == 0) {
      this.mAutomator.j.put("netCost", Long.valueOf(0L));
    }
  }
  
  private void a(Object paramObject, HashMap<String, Long> paramHashMap, String paramString)
  {
    if (paramObject != null)
    {
      long l1 = Long.parseLong(paramObject.toString());
      paramHashMap.put(paramString, Long.valueOf(l1 - this.p));
      this.p = l1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (!this.mAutomator.k.getMsgHandler().A())
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
        this.b = new RegisterProxy.ReconnectHandler(this, ThreadManager.getSubThreadLooper());
        this.b.sendEmptyMessageDelayed(100, 3000L);
      }
      return;
    }
    this.m = true;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.mName);
      localStringBuilder.append("[ReSendProxy] RESULT_NET_CONNECT resend request!");
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    super.setResult(4);
  }
  
  private void b()
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
        ((StringBuilder)localObject1).append(this.mAutomator.c);
        QLog.i("AutoMonitor", 2, ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginR, cost=");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(", totalFailCount=");
        ((StringBuilder)localObject1).append(this.mAutomator.c);
        QLog.i("AutoMonitor", 2, ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginB, cost=");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(", totalFailCount=");
        ((StringBuilder)localObject1).append(this.mAutomator.c);
        Log.i("AutoMonitor", ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("ActionLoginR, cost=");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(", totalFailCount=");
        ((StringBuilder)localObject1).append(this.mAutomator.c);
        Log.i("AutoMonitor", ((StringBuilder)localObject1).toString());
      }
      d = l3;
      localObject2 = new HashMap();
      if (this.mAutomator.c > 9) {
        localObject1 = ">9";
      } else {
        localObject1 = String.valueOf(this.mAutomator.c);
      }
      ((HashMap)localObject2).put("param_FailCount", localObject1);
      if (this.mAutomator.c > 0) {
        localObject1 = "CLIENT_TIMEOUT";
      } else {
        localObject1 = "";
      }
      ((HashMap)localObject2).put("param_FailCode", localObject1);
      ((HashMap)localObject2).put("param_TimeoutCode", String.valueOf(this.a));
      ((HashMap)localObject2).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().c()));
      ((HashMap)localObject2).put("param_hc_state", String.valueOf(HardCoderManager.getInstance().getState()));
      ((HashMap)localObject2).put("param_model", Build.MODEL);
      ((HashMap)localObject2).put("param_PluginDelayTime", String.valueOf(this.mAutomator.d.getLong("PREF_PLUGIN_DELAY_TIME", -1L)));
      localObject1 = this.mAutomator.j.keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        String str1 = (String)((Iterator)localObject1).next();
        if (this.mAutomator.j.containsKey(str1))
        {
          try
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("param_");
            localStringBuilder.append(str1);
            ((HashMap)localObject2).put(localStringBuilder.toString(), String.valueOf(this.mAutomator.j.get(str1)));
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
      ((HashMap)localObject2).put(((StringBuilder)localObject1).toString(), String.valueOf(l1 - this.o));
      FeatureFlag.a((Map)localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = ((HashMap)localObject2).keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str2 = (String)((Iterator)localObject1).next();
          QLog.d("QQInitHandler", 2, new Object[] { str2, "=", ((HashMap)localObject2).get(str2) });
        }
      }
      ((HashMap)localObject2).put("costR", String.valueOf(l3));
      int i1 = c;
      if (i1 == 0)
      {
        StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(null, "actLoginB", true, l2, 0L, (HashMap)localObject2, null);
        StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(null, "actLoginR", true, l3, 0L, (HashMap)localObject2, null);
      }
      else
      {
        ((HashMap)localObject2).put("param_exceptionReason", String.valueOf(i1));
        StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(null, "actLoginB_prxyError", true, l2, 0L, (HashMap)localObject2, null);
        StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(null, "actLoginR_prxyError", true, l3, 0L, (HashMap)localObject2, null);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("prxyError durationB:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append(", durationR:");
        ((StringBuilder)localObject1).append(l3);
        ((StringBuilder)localObject1).append(",totalFailCount:");
        ((StringBuilder)localObject1).append(this.mAutomator.c);
        ((StringBuilder)localObject1).append(",actBExcetpionReason=");
        ((StringBuilder)localObject1).append(c);
        QLog.i("QQInitHandler", 1, ((StringBuilder)localObject1).toString());
      }
    }
    BaseApplicationImpl.sShowTime = 0L;
    BaseApplicationImpl.sLaunchTime = 0L;
    if (BaseApplicationImpl.appStartTime > 0L)
    {
      l1 -= BaseApplicationImpl.appStartTime;
      if ((AutomatorHelper.b) && (LoginSetting.a)) {
        localObject1 = "1";
      } else if ((AutomatorHelper.b) && (!LoginSetting.a)) {
        localObject1 = "2";
      } else if ((!AutomatorHelper.b) && (LoginSetting.a)) {
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
      if (c == 0)
      {
        StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(null, "actLoginT", true, l1, 0L, (HashMap)localObject2, null);
      }
      else
      {
        StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(null, "actLoginT_prxyError", true, l1, 0L, (HashMap)localObject2, null);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("prxyError durationT:");
        ((StringBuilder)localObject2).append(l1);
        ((StringBuilder)localObject2).append(",actLoginType:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(",actBExcetpionReason=");
        ((StringBuilder)localObject2).append(c);
        QLog.i("QQInitHandler", 1, ((StringBuilder)localObject2).toString());
      }
    }
    BaseApplicationImpl.appStartTime = 0L;
    c = 0;
  }
  
  private boolean c()
  {
    return (this.g == 2) && (this.h == 2) && (this.i == 2) && (this.j == 2);
  }
  
  boolean a()
  {
    int i1 = this.f;
    if ((i1 == 2) || (i1 == 1))
    {
      i1 = this.g;
      if ((i1 == 2) || (i1 == 1))
      {
        i1 = this.j;
        if ((i1 == 2) || (i1 == 1))
        {
          i1 = this.h;
          if ((i1 == 2) || (i1 == 1))
          {
            i1 = this.i;
            if (i1 == 2) {
              break label79;
            }
            if (i1 == 1) {
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
    Object localObject = HardCoderManager.getInstance();
    int i1 = MainService.sNativeTidOfReceiver;
    int i2 = Process.myTid();
    boolean bool2 = true;
    this.n = ((HardCoderManager)localObject).start(0, 1, 1, i1, 5000, 201, 131072L, i2, "pullMsg");
    this.o = SystemClock.uptimeMillis();
    if (this.m)
    {
      localObject = this.mAutomator.k.getMsgHandler();
      if (this.mStepId == 18) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      ((MessageHandler)localObject).h(i1);
      this.m = false;
    }
    long l1 = (int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt());
    this.p = System.currentTimeMillis();
    boolean bool1;
    if (this.mStepId == 18)
    {
      RegisterProxyHandler.l = false;
      this.mAutomator.k.getMsgHandler().a(2, true, l1, false);
    }
    else if (RegisterProxyHandler.c)
    {
      localObject = this.mAutomator.k.getMsgHandler();
      if (this.mStepId == 17) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((MessageHandler)localObject).a(l1, bool1, false);
    }
    else
    {
      localObject = this.mAutomator.k.getMsgHandler();
      if (this.mStepId == 17) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((MessageHandler)localObject).a(1, true, l1, bool1);
    }
    this.mAutomator.j.put("SERP", Long.valueOf(SystemClock.uptimeMillis() - this.o));
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
      ((StringBuilder)localObject).append(RegisterProxyHandler.c);
      QLog.d("RegisterProxy", 2, ((StringBuilder)localObject).toString());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("STEP_SEND_REGISTER_PACKAGE, cost=");
    ((StringBuilder)localObject).append(SystemClock.uptimeMillis() - this.o);
    Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
    return 2;
  }
  
  public void onCreate()
  {
    if (this.e == null)
    {
      this.e = new RegisterProxy.MyMessageObserver(this, null);
      this.mAutomator.k.addDefaultObservers(this.e);
      this.l = new RegisterProxy.MyAutomatorObserver(this, null);
      this.mAutomator.k.addObserver(this.l);
    }
    if ((this.mStepId == 17) || (this.mStepId == 19)) {
      MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumBegin(Thread.currentThread().getThreadGroup().activeCount());
    }
    this.mCountRetry = 3;
    this.m = false;
    RegisterProxyHandler.c = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("new_regprxy_switch", true);
    this.mAutomator.k.getMsgCache().d(true);
  }
  
  public void onDestroy()
  {
    if (this.e != null)
    {
      this.mAutomator.k.removeObserver(this.e);
      this.e = null;
      this.mAutomator.k.removeObserver(this.l);
      this.l = null;
    }
    int i2 = this.mResult;
    int i1 = 2;
    if ((i2 != 7) || (!c()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("RegisterProxy result:");
        ((StringBuilder)localObject).append(this.mResult);
        ((StringBuilder)localObject).append(" ,syncSucc:");
        ((StringBuilder)localObject).append(c());
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
      }
      this.mAutomator.k.getMsgCache().c(true);
    }
    MsgAutoMonitorUtil.getInstance().markMsgProxyThreadNumEnd(Thread.currentThread().getThreadGroup().activeCount());
    b();
    if (this.mStepId == 17)
    {
      AIOInputTypeHelper.a(this.mAutomator.k);
      AIOPreLoadEngine.a().a(BaseActivity.sTopActivity);
    }
    this.mAutomator.k.getMsgHandler().d(c());
    this.mAutomator.k.getMsgHandler().t();
    if (this.mAutomator.a > 0L)
    {
      long l1 = System.currentTimeMillis() - this.mAutomator.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SyncData, cost=");
      ((StringBuilder)localObject).append(l1);
      Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
      if (NetworkUtil.isNetworkAvailable(this.mAutomator.k.getApp()))
      {
        if (this.mAutomator.d.getBoolean("isFirstQQInit", true))
        {
          this.mAutomator.d.edit().putBoolean("isFirstQQInit", false).commit();
          localObject = "actSyncMsgFirst";
        }
        else
        {
          localObject = "actSyncMsgSecond";
        }
        StatisticCollector.getInstance(this.mAutomator.k.getApp()).collectPerformance(null, (String)localObject, c(), l1, this.mAutomator.c, null, null);
      }
    }
    Object localObject = this.mAutomator;
    if (!this.mAutomator.k.getMsgHandler().v()) {
      i1 = 1;
    }
    ((Automator)localObject).b = i1;
    if (((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).shouldGetIndividualTimePush())
    {
      localObject = ((IReadInJoyLogicManager)this.mAutomator.k.getRuntimeService(IReadInJoyLogicManager.class)).getReadInJoyLogicEngine();
      if (localObject != null) {
        ((IReadInJoyLogicEngine)localObject).b(this.mAutomator.k.getLongAccountUin());
      }
    }
    MsfServiceSdk.get().registerProxyDone();
    if (this.n != 0)
    {
      HardCoderManager.getInstance().stop(this.n);
      this.n = 0;
    }
  }
  
  public void setResult(int paramInt)
  {
    if (!this.mAutomator.i()) {
      if (paramInt == 4)
      {
        a(true);
      }
      else
      {
        Handler localHandler = this.b;
        if (localHandler != null) {
          localHandler.removeMessages(100);
        }
      }
    }
    super.setResult(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.automator.AutomatorHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.LoginSetting;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

class RegisterProxy$MyMessageObserver
  extends MessageObserver
{
  private RegisterProxy$MyMessageObserver(RegisterProxy paramRegisterProxy) {}
  
  private void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stateC2C=");
      ((StringBuilder)localObject).append(RegisterProxy.a(this.a));
      ((StringBuilder)localObject).append(" stateGroupFirstMsg=");
      ((StringBuilder)localObject).append(RegisterProxy.c(this.a));
      QLog.d("QQInitHandler1", 2, ((StringBuilder)localObject).toString());
    }
    if ((RegisterProxy.a(this.a) == 2) && (RegisterProxy.c(this.a) == 2))
    {
      long l1 = SystemClock.uptimeMillis();
      this.a.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a.d = true;
      this.a.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c(true);
      long l2;
      if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
      {
        l2 = l1 + BaseApplicationImpl.sLaunchTime;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("registerB, cost=");
          ((StringBuilder)localObject).append(l2);
          QLog.i("AutoMonitor", 2, ((StringBuilder)localObject).toString());
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("registerB, cost=");
          ((StringBuilder)localObject).append(l2);
          Log.i("AutoMonitor", ((StringBuilder)localObject).toString());
        }
        StatisticCollector.getInstance(this.a.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "prxyRegisterB", true, l2, 0L, null, null);
      }
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l2 = BaseApplicationImpl.appStartTime;
        if ((AutomatorHelper.b) && (LoginSetting.a)) {
          localObject = "1";
        } else if ((AutomatorHelper.b) && (!LoginSetting.a)) {
          localObject = "2";
        } else if ((!AutomatorHelper.b) && (LoginSetting.a)) {
          localObject = "3";
        } else {
          localObject = "4";
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("actLoginType", localObject);
        StatisticCollector.getInstance(this.a.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "prxyRegisterT", true, l1 - l2, 0L, localHashMap, null);
      }
      if (this.a.mAutomator.jdField_a_of_type_Long > 0L)
      {
        l1 = System.currentTimeMillis() - this.a.mAutomator.jdField_a_of_type_Long;
        if (NetworkUtil.isNetworkAvailable(this.a.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
        {
          boolean bool = this.a.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true);
          localObject = new HashMap();
          ((HashMap)localObject).put("param_isFirstInit", String.valueOf(bool));
          StatisticCollector.getInstance(this.a.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "prxyRegisterM", RegisterProxy.a(this.a), l1, 0L, (HashMap)localObject, null);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("machineStartToStopCircle, cost=");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append(", isfirstQQInit=");
            ((StringBuilder)localObject).append(bool);
            QLog.i("AutoMonitor", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if (GuardManager.a != null) {
        GuardManager.a(this.a.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), GuardManager.a.a());
      }
    }
  }
  
  private void b()
  {
    if (this.a.a()) {
      this.a.setResult(7);
    }
  }
  
  protected void onGetAllProxyTroopMsgFin(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.mName);
      ((StringBuilder)localObject).append(" onGetAllProxyMsgFin:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", timeoutFlag=");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.a.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPA", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    if (paramLong2 == 0L)
    {
      localObject = this.a;
      int j = 1;
      int i;
      if ((paramBoolean) && (paramLong1 != 8L) && (paramLong1 != 4L)) {
        i = 2;
      } else {
        i = 1;
      }
      RegisterProxy.d((RegisterProxy)localObject, i);
      localObject = this.a;
      if ((paramBoolean) && (paramLong1 != 128L) && (paramLong1 != 64L) && (paramLong1 != 32L)) {
        i = 2;
      } else {
        i = 1;
      }
      RegisterProxy.c((RegisterProxy)localObject, i);
      this.a.jdField_a_of_type_Long = paramLong1;
      if (RegisterProxyHandler.c)
      {
        localObject = this.a;
        if (paramBoolean) {
          i = 2;
        } else {
          i = 1;
        }
        RegisterProxy.b((RegisterProxy)localObject, i);
        localObject = this.a;
        i = j;
        if (paramBoolean) {
          i = 2;
        }
        RegisterProxy.e((RegisterProxy)localObject, i);
        RegisterProxyHandler.c = false;
      }
      b();
    }
  }
  
  protected void onGetDiscussionMsgFin(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.mName);
      ((StringBuilder)localObject).append(" on GetDiscussionMsg Fin:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.a.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPD", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markDisFinishCost();
    Object localObject = this.a;
    if (!paramBoolean) {
      i = 1;
    }
    RegisterProxy.c((RegisterProxy)localObject, i);
    b();
  }
  
  protected void onGetGroupFirstMsgFin(boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.mName);
      ((StringBuilder)localObject).append(" on GetFirstGroup Fin:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.a.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPF", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    Object localObject = this.a;
    if (!paramBoolean) {
      i = 1;
    }
    RegisterProxy.f((RegisterProxy)localObject, i);
    a();
  }
  
  protected void onGetMsgFin(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.mName);
      ((StringBuilder)localObject).append(" on GetC2CMsg Fin:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.a.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPC", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markC2CFinishCost();
    Object localObject = this.a;
    boolean bool = true;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    RegisterProxy.b((RegisterProxy)localObject, i);
    if (RegisterProxyHandler.c)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.a.mName);
        ((StringBuilder)localObject).append(" on GetDiscussionMsg Fin: Receive empty package set isC2CMsgSuccess true");
        QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
      }
      this.a.mAutomator.b = true;
    }
    else
    {
      localObject = this.a.mAutomator;
      if (RegisterProxy.a(this.a) == 2) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      ((Automator)localObject).b = paramBoolean;
    }
    if (RegisterProxyHandler.a) {
      a();
    }
    b();
  }
  
  protected void onGetPAMsgFin(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.mName);
      ((StringBuilder)localObject).append(" on GetPAMsg Fin:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.a.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    Object localObject = this.a;
    boolean bool = true;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    RegisterProxy.e((RegisterProxy)localObject, i);
    if (RegisterProxyHandler.c)
    {
      this.a.mAutomator.c = true;
    }
    else
    {
      localObject = this.a.mAutomator;
      if (RegisterProxy.b(this.a) == 2) {
        paramBoolean = bool;
      } else {
        paramBoolean = false;
      }
      ((Automator)localObject).c = paramBoolean;
    }
    b();
  }
  
  protected void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append(this.a.mName);
      paramArrayOfString.append(" on GetTroopMsg Fin:");
      paramArrayOfString.append(paramBoolean);
      QLog.d("QQInitHandler", 2, paramArrayOfString.toString());
    }
    this.a.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPT", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
    paramArrayOfString = this.a;
    if (!paramBoolean) {
      i = 1;
    }
    RegisterProxy.d(paramArrayOfString, i);
    b();
  }
  
  protected void onRegisterProxyFin(boolean paramBoolean, Object paramObject)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("on RegisterProxy Fin:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQInitHandler", 2, ((StringBuilder)localObject).toString());
    }
    this.a.mAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    Object localObject = this.a;
    if (!paramBoolean) {
      i = 1;
    }
    RegisterProxy.a((RegisterProxy)localObject, i);
    if (paramBoolean)
    {
      b();
      RegisterProxy.a(this.a, paramObject);
      return;
    }
    this.a.setResult(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */
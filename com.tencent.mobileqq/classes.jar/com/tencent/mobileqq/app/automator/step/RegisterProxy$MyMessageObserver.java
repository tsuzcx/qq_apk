package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
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
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler1", 2, "stateC2C=" + RegisterProxy.a(this.a) + " stateGroupFirstMsg=" + RegisterProxy.c(this.a));
    }
    long l1;
    long l2;
    Object localObject;
    if ((RegisterProxy.a(this.a) == 2) && (RegisterProxy.c(this.a) == 2))
    {
      l1 = SystemClock.uptimeMillis();
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c = true;
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(true);
      if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
      {
        l2 = BaseApplicationImpl.sLaunchTime + l1;
        if (!QLog.isColorLevel()) {
          break label464;
        }
        QLog.i("AutoMonitor", 2, "registerB, cost=" + l2);
        StatisticCollector.getInstance(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "prxyRegisterB", true, l2, 0L, null, null);
      }
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l2 = BaseApplicationImpl.appStartTime;
        if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!LoginSetting.a)) {
          break label492;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("actLoginType", localObject);
      StatisticCollector.getInstance(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "prxyRegisterT", true, l1 - l2, 0L, localHashMap, null);
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long > 0L)
      {
        l1 = System.currentTimeMillis() - this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_Long;
        if (NetworkUtil.g(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
        {
          boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true);
          localObject = new HashMap();
          ((HashMap)localObject).put("param_isFirstInit", String.valueOf(bool));
          StatisticCollector.getInstance(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(null, "prxyRegisterM", RegisterProxy.a(this.a), l1, 0L, (HashMap)localObject, null);
          if (QLog.isColorLevel()) {
            QLog.i("AutoMonitor", 2, "machineStartToStopCircle, cost=" + l1 + ", isfirstQQInit=" + bool);
          }
        }
      }
      if (GuardManager.a != null) {
        GuardManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), GuardManager.a.a());
      }
      return;
      label464:
      Log.i("AutoMonitor", "registerB, cost=" + l2);
      break;
      label492:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!LoginSetting.a)) {
        localObject = "2";
      } else if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (LoginSetting.a)) {
        localObject = "3";
      } else {
        localObject = "4";
      }
    }
  }
  
  private void b()
  {
    if (this.a.a()) {
      this.a.a(7);
    }
  }
  
  public void onGetAllProxyTroopMsgFin(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPA", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    RegisterProxy localRegisterProxy;
    if (paramLong2 == 0L)
    {
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
        break label248;
      }
      i = 2;
      RegisterProxy.d(localRegisterProxy, i);
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 128L) || (paramLong1 == 64L) || (paramLong1 == 32L)) {
        break label254;
      }
      i = 2;
      label174:
      RegisterProxy.c(localRegisterProxy, i);
      this.a.jdField_a_of_type_Long = paramLong1;
      if (MessageHandler.a)
      {
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label260;
        }
        i = 2;
        label209:
        RegisterProxy.b(localRegisterProxy, i);
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label266;
        }
      }
    }
    label260:
    label266:
    for (int i = j;; i = 1)
    {
      RegisterProxy.e(localRegisterProxy, i);
      MessageHandler.a = false;
      b();
      return;
      label248:
      i = 1;
      break;
      label254:
      i = 1;
      break label174;
      i = 1;
      break label209;
    }
  }
  
  public void onGetDiscussionMsgFin(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetDiscussionMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPD", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markDisFinishCost();
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.c(localRegisterProxy, i);
      b();
      return;
      i = 1;
    }
  }
  
  public void onGetGroupFirstMsgFin(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetFirstGroup Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPF", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.f(localRegisterProxy, i);
      a();
      return;
      i = 1;
    }
  }
  
  public void onGetMsgFin(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetC2CMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPC", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markC2CFinishCost();
    Object localObject = this.a;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      RegisterProxy.b((RegisterProxy)localObject, i);
      if (!MessageHandler.a) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetDiscussionMsg Fin: Receive empty package set isC2CMsgSuccess true");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b = true;
      if (MessageHandler.b) {
        a();
      }
      b();
      return;
    }
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (RegisterProxy.a(this.a) == 2) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).b = paramBoolean;
      break;
    }
  }
  
  public void onGetPAMsgFin(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetPAMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    Object localObject = this.a;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      RegisterProxy.e((RegisterProxy)localObject, i);
      if (!MessageHandler.a) {
        break;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.c = true;
      b();
      return;
    }
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator;
    if (RegisterProxy.b(this.a) == 2) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).c = paramBoolean;
      break;
    }
  }
  
  public void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, this.a.jdField_a_of_type_JavaLangString + " on GetTroopMsg Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RPT", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
    paramArrayOfString = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.d(paramArrayOfString, i);
      b();
      return;
      i = 1;
    }
  }
  
  public void onRegisterProxyFin(boolean paramBoolean, Object paramObject)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put("RP", Long.valueOf(SystemClock.uptimeMillis() - RegisterProxy.a(this.a)));
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.a(localRegisterProxy, i);
      if (!paramBoolean) {
        break;
      }
      b();
      RegisterProxy.a(this.a, paramObject);
      return;
      i = 1;
    }
    this.a.a(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.RegisterProxy.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */
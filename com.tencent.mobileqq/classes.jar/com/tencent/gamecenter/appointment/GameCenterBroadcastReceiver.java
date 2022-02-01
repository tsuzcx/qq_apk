package com.tencent.gamecenter.appointment;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.gamecenter.wadl.util.WLog;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class GameCenterBroadcastReceiver
  implements INetEventHandler
{
  public static int a;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private static GameCenterBroadcastReceiver jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver;
  public static boolean a;
  public static boolean b;
  boolean c = false;
  boolean d = false;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Int = 100;
    b = false;
    jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver = null;
  }
  
  public static void a()
  {
    WLog.c("GameCenterBroadcastReceiver", "registerReceiver");
    if (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver == null) {
      jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver = new GameCenterBroadcastReceiver();
    }
    if (jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      jdField_a_of_type_AndroidContentBroadcastReceiver = new GameCenterBroadcastReceiver.1();
    }
    if (!jdField_a_of_type_Boolean) {}
    try
    {
      AppNetConnInfo.registerNetChangeReceiver(MobileQQ.sMobileQQ, jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
      localIntentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
      MobileQQ.sMobileQQ.registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      WLog.a("GameCenterBroadcastReceiver", "registerReceiver exception", localThrowable);
    }
  }
  
  public static void b()
  {
    WLog.c("GameCenterBroadcastReceiver", "unRegisterReceiver");
    try
    {
      if (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver != null)
      {
        AppNetConnInfo.unregisterNetEventHandler(jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver);
        jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver = null;
      }
      if (jdField_a_of_type_AndroidContentBroadcastReceiver != null)
      {
        MobileQQ.sMobileQQ.unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
        jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        WLog.a("GameCenterBroadcastReceiver", "unRegisterReceiver exception", localThrowable);
        jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver = null;
        jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      }
    }
    finally
    {
      jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver = null;
      jdField_a_of_type_AndroidContentBroadcastReceiver = null;
    }
    jdField_a_of_type_Boolean = false;
  }
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.i("GameCenterBroadcastReceiver", 2, "no net");
      }
    }
    do
    {
      return;
      if (!AppNetConnInfo.isMobileConn()) {
        break;
      }
    } while (this.d);
    if (QLog.isColorLevel()) {
      QLog.i("GameCenterBroadcastReceiver", 2, "mobile connect");
    }
    for (;;)
    {
      this.c = false;
      return;
      if (AppNetConnInfo.isWifiConn())
      {
        if (this.c) {
          break;
        }
        this.c = true;
        if (QLog.isColorLevel()) {
          QLog.i("GameCenterBroadcastReceiver", 2, "wifi connect");
        }
        GameCenterCheck.a();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GameCenterBroadcastReceiver", 2, "no connect");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
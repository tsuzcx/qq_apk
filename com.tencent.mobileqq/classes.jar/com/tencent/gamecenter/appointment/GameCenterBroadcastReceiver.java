package com.tencent.gamecenter.appointment;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.open.wadl.WLog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import qje;

public class GameCenterBroadcastReceiver
  implements INetEventHandler
{
  public static int a;
  private static BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private static GameCenterBroadcastReceiver jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver;
  public static boolean a;
  boolean b = false;
  boolean c = false;
  
  static
  {
    jdField_a_of_type_Int = 100;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterBroadcastReceiver", 2, "registerReceiver");
    }
    if (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver == null) {
      jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver = new GameCenterBroadcastReceiver();
    }
    if (jdField_a_of_type_AndroidContentBroadcastReceiver == null) {
      jdField_a_of_type_AndroidContentBroadcastReceiver = new qje();
    }
    if (!jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = true;
      AppNetConnInfo.registerNetChangeReceiver(BaseApplicationImpl.getApplication(), jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.BATTERY_CHANGED");
      BaseApplicationImpl.getContext().registerReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameCenterBroadcastReceiver", 2, "unRegisterReceiver");
    }
    if (jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver != null)
    {
      AppNetConnInfo.unregisterNetEventHandler(jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver);
      jdField_a_of_type_ComTencentGamecenterAppointmentGameCenterBroadcastReceiver = null;
    }
    if (jdField_a_of_type_AndroidContentBroadcastReceiver != null)
    {
      BaseApplicationImpl.getContext().unregisterReceiver(jdField_a_of_type_AndroidContentBroadcastReceiver);
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
    } while (this.c);
    if (QLog.isColorLevel()) {
      WLog.b("GameCenterBroadcastReceiver", "mobile connect");
    }
    for (;;)
    {
      this.b = false;
      return;
      if (AppNetConnInfo.isWifiConn())
      {
        if (this.b) {
          break;
        }
        this.b = true;
        if (QLog.isColorLevel()) {
          WLog.b("GameCenterBroadcastReceiver", "wifi connect");
        }
        GameCenterCheck.b();
        continue;
      }
      if (QLog.isColorLevel()) {
        WLog.b("GameCenterBroadcastReceiver", "no connect");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */
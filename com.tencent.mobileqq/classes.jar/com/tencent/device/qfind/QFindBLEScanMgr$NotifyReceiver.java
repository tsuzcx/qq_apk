package com.tencent.device.qfind;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.device.ble.JNIEngineLite;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import zok;
import zur;

public class QFindBLEScanMgr$NotifyReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = null;
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel()) {
      QLog.i("QFindBLE", 2, "QFindBLEScanMgr NotifyReceiver onReceive action=" + paramContext);
    }
    int i;
    if ("com.tencent.device.ble.ACTION_GATT_SERVICES_DISCOVERED".equals(paramContext))
    {
      i = paramIntent.getExtras().getInt("com.tencent.device.ble.EXTRA_BLEID");
      paramIntent = this.a.a.values().iterator();
      do
      {
        if (!paramIntent.hasNext()) {
          break;
        }
        paramContext = (zur)paramIntent.next();
      } while (paramContext.c != i);
    }
    for (;;)
    {
      if (paramContext == null) {
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr GATT_SERVICES_DISCOVERED bleId " + i + " is not in mReportedDevice");
        }
      }
      label542:
      do
      {
        do
        {
          do
          {
            return;
            paramContext = JNIEngineLite.packVerifyReq((int)(NetConnInfoCenter.getServerTimeMillis() / 1000L));
            zok.a().a(i, paramContext);
          } while (!QLog.isColorLevel());
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr GATT_SERVICES_DISCOVERED bleId " + i);
          return;
          if (!"onDeviceVerifyRsp".equals(paramContext)) {
            break label542;
          }
          paramContext = paramIntent.getExtras();
          i = paramContext.getInt("bleId");
          paramIntent = paramContext.getByteArray("buffer");
          Iterator localIterator = this.a.a.values().iterator();
          do
          {
            paramContext = localObject;
            if (!localIterator.hasNext()) {
              break;
            }
            paramContext = (zur)localIterator.next();
          } while (paramContext.c != i);
          if (paramContext != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp bleId " + i + " is not in mReportedDevice");
        return;
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp bleId " + i + ": data " + paramIntent.length);
        }
        if (!paramContext.jdField_a_of_type_Boolean)
        {
          paramContext.jdField_b_of_type_ArrayOfByte = paramIntent;
          QFindBLEScanMgr.a(this.a, paramContext, paramContext.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo, true);
          paramIntent = "" + paramContext.jdField_a_of_type_Int + "|" + paramContext.a();
          paramContext.jdField_a_of_type_Boolean = true;
          paramContext.jdField_b_of_type_Boolean = false;
          paramIntent = (zur)this.a.a.put(paramIntent, paramContext);
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp old bleId " + paramIntent.c + " ; reported = " + paramIntent.jdField_a_of_type_Boolean);
          }
        }
        for (;;)
        {
          zok.a().a(paramContext.a());
          return;
          if (QLog.isColorLevel()) {
            QLog.i("QFindBLE", 2, "QFindBLEScanMgr onDeviceVerifyRsp report already bleId " + i + " ; reported = " + paramContext.jdField_a_of_type_Boolean);
          }
        }
      } while (!"QFIND_BLE_CONNECT_ERROR".equals(paramContext));
      i = paramIntent.getExtras().getInt("bleId");
      paramIntent = this.a.a.values().iterator();
      do
      {
        if (!paramIntent.hasNext()) {
          break;
        }
        paramContext = (zur)paramIntent.next();
      } while (paramContext.c != i);
      for (;;)
      {
        if (paramContext == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR bleId " + i + " is not in mReportedDevice");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR bleId " + i + " ; reported = " + paramContext.jdField_a_of_type_Boolean);
        }
        if (!paramContext.jdField_a_of_type_Boolean)
        {
          QFindBLEScanMgr.a(this.a, paramContext, paramContext.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo, false);
          paramIntent = "" + paramContext.jdField_a_of_type_Int + "|" + paramContext.a();
          paramContext.jdField_a_of_type_Boolean = true;
          paramContext.jdField_b_of_type_Boolean = false;
          paramContext = (zur)this.a.a.put(paramIntent, paramContext);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR old bleId " + paramContext.c + " ; reported = " + paramContext.jdField_a_of_type_Boolean);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("QFindBLE", 2, "QFindBLEScanMgr QFIND_BLE_CONNECT_ERROR report already bleId " + i + " ; reported = " + paramContext.jdField_a_of_type_Boolean);
        return;
        paramContext = null;
      }
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.NotifyReceiver
 * JD-Core Version:    0.7.0.1
 */
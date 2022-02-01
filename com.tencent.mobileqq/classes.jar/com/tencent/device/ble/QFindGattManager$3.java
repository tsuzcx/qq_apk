package com.tencent.device.ble;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.device.qfind.PeerInfo;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

class QFindGattManager$3
  extends BroadcastReceiver
{
  QFindGattManager$3(QFindGattManager paramQFindGattManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mGattUpdateReceiver onReceive action=");
      localStringBuilder.append(paramContext);
      QLog.i("DeviceBLE2", 2, localStringBuilder.toString());
    }
    if ("com.tencent.device.ble.ACTION_GATT_CONNECTED".equals(paramContext))
    {
      SmartDeviceReport.a().a(null, "Net_Bind_BLE_Connect", 0);
      return;
    }
    int i;
    if ("com.tencent.device.ble.ACTION_GATT_DISCONNECTED".equals(paramContext))
    {
      i = paramIntent.getIntExtra("com.tencent.device.ble.EXTRA_BLEID", 0);
      paramIntent.getIntExtra("com.tencent.device.ble.EXTRA_STATUS", 0);
      paramContext = this.a.a(i);
      if (paramContext != null)
      {
        paramContext.jdField_a_of_type_Boolean = false;
        paramContext.c = false;
        paramContext.b = false;
        JNIEngineLite.disconnectBle(paramContext.jdField_a_of_type_Int);
        QFindGattManager.b(this.a).remove(paramContext);
        if (this.a.jdField_a_of_type_ComTencentDeviceQfindPeerInfo == paramContext) {
          this.a.jdField_a_of_type_ComTencentDeviceQfindPeerInfo = null;
        }
        QFindGattManager.a(this.a).remove(paramContext);
        QFindGattManager.a(this.a, i);
        this.a.a(paramContext);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("ACTION_GATT_DISCONNECTED but no peerInfo with id:");
        paramContext.append(i);
        QLog.e("DeviceBLE2", 2, paramContext.toString());
      }
    }
    else if ((!"com.tencent.device.ble.ACTION_GATT_SET_NOTIFICATION_FAILED".equals(paramContext)) && (!"com.tencent.device.ble.ACTION_GATT_NOT_QQ".equals(paramContext)))
    {
      if ("com.tencent.device.ble.ACTION_DATA_AVAILABLE".equals(paramContext))
      {
        JNIEngineLite.bleReceived(paramIntent.getIntExtra("com.tencent.device.ble.EXTRA_BLEID", 0), paramIntent.getByteArrayExtra("com.tencent.device.ble.EXTRA_DATA"));
        return;
      }
      if ("com.tencent.device.ble.ACTION_DATA_WRITE_RST".equals(paramContext))
      {
        i = paramIntent.getIntExtra("com.tencent.device.ble.EXTRA_BLEID", 0);
        boolean bool = paramIntent.getBooleanExtra("com.tencent.device.ble.EXRTA_RESULT", false);
        paramContext = this.a.a(i);
        if (!bool)
        {
          QFindGattManager.a(this.a, i);
          if (paramContext != null) {
            this.a.a(paramContext);
          }
        }
      }
      else if (("onDeviceVerifyRsp".equals(paramContext)) && (this.a.jdField_a_of_type_MqqOsMqqHandler != null))
      {
        this.a.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      }
    }
    else
    {
      i = paramIntent.getIntExtra("com.tencent.device.ble.EXTRA_BLEID", 0);
      paramContext = this.a.a(i);
      if (paramContext != null)
      {
        QFindGattManager.a(this.a, i);
        this.a.a(paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.ble.QFindGattManager.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class QFindBLEScanMgr$3$1
  implements Runnable
{
  QFindBLEScanMgr$3$1(QFindBLEScanMgr.3 param3, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    BlePeerInfo localBlePeerInfo = new BlePeerInfo();
    localBlePeerInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localBlePeerInfo.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localBlePeerInfo.jdField_a_of_type_Boolean = false;
    BlePeerInfo.a(this.jdField_a_of_type_ArrayOfByte, localBlePeerInfo);
    StringBuilder localStringBuilder;
    if ((localBlePeerInfo.jdField_a_of_type_JavaUtilList != null) && (localBlePeerInfo.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLeScan name=");
        localStringBuilder.append(localBlePeerInfo.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" pid:");
        localStringBuilder.append(localBlePeerInfo.jdField_a_of_type_Int);
        localStringBuilder.append(" address:");
        localStringBuilder.append(localBlePeerInfo.b);
        localStringBuilder.append(" ; blePeerInfo.ble_id = ");
        localStringBuilder.append(localBlePeerInfo.c);
        QLog.i("QFindBLE_ex", 2, localStringBuilder.toString());
      }
      if ((localBlePeerInfo.jdField_a_of_type_Int == 0) || (localBlePeerInfo.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a.b.contains(new Long(localBlePeerInfo.jdField_a_of_type_Int)))) {}
    }
    try
    {
      QFindBLEScanMgr.b(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a);
      boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a, localBlePeerInfo);
      boolean bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a, localBlePeerInfo, bool1);
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLeScan blePeerInfo.ble_id = ");
        localStringBuilder.append(localBlePeerInfo.c);
        localStringBuilder.append(" ; needReportLoc = ");
        localStringBuilder.append(bool1);
        localStringBuilder.append(" ; needReport = ");
        localStringBuilder.append(bool2);
        QLog.i("QFindBLE_ex", 2, localStringBuilder.toString());
      }
      if ((bool2) && (bool1)) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a, localBlePeerInfo.jdField_a_of_type_Int, localBlePeerInfo.a());
      } else if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a, localBlePeerInfo, null, false);
      }
    }
    catch (Exception localException)
    {
      label359:
      break label359;
    }
    this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_ComTencentDeviceQfindQFindBLEScanMgr$3.a.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
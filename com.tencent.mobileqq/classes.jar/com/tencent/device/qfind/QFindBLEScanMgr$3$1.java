package com.tencent.device.qfind;

import abwe;
import abwn;
import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(abwn paramabwn, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    abwe localabwe = new abwe();
    localabwe.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localabwe.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localabwe.jdField_a_of_type_Boolean = false;
    abwe.a(this.jdField_a_of_type_ArrayOfByte, localabwe);
    if ((localabwe.jdField_a_of_type_JavaUtilList != null) && (localabwe.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localabwe.jdField_a_of_type_JavaLangString + " pid:" + localabwe.jdField_a_of_type_Int + " address:" + localabwe.b + " ; blePeerInfo.ble_id = " + localabwe.c);
      }
      if ((localabwe.jdField_a_of_type_Int == 0) || (localabwe.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Abwn.a.b.contains(new Long(localabwe.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Abwn.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Abwn.a, localabwe);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Abwn.a, localabwe, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localabwe.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Abwn.a, localabwe.jdField_a_of_type_Int, localabwe.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Abwn.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Abwn.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Abwn.a, localabwe, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
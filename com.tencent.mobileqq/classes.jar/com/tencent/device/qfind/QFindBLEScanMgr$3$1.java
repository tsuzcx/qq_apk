package com.tencent.device.qfind;

import aawr;
import aaxa;
import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(aaxa paramaaxa, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    aawr localaawr = new aawr();
    localaawr.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localaawr.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localaawr.jdField_a_of_type_Boolean = false;
    aawr.a(this.jdField_a_of_type_ArrayOfByte, localaawr);
    if ((localaawr.jdField_a_of_type_JavaUtilList != null) && (localaawr.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localaawr.jdField_a_of_type_JavaLangString + " pid:" + localaawr.jdField_a_of_type_Int + " address:" + localaawr.b + " ; blePeerInfo.ble_id = " + localaawr.c);
      }
      if ((localaawr.jdField_a_of_type_Int == 0) || (localaawr.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Aaxa.a.b.contains(new Long(localaawr.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Aaxa.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Aaxa.a, localaawr);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Aaxa.a, localaawr, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localaawr.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Aaxa.a, localaawr.jdField_a_of_type_Int, localaawr.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Aaxa.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Aaxa.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Aaxa.a, localaawr, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import yfy;
import ygh;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(ygh paramygh, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    yfy localyfy = new yfy();
    localyfy.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localyfy.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localyfy.jdField_a_of_type_Boolean = false;
    yfy.a(this.jdField_a_of_type_ArrayOfByte, localyfy);
    if ((localyfy.jdField_a_of_type_JavaUtilList != null) && (localyfy.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localyfy.jdField_a_of_type_JavaLangString + " pid:" + localyfy.jdField_a_of_type_Int + " address:" + localyfy.b + " ; blePeerInfo.ble_id = " + localyfy.c);
      }
      if ((localyfy.jdField_a_of_type_Int == 0) || (localyfy.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Ygh.a.b.contains(new Long(localyfy.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Ygh.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Ygh.a, localyfy);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Ygh.a, localyfy, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localyfy.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Ygh.a, localyfy.jdField_a_of_type_Int, localyfy.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Ygh.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Ygh.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Ygh.a, localyfy, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
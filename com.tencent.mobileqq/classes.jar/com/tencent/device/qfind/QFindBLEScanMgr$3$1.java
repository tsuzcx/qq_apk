package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import ygb;
import ygk;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(ygk paramygk, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    ygb localygb = new ygb();
    localygb.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localygb.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localygb.jdField_a_of_type_Boolean = false;
    ygb.a(this.jdField_a_of_type_ArrayOfByte, localygb);
    if ((localygb.jdField_a_of_type_JavaUtilList != null) && (localygb.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localygb.jdField_a_of_type_JavaLangString + " pid:" + localygb.jdField_a_of_type_Int + " address:" + localygb.b + " ; blePeerInfo.ble_id = " + localygb.c);
      }
      if ((localygb.jdField_a_of_type_Int == 0) || (localygb.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Ygk.a.b.contains(new Long(localygb.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Ygk.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Ygk.a, localygb);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Ygk.a, localygb, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localygb.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Ygk.a, localygb.jdField_a_of_type_Int, localygb.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Ygk.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Ygk.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Ygk.a, localygb, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import zur;
import zva;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(zva paramzva, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    zur localzur = new zur();
    localzur.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localzur.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localzur.jdField_a_of_type_Boolean = false;
    zur.a(this.jdField_a_of_type_ArrayOfByte, localzur);
    if ((localzur.jdField_a_of_type_JavaUtilList != null) && (localzur.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localzur.jdField_a_of_type_JavaLangString + " pid:" + localzur.jdField_a_of_type_Int + " address:" + localzur.b + " ; blePeerInfo.ble_id = " + localzur.c);
      }
      if ((localzur.jdField_a_of_type_Int == 0) || (localzur.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Zva.a.b.contains(new Long(localzur.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Zva.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Zva.a, localzur);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Zva.a, localzur, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localzur.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Zva.a, localzur.jdField_a_of_type_Int, localzur.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Zva.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Zva.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Zva.a, localzur, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
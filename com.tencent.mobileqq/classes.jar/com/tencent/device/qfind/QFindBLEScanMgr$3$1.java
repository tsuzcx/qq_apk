package com.tencent.device.qfind;

import acai;
import acar;
import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(acar paramacar, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    acai localacai = new acai();
    localacai.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localacai.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localacai.jdField_a_of_type_Boolean = false;
    acai.a(this.jdField_a_of_type_ArrayOfByte, localacai);
    if ((localacai.jdField_a_of_type_JavaUtilList != null) && (localacai.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localacai.jdField_a_of_type_JavaLangString + " pid:" + localacai.jdField_a_of_type_Int + " address:" + localacai.b + " ; blePeerInfo.ble_id = " + localacai.c);
      }
      if ((localacai.jdField_a_of_type_Int == 0) || (localacai.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Acar.a.b.contains(new Long(localacai.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Acar.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Acar.a, localacai);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Acar.a, localacai, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localacai.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Acar.a, localacai.jdField_a_of_type_Int, localacai.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Acar.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Acar.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Acar.a, localacai, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
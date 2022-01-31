package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import xwx;
import xxg;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(xxg paramxxg, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    xwx localxwx = new xwx();
    localxwx.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localxwx.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localxwx.jdField_a_of_type_Boolean = false;
    xwx.a(this.jdField_a_of_type_ArrayOfByte, localxwx);
    if ((localxwx.jdField_a_of_type_JavaUtilList != null) && (localxwx.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localxwx.jdField_a_of_type_JavaLangString + " pid:" + localxwx.jdField_a_of_type_Int + " address:" + localxwx.b + " ; blePeerInfo.ble_id = " + localxwx.c);
      }
      if ((localxwx.jdField_a_of_type_Int == 0) || (localxwx.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Xxg.a.b.contains(new Long(localxwx.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Xxg.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Xxg.a, localxwx);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Xxg.a, localxwx, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localxwx.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Xxg.a, localxwx.jdField_a_of_type_Int, localxwx.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Xxg.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Xxg.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Xxg.a, localxwx, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
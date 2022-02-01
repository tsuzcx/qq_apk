package com.tencent.device.qfind;

import abmd;
import abmm;
import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(abmm paramabmm, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    abmd localabmd = new abmd();
    localabmd.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localabmd.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localabmd.jdField_a_of_type_Boolean = false;
    abmd.a(this.jdField_a_of_type_ArrayOfByte, localabmd);
    if ((localabmd.jdField_a_of_type_JavaUtilList != null) && (localabmd.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localabmd.jdField_a_of_type_JavaLangString + " pid:" + localabmd.jdField_a_of_type_Int + " address:" + localabmd.b + " ; blePeerInfo.ble_id = " + localabmd.c);
      }
      if ((localabmd.jdField_a_of_type_Int == 0) || (localabmd.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Abmm.a.b.contains(new Long(localabmd.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Abmm.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Abmm.a, localabmd);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Abmm.a, localabmd, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localabmd.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Abmm.a, localabmd.jdField_a_of_type_Int, localabmd.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Abmm.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Abmm.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Abmm.a, localabmd, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
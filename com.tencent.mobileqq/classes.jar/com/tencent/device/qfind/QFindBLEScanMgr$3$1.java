package com.tencent.device.qfind;

import android.bluetooth.BluetoothDevice;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import zzg;
import zzp;

public class QFindBLEScanMgr$3$1
  implements Runnable
{
  public QFindBLEScanMgr$3$1(zzp paramzzp, BluetoothDevice paramBluetoothDevice, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    zzg localzzg = new zzg();
    localzzg.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getName();
    localzzg.b = this.jdField_a_of_type_AndroidBluetoothBluetoothDevice.getAddress();
    localzzg.jdField_a_of_type_Boolean = false;
    zzg.a(this.jdField_a_of_type_ArrayOfByte, localzzg);
    if ((localzzg.jdField_a_of_type_JavaUtilList != null) && (localzzg.jdField_a_of_type_JavaUtilList.contains("0000feba-0000-1000-8000-00805f9b34fb")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QFindBLE_ex", 2, "onLeScan name=" + localzzg.jdField_a_of_type_JavaLangString + " pid:" + localzzg.jdField_a_of_type_Int + " address:" + localzzg.b + " ; blePeerInfo.ble_id = " + localzzg.c);
      }
      if ((localzzg.jdField_a_of_type_Int == 0) || (localzzg.jdField_a_of_type_ArrayOfByte == null) || (!this.jdField_a_of_type_Zzp.a.b.contains(new Long(localzzg.jdField_a_of_type_Int)))) {}
    }
    for (;;)
    {
      try
      {
        QFindBLEScanMgr.b(this.jdField_a_of_type_Zzp.a);
        boolean bool1 = QFindBLEScanMgr.a(this.jdField_a_of_type_Zzp.a, localzzg);
        bool2 = QFindBLEScanMgr.a(this.jdField_a_of_type_Zzp.a, localzzg, bool1);
        if (QLog.isColorLevel()) {
          QLog.i("QFindBLE_ex", 2, "onLeScan blePeerInfo.ble_id = " + localzzg.c + " ; needReportLoc = " + bool1 + " ; needReport = " + bool2);
        }
        if ((!bool2) || (!bool1)) {
          continue;
        }
        QFindBLEScanMgr.a(this.jdField_a_of_type_Zzp.a, localzzg.jdField_a_of_type_Int, localzzg.a());
      }
      catch (Exception localException)
      {
        boolean bool2;
        continue;
      }
      this.jdField_a_of_type_Zzp.a.a.postDelayed(new QFindBLEScanMgr.3.1.1(this), this.jdField_a_of_type_Zzp.a.i);
      return;
      if (bool2) {
        QFindBLEScanMgr.a(this.jdField_a_of_type_Zzp.a, localzzg, null, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.device.qfind;

import android.bluetooth.BluetoothAdapter;
import com.tencent.qphone.base.util.QLog;

class QFindBLEScanMgr$2
  implements Runnable
{
  QFindBLEScanMgr$2(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean)
    {
      Object localObject = this.this$0;
      ((QFindBLEScanMgr)localObject).jdField_a_of_type_Boolean = false;
      try
      {
        if (((QFindBLEScanMgr)localObject).jdField_a_of_type_AndroidBluetoothBluetoothAdapter != null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("call native mBluetoothAdapter.stopLeScan with cb=");
            ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
            ((StringBuilder)localObject).append(", mScanning=");
            ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Boolean);
            QLog.i("QFindBLE", 2, ((StringBuilder)localObject).toString());
          }
          this.this$0.jdField_a_of_type_AndroidBluetoothBluetoothAdapter.stopLeScan(this.this$0.jdField_a_of_type_AndroidBluetoothBluetoothAdapter$LeScanCallback);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.2
 * JD-Core Version:    0.7.0.1
 */
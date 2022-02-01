package com.tencent.device.qfind;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import mqq.os.MqqHandler;

class QFindBLEScanMgr$3
  implements BluetoothAdapter.LeScanCallback
{
  QFindBLEScanMgr$3(QFindBLEScanMgr paramQFindBLEScanMgr) {}
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (this.a.w != null) {
      this.a.w.post(new QFindBLEScanMgr.3.1(this, paramBluetoothDevice, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.3
 * JD-Core Version:    0.7.0.1
 */
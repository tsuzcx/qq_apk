package com.tencent.device.qfind;

import zvb;

public class QFindBLEScanMgr$ScanReceiver$1
  implements Runnable
{
  public QFindBLEScanMgr$ScanReceiver$1(zvb paramzvb) {}
  
  public void run()
  {
    if (this.a.a.b)
    {
      QFindBLEScanMgr.a(this.a.a, System.currentTimeMillis());
      QFindBLEScanMgr.a(this.a.a, true);
      return;
    }
    QFindBLEScanMgr.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.ScanReceiver.1
 * JD-Core Version:    0.7.0.1
 */
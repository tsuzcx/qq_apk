package com.tencent.device.qfind;

class QFindBLEScanMgr$ScanReceiver$1
  implements Runnable
{
  QFindBLEScanMgr$ScanReceiver$1(QFindBLEScanMgr.ScanReceiver paramScanReceiver) {}
  
  public void run()
  {
    if (this.a.a.o)
    {
      QFindBLEScanMgr.a(this.a.a, System.currentTimeMillis());
      QFindBLEScanMgr.a(this.a.a, true);
      return;
    }
    QFindBLEScanMgr.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.qfind.QFindBLEScanMgr.ScanReceiver.1
 * JD-Core Version:    0.7.0.1
 */
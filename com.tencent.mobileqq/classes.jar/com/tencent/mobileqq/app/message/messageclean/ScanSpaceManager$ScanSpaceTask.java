package com.tencent.mobileqq.app.message.messageclean;

import afhn;
import aouu;
import bdnv;
import bhrw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class ScanSpaceManager$ScanSpaceTask
  implements Runnable
{
  ScanSpaceManager$ScanSpaceTask(ScanSpaceManager paramScanSpaceManager) {}
  
  public void run()
  {
    long l1 = bhrw.a();
    long l2 = bhrw.a(BaseApplicationImpl.getApplication());
    long l3 = bhrw.b();
    long l4 = bhrw.b(BaseApplicationImpl.getApplication());
    this.this$0.a = (l1 + l2);
    this.this$0.c = (l3 + l4);
    aouu localaouu = new aouu(this);
    this.this$0.b = bdnv.a().a(localaouu, 0, 98);
    localaouu.a(100);
    QLog.d("ScanSpaceManager", 1, "SpaceInfo total: " + this.this$0.a + " ava: " + this.this$0.c + " qq: " + this.this$0.b);
    QLog.d("ScanSpaceManager", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
    ScanSpaceManager.a(this.this$0, true);
    ScanSpaceManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager.ScanSpaceTask
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.message.messageclean;

import aerk;
import aoqn;
import bdne;
import bhhk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class ScanSpaceManager$ScanSpaceTask
  implements Runnable
{
  ScanSpaceManager$ScanSpaceTask(ScanSpaceManager paramScanSpaceManager) {}
  
  public void run()
  {
    long l1 = bhhk.a();
    long l2 = bhhk.a(BaseApplicationImpl.getApplication());
    long l3 = bhhk.b();
    long l4 = bhhk.b(BaseApplicationImpl.getApplication());
    this.this$0.a = (l1 + l2);
    this.this$0.c = (l3 + l4);
    aoqn localaoqn = new aoqn(this);
    this.this$0.b = bdne.a().a(localaoqn, 0, 98);
    localaoqn.a(100);
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
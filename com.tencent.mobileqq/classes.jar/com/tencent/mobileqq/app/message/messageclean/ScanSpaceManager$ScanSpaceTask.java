package com.tencent.mobileqq.app.message.messageclean;

import abme;
import akdm;
import awtx;
import baht;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class ScanSpaceManager$ScanSpaceTask
  implements Runnable
{
  ScanSpaceManager$ScanSpaceTask(ScanSpaceManager paramScanSpaceManager) {}
  
  public void run()
  {
    long l1 = baht.a();
    long l2 = baht.a(BaseApplicationImpl.getApplication());
    long l3 = baht.b();
    long l4 = baht.b(BaseApplicationImpl.getApplication());
    this.this$0.a = (l1 + l2);
    this.this$0.c = (l3 + l4);
    akdm localakdm = new akdm(this);
    this.this$0.b = awtx.a().a(localakdm, 0, 98);
    localakdm.a(100);
    QLog.d("ScanSpaceManager", 1, "SpaceInfo total: " + this.this$0.a + " ava: " + this.this$0.c + " qq: " + this.this$0.b);
    QLog.d("ScanSpaceManager", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
    ScanSpaceManager.a(this.this$0, true);
    ScanSpaceManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager.ScanSpaceTask
 * JD-Core Version:    0.7.0.1
 */
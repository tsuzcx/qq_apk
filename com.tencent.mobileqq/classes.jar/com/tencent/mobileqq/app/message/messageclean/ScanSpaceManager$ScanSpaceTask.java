package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSettingCleanActivity.IProgressCallback;
import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.qphone.base.util.QLog;

class ScanSpaceManager$ScanSpaceTask
  implements Runnable
{
  ScanSpaceManager$ScanSpaceTask(ScanSpaceManager paramScanSpaceManager) {}
  
  public void run()
  {
    long l1 = SdCardUtil.getTotalInternalMemorySize();
    long l2 = SdCardUtil.getTotalExternalMemorySize(BaseApplicationImpl.getApplication());
    long l3 = SdCardUtil.getAvailableInternalMemorySize();
    long l4 = SdCardUtil.getAvailableExternalMemorySize(BaseApplicationImpl.getApplication());
    this.this$0.a = (l1 + l2);
    this.this$0.c = (l3 + l4);
    ScanSpaceManager.ScanSpaceTask.1 local1 = new ScanSpaceManager.ScanSpaceTask.1(this);
    this.this$0.b = StorageReport.a().a(local1, 0, 98);
    local1.a(100);
    QLog.d("ScanSpaceManager", 1, "SpaceInfo total: " + this.this$0.a + " ava: " + this.this$0.c + " qq: " + this.this$0.b);
    QLog.d("ScanSpaceManager", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
    ScanSpaceManager.a(this.this$0, true);
    ScanSpaceManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager.ScanSpaceTask
 * JD-Core Version:    0.7.0.1
 */
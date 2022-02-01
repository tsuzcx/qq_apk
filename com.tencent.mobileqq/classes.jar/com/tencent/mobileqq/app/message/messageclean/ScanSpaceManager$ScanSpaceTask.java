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
    Object localObject = this.this$0;
    ((ScanSpaceManager)localObject).a = (l1 + l2);
    ((ScanSpaceManager)localObject).c = (l3 + l4);
    localObject = new ScanSpaceManager.ScanSpaceTask.1(this);
    this.this$0.b = StorageReport.a().a((QQSettingCleanActivity.IProgressCallback)localObject, 0, 98);
    ((QQSettingCleanActivity.IProgressCallback)localObject).a(100);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SpaceInfo total: ");
    ((StringBuilder)localObject).append(this.this$0.a);
    ((StringBuilder)localObject).append(" ava: ");
    ((StringBuilder)localObject).append(this.this$0.c);
    ((StringBuilder)localObject).append(" qq: ");
    ((StringBuilder)localObject).append(this.this$0.b);
    QLog.d("ScanSpaceManager", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SpaceInfo totalIner: ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" totalExter: ");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" avaInter: ");
    ((StringBuilder)localObject).append(l3);
    ((StringBuilder)localObject).append(" avaExter: ");
    ((StringBuilder)localObject).append(l4);
    QLog.d("ScanSpaceManager", 1, ((StringBuilder)localObject).toString());
    ScanSpaceManager.a(this.this$0, true);
    ScanSpaceManager.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.messageclean.ScanSpaceManager.ScanSpaceTask
 * JD-Core Version:    0.7.0.1
 */
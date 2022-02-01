package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.statistics.storage.StorageReport;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;

class QQSettingCleanActivity$ScanSpaceTask
  implements Runnable
{
  QQSettingCleanActivity$ScanSpaceTask(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void run()
  {
    long l1 = SdCardUtil.getTotalInternalMemorySize();
    long l2 = SdCardUtil.getTotalExternalMemorySize(this.this$0);
    long l3 = SdCardUtil.getAvailableInternalMemorySize();
    long l4 = SdCardUtil.getAvailableExternalMemorySize(this.this$0);
    Object localObject = this.this$0;
    ((QQSettingCleanActivity)localObject).t = (l1 + l2);
    ((QQSettingCleanActivity)localObject).w = (l3 + l4);
    localObject = new QQSettingCleanActivity.ScanSpaceTask.1(this);
    this.this$0.u = StorageReport.a().a((QQSettingCleanActivity.IProgressCallback)localObject, 0, 98);
    this.this$0.v = StorageReport.a().a(QQSettingCleanActivity.z);
    QQSettingCleanActivity localQQSettingCleanActivity = this.this$0;
    localQQSettingCleanActivity.u -= this.this$0.v;
    ((QQSettingCleanActivity.IProgressCallback)localObject).a(100);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SpaceInfo total: ");
    ((StringBuilder)localObject).append(this.this$0.t);
    ((StringBuilder)localObject).append(" ava: ");
    ((StringBuilder)localObject).append(this.this$0.w);
    ((StringBuilder)localObject).append(" qq: ");
    ((StringBuilder)localObject).append(this.this$0.u);
    ((StringBuilder)localObject).append(" file: ");
    ((StringBuilder)localObject).append(this.this$0.v);
    QLog.d("QQCleanActivity", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SpaceInfo totalIner: ");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append(" totalExter: ");
    ((StringBuilder)localObject).append(l2);
    ((StringBuilder)localObject).append(" avaInter: ");
    ((StringBuilder)localObject).append(l3);
    ((StringBuilder)localObject).append(" avaExter: ");
    ((StringBuilder)localObject).append(l4);
    QLog.d("QQCleanActivity", 1, ((StringBuilder)localObject).toString());
    this.this$0.k.setFinish(this.this$0.u, this.this$0.v, this.this$0.t - this.this$0.u - this.this$0.v - this.this$0.w, this.this$0.w, 3.0F);
    localObject = this.this$0;
    ((QQSettingCleanActivity)localObject).runOnUiThread(new QQSettingCleanActivity.ShowTask((QQSettingCleanActivity)localObject, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.ScanSpaceTask
 * JD-Core Version:    0.7.0.1
 */
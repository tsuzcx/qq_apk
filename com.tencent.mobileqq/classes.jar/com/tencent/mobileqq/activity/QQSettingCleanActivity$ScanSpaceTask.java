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
    this.this$0.b = (l1 + l2);
    this.this$0.e = (l3 + l4);
    QQSettingCleanActivity.ScanSpaceTask.1 local1 = new QQSettingCleanActivity.ScanSpaceTask.1(this);
    this.this$0.c = StorageReport.a().a(local1, 0, 98);
    this.this$0.d = StorageReport.a().a(QQSettingCleanActivity.jdField_a_of_type_JavaUtilArrayList);
    this.this$0.c -= this.this$0.d;
    local1.a(100);
    QLog.d("QQCleanActivity", 1, "SpaceInfo total: " + this.this$0.b + " ava: " + this.this$0.e + " qq: " + this.this$0.c + " file: " + this.this$0.d);
    QLog.d("QQCleanActivity", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar.setFinish(this.this$0.c, this.this$0.d, this.this$0.b - this.this$0.c - this.this$0.d - this.this$0.e, this.this$0.e, 3.0F);
    this.this$0.runOnUiThread(new QQSettingCleanActivity.ShowTask(this.this$0, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.ScanSpaceTask
 * JD-Core Version:    0.7.0.1
 */
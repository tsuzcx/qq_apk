package com.tencent.mobileqq.activity;

import aeaf;
import aeah;
import bcgg;
import bfys;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;

public class QQSettingCleanActivity$ScanSpaceTask
  implements Runnable
{
  QQSettingCleanActivity$ScanSpaceTask(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void run()
  {
    long l1 = bfys.a();
    long l2 = bfys.a(this.this$0);
    long l3 = bfys.b();
    long l4 = bfys.b(this.this$0);
    this.this$0.b = (l1 + l2);
    this.this$0.e = (l3 + l4);
    aeah localaeah = new aeah(this);
    this.this$0.c = bcgg.a().a(localaeah, 0, 98);
    this.this$0.d = bcgg.a().a(QQSettingCleanActivity.jdField_a_of_type_JavaUtilArrayList);
    this.this$0.c -= this.this$0.d;
    localaeah.a(100);
    QLog.d("QQCleanActivity", 1, "SpaceInfo total: " + this.this$0.b + " ava: " + this.this$0.e + " qq: " + this.this$0.c + " file: " + this.this$0.d);
    QLog.d("QQCleanActivity", 1, "SpaceInfo totalIner: " + l1 + " totalExter: " + l2 + " avaInter: " + l3 + " avaExter: " + l4);
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgressBar.setFinish(this.this$0.c, this.this$0.d, this.this$0.b - this.this$0.c - this.this$0.d - this.this$0.e, this.this$0.e, 3.0F);
    this.this$0.runOnUiThread(new QQSettingCleanActivity.ShowTask(this.this$0, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingCleanActivity.ScanSpaceTask
 * JD-Core Version:    0.7.0.1
 */
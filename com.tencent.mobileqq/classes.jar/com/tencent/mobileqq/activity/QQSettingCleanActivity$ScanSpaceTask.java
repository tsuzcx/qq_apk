package com.tencent.mobileqq.activity;

import abwb;
import abwd;
import axua;
import bbjn;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;

public class QQSettingCleanActivity$ScanSpaceTask
  implements Runnable
{
  QQSettingCleanActivity$ScanSpaceTask(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void run()
  {
    long l1 = bbjn.a();
    long l2 = bbjn.a(this.this$0);
    long l3 = bbjn.b();
    long l4 = bbjn.b(this.this$0);
    this.this$0.b = (l1 + l2);
    this.this$0.e = (l3 + l4);
    abwd localabwd = new abwd(this);
    this.this$0.c = axua.a().a(localabwd, 0, 98);
    this.this$0.d = axua.a().a(QQSettingCleanActivity.jdField_a_of_type_JavaUtilArrayList);
    this.this$0.c -= this.this$0.d;
    localabwd.a(100);
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
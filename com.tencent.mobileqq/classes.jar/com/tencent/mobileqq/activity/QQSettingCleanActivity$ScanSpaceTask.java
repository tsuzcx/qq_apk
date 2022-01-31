package com.tencent.mobileqq.activity;

import adry;
import adsa;
import azuc;
import bdms;
import com.tencent.mobileqq.widget.CircleProgressBar;
import com.tencent.qphone.base.util.QLog;

public class QQSettingCleanActivity$ScanSpaceTask
  implements Runnable
{
  QQSettingCleanActivity$ScanSpaceTask(QQSettingCleanActivity paramQQSettingCleanActivity) {}
  
  public void run()
  {
    long l1 = bdms.a();
    long l2 = bdms.a(this.this$0);
    long l3 = bdms.b();
    long l4 = bdms.b(this.this$0);
    this.this$0.b = (l1 + l2);
    this.this$0.e = (l3 + l4);
    adsa localadsa = new adsa(this);
    this.this$0.c = azuc.a().a(localadsa, 0, 98);
    this.this$0.d = azuc.a().a(QQSettingCleanActivity.jdField_a_of_type_JavaUtilArrayList);
    this.this$0.c -= this.this$0.d;
    localadsa.a(100);
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
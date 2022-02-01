package com.dataline.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;

class LiteActivity$12
  implements DialogInterface.OnClickListener
{
  LiteActivity$12(LiteActivity paramLiteActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getIntExtra("forward_type", -1) == 11) {
      ReportCenter.a().a(this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.app.getAccount(), "", String.valueOf(this.jdField_a_of_type_Long), "1000", "52", "0", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i(LiteActivity.a, 2, "qbShowShareResultDialog stay");
    }
    if (this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().getBooleanExtra("MigSdkShareNotDone", false)) {
      this.jdField_a_of_type_ComDatalineActivitiesLiteActivity.getIntent().putExtra("MigSdkShareNotDone", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.12
 * JD-Core Version:    0.7.0.1
 */
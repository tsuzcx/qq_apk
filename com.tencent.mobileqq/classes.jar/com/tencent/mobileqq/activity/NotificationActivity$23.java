package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.ims.AlertReport.ButtonAction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqprotect.common.QPMiscUtils;

class NotificationActivity$23
  implements DialogInterface.OnClickListener
{
  NotificationActivity$23(NotificationActivity paramNotificationActivity, int paramInt, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new AlertReport.ButtonAction();
      paramDialogInterface.uint32_cmd.set(1);
      paramDialogInterface.uint32_button_id.set(this.jdField_a_of_type_Int);
      paramDialogInterface.str_package_name.set(QPMiscUtils.c());
      paramDialogInterface.uint32_app_id.set(AppSetting.a());
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.app, paramDialogInterface.toByteArray(), "SecuritySvc.AlertReport");
      ReportController.b(null, "P_CliOper", "Safe_AlertReport", "", "0X8007535", "0X8007535", this.jdField_a_of_type_Int, 0, this.jdField_a_of_type_JavaLangString, "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        paramDialogInterface.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.23
 * JD-Core Version:    0.7.0.1
 */
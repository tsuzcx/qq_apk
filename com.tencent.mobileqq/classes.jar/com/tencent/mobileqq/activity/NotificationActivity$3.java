package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.ims.signature.SignatureKickData;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;

class NotificationActivity$3
  implements DialogInterface.OnClickListener
{
  NotificationActivity$3(NotificationActivity paramNotificationActivity, signature.SignatureKickData paramSignatureKickData) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.i("NotificationActivity", 1, "setPositiveButton.onClick: invoked.  isDialogShow: " + NotificationActivity.access$000(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity));
    paramDialogInterface = new Bundle();
    paramDialogInterface.putString("password", null);
    paramDialogInterface = new Intent().putExtras(paramDialogInterface).addFlags(67108864);
    RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity, paramDialogInterface, "/base/login");
    try
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(this.jdField_a_of_type_ComTencentImsSignature$SignatureKickData.str_url.get()));
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.startActivity(paramDialogInterface);
      label104:
      paramDialogInterface = new Intent("qqplayer_exit_action");
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.sendBroadcast(paramDialogInterface);
      this.jdField_a_of_type_ComTencentMobileqqActivityNotificationActivity.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.3
 * JD-Core Version:    0.7.0.1
 */
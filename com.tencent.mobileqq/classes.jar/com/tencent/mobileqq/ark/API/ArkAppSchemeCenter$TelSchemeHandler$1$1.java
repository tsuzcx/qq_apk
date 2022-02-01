package com.tencent.mobileqq.ark.API;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class ArkAppSchemeCenter$TelSchemeHandler$1$1
  implements DialogInterface.OnClickListener
{
  ArkAppSchemeCenter$TelSchemeHandler$1$1(ArkAppSchemeCenter.TelSchemeHandler.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppSchemeCenter$TelSchemeHandler$1.a));
    ArkAppCenter.a(paramDialogInterface);
    BaseActivity.sTopActivity.startActivity(paramDialogInterface);
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.TelSchemeHandler.1.1
 * JD-Core Version:    0.7.0.1
 */
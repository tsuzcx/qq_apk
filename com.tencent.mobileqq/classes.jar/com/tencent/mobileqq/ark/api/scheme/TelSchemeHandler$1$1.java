package com.tencent.mobileqq.ark.api.scheme;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TelSchemeHandler$1$1
  implements DialogInterface.OnClickListener
{
  TelSchemeHandler$1$1(TelSchemeHandler.1 param1, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new StringBuilder();
    paramDialogInterface.append("tel:");
    paramDialogInterface.append(this.jdField_a_of_type_ComTencentMobileqqArkApiSchemeTelSchemeHandler$1.a);
    paramDialogInterface = new Intent("android.intent.action.DIAL", Uri.parse(paramDialogInterface.toString()));
    ArkAppCenter.a(paramDialogInterface);
    BaseActivity.sTopActivity.startActivity(paramDialogInterface);
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if ((paramDialogInterface != null) && (paramDialogInterface.isShowing())) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;

class TranslucentTRansferFragment$1
  implements DialogInterface.OnClickListener
{
  TranslucentTRansferFragment$1(TranslucentTRansferFragment paramTranslucentTRansferFragment, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.dismiss();
    paramDialogInterface = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
    paramDialogInterface = new Intent(this.b.getBaseActivity(), paramDialogInterface.getRegisterPhoneNumActivityClass());
    paramDialogInterface.putExtra("invite_code", this.b.getBaseActivity().getIntent().getStringExtra("invite_code"));
    this.b.startActivity(paramDialogInterface);
    ReportController.b(null, "dc00898", "", "", "0X800970C", "0X800970C", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TranslucentTRansferFragment.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;

class RegisterActivity$3
  implements DialogInterface.OnClickListener
{
  RegisterActivity$3(RegisterActivity paramRegisterActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.a));
    this.b.startActivity(localIntent);
    paramDialogInterface.dismiss();
    this.b.p.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity.3
 * JD-Core Version:    0.7.0.1
 */
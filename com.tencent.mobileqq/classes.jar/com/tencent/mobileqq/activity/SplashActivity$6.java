package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class SplashActivity$6
  implements DialogInterface.OnClickListener
{
  SplashActivity$6(SplashActivity paramSplashActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent(this.a, GesturePWDSettingActivity.class);
    localIntent.putExtra("key_reset", true);
    this.a.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SplashActivity.6
 * JD-Core Version:    0.7.0.1
 */
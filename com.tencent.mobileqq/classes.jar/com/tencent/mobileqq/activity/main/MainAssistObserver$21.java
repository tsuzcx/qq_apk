package com.tencent.mobileqq.activity.main;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.utils.QQCustomDialog;

class MainAssistObserver$21
  implements DialogInterface.OnClickListener
{
  MainAssistObserver$21(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.getIntent().removeExtra("if_check_account_same");
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.21
 * JD-Core Version:    0.7.0.1
 */
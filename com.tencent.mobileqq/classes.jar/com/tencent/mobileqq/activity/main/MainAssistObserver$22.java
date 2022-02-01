package com.tencent.mobileqq.activity.main;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;

class MainAssistObserver$22
  implements DialogInterface.OnClickListener
{
  MainAssistObserver$22(MainAssistObserver paramMainAssistObserver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("is_change_account", true);
    if (this.a.a.getIntent().getExtras() != null) {
      paramDialogInterface.putExtras(this.a.a.getIntent().getExtras());
    }
    paramDialogInterface.addFlags(268435456);
    paramDialogInterface.addFlags(67108864);
    RouteUtils.a(this.a.a, paramDialogInterface, "/base/login");
    this.a.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.22
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.phone;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

class DialogBaseActivity$2
  implements DialogInterface.OnClickListener
{
  DialogBaseActivity$2(DialogBaseActivity paramDialogBaseActivity, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a)
    {
      paramDialogInterface = new Intent(BaseActivity.sTopActivity, SplashActivity.class);
      paramDialogInterface.putExtra("main_tab_id", 1);
      paramDialogInterface.setFlags(603979776);
      BaseActivity.sTopActivity.startActivity(paramDialogInterface);
      this.b.finish();
      ReportController.b(this.b.app, "dc00898", "", "", "0X8006AA6", "0X8006AA6", 0, 0, "", "", "", "");
      return;
    }
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.DialogBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */
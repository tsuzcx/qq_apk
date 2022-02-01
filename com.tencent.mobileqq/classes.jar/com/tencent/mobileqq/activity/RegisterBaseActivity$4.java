package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class RegisterBaseActivity$4
  implements Runnable
{
  public void run()
  {
    RegisterBaseActivity localRegisterBaseActivity = this.this$0;
    localRegisterBaseActivity.e = new ReportDialog(localRegisterBaseActivity, 2131953338);
    this.this$0.e.setContentView(2131623999);
    ((TextView)this.this$0.e.findViewById(2131431876)).setText(this.this$0.getString(this.a));
    this.this$0.e.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */
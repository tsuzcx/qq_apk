package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class RegisterNewBaseActivity$4
  implements Runnable
{
  RegisterNewBaseActivity$4(RegisterNewBaseActivity paramRegisterNewBaseActivity, int paramInt) {}
  
  public void run()
  {
    this.this$0.a = new ReportDialog(this.this$0, 2131755826);
    this.this$0.a.setContentView(2131561817);
    ((TextView)this.this$0.a.findViewById(2131365552)).setText(this.this$0.getString(this.a));
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterNewBaseActivity.4
 * JD-Core Version:    0.7.0.1
 */
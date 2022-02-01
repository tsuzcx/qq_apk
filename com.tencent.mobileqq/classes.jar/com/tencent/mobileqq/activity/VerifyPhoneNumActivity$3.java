package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

class VerifyPhoneNumActivity$3
  implements Runnable
{
  public void run()
  {
    VerifyPhoneNumActivity localVerifyPhoneNumActivity = this.this$0;
    localVerifyPhoneNumActivity.a = new ReportDialog(localVerifyPhoneNumActivity, 2131953338);
    this.this$0.a.setContentView(2131623999);
    ((TextView)this.this$0.a.findViewById(2131431876)).setText(this.this$0.getString(this.a));
    this.this$0.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VerifyPhoneNumActivity.3
 * JD-Core Version:    0.7.0.1
 */
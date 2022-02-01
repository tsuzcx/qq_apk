package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import anni;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import okj;

public class ReadInJoyUploadAvatarFragment$1
  implements Runnable
{
  ReadInJoyUploadAvatarFragment$1(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, Activity paramActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.this$0.a = new ReportProgressDialog(this.a, 2131755823);
    this.this$0.a.setCancelable(true);
    this.this$0.a.show();
    this.this$0.a.setContentView(2131559567);
    ((TextView)this.this$0.a.findViewById(2131372466)).setText(anni.a(2131711729));
    this.this$0.a.setOnCancelListener(new okj(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.1
 * JD-Core Version:    0.7.0.1
 */
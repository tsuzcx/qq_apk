package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import anzj;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import olr;

public class ReadInJoyUploadAvatarFragment$1
  implements Runnable
{
  ReadInJoyUploadAvatarFragment$1(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, Activity paramActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.this$0.a = new ReportProgressDialog(this.a, 2131755824);
    this.this$0.a.setCancelable(true);
    this.this$0.a.show();
    this.this$0.a.setContentView(2131559572);
    ((TextView)this.this$0.a.findViewById(2131372578)).setText(anzj.a(2131711838));
    this.this$0.a.setOnCancelListener(new olr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;

class ReadInJoyUploadAvatarFragment$1
  implements Runnable
{
  ReadInJoyUploadAvatarFragment$1(ReadInJoyUploadAvatarFragment paramReadInJoyUploadAvatarFragment, Activity paramActivity) {}
  
  public void run()
  {
    if (this.a.isFinishing()) {
      return;
    }
    this.this$0.a = new ReportProgressDialog(this.a, 2131755842);
    this.this$0.a.setCancelable(true);
    this.this$0.a.show();
    this.this$0.a.setContentView(2131559683);
    ((TextView)this.this$0.a.findViewById(2131373066)).setText(HardCodeUtil.a(2131712923));
    this.this$0.a.setOnCancelListener(new ReadInJoyUploadAvatarFragment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment.1
 * JD-Core Version:    0.7.0.1
 */
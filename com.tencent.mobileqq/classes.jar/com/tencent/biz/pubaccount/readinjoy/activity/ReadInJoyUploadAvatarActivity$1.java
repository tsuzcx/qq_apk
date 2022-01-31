package com.tencent.biz.pubaccount.readinjoy.activity;

import ajyc;
import android.app.ProgressDialog;
import android.widget.TextView;
import nxh;

public class ReadInJoyUploadAvatarActivity$1
  implements Runnable
{
  ReadInJoyUploadAvatarActivity$1(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.a = new ProgressDialog(this.this$0, 2131755791);
    this.this$0.a.setCancelable(true);
    this.this$0.a.show();
    this.this$0.a.setContentView(2131559386);
    ((TextView)this.this$0.a.findViewById(2131371557)).setText(ajyc.a(2131712955));
    this.this$0.a.setOnCancelListener(new nxh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity.1
 * JD-Core Version:    0.7.0.1
 */
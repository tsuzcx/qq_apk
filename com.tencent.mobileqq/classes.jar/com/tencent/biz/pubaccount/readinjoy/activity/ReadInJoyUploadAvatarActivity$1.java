package com.tencent.biz.pubaccount.readinjoy.activity;

import alpo;
import android.app.ProgressDialog;
import android.widget.TextView;
import oak;

public class ReadInJoyUploadAvatarActivity$1
  implements Runnable
{
  ReadInJoyUploadAvatarActivity$1(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.a = new ProgressDialog(this.this$0, 2131755801);
    this.this$0.a.setCancelable(true);
    this.this$0.a.show();
    this.this$0.a.setContentView(2131559438);
    ((TextView)this.this$0.a.findViewById(2131371874)).setText(alpo.a(2131713338));
    this.this$0.a.setOnCancelListener(new oak(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity.1
 * JD-Core Version:    0.7.0.1
 */
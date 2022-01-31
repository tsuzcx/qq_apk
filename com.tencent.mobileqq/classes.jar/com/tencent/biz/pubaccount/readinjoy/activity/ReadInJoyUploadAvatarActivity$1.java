package com.tencent.biz.pubaccount.readinjoy.activity;

import ajjy;
import android.app.ProgressDialog;
import android.widget.TextView;
import nlw;

public class ReadInJoyUploadAvatarActivity$1
  implements Runnable
{
  ReadInJoyUploadAvatarActivity$1(ReadInJoyUploadAvatarActivity paramReadInJoyUploadAvatarActivity) {}
  
  public void run()
  {
    if (this.this$0.isFinishing()) {
      return;
    }
    this.this$0.a = new ProgressDialog(this.this$0, 2131690181);
    this.this$0.a.setCancelable(true);
    this.this$0.a.show();
    this.this$0.a.setContentView(2131493818);
    ((TextView)this.this$0.a.findViewById(2131305861)).setText(ajjy.a(2131647167));
    this.this$0.a.setOnCancelListener(new nlw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarActivity.1
 * JD-Core Version:    0.7.0.1
 */
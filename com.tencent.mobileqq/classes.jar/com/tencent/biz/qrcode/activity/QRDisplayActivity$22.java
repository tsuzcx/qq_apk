package com.tencent.biz.qrcode.activity;

import android.view.View;
import xze;

public class QRDisplayActivity$22
  implements Runnable
{
  QRDisplayActivity$22(QRDisplayActivity paramQRDisplayActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      this.this$0.d.setOnClickListener(null);
      this.this$0.d.setClickable(false);
      this.this$0.d.setOnTouchListener(new xze(this));
      return;
    }
    this.this$0.d.setClickable(true);
    this.this$0.d.setOnClickListener(this.this$0);
    this.this$0.d.setTouchDelegate(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.22
 * JD-Core Version:    0.7.0.1
 */
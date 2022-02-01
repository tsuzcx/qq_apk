package com.tencent.biz.qrcode.activity;

import android.view.View;

class QRDisplayActivity$26
  implements Runnable
{
  QRDisplayActivity$26(QRDisplayActivity paramQRDisplayActivity, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      this.this$0.I.setOnClickListener(null);
      this.this$0.I.setClickable(false);
      this.this$0.I.setOnTouchListener(new QRDisplayActivity.26.1(this));
      return;
    }
    this.this$0.I.setClickable(true);
    this.this$0.I.setOnClickListener(this.this$0);
    this.this$0.I.setTouchDelegate(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.26
 * JD-Core Version:    0.7.0.1
 */